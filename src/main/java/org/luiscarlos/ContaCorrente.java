package org.luiscarlos;

public class ContaCorrente extends Conta {
    private static final double TAXA_OPERACAO = 0.1;

    public ContaCorrente(Cliente cliente, String senha) {
        super(cliente, senha);
    }

    @Override
    public void sacar(double valor, String senha) {
        if (saldo >= (valor + TAXA_OPERACAO)) {
            super.sacar(valor + TAXA_OPERACAO, senha);
        } else {
            System.out.println("Saldo insuficiente para cobrir o valor e a taxa de operação.");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirExtrato();
        System.out.println("=== === === === === === === ===");
    }
}
