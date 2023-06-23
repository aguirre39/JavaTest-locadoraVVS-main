package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.builders.FilmeBuilder.umFilme;
import static br.ce.wcaquino.builders.FilmeBuilder.umFilmeSemEstoque;
import static br.ce.wcaquino.builders.LocacaoBuilder.umLocacao;
import static br.ce.wcaquino.builders.UsuarioBuilder.umUsuario;
import static br.ce.wcaquino.matchers.MatchersProprios.caiNumaSegunda;
import static br.ce.wcaquino.matchers.MatchersProprios.ehHoje;
import static br.ce.wcaquino.matchers.MatchersProprios.ehHojeComDiferencaDias;
import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.ce.wcaquino.daos.LocacaoDAO;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
    
    // Injeção de dependências
    @InjectMocks
    @Spy
    private LocacaoService service;

    @Mock
    private SPCService spc;
    @Mock
    private LocacaoDAO dao;
    @Mock
    private EmailService email;

    // Captura de argumentos
    @Captor
    private ArgumentCaptor<Locacao> locacaoCaptor;

    // Regras de teste
    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    // Configuração inicial
    @Before
	public void setup(){
    MockitoAnnotations.openMocks(this);
    }

    // Configuração final
    @After
    public void tearDown() {
        System.out.println("finalizando 2...");
    }

    // Configuração final da classe
    @AfterClass
    public static void tearDownClass() {
        System.out.println(CalculadoraTest.ordem.toString());
    }

    // Teste de aluguel de filme
    @Test
    public void deveAlugarFilme() throws Exception {
        // Cenário
        Usuario usuario = umUsuario().agora();
        List<Filme> filmes = Arrays.asList(umFilme().comValor(5.0).agora());

        doReturn(DataUtils.obterData(28, 4, 2017)).when(service).obterData();

        // Ação
        Locacao locacao = service.alugarFilme(usuario, filmes);

        // Verificação
        assertThat(locacao.getValor(), is(equalTo(5.0)));
        assertThat(isMesmaData(locacao.getDataLocacao(), DataUtils.obterData(28, 4, 2017)), is(true));
        assertThat(isMesmaData(locacao.getDataRetorno(), DataUtils.obterData(29, 4, 2017)), is(true));
}

// Teste de aluguel de filme sem estoque
@Test(expected = FilmeSemEstoqueException.class)
public void naoDeveAlugarFilmeSemEstoque() throws Exception {
    // Cenário
    Usuario usuario = umUsuario().agora();
    List<Filme> filmes = Arrays.asList(umFilmeSemEstoque().agora());

    // Ação
    service.alugarFilme(usuario, filmes);
}

// Teste de aluguel de filme sem usuário
@Test
public void naoDeveAlugarFilmeSemUsuario() throws FilmeSemEstoqueException {
    //Cenário
    List<Filme> filmes = Arrays.asList(umFilme().agora());

    try {
        // Ação
        service.alugarFilme(null, filmes);
        Assert.fail();
    } catch (LocadoraException e) {
        // Verificação
        assertThat(e.getMessage(), is("Usuario vazio"));
    }
}

// Teste de aluguel de filme sem filme
@Test
public void naoDeveAlugarFilmeSemFilme() throws FilmeSemEstoqueException, LocadoraException {
    // Cenário
    Usuario usuario = umUsuario().agora();

    exception.expect(LocadoraException.class);
    exception.expectMessage("Filme vazio");

    // Ação
    service.alugarFilme(usuario, null);
}

// Teste de devolução na segunda-feira ao alugar no sábado
@Test
public void deveDevolverNaSegundaAoAlugarNoSabado() throws Exception {
    //Cenário
    Usuario usuario = umUsuario().agora();
    List<Filme> filmes = Arrays.asList(umFilme().agora());

    doReturn(DataUtils.obterData(29, 4, 2017)).when(service).obterData();

    // Ação
    Locacao retorno = service.alugarFilme(usuario, filmes);

    // Verificação
    assertThat(retorno.getDataRetorno(), caiNumaSegunda());
}

// Teste de aluguel de filme para usuário negativado no SPC
@Test
public void naoDeveAlugarFilmeParaNegativadoSPC() throws Exception {
    //Cenário
    Usuario usuario = umUsuario().agora();
    List<Filme> filmes = Arrays.asList(umFilme().agora());

    when(spc.possuiNegativacao(Mockito.any(Usuario.class))).thenReturn(true);

    try {
        // Ação
        service.alugarFilme(usuario, filmes);
        Assert.fail();
    } catch (LocadoraException e) {
        // Verificação
        assertThat(e.getMessage(), is("Usuário Negativado"));
    }

    verify(spc).possuiNegativacao(usuario);
}

// Teste de envio de e-mail para locações atrasadas
@Test
public void deveEnviarEmailParaLocacoesAtrasadas() {
    //Cenário
    Usuario usuario = umUsuario().agora();
    Usuario usuario2 = umUsuario().comNome("Usuario em dia").agora();
    Usuario usuario3 = umUsuario().comNome("Outro atrasado").agora();
    List<Locacao> locacoes = Arrays.asList(
            umLocacao().atrasada().comUsuario(usuario).agora(),
            umLocacao().comUsuario(usuario2).agora(),
            umLocacao().atrasada().comUsuario(usuario3).agora(),
            umLocacao().atrasada().comUsuario(usuario3).agora());
    when(dao.obterLocacoesPendentes()).thenReturn(locacoes);

    // Ação
    service.notificarAtrasos();

    // Verificação
    verify(email, times(3)).notificarAtraso(Mockito.any(Usuario.class));
    verify(email).notificarAtraso(usuario);
    verify(email, atLeastOnce()).notificarAtraso(usuario3);
    verify(email, never()).notificarAtraso(usuario2);
    verifyNoMoreInteractions(email);
}

// Teste de tratamento de erro no SPC
@Test
public void deveTratarErronoSPC() throws Exception {
    // Cenário
    Usuario usuario = umUsuario().agora();
    List<Filme> filmes = Arrays.asList(umFilme().agora());

    when(spc.possuiNegativacao(usuario)).thenThrow(new Exception("Falha catratrófica"));

    exception.expect(LocadoraException.class);
    exception.expectMessage("Problemas com SPC, tente novamente");

    // Ação
    service.alugarFilme(usuario, filmes);
}

// Teste de prorrogação de locação
@Test
public void deveProrrogarUmaLocacao() {
    // Cenário
    Locacao locacao = umLocacao().agora();

    // Ação
    service.prorrogarLocacao(locacao, 3);

    // Verificação
    verify(dao).salvar(locacaoCaptor.capture());
    Locacao locacaoRetornada = locacaoCaptor.getValue();

    error.checkThat(locacaoRetornada.getValor(), is(12.0));
    error.checkThat(locacaoRetornada.getDataLocacao(), ehHoje());
    error.checkThat(locacaoRetornada.getDataRetorno(), ehHojeComDiferencaDias(3));
}

    // Teste de cálculo de valor de locação
    @Test
    public void deveCalcularValorLocacao() throws Exception {

        // Cenário
        List<Filme> filmes = Arrays.asList(umFilme().agora());
        // Ação
        Class<LocacaoService> clazz = LocacaoService.class;
        Method metodo = clazz.getDeclaredMethod("calcularValorLocacao", List.class);
        metodo.setAccessible(true);
        Double valor = (Double) metodo.invoke(service, filmes);

        // Verificação
        assertThat(valor, is(4.0));
    }
}