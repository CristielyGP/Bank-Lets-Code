package contas;

import clientes.Cliente;
import clientes.ClientePessoaJuridica;

public abstract class Conta {

    private int numero;
    private int agencia;
    private Cliente titular;
    private double saldo;

    public Conta(int numero, int agencia, Cliente titular) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
    }

    public boolean sacar(double valor) {

        if (this.getTitular() instanceof ClientePessoaJuridica)
            valor *= 1.005;

        if (this.getSaldo() >= valor) {
            this.saldo -= valor;
            mostrarSaldo(Operacoes.sacar.toString());
            return true;
        } else {
            System.out.println("Saldo indisponível");
            return false;
        }
    }

    public void depositar(double valor) {
        if (this.getTitular() instanceof ClientePessoaJuridica)
            valor -= valor*0.005;

        this.saldo += valor;
        mostrarSaldo(Operacoes.depositar.toString());

    }

    public boolean transferir(double valor, Conta destino) {
        
        if (this.getTitular() instanceof ClientePessoaJuridica)
            valor -= valor*0.005;

        if (this.sacar(valor)) {
            destino.depositar(valor);
            mostrarSaldo(Operacoes.transferir.toString());
            return true;
        } else {
            if(destino == null)
                System.out.println("Conta destino inexistente");
            
            if(this.saldo < valor)
                System.out.println("Saldo insuficiente");
                
            return false;
        }
    }

    public void mostrarSaldo(String operacao) {
        System.out.println("A operação de " + operacao + " foi realizada com sucesso! O saldo da conta " + this.getNumero() + " agora é " + this.getSaldo());
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
