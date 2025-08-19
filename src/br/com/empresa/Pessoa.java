package br.com.empresa;

import java.time.LocalDate;

// Declaro a classe Pessoa que é pública e pode ser acessada por outras classes
public class Pessoa {
    // Declaro a String nome e o LocalDate dataNascimento como campos privados para serem usados somente pela própria
    // classe e adiciono final para indicar que o valor não será alterado depois da inicialização
    private final String nome;
    private final LocalDate dataNascimento;

    // Declaro o construtor público, que recebe os parâmetros para inicialização dos campos
    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    // Declaro o método getNome como público para poder retornar o nome da pessoa
    public String getNome() {
        return nome;
    }

    // Declaro o método getDataNascimento como público para poder retornar a data de nascimento da pessoa
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
