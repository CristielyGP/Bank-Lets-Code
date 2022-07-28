package contas;

import clientes.Cliente;

public class ContaCorrente extends Conta{

    public ContaCorrente(int numero, int agencia, Cliente titular) {
        super(numero, agencia, titular);
    }
    
}