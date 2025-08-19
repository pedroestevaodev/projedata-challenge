package br.com.empresa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Declaro a classe utilitária FuncionarioPrinter para agrupar os métodos de impressão/exibição dos dados dos
// funcionários
public class FuncionarioPrinter {
    // Declaro o método formatarFuncionario que devolve uma String formatada dos dados do funcionário
    public static String formatarFuncionario(Funcionario funcionario) {
        // Uso o BR_DATE para formatar a data para o padrão brasileiro
        String data = FormatUtils.BR_DATE.format(funcionario.getDataNascimento());
        // Uso o BR_NUMBER para formatar o número do salário para o padrão brasileiro
        String salario = FormatUtils.BR_NUMBER.format(funcionario.getSalario());

        // Devolvo uma string tabulada com os dados do funcionario
        return String.format("%-15s %-20s %-15s %-15s", funcionario.getNome(), data, salario, funcionario.getFuncao());
    }

    // Declaro o método imprimir que é responsável por imprimrir no console os dados dos funcionários
    public static void imprimir(List<Funcionario> funcionarios) {
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-15s %-15s%n", "Nome", "Data Nascimento", "Salário", "Função");
        System.out.println("------------------------------------------------------------------------");
        // Passo a lista de funcionários para o método formatarFuncionario que devolverá os dados de cada
        // funcionário formatados
        funcionarios.forEach(f -> System.out.println(formatarFuncionario(f)));
    }

    // Declaro o método imprimirAgrupadosPorFuncao que é responsável por imprimir a lista de funcionários, mas agrupados
    // por cada uma das funções existentes
    public static void imprimirAgrupadosPorFuncao(Map<String, List<Funcionario>> porFuncao) {
        // Percorro as entradas do Map e ordeno alfabeticamente pela chave, devolvendo os dados tabulados
        porFuncao.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
            System.out.printf("%-25s %-25s %-25s%n", "====================", entry.getKey(), "====================");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-15s %-20s %-15s %-15s%n", "Nome", "Data Nascimento", "Salário", "Função");
            System.out.println("------------------------------------------------------------------------");
            // Exibo os dados formatados de cada funcionário da função atual
            entry.getValue().forEach(f -> System.out.println(formatarFuncionario(f) + "\n"));
        });
    }

    // Declaro o método imprimirMaisVelho que imprime os dados tabulados do funcionário mais velho
    public static void imprimirMaisVelho(Optional<Funcionario> funcionario) {
        System.out.println("-----------------------------");
        System.out.printf("%-15s %-15s%n", "Nome", "Idade");
        System.out.println("-----------------------------");
        // Verifico se o Optional contem um funcionário válido, e caso sim, exibo os dados do mesmo
        funcionario.ifPresent(
                f -> System.out.printf("%-15s %-15s%n", f.getNome(), f.getIdade() + " anos")
        );
    }

    // Declaro o método imprimirTotalSalarios que imprime os dados tabulados do total de salários
    public static void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        // Começo somando todos os salários dos funcionários usando reduce
        BigDecimal totalSalarios = funcionarios.stream().map(Funcionario::getSalario).reduce(
                BigDecimal.ZERO, BigDecimal::add
        );
        System.out.println("-------------");
        System.out.printf("%-15s%n", "Total");
        System.out.println("-------------");
        // Por fim exibo o resultado da soma
        System.out.printf("%-15s%n", FormatUtils.BR_NUMBER.format(totalSalarios));
    }

    // Declaro o método imprimirSalariosMinimos que imprime os dados tabulados da quantidade de salários-mínimos de
    // cada funcionário
    public static void imprimirSalariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo) {
        System.out.println("-----------------------------------------");
        System.out.printf("%-15s %-25s%n", "Nome", "Qtd. Salários-mínimos");
        System.out.println("-----------------------------------------");
        // Percorro cada funcionário dividindo seu salário pelo salário mínimo, arredondando para duas casas decimais e
        // exibo os dados tabulados
        funcionarios.forEach(f -> {
            BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.printf("%-15s %-25s%n", f.getNome(), FormatUtils.BR_NUMBER.format(qtd));
        });
    }
}
