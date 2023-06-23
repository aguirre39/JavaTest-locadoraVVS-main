package br.ce.wcaquino.daos;

import java.util.List;

import br.ce.wcaquino.entidades.Locacao;

public interface LocacaoDAO {

    // Método para salvar uma nova locação no banco de dados
    public void salvar(Locacao locacao);

    // Método para obter todas as locações pendentes (aquelas que ainda não foram concluídas)
    public List<Locacao> obterLocacoesPendentes();
}