package contas;

import clientes.Cliente;
import clientes.ClientePessoaFisica;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int numero, int agencia, ClientePessoaFisica titular) {
        super(numero, agencia, titular);
    }
    
} 