package br.com.empresa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

// Declaro a classe Funcionario que é pública e pode ser acessada por outras classes. Ela estenda a classe Pessoa
// podendo herdar seus campos e métodos
public class Funcionario extends Pessoa {
    // Declaro o BigDecimal salario e a String funcao como campos privados para serem usados somente pela própria classe
    // Como realizei o reajuste de 10% na classe Principal, não faz sentido adicionar o final na declaração do campo
    private BigDecimal salario;
    // Como não alterei a função dos funcionários em nenhum momento, optei por adicionar o final no campo funcao
    private final String funcao;

    // Declaro o construtor público, que recebe os parâmetros para inicialização dos campos (inclusive os
    // herdados de Pessoa)
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        // Chamo o construtor da classe Pessoa, inicializando seus respectivos campos
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    // Declaro o método getSalario como público para poder retornar o salário do funcionário
    public BigDecimal getSalario() {
        return salario;
    }

    // Declaro o método getFuncao como público para poder retornar a função do funcionário
    public String getFuncao() {
        return funcao;
    }

    // Declaro o método aplicarReajustePercentual público para aplicar um reajuste no salário do funcionário
    public void aplicarReajustePercentual(BigDecimal percentual) {
        BigDecimal fator = BigDecimal.ONE.add(percentual);
        this.salario = this.salario.multiply(fator).setScale(2, RoundingMode.HALF_UP);
    }

    // Declaro o método getIdade público para calcular a idade do funcionário
    public int getIdade() {
        // Uso Period.between para calcular o intervalo entre a data de nascimento e a data atual
        return Period.between(getDataNascimento(), LocalDate.now()).getYears();
    }
}
