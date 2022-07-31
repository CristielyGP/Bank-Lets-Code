import contas.*;
import clientes.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static boolean listou = false;

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Conta> listaContas = new ArrayList<Conta>();
        int opcao = 0, contaAcessada = -1, valor, numeroContaDestino;

        // Exemplos de teste
        /*
         * ClientePessoaJuridica cli1 = new ClientePessoaJuridica("dburger",
         * "servicenow", "4321gecap1");
         * ClientePessoaFisica cli2 = new ClientePessoaFisica("artur", "queridão",
         * "700nn033");
         * 
         * ContaCorrente conta10 = new ContaCorrente(0, 0, cli1);
         * listaContas.add(conta10);
         * ContaCorrente conta20 = new ContaCorrente(1, 1, cli2);
         * listaContas.add(conta20);
         * 
         * conta10.depositar(1000);
         * conta10.transferir(500, conta20);
         */

        // telinhas improvisadas

        while (opcao != -1) {

            System.out.println("-----------------------------------------------------------");
            System.out.println("------------------Bem vindos a Let's Bank------------------");
            System.out.println("-----------------------------------------------------------");
            System.out.println("**** Entre com sua conta ou crie uma nova para começar ****");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|   Opção 1 - Criar conta   |");
            System.out.println("|   Opção 2 - Acessar conta |");
            System.out.println("|   Opção 3 - Listar Contas |");
            System.out.println("|   Opção 4 - Sair          |");

            opcao = scanner.nextInt();
            scanner.nextLine();
            listou = false;

            switch (opcao) {
                case 1:
                    System.out.print("Por favor, digite seu nome: ");
                    String nome = scanner.nextLine().trim();
                    System.out.print("Por favor, digite seu telefone: ");
                    String telefone = scanner.nextLine().trim();

                    System.out.println(
                            "Qual tipo da pessoa: Física ou Jurídica? Digite F para primeira opção e J para segunda");
                    char tipoPessoa = scanner.nextLine().toLowerCase().charAt(0);

                    if (tipoPessoa == 'f') {
                        System.out.print("Por favor, digite seu CPF: ");
                        String cpf = scanner.nextLine().trim();
                        System.out.println(
                                "Qual tipo da conta: Poupança (P), Corrente (C) ou Investimento (I)? Digite a letra correspondente a opção desejada");
                        char tipoConta = scanner.nextLine().toLowerCase().charAt(0);
                        switch (tipoConta) {

                            case 'p':
                                ClientePessoaFisica cliente1 = new ClientePessoaFisica(nome, cpf, telefone);
                                ContaPoupanca conta1 = new ContaPoupanca(Conta.numeroDeContas, 1, cliente1);
                                listaContas.add(conta1);
                                System.out.printf("Conta criada: número %s e agencia %s", conta1.getNumero(),
                                        conta1.getAgencia());
                                contaAcessada = listaContas.size() - 1;
                                break;
                            case 'c':
                                ClientePessoaFisica cliente2 = new ClientePessoaFisica(nome, cpf, telefone);
                                ContaCorrente conta2 = new ContaCorrente(Conta.numeroDeContas, 2, cliente2);
                                listaContas.add(conta2);
                                System.out.printf("Conta criada: número %s e agencia %s", conta2.getNumero(),
                                        conta2.getAgencia());
                                contaAcessada = listaContas.size() - 1;
                                break;
                            case 'i':
                                ClientePessoaFisica cliente3 = new ClientePessoaFisica(nome, cpf, telefone);
                                ContaInvestimento conta3 = new ContaInvestimento(Conta.numeroDeContas, 3, cliente3);
                                listaContas.add(conta3);
                                System.out.printf("Conta criada: número %s e agencia %s", conta3.getNumero(),
                                        conta3.getAgencia());
                                contaAcessada = listaContas.size() - 1;
                                break;

                            default:
                                System.out.println("Digite uma opção válida!");
                                break;

                        }

                    } else if (tipoPessoa == 'j') {
                        System.out.print("Por favor, digite seu CNPJ: ");
                        String cnpj = scanner.nextLine().trim();
                        System.out.println(
                                "Qual tipo da conta: Corrente (C) ou Investimento (I)? Digite a letra correspondente a opção desejada");
                        char tipoConta = scanner.nextLine().toLowerCase().charAt(0);

                        switch (tipoConta) {

                            case 'c':
                                ClientePessoaJuridica cliente4 = new ClientePessoaJuridica(nome, cnpj, telefone);
                                ContaCorrente conta4 = new ContaCorrente(Conta.numeroDeContas, 4, cliente4);
                                listaContas.add(conta4);
                                System.out.printf("Conta criada: número %s e agencia %s", conta4.getNumero(),
                                        conta4.getAgencia());
                                contaAcessada = listaContas.size() - 1;
                                break;
                            case 'i':
                                ClientePessoaJuridica cliente5 = new ClientePessoaJuridica(nome, cnpj, telefone);
                                ContaInvestimento conta5 = new ContaInvestimento(Conta.numeroDeContas, 5, cliente5);
                                listaContas.add(conta5);
                                System.out.printf("Conta criada: número %s e agencia %s", conta5.getNumero(),
                                        conta5.getAgencia());
                                contaAcessada = listaContas.size() - 1;
                                break;

                            default:
                                System.out.println("Digite uma opção válida!");
                                break;
                        }

                    } else {
                        System.out.println("Digite uma opção válida F pessoa física e J para pessoa jurídoca");
                    }
                    break;

                case 2:
                    if (listaContas.isEmpty()) {
                        System.out.println("Nenhuma conta registrada!");
                        listou = true;
                        esperaProximaOperacao();
                        break;
                    }
                    System.out.println("Digite o numero da conta");
                    int numeroConta = scanner.nextInt();
                    for (int i = 0; i < listaContas.size(); ++i) {
                        if (listaContas.get(i).getNumero() == numeroConta) {
                            contaAcessada = i;
                            System.out.println("Conta acessada " + listaContas.get(i).getTitular().getNome());
                            listou = false;
                            esperaProximaOperacao();  
                            break;
                        }
                        else if(i == listaContas.size()){
                            System.out.println("Conta não encontrada!");
                            listou = true;
                            esperaProximaOperacao();   
                        }
                    }
                    if (contaAcessada == -1) {
                        System.out.println("Número da conta inválido, por favor reinicie a aplicação");
                        return;
                    }                  
                                
                    
                    break;

                case 3:
                    listarContas(listaContas);
                    esperaProximaOperacao();
                    break;

                case 4:
                    if (contaAcessada == -1) {
                        System.out.println("Obrigado por usar Let's Bank! Até a próxima!");
                        return;
                    }
            }

            if (!listou) {
                while (opcao != 5) {
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("------------------Bem vindos a Let's Bank------------------");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("*****    Selecione uma operação que deseja realizar   *****");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("|   Opção 1 - Sacar         |");
                    System.out.println("|   Opção 2 - Depositar     |");
                    System.out.println("|   Opção 3 - Transferir    |");
                    System.out.println("|   Opção 4 - Ver Saldo     |");
                    System.out.println("|   Opção 5 - Voltar        |");
                    System.out.println("|   Opção 6 - Sair          |");

                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.println("Digite o valor a ser sacado");
                            valor = scanner.nextInt();
                            listaContas.get(contaAcessada).sacar(valor);
                            esperaProximaOperacao();
                            break;

                        case 2:
                            System.out.println("Digite o valor a ser depositado");
                            valor = scanner.nextInt();
                            listaContas.get(contaAcessada).depositar(valor);
                            esperaProximaOperacao();
                            break;

                        case 3:
                            System.out.println("Digite o valor a ser transferido");
                            valor = scanner.nextInt();
                            System.out.println("Digite o número da conta destino");
                            numeroContaDestino = scanner.nextInt();
                            try{
                                listaContas.get(contaAcessada).transferir(valor, listaContas.get(numeroContaDestino));
                            } catch (Exception e){
                                System.out.println("Conta destino inexistente!");
                            }
                            esperaProximaOperacao();
                            break;

                        case 4:
                            listaContas.get(contaAcessada).mostrarSaldo();
                            esperaProximaOperacao();
                            break;

                        case 5:
                            continue;

                        case 6:
                            System.out.println("Obrigado por usar Let's Bank! Até a próxima!");
                            opcao = -1;
                    }
                    listou = false;
                }
            }
        }

    }

    public static void listarContas(ArrayList<Conta> listaContas) {

        listou = true;

        if (listaContas.isEmpty())
            System.out.println("Nenhuma conta encontrada!");

        for (int i = 0; i < listaContas.size(); ++i) {
            // toString
            System.out.println("Conta numero " + listaContas.get(i).getNumero()
                    + " pertencente a " + listaContas.get(i).getTitular().getNome());
        }
    }

    public static void esperaProximaOperacao(){
      
        System.out.println("Pressione qualquer tecla para continuar...");
        try {
            System.in.read();
        } catch (IOException e) {            
            e.printStackTrace();
        }
    }

}
