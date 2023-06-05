package br.com.martinez.contabancaria;

import br.com.martinez.contabancaria.model.Banco;
import java.util.Scanner;

public class Main {
        private static Banco banco;
        private static Scanner scanner;

    public static void main(String[] args) {

        banco = new Banco(100);
        scanner = new Scanner(System.in);
        
        boolean sair = false;
        while(!sair) {
            exibirMenu();
            int opcao = lerOpcao();
            switch (opcao) {
                case 1:
                    cadastrarConta();
                    break;
                case 2:
                    ordenarContas();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    sacar();
                    break;
                case 5:
                    calcularSaldoTotal();
                    break;  
                case 6:
                    verificarSaldoNegativo();
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida! Tente Novamente!");
            }
        }
        
        scanner.close();
            System.out.println("Encerrando software!");
    }
    
    private static void exibirMenu() {
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
    
    public static int lerOpcao() {
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    private static void cadastrarConta() {
        System.out.println("\nNúmero da conta");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Nome do Titular: ");
        String nomeTitular = scanner.nextLine();
        
        System.out.println("Saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        
        banco.cadastrarConta(numeroConta, nomeTitular, saldoInicial);
    }
    
    private static void ordenarContas() {
        banco.ordenarContas();
    }
    
    private static boolean isNumeroConta(String prm) {
        try {
            Integer.parseInt(prm);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private static void depositar() {
        System.out.println("\nNúmero da conta ou nome do titular: ");
        String prm = scanner.nextLine();
        
        System.out.println("Valor do depósito: ");
        double valor = scanner.nextDouble();
        
        if (isNumeroConta(prm)) {
            int numeroConta = Integer.parseInt(prm);
            banco.depositar(numeroConta, valor);
        } else {
            System.out.println("Pesquisar por nome do titular ainda não implementado!");
        }
    }
    
    private static void sacar() {
        System.out.println("\nNumero da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Valor do saque: ");
        double valor = scanner.nextDouble();
        
        banco.sacar(numeroConta, valor);
    }
    
    private static void calcularSaldoTotal() {
        double saldoTotal = banco.calcularSaldoTotal();
        System.out.println("\nSaldo total do banco" + saldoTotal);
    }
    
    private static void verificarSaldoNegativo() {
        banco.verificarSaldoNegativo();
    }
}
