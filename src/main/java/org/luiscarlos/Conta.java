package org.luiscarlos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Conta implements IConta {
    private static int SEQUENCIAL = 1;
    private static final int AGENCIA_PADRAO = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<String> transacoes;
    private String senha;

    public Conta(Cliente cliente, String senha) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0;
        this.transacoes = new ArrayList<>();
        this.senha = senha;
    }

    protected boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        transacoes.add("Depósito de: " + valor);
    }

    @Override
    public void sacar(double valor, String senha) {
        if (autenticar(senha)) {
            if (saldo >= valor) {
                saldo -= valor;
                transacoes.add("Saque de: " + valor);
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Senha incorreta.");
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino, String senha) {
        if (autenticar(senha)) {
            if (saldo >= valor) {
                this.sacar(valor, senha);
                contaDestino.depositar(valor);
                transacoes.add("Transferência de: " + valor + " para conta com número " + ((Conta) contaDestino).numero);
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Senha incorreta.");
        }
    }

    @Override
    public void imprimirExtrato() {
        imprimirInfosComuns();
        transacoes.forEach(System.out::println);
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agência: %d%n", this.agencia);
        System.out.printf("Número: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }
}
