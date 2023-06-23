package br.ce.wcaquino.builders;

import br.ce.wcaquino.entidades.Filme;

// Classe builder para a entidade Filme
public class FilmeBuilder {

    private Filme filme;

    private FilmeBuilder(){}

    // Método estático que retorna uma instância de FilmeBuilder com um filme já criado com valores padrão
    public static FilmeBuilder umFilme(){
        FilmeBuilder builder = new FilmeBuilder();
        builder.filme = new Filme();
        builder.filme.setEstoque(2);
        builder.filme.setNome("Filme 1");
        builder.filme.setPrecoLocacao(4.0);
        return builder;
    }

    // Método estático que retorna uma instância de FilmeBuilder com um filme sem estoque já criado com valores padrão
    public static FilmeBuilder umFilmeSemEstoque(){
        FilmeBuilder builder = new FilmeBuilder();
        builder.filme = new Filme();
        builder.filme.setEstoque(0);
        builder.filme.setNome("Filme 1");
        builder.filme.setPrecoLocacao(4.0);
        return builder;
    }

    // Método que altera o estoque do filme
    public FilmeBuilder semEstoque(){
        filme.setEstoque(0);
        return this;
    }

    // Método que altera o valor de locação do filme
    public FilmeBuilder comValor(Double valor) {
        filme.setPrecoLocacao(valor);
        return this;
    }

    // Método que retorna o filme criado
    public Filme agora(){
        return filme;
    }
}