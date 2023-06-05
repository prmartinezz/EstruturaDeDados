package br.com.martinez.contabancaria.model;

public class ContaBancaria implements Comparable<ContaBancaria> {

    private int numeroConta;
    private String nomeTitular;
    private double saldo;
    private double deposito;
    private double saque;   

    public ContaBancaria(int numeroConta, String nomeTitular, double saldo) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
        this.deposito = deposito;
        this.saque = saque;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    public double getSaque() {
        return saque;
    }

    public void setSaque(double saque) {
        this.saque = saque;
    }
        
    public void depositar() {
        saldo -= saque;
        saque = 0;
    }
    
    public void sacar() {
        saldo -= saque;
        saque = 0;
    }
    
    @Override
    public int compareTo(ContaBancaria outraConta) {
        return Integer.compare(this.numeroConta, outraConta.numeroConta);
    }
    
}
