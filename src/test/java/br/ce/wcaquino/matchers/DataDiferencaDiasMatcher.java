package br.ce.wcaquino.matchers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import br.ce.wcaquino.utils.DataUtils;

// Classe matcher para verificar se uma data tem a diferença de dias esperada
public class DataDiferencaDiasMatcher extends TypeSafeMatcher<Date> {

  private Integer qtdDias;

  public DataDiferencaDiasMatcher(Integer qtdDias) {
    this.qtdDias = qtdDias;
  }

  // Método que adiciona a descrição do matcher
  public void describeTo(Description desc) {
    // Cria uma data com a diferença de dias especificada
    Date dataEsperada = DataUtils.obterDataComDiferencaDias(qtdDias);
    // Formata a data no formato "dd/MM/YYYY"
    DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
    // Adiciona a data formatada à descrição do matcher
    desc.appendText(format.format(dataEsperada));
  }

  // Método que verifica se a data recebida é a mesma que a data atual mais o número de dias especificado
  @Override
  protected boolean matchesSafely(Date data) {
    return DataUtils.isMesmaData(data, DataUtils.obterDataComDiferencaDias(qtdDias));
  }

}