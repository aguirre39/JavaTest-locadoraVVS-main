package br.ce.wcaquino.builders;

import br.ce.wcaquino.entidades.Usuario;

// Classe builder para a entidade Usuario
public class UsuarioBuilder {

    private Usuario usuario;

    private UsuarioBuilder() {}

    // Método estático que retorna uma instância de UsuarioBuilder com um usuário já criado com valores padrão
    public static UsuarioBuilder umUsuario(){
        UsuarioBuilder builder = new UsuarioBuilder();
        builder.usuario = new Usuario();
        builder.usuario.setNome("Usuario 1");
        return builder;
    }

    // Método que altera o nome do usuário
    public UsuarioBuilder comNome(String nome) {
        usuario.setNome(nome);
        return this;
    }

    // Método que retorna o usuário criado
    public Usuario agora(){
        return usuario;
    }
}