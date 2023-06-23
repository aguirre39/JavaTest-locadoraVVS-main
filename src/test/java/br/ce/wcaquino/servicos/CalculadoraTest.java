package br.ce.wcaquino.servicos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.exceptions.NaoPodeDividirPorZeroException;

// Classe de testes para a classe Calculadora
public class CalculadoraTest {

    // Variável estática que armazena a ordem de execução dos métodos
    public static StringBuffer ordem = new StringBuffer();

    // Cria uma instância da classe Calculadora
    private Calculadora calc;

    // Método que é executado antes de cada teste e inicializa a instância da classe Calculadora
    @Before
    public void setup(){
        calc = new Calculadora();
        System.out.println("iniciando...");
        // Adiciona o valor "1" à variável ordem
        ordem.append("1");
    }

    // Método que é executado após cada teste e imprime a mensagem "finalizando..."
    @After
    public void tearDown(){
        System.out.println("finalizando...");
    }

    // Método que é executado após todos os testes e imprime a ordem de execução dos métodos
    @AfterClass
    public static void tearDownClass(){
        System.out.println(ordem.toString());
    }

    // Teste que verifica se a soma de dois valores está correta
    @Test
    public void deveSomarDoisValores(){
        // Cenário: define os valores a serem somados
        int a = 5;
        int b = 3;

        // Ação: chama o método somar da classe Calculadora
        int resultado = calc.somar(a, b);

        // Verificação: verifica se o resultado da soma é igual a 8
        Assert.assertEquals(8, resultado);

    }

    // Teste que verifica se a subtração de dois valores está correta
    @Test
    public void deveSubtrairDoisValores(){
        // Cenário: define os valores a serem subtraídos
        int a = 8;
        int b = 5;

        // Ação: chama o método subtrair da classe Calculadora
        int resultado = calc.subtrair(a, b);

        // Verificação: verifica se o resultado da subtração é igual a 3
        Assert.assertEquals(3, resultado);

    }

    // Teste que verifica se a divisão de dois valores está correta
    @Test
    public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException{
        // Cenário: define os valores a serem divididos
        int a = 6;
        int b = 3;

        // Ação: chama o método divide da classe Calculadora
        int resultado = calc.divide(a, b);

        // Verificação: verifica se o resultado da divisão é igual a 2
        Assert.assertEquals(2, resultado);
    }

    // Teste que verifica se a exceção NaoPodeDividirPorZeroException é lançada ao tentar dividir por zero
    @Test(expected = NaoPodeDividirPorZeroException.class)
    public void deveLancarExcecaoAoDividirPorZero() throws NaoPodeDividirPorZeroException{
        // Cenário: define os valores a serem divididos (sendo o segundo valor igual a zero)
        int a = 10;
        int b = 0;

        // Ação: chama o método divide da classe Calculadora
        calc.divide(a, b);
    }

    // Teste que verifica se a divisão de dois valores representados como strings está correta
    @Test
    public void deveDividir(){
        // Cenário: define os valores a serem divididos (como strings)
        String a = "6";
        String b = "3";

        // Ação: chama o método divide da classe Calculadora
        int resultado = calc.divide(a, b);

        // Verificação: verifica se o resultado da divisão é igual a 2
        Assert.assertEquals(2, resultado);
    }
}