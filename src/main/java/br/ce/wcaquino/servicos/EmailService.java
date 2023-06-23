package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Usuario;

// Interface que define um serviço de envio de e-mails
public interface EmailService {

    // Método que notifica um usuário sobre um atraso
    public void notificarAtraso(Usuario usuario);

}