package contas;

import clientes.Cliente;

public abstract class ContaRentavel extends Conta {
        
    public ContaRentavel(int numero, int agencia, Cliente titular) throws Exception {
        super(numero, agencia, titular);
    }

    public abstract void render();

}
