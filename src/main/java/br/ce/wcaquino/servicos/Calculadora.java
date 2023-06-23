package br.ce.wcaquino.servicos;

import br.ce.wcaquino.exceptions.NaoPodeDividirPorZeroException;

public class Calculadora {

    // Método que realiza a soma de dois números inteiros
    public int somar(int a, int b) {
        System.out.println("Estou executando o método somar");
        return a + b;
    }

    // Método que realiza a subtração de dois números inteiros
    public int subtrair(int a, int b) {
        return a - b;
    }

    // Método que realiza a divisão de dois números inteiros, lançando uma exceção caso o segundo número seja zero
    public int divide(int a, int b) throws NaoPodeDividirPorZeroException {
        if(b == 0) {
            throw new NaoPodeDividirPorZeroException();
        }
        return a / b;
    }

    // Método que realiza a divisão de duas strings que representam números inteiros
    public int divide(String a, String b) {
        return Integer.valueOf(a) / Integer.valueOf(b);
    }

    // Método que imprime uma mensagem na tela
    public void imprime(){
        System.out.println("Passei aqui");
    }

    // Método main que cria uma instância da classe Calculadora e chama o método divide com duas strings inválidas
    public static void main(String[] args) {
        new Calculadora().divide("a", "b");
    }

}