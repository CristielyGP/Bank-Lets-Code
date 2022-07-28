import contas.*;
import clientes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App {   
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Conta> listaContas = new ArrayList<Conta>();
        int opcao, contaAcessada = -1, valor, numeroContaDestino;


        //Exemplos de teste
        ClientePessoaJuridica cli1 = new ClientePessoaJuridica("dburger", "servicenow", "4321gecap1");
        ClientePessoaFisica cli2 = new ClientePessoaFisica("artur", "queridão", "700nn033");

        ContaCorrente conta1 = new ContaCorrente(0, 0, cli1);
        listaContas.add(conta1);
        ContaCorrente conta2 = new ContaCorrente(1, 1, cli2);
        listaContas.add(conta2);

        conta1.depositar(1000);
        conta1.transferir(500, conta2);


        //telinhas improvisadas

        System.out.println("-----------------------------------------------------------");
        System.out.println("------------------Bem vindos a Let's Bank------------------");
        System.out.println("-----------------------------------------------------------");
        System.out.println("**** Entre com sua conta ou crie uma nova para começar ****");
        System.out.println("-----------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Acessar conta |");

        opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao){
            case 1:
                //contaAcessada = criarConta();
                break;

            case 2:
                System.out.println("Digite o numero da conta");
                int numeroConta = scanner.nextInt();
                for(int i = 0; i<listaContas.size(); ++i){
                    if(listaContas.get(i).getNumero() == numeroConta){
                        contaAcessada = i;
                        System.out.println("Conta acessada " + listaContas.get(i).getTitular().getNome());
                        continue;
                    }
                }
                if(contaAcessada == -1){
                    System.out.println("Número da conta inválido, por favor reinicie a aplicação");
                    return;
                }
        }

        System.out.println("-----------------------------------------------------------");
        System.out.println("------------------Bem vindos a Let's Bank------------------");
        System.out.println("-----------------------------------------------------------");
        System.out.println("*****    Selecione uma operação que deseja realizar   *****");
        System.out.println("-----------------------------------------------------------");
        System.out.println("|   Opção 1 - Sacar         |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Transferir    |");
        System.out.println("|   Opção 4 - Listar        |");
        System.out.println("|   Opção 5 - Sair          |");

        opcao = scanner.nextInt();
        scanner.nextLine();


        switch(opcao){            
            case 1:
                System.out.println("Digite o valor a ser sacado");
                valor = scanner.nextInt();
                listaContas.get(contaAcessada).sacar(valor);
                break;

            case 2:
                System.out.println("Digite o valor a ser depositado");
                valor = scanner.nextInt();
                listaContas.get(contaAcessada).depositar(valor);
                break;

            case 3:
                System.out.println("Digite o valor a ser transferido");
                valor = scanner.nextInt(); 
                System.out.println("Digite o número da conta destino");
                numeroContaDestino = scanner.nextInt();
                break;

            case 4:
                listarContas(listaContas);
                break;
        }       

    }

    public static void criarConta() {
    
    }

    public static void listarContas(ArrayList<Conta> listaContas) {
        for(int i = 0; i<listaContas.size(); ++i){
            //toString
            System.out.println("Conta numero " + listaContas.get(i).getNumero() 
                            + " pertencente a " + listaContas.get(i).getTitular().getNome());
        }
    }

    

}
