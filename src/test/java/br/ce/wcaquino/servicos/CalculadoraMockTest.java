package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

// Classe de testes para a classe Calculadora utilizando mocks e spyes
public class CalculadoraMockTest {

    // Cria um mock da classe Calculadora
    @Mock
    private Calculadora calcMock;

    // Cria um spy da classe Calculadora
    @Spy
    private Calculadora calcSpy;

    // Cria um mock do serviço de email
    @Mock
    private EmailService email;

    // Método que é executado antes de cada teste e inicializa os mocks e spies
    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    // Teste que mostra a diferença entre mocks e spies
    @Test
    public void testShowDifferenceBetweenMockAndSpy() {
        // Configura o mock para retornar 5 quando o método somar for chamado com os argumentos 1 e 2
        Mockito.when(calcMock.somar(1, 2)).thenReturn(5);
        // Configura o spy para retornar 5 quando o método somar for chamado com os argumentos 1 e 2
        Mockito.doReturn(5).when(calcSpy).somar(1, 2);
        // Configura o spy para não fazer nada quando o método imprime for chamado
        Mockito.doNothing().when(calcSpy).imprime();

        // Imprime o resultado da chamada do método somar no mock
        System.out.println("Mock: " + calcMock.somar(1, 2));
        // Imprime o resultado da chamada do método somar no spy
        System.out.println("Spy: " + calcSpy.somar(1, 2));

        // Imprime a mensagem "Mock" e chama o método imprime no mock
        System.out.println("Mock");
        calcMock.imprime();
        // Imprime a mensagem "Spy" e chama o método imprime no spy
        System.out.println("Spy");
        calcSpy.imprime();
    }

    // Teste que utiliza um mock com argumentos capturados
    @Test
    public void testMock() {
        // Cria um mock da classe Calculadora
        Calculadora calc = Mockito.mock(Calculadora.class);

        // Cria um capturador de argumentos para a classe Integer
        ArgumentCaptor<Integer> argCapt = ArgumentCaptor.forClass(Integer.class);
        // Configura o mock para retornar 5 quando o método somar for chamado com quaisquer argumentos
        Mockito.when(calc.somar(argCapt.capture(), argCapt.capture())).thenReturn(5);

        // Verifica se o resultado da chamada do método somar com os argumentos 134345 e -234 é igual a 5
        Assert.assertEquals(5, calc.somar(134345, -234));
        // Imprime todos os valores capturados pelo capturador de argumentos
        System.out.println(argCapt.getAllValues());
    }
}