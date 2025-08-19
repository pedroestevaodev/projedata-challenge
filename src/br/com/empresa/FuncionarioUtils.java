package br.com.empresa;

import java.util.*;
import java.util.stream.Collectors;

// Declaro a classe utilitária FuncionarioUtils onde centralizei os métodos utilizados para operações sobre coleções
// de funcionários
public class FuncionarioUtils {
    // Declaro o método aniversariantesDoMes que devolve uma lista com os aniversariantes dos meses informados no
    // varargs meses
    public static List<Funcionario> aniversariantesDoMes(List<Funcionario> funcionarios, int... meses) {
        // Primeiro converto o array de meses em um Set para busca O(1) e evitar dados duplicados
        Set<Integer> mesesSet = Arrays.stream(meses).boxed().collect(Collectors.toSet());
        // Depois retorno um stream da lista de funcionários filtrando apenas pelos que têm o mês de nascimento
        // dentro do Set, e coloco em uma nova lista
        return funcionarios.stream().filter(f -> mesesSet.contains(f.getDataNascimento().getMonthValue())).collect(
                Collectors.toList()
        );
    }

    // Declaro o método funcionarioMaisVelho que devolve o funcionário mais velho. Criei como opcional pois pode haver
    // o caso em que
    public static Optional<Funcionario> funcionarioMaisVelho(List<Funcionario> funcionarios) {
        // Retorno a lista de funcionários comparando entre si para encontrar a menor data de nascimento
        return funcionarios.stream().min(Comparator.comparing(Funcionario::getDataNascimento));
    }

    // Declaro o método agruparPorFuncao que agrupa os funcionários por função, retornando um Map onde a chave é
    // a função e o valor é a lista de funcionários que possuem a função
    public static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        // Uso groupingBy para criar um mapa de agrupamento e LinkedHashMap para preservar a ordem de inserção
        // das chaves
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao, LinkedHashMap::new,
                Collectors.toList()
        ));
    }
}
