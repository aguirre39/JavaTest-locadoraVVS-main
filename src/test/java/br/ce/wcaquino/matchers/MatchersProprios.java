package br.ce.wcaquino.matchers;

import java.util.Calendar;

// Classe com métodos estáticos para criar matchers personalizados
public class MatchersProprios {

    // Método estático que retorna um matcher para verificar se uma data é de um determinado dia da semana
    public static DiaSemanaMatcher caiEm(Integer diaSemana) {
        return new DiaSemanaMatcher(diaSemana);
    }

    // Método estático que retorna um matcher para verificar se uma data é de uma segunda-feira
    public static DiaSemanaMatcher caiNumaSegunda(){
        return new DiaSemanaMatcher(Calendar.MONDAY);
    }

    // Método estático que retorna um matcher para verificar se uma data é a data atual mais uma diferença de dias
    public static DataDiferencaDiasMatcher ehHojeComDiferencaDias(Integer qtdDias) {
        return new DataDiferencaDiasMatcher(qtdDias);
    }

    // Método estático que retorna um matcher para verificar se uma data é a data atual
    public static DataDiferencaDiasMatcher ehHoje() {
        return new DataDiferencaDiasMatcher(0);
    }
}