package contas;

import java.math.BigDecimal;

import clientes.Cliente;
import clientes.ClientePessoaJuridica;

public class ContaInvestimento extends ContaRentavel {

    private static BigDecimal rendimento = BigDecimal.valueOf(0);
    private final BigDecimal rendimentoAdicionalPJ = BigDecimal.valueOf(0.02);
    
    public ContaInvestimento(int numero, int agencia, Cliente titular) {
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
        if (this.getTitular() instanceof ClientePessoaJuridica) {
            this.operacaoDeposito(this.getSaldo()
                                      .multiply(ContaInvestimento.getRendimento()
                                                    .add(rendimentoAdicionalPJ))); 
        } else {
            this.operacaoDeposito(this.getSaldo()
                                      .multiply(ContaInvestimento.getRendimento())); 
        }
    }
    
}
