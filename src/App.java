import contas.*;
import clientes.*;

public class App {
    public static void main(String[] args) throws Exception {

        ClientePessoaJuridica cli1 = new ClientePessoaJuridica("dburger", "servicenow", "4321gecap1");
        ClientePessoaFisica cli2 = new ClientePessoaFisica("artur", "queridão", "700nn033");

        ContaCorrente conta1 = new ContaCorrente(0, 0, cli1);
        ContaCorrente conta2 = new ContaCorrente(1, 1, cli2);

        conta1.depositar(1000);
        conta1.transferir(500, conta2);

    }
}
