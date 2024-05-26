package org.luiscarlos;

public interface IConta {
    void sacar(double valor, String senha);
    void depositar(double valor);
    void transferir(double valor, IConta contaDestino, String senha);
    void imprimirExtrato();
}
