package programa;

import java.util.ArrayList;
import java.util.Scanner;

public class agenciaBancaria {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();

    }

    public static void operacoes() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------Bem vindos a nossa agência----------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("********* Selecione uma operação que deseja realizar *********");
        System.out.println("--------------------------------------------------------------");
        System.out.println("|    Opção 1 - Criar conta     |");
        System.out.println("|    Opção 2 - Depositar       |");
        System.out.println("|    Opção 3 - Sacar           |");
        System.out.println("|    Opção 4 - Transferir      |");
        System.out.println("|    Opção 5 - Listar          |");
        System.out.println("|    Opção 6 - Sair            |");

        int operacao = sc.nextInt();

        switch(operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println(" Obrigado por usar nossa agência! ");
                System.exit(0);
            default:
                System.out.println(" Opção inválida! ");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.print("\nNome: ");
        String nome = sc.next();
        System.out.print("\nCPF: ");
        String cpf = sc.next();
        System.out.print("\nEmail: ");
        String email = sc.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println(" Sua conta foi criada com sucesso! ");

        System.out.println(conta);

        operacoes();
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for(Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta);
                conta = c;

            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.print("Número da conta: ");
        int numeroConta = sc.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.print("Qual valor deseja depositar? ");
            Double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println(conta);
        }else {
            System.out.println(" Conta não encontrada! ");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.print("Número da conta: ");
        int numeroConta = sc.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.print("Qual valor deseja sacar? ");
            Double valorSaque = sc.nextDouble();
            conta.sacar(valorSaque);
            System.out.println(conta);
        }else {
            System.out.println(" Conta não encontrada! ");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.print("Número da conta do remetente: ");
        int numeroContaRemetente = sc.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.print("Número da conta do destinatário: ");
            int numeroContaDestinatario = sc.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.print("Valor da transferência: ");
                Double valor = sc.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
            }else {
                System.out.println(" Conta para depósito não foi encontrada! ");
            }
        }else {
            System.out.println(" Conta para transferência não encontrada! ");
        }
        operacoes();
    }

    public static void listar() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        }else {
            System.out.print(" Não há contas cadastradas!");
        }
    }
}
