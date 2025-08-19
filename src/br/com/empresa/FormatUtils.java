package br.com.empresa;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// Declaro a classe utilitária FormatUtils para centralizar métodos de manipulação/formatação
public class FormatUtils {
    // Declaro o formatador BR_DATE para o padrão brasileiro
    public static final DateTimeFormatter BR_DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // Declaro a localidade para PT-BR para ajudar em formatações
    public static final Locale PT_BR = Locale.forLanguageTag("pt-BR");
    // Declaro o formatador BR_NUMBER para formatar números no padrão PT_BR
    public static final NumberFormat BR_NUMBER = NumberFormat.getNumberInstance(PT_BR);
    // Declaro eles como públicos para poderem ser usados por outras clásses e métodos
    // Adicionei final pois são campos que não irão mudar depois da incialização

    // Declaro o construtor como privado para impedir que a classe seja instanciada
    private FormatUtils() {}
}
