package br.ce.wcaquino.entidades;

import java.util.Date;
import java.util.List;

public class Locacao {

    private Usuario usuario; // Usuário que está locando os filmes
    private List<Filme> filmes; // Lista de filmes que estão sendo locados
    private Date dataLocacao; // Data em que a locação foi feita
    private Date dataRetorno; // Data em que os filmes devem ser devolvidos
    private Double valor; // Valor total da locação

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
}