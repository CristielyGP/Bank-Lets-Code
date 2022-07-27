package clientes;

public class ClientePessoaFisica extends Cliente{     
     String cpf;

    public ClientePessoaFisica(String nome, String cpf, String telefone){
        super(nome,telefone);
        this.cpf = cpf;
        
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
