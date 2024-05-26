package org.luiscarlos;

public class ContaPoupanca extends Conta {
    private static final double TAXA_JUROS_ANUAL = 0.05;

    public ContaPoupanca(Cliente cliente, String senha) {
        super(cliente, senha);
    }

    public void aplicarJuros() {
        double juros = this.saldo * TAXA_JUROS_ANUAL;
        this.depositar(juros);
        transacoes.add("Juros aplicados: " + juros);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirExtrato();
        System.out.println("=== === === === === === === ===");
    }
}
