package org.luiscarlos;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco do Desenvolvedor");
        Cliente cliente1 = new Cliente("João da Silva", "123.456.789-00");
        Conta cc = new ContaCorrente(cliente1, "1234");
        ContaPoupanca poupanca = new ContaPoupanca(cliente1, "1234");

        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        cc.depositar(100);
        cc.transferir(50, poupanca, "1234");

        poupanca.aplicarJuros();

//        cc.imprimirExtrato();
//        poupanca.imprimirExtrato();
        banco.imprimirRelatorioContas();
    }
}