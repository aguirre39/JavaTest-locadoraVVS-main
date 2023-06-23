package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Usuario;

// Interface que define um serviço de consulta ao SPC
public interface SPCService {

    // Método que verifica se um usuário possui negativação no SPC
    public boolean possuiNegativacao(Usuario usuario) throws Exception;
}