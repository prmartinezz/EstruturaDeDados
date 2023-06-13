package br.com.martinez.contabanco;

import br.com.martinez.contabanco.model.Conta;
import java.util.Scanner;

public class Main {
    
    private static Conta[] contas;
    private static int nrContas;

    public static void main(String[] args) {

     Scanner scn = new Scanner(System.in);
        nrContas = 0;
        contas = new Conta[100];
        
        int opcao = 0;
        do {
            Menu();
            opcao = scn.nextInt();
            scn.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarConta(scn);
                        break;
                case 2:
                    ordenarContas(scn);
                        break;
                case 3:
                    Deposito(scn);
                        break;
                case 4:
                    Saque(scn);
                        break;
                case 5:
                    double saldoTotal = calcularSaldoTotal();
                    System.out.println("Saldo Total: " + saldoTotal);
                        break;
                case 6:
                    saldoNegativo();
                        break;
                case 7:
                    System.out.println("Finalizando..");
                        break;
                default:
                    System.out.println("Opção nula ou invalida!");
                        break;
            }
        } while (opcao != 7);

        scn.close();
    }
    
    public static void Menu() {
        System.out.println("\n<--------MENU-------->");
        System.out.println("[1] Cadastrar conta");
        System.out.println("[2] Ordenar conta");
        System.out.println("[3] Realizar Deposito");
        System.out.println("[4] Realizar Saque");
        System.out.println("[5] Calcular saldo total do banco");
        System.out.println("[6] Verificar saldo negativo");
        System.out.println("[0] Sair");
        System.out.println("Escolha uma opção!");
    }
    
    public static void cadastrarConta(Scanner scn){
        
        System.out.println("\nCadastro de Conta:");
        System.out.print("Número da conta: ");
        int numero = scn.nextInt();
            scn.nextLine();
                
        System.out.print("Nome do titular: ");
            String titular = scn.nextLine();
            
        System.out.print("Saldo inicial: ");
            double saldo = scn.nextDouble();
            scn.nextLine();
                
        System.out.println("Conta cadastrada com sucesso!");
        
        Conta conta = new Conta(numero, saldo, titular);
        contas[nrContas] = conta;
        nrContas++;
    }
    
    public static void ordenarContas(Scanner scanner) {
        if (nrContas == 0){
            System.out.println("Não há contas cadastradas!");
            return;
        }
        System.out.println("Ordenar Contas:");
        System.out.println("[1] - Ordenar por número da conta");
        System.out.println("[2] - Ordenar por saldo");
        System.out.print("Digite a opção desejada: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                ordenarPorNumero();
                    System.out.println("Contas bancarias ordenadas pelo número da conta:");
                        break;
            case 2:
                ordenarPorSaldo();
                    System.out.println("Contas bancarias ordenadas pelo saldo:");
                        break;
            default:
                System.out.println("Esta opção está invalida!");
                    return;
        }
    }
  
    public static void ordenarPorNumero() {
     for (int i = 0; i < nrContas - 1; i++) {
         for (int j = 0; j < nrContas - i - 1; j++) {
             if (contas[j].getNumero() > contas[j + 1].getNumero()) {
                 Conta temp = contas[j];
                    contas[j] = contas[j + 1];
                        contas[j + 1] = temp;
             }
         }
    }
 }
    
    public static void ordenarPorSaldo() {
        for (int i = 0; i < nrContas - 1; i++) {
            for (int j = 0; j < nrContas - i - 1; j++) {
                if (contas[j].getSaldo() > contas[j + 1].getSaldo()) {
                    Conta temp = contas[j];
                        contas[j] = contas[j + 1];
                            contas[j + 1] = temp;
                }
            }
        }
    }
    
    public static void Deposito(Scanner scn) {
        
        if (nrContas == 0) {
            System.out.println("Não há contas cadastradas!");
            return;
        }
        
        Conta conta = new Conta(nrContas, nrContas, "");

        System.out.println("Realizar Deposito:");
        System.out.println("[1] Pesquisar por número da conta");
        System.out.println("[2] Pesquisar por nome do titular");
        System.out.print("Digite a opção desejada: ");
        int opcao = scn.nextInt();
        scn.nextLine();

        Conta contas = null;
        switch (opcao){
            case 1:
                System.out.print("Digite o número da conta: ");
                int numeroConta = scn.nextInt();
                    scn.nextLine();
                        contas = pesquisarPorNumero(numeroConta);
                            break;
            case 2:
                System.out.print("Digite o nome do titular: ");
                    String nomeTitular = scn.nextLine();
                        contas = pesquisarPorNomeTitular(nomeTitular);
                            break;
            default:
                System.out.println("Opcão invalida!!!");
                    return;
        }

        if (contas == null) {
            System.out.println("Conta não encontrada");
                return;
        }

        System.out.print("Insira o valor do deposito: ");
            double valorDeposito = scn.nextDouble();
                scn.nextLine();

        conta.depositar(valorDeposito);
            System.out.println("Deposito realizado!!");
                System.out.println("Novo saldo da conta: " + conta.getSaldo());
    }
    
     public static Conta pesquisarPorNumero(int numero) {
        for (int i = 0; i < nrContas; i++) {
            if (contas[i].getNumero() == numero) {
                return contas[i];
            }
        }
        return null;
    }

    public static Conta pesquisarPorNomeTitular(String titular) {
        for (int i = 0; i < nrContas; i++) {
            if (contas[i].getNomeTitular().equals(titular)) {
                return contas[i];
            }
        }
        return null;
    }
    
    public static void Saque(Scanner scn) {
        if (nrContas == 0) {
            System.out.println("Não há contas cadastradas");
                return;
        }

        System.out.println("Realizar Saque: ");
            System.out.print("Digite o número da conta: ");
                int numeroConta = scn.nextInt();
                    scn.nextLine();

        ordenarPorNumero();
        Conta contas = pesquisarPorNumero(numeroConta);

        if (contas == null) {
            System.out.println("Conta não encontrada!!!");
                return;
        }

        System.out.print("Insira o valor do saque: ");
            double valorSaque = scn.nextDouble();
                scn.nextLine();

        if (contas.sacar(valorSaque)){
            System.out.println("Saque realizado!");
            System.out.println("Novo saldo: " + contas.getSaldo());
        } else {
            System.out.println("Saldo insuficiente!!!");
        }
    }
    
    public static double calcularSaldoTotal() {
        return saldoTotalRecursivo(0);
    }

    public static double saldoTotalRecursivo(int index) {
        if (index == nrContas) {
            return 0;
        }
        return contas[index].getSaldo() + saldoTotalRecursivo(index + 1);
    }

    public static void saldoNegativo() {
        boolean saldoNegativo = saldoNegativoRecursivo(0);
        if (saldoNegativo) {
            System.out.println("Existe contas que possui saldo negativo!");
        } else {
            System.out.println("Não há conta que possui saldo negativo!");
        }
    }

    public static boolean saldoNegativoRecursivo(int index) {
        if (index == nrContas) {
            return false;
        }
        if (contas[index].getSaldo() < 0) {
            System.out.println("Conta com saldo negativo:");
                System.out.println(contas[index]);
                    return true;
        }
        return saldoNegativoRecursivo(index + 1);
    }
}   

