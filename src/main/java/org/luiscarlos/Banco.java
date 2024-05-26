package org.luiscarlos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(int numeroConta) {
        contas.removeIf(conta -> conta.getNumero() == numeroConta);
    }

    public Conta buscarContaPorNumero(int numeroConta) {
        return contas.stream()
                .filter(conta -> conta.getNumero() == numeroConta)
                .findFirst()
                .orElse(null); // Ou lançar uma exceção se preferir
    }

    public double calcularTotalSaldos() {
        return contas.stream()
                .mapToDouble(Conta::getSaldo)
                .sum();
    }

    public void imprimirRelatorioContas() {
        System.out.println("Relatório de Contas do Banco " + this.nome);
        contas.forEach(Conta::imprimirExtrato);
    }
}
