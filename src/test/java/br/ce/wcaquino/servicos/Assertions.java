package br.ce.wcaquino.servicos;

// Classe utilitária para realizar asserções nos testes
public class Assertions {

    // Método que verifica se dois valores double são iguais e lança uma exceção com a mensagem especificada caso contrário
    public static void assertEquals(Double valorLocacao, Double valor, String mensagem) {
        if (valorLocacao != valor) {
            throw new AssertionError(mensagem);
        }
    }

}