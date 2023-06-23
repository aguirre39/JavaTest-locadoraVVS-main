package br.ce.wcaquino.exceptions;

// Classe que representa uma exceção genérica para a locadora
public class LocadoraException extends Exception {

    // Atributo usado para garantir a compatibilidade entre diferentes versões da classe em diferentes sistemas
    private static final long serialVersionUID = 3837982804180390821L;

    // Construtor que recebe uma mensagem de erro e a repassa para a superclasse "Exception"
    public LocadoraException(String message) {
        super(message);
    }
}