package br.com.martinez.contabanco.model;

public class Conta {

    private double saldo;
    private int numero;
    private String nomeTitular;

    public Conta(int numero, double saldo, String nomeTitular) {
        this.saldo = saldo;
        this.numero = numero;
        this.nomeTitular = nomeTitular;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }
    
    public void depositar(double valor){
        saldo += valor;
    }
    
    public boolean sacar(double valor){
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta bancária: " + "Numero = " + numero + ", Saldo = " + saldo + ", Nome do Titular = " + nomeTitular + '}';
    }
    
}
