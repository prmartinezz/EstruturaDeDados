package br.com.martinez.contabancaria.model;

import java.util.Arrays;

public class Banco {

    private ContaBancaria[] contas;
    private int numeroContas;
    
    public Banco(int capacidadeMaxima) {
        contas = new ContaBancaria[capacidadeMaxima];
        numeroContas = 0;
    }
    
    public Banco() {
        
    }
    
    public void cadastrarConta(int numeroConta, String nomeTitular, double saldo) {
        if (numeroContas < contas.length) {
            ContaBancaria novaConta = new ContaBancaria(numeroConta, nomeTitular, saldo);
            contas[numeroContas] = novaConta;
            numeroContas++;
            System.out.println("Conta cadastrada com sucesso.");
        } else {
            System.out.println("Não é possível cadastrar mais contas. Limite máximo atingido.");
        }
    }
    
    public void ordenarContas() {
        Arrays.sort(contas, 0, numeroContas);
        System.out.println("Contas ordenadas com sucesso.");
    }
    
    public void depositar(int numeroConta, double valor) {
    ContaBancaria conta = pesquisarConta(numeroConta);
    if (conta != null) {
        conta.setSaldo(conta.getSaldo() + valor);
        System.out.println("Depósito realizado com sucesso.");
    } else {
        System.out.println("Conta não encontrada.");
        }
    }

    
    public void sacar(int numeroConta, double valor) {
        ContaBancaria conta = pesquisarConta(numeroConta);
        if (conta != null) {
            conta.setSaque(valor);
            conta.sacar();
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
    
    private ContaBancaria pesquisarConta(int numeroConta) {
    for (int i = 0; i < numeroContas; i++) {
        if (contas[i].getNumeroConta() == numeroConta) {
            return contas[i];
        }
    }
        return null; // Retorna null se a conta não for encontrada
    }
    
    
    private double calcularSaldoTotalRecursivo(int indice) {
        if (indice == numeroContas) {
            return 0;
        } else {
            return contas[indice].getSaldo() + calcularSaldoTotalRecursivo(indice + 1);
        }
    }
    
    public double calcularSaldoTotal() {
        return calcularSaldoTotalRecursivo(0);
    }
    
    private boolean verificarSaldoNegativoRecursivo(int indice) {
        if (indice == numeroContas) {
            return false;
        } else if (contas[indice].getSaldo() < 0) {
            System.out.println("Conta com saldo negativo: " + contas[indice].getNumeroConta()
                    + " (saldo: " + contas[indice].getSaldo() + ")");
            return true;
        } else {
            return verificarSaldoNegativoRecursivo(indice + 1);
        }
    }
    
    public void verificarSaldoNegativo() {
        boolean saldoNegativo = verificarSaldoNegativoRecursivo(0);
        if (!saldoNegativo) {
            System.out.println("Nenhuma conta possui saldo negativo.");
        }
    }

    public ContaBancaria[] getContas() {
        return contas;
    }

    public void setContas(ContaBancaria[] contas) {
        this.contas = contas;
    }

    public int getNumeroContas() {
        return numeroContas;
    }

    public void setNumeroContas(int numeroContas) {
        this.numeroContas = numeroContas;
    }
    
    @Override
    public String toString() {
        return "Banco{" + "contas=" + contas + ", numeroContas=" + numeroContas + '}';
    }

}