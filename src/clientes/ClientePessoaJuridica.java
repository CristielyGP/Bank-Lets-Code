package clientes;

public class ClientePessoaJuridica extends Cliente{
       
     String cnpj;
     double taxa=0.005;
     double rendimento=0.02;

    public ClientePessoaJuridica(String nome, String cnpj, String telefone){
        super(nome,telefone);
        this.cnpj = cnpj;        
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}

    
