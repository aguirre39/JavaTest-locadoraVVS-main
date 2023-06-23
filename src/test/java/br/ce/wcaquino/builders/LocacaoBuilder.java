package br.ce.wcaquino.builders;

import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

import java.util.Arrays;

import static br.ce.wcaquino.builders.FilmeBuilder.umFilme;
import static br.ce.wcaquino.builders.UsuarioBuilder.umUsuario;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;

import java.lang.Double;
import java.util.Date;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;

// Classe builder para a entidade Locacao
public class LocacaoBuilder {
    private Locacao elemento;
    private LocacaoBuilder(){}

    // Método estático que retorna uma instância de LocacaoBuilder com uma locação já criada com valores padrão
    public static LocacaoBuilder umLocacao() {
        LocacaoBuilder builder = new LocacaoBuilder();
        inicializarDadosPadroes(builder);
        return builder;
    }

    // Método estático que inicializa os dados padrão de uma locação
    public static void inicializarDadosPadroes(LocacaoBuilder builder) {
        builder.elemento = new Locacao();
        Locacao elemento = builder.elemento;

        elemento.setUsuario(umUsuario().agora());
        elemento.setFilmes(Arrays.asList(umFilme().agora()));
        elemento.setDataLocacao(new Date());
        elemento.setDataRetorno(DataUtils.obterDataComDiferencaDias(1));
        elemento.setValor(4.0);
    }

    // Método que altera o usuário da locação
    public LocacaoBuilder comUsuario(Usuario param) {
        elemento.setUsuario(param);
        return this;
    }

    // Método que altera a lista de filmes da locação
    public LocacaoBuilder comListaFilmes(Filme... params) {
        elemento.setFilmes(Arrays.asList(params));
        return this;
    }

    // Método que altera a data de locação da locação
    public LocacaoBuilder comDataLocacao(Date param) {
        elemento.setDataLocacao(param);
        return this;
    }

    // Método que altera a data de retorno da locação
    public LocacaoBuilder comDataRetorno(Date param) {
        elemento.setDataRetorno(param);
        return this;
    }

    // Método que define a locação como atrasada
    public LocacaoBuilder atrasada(){
        elemento.setDataLocacao(obterDataComDiferencaDias(-4));
        elemento.setDataRetorno(obterDataComDiferencaDias(-2));
        return this;
    }

    // Método que altera o valor da locação
    public LocacaoBuilder comValor(Double param) {
        elemento.setValor(param);
        return this;
    }

    // Método que retorna a locação criada
    public Locacao agora() {
        return elemento;
    }
}