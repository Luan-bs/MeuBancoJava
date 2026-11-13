package com.meubanco.app;

import java.util.Scanner;
import java.util.InputMismatchException;
import com.meubanco.model.ContaBancaria;

public class Main {
    public static void main(String[] args) {

        ContaBancaria minhaConta = new ContaBancaria("Luan", "0123456789", 12500.00);

        int resposta = -1;
        Scanner scanner = new Scanner(System.in);

        // Terminal de comandos
        while (resposta != 0) {
            System.out.print(
                "\n1 - Consultar Saldo" +
                "\n2 - Depositar" +
                "\n3 - Sacar" +
                "\n0 - Sair" +
                "\nEscolha uma opção: "
            );

            
            try {

            // Ferramenta que pega o valor digitado
            resposta = scanner.nextInt(); 

            if (resposta == 0) {
                break;
            } else if (resposta == 1) {
                System.out.println("Saldo Atual: " + minhaConta.getSaldo());
            } else if (resposta == 2) {
                System.out.print("Digite o valor do depósito: ");
                double valor = scanner.nextDouble();
                minhaConta.depositar(valor);
            } else if (resposta == 3) {
                System.out.print("Digite o valor de saque: ");
                double valor = scanner.nextDouble();
                minhaConta.sacar(valor);
            } else {
                System.out.println("Valor digitado não está nas opções!");
            } 
            
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada inválida! Digite apenas números.");
                scanner.nextLine();
            }

        }

        scanner.close();
    }
}
