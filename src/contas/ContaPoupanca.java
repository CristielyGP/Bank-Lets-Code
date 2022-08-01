package contas;

import java.math.BigDecimal;

import clientes.ClientePessoaFisica;

public class ContaPoupanca extends ContaRentavel  {

    private static BigDecimal rendimento = BigDecimal.valueOf(0);

    public ContaPoupanca(int numero, int agencia, ClientePessoaFisica titular) throws Exception {
        super(numero, agencia, titular);
    }

    
    public static BigDecimal getRendimento() {
        return rendimento;
    }

    public static void setRendimento(double novoRendimento) {
        rendimento = BigDecimal.valueOf(novoRendimento);
    }
    
    @Override
    public void render() {
       this.operacaoDeposito(this.getSaldo().multiply(ContaPoupanca.getRendimento())); 
    }

    
}