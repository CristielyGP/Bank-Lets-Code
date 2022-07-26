package contas;

import java.math.BigDecimal;
import java.util.HashSet;


import clientes.Cliente;
import clientes.ClientePessoaJuridica;

public abstract class Conta {

    public static int numeroDeContas = 1;
    private static HashSet<Integer[]> controladorDeContas = new HashSet<>();
    private int numero;
    private int agencia;
    private Cliente titular;
    private BigDecimal saldo;

    public Conta(int numero, int agencia, Cliente titular) throws Exception {
        if (titular == null) {
            throw new NullPointerException("Cliente inválido.");
        }
        Integer[] novoCodigoConta = {agencia, numero};
        if (controladorDeContas.contains(novoCodigoConta)) {
            throw new Exception("Conta já existente.");
        }
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = BigDecimal.valueOf(0);
        controladorDeContas.add(novoCodigoConta);
        numeroDeContas++;
    }
    
    public void sacar(double valor) {
        if(this.operacaoSaque(valor)) {
            //mostrarSaldo(Operacoes.sacar.toString());
            mostrarSaldo();
        } else {
            System.out.println("Saldo indisponível");
        }
    }

    private boolean operacaoSaque(double valor) {
        if (this.getTitular() instanceof ClientePessoaJuridica) {
            valor = valor*1.005;
        }

        if (this.getSaldo().compareTo(BigDecimal.valueOf(valor)) >= 0) {
            this.setSaldo(this.getSaldo()
                              .subtract(BigDecimal.valueOf(valor)));
            return true;
        } else {
            return false;
        }
    }

    public void depositar(double valor) {
        if(this.operacaoDeposito(BigDecimal.valueOf(valor))) {
            //mostrarSaldo(Operacoes.depositar.toString());
            mostrarSaldo();
        } else {
            System.out.println("Um erro aconteceu durante a operação de depósito. Operação Abortada.");
        }
    }

    protected boolean operacaoDeposito(BigDecimal valor) {
        this.setSaldo(this.getSaldo()
                          .add(valor));
        return true;
    }

    public void transferir(double valor, Conta destino) {
        if(destino != null) {
            if (this.operacaoSaque(valor)) {
                destino.depositar(valor);
                mostrarSaldo();
                //mostrarSaldo(Operacoes.transferir.toString());
            } else {
                System.out.println("Saldo insuficiente");    
            }
        } else {
            System.out.println("Conta destino inexistente");
        }
    }

    public void mostrarSaldo() {
        System.out.println("O saldo da conta " + this.getNumero() + " atual é " + this.getSaldo());
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

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    private void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
