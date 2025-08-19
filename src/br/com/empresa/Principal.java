/**
 * Olá! Seja bem-vindo(a) ao código :)
 *
 * Vou ser bem sincero: já fazia bastante tempo que eu não trabalhava com Java.
 * Profissionalmente, minha última experiência sólida com a linguagem foi há uns
 * 2 anos. Depois disso, voltei a rever os conceitos principais no primeiro semestre
 * do ano passado.
 *
 * Nesse processo precisei revisitar e reforçar vários fundamentos importantes:
 * - Boas práticas do próprio Java
 * - Criação de classes
 * - Herança e Polimorfismo
 * - Responsabilidade Única
 * - Programação Orientada a Objetos no geral (kkkkk)
 *
 * Embora eu tenha começado a trabalhar com Java na empresa CIAware,
 * acabei me especializando mais em JavaScript/TypeScript, principalmente
 * para uso no Front-End.
 *
 * Ainda assim, estou muito disposto a me desenvolver ainda mais com Java
 * e dominá-lo de vez.
 */

package br.com.empresa;

import java.math.BigDecimal;
import java.text.Collator;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

// Declaro a classe principal do programa que contem o método main
// Fiquei na dúvida se criava Main ou Principal, mas no fim optei por seguir as instruções mesmo
public class Principal {
    // Declaro a constante SALARIO_MINIMO para poder usar em futuros cálculos
    // Uso BigDecimal para poder ter uma maior precisão com os valores monetários
    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    // Declaro o método principal da aplicação
    public static void main(String[] args) {
        // Chamo o método auxiliar carregarFuncionarios para inicializar a lista de funcionários
        List<Funcionario> funcionarios = carregarFuncionarios();
        // Removo o funcionário chamado "João". Como só existe um João na tabela optei por usar o método "equalsIgnoreCase"
        // para maior abrangência
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase("João"));

        // Imprimo a lista de funcionários cadastrados usando o método imprimir
        System.out.println("\n1. === Listagem de Funcionários ===");
        FuncionarioPrinter.imprimir(funcionarios);

        // Aplico o reajuste salarial de 10% aos salários dos funcionários
        funcionarios.forEach(f -> f.aplicarReajustePercentual(new BigDecimal("0.10")));
        // Não foi solicitado que reimprimisse após o reajuste, mas julguei que seria melhor para visualização e
        // comparação entre os outros dados exibidos abaixo
        System.out.println("\n1.1. === Listagem de Funcionários (com reajuste de 10% aplicado) ===");
        FuncionarioPrinter.imprimir(funcionarios);

        // Agrupo os funcionários por função e imprimo com o método imprimirAgrupadosPorFuncao
        Map<String, List<Funcionario>> funcionariosPorFuncao = FuncionarioUtils.agruparPorFuncao(funcionarios);
        System.out.println("\n2. === Funcionários Agrupados por Função ===");
        FuncionarioPrinter.imprimirAgrupadosPorFuncao(funcionariosPorFuncao);

        // Filtro apenas os funcionários que fazem aniversário nos meses de outubro e dezembro e imprimo com o
        // método imprimir
        System.out.println("\n3. === Funcionários que Fazem Aniversário em Outubro(10) e Dezembro(12) ===");
        List<Funcionario> funcionariosAniversariantes = FuncionarioUtils.aniversariantesDoMes(funcionarios,
                10, 12
        );
        FuncionarioPrinter.imprimir(funcionariosAniversariantes);

        // Busco pelo funcionário mais velho e imprimo seus daos
        System.out.println("\n4. === Funcionário com Maior Idade ===");
        Optional<Funcionario> funcionarioMaisVelho = FuncionarioUtils.funcionarioMaisVelho(funcionarios);
        FuncionarioPrinter.imprimirMaisVelho(funcionarioMaisVelho);

        // Ordeno a lista de funcionários em ordem alfabética pelo nome, usando Collator para comparação e imprimo
        // no console
        System.out.println("\n5. === Listagem de Funcionários (em ordem alfabética) ===");
        Collator collator = Collator.getInstance(FormatUtils.PT_BR);
        List<Funcionario> funcionariosOrdenados = funcionarios.stream().sorted(
                Comparator.comparing(Funcionario::getNome, collator)
        ).toList();
        FuncionarioPrinter.imprimir(funcionariosOrdenados);

        // Imprimo o total de todos os salários dos funcionários com o método imprimirTotalSalarios
        System.out.println("\n6. === Total de Salários dos Funcionários (após reajuste de 10%) ===");
        FuncionarioPrinter.imprimirTotalSalarios(funcionarios);

        // Imprimo a qtd de salários-mínimos de cada funcionário com o método imprimirSalariosMinimos
        System.out.println("\n7. === Salários-mínimos por Funcionário (salário-mínimo: R$ 1.212,00) ===");
        FuncionarioPrinter.imprimirSalariosMinimos(funcionarios, SALARIO_MINIMO);
    }

    // Declaro o método auxiliar carregarFuncionarios que cria e retorna a lista de funcionários fixos, simulando os
    // dados da tabela
    private static List<Funcionario> carregarFuncionarios() {
        // Começo criando uma lista mutável para armazenar os funcionários
        List<Funcionario> list = new ArrayList<>();

        // Adiciono manualmente cada funcionário à lista com seus respectivos dados
        list.add(new Funcionario("Maria", LocalDate.of(2000, Month.OCTOBER, 18),
                new BigDecimal("2009.44"), "Operador")
        );
        list.add(new Funcionario("João", LocalDate.of(1990, Month.MAY, 12),
                new BigDecimal("2284.38"), "Operador")
        );
        list.add(new Funcionario("Caio", LocalDate.of(1961, Month.MAY, 2),
                new BigDecimal("9836.14"), "Coordenador")
        );
        list.add(new Funcionario("Miguel", LocalDate.of(1988, Month.OCTOBER, 14),
                new BigDecimal("19119.88"), "Diretor")
        );
        list.add(new Funcionario("Alice", LocalDate.of(1995, Month.JANUARY, 5),
                new BigDecimal("2234.68"), "Recepcionista")
        );
        list.add(new Funcionario("Heitor", LocalDate.of(1999, Month.NOVEMBER, 19),
                new BigDecimal("1582.72"), "Operador")
        );
        list.add(new Funcionario("Arthur", LocalDate.of(1993, Month.MARCH, 31),
                new BigDecimal("4071.84"), "Contador")
        );
        list.add(new Funcionario("Laura", LocalDate.of(1994, Month.JULY, 8),
                new BigDecimal("3017.45"), "Gerente")
        );
        list.add(new Funcionario("Heloísa", LocalDate.of(2003, Month.MAY, 24),
                new BigDecimal("1606.85"), "Eletricista")
        );
        list.add(new Funcionario("Helena", LocalDate.of(1996, Month.SEPTEMBER, 2),
                new BigDecimal("2799.93"), "Gerente")
        );

        // Por fim devolvo a lista com todos os funcionários
        return list;
    }
}
