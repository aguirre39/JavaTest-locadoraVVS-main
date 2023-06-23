package br.ce.wcaquino.daos;

import java.util.List;

import br.ce.wcaquino.entidades.Locacao;

public class LocacaoDAOFake implements LocacaoDAO {

    // Método para salvar uma nova locação no banco de dados
    public void salvar(Locacao locacao) {
        // Não faz nada, pois a classe "LocacaoDAOFake" não precisa salvar dados reais no banco de dados
    }

    // Método para obter todas as locações pendentes (aquelas que ainda não foram concluídas)
    public List<Locacao> obterLocacoesPendentes() {
        return null; // Retorna uma lista vazia de locações pendentes
    }
}