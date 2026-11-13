package com.meubanco.model;

public class ContaBancaria {
    
    private double saldo;
    private String nome;
    private String cpf;
    
    public ContaBancaria(String nome, String cpf, double saldoInicial) {
        this.nome = nome;
        this.cpf = cpf;
        if (saldoInicial >= 0) {
            this.saldo += saldoInicial;
        }
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Deposito de " + valor + " concluido");
        } else {
            System.out.println("Não é permitido valores negativos! Deposito cancelado, tente novamente."); 
        }
    }
    
    public void sacar(double valor) {
        if (valor <= saldo && valor > 0) {
            this.saldo -= valor;
            System.out.println("Saque de " + valor + " Concluido!");
        } else {
            System.out.println("Valor é maior que o saldo ou menor que 0! Saque cancelado, tente novamente.");
        }
    }
}