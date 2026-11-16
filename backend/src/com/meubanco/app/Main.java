package com.meubanco.app;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import com.meubanco.model.ContaBancaria;
import com.meubanco.service.TransferenciaService;

public class Main {
    public static void main(String[] args) {

        ArrayList<ContaBancaria> contas = new ArrayList<>();

        contas.add(new ContaBancaria("Luan", "0123456789", 12500.00));
        contas.add(new ContaBancaria("Poliana", "54321", 5000));
        ContaBancaria primeiraConta = new ContaBancaria("Luan", "0123456789",
        12500.00);
        ContaBancaria segundaConta = new ContaBancaria("Poliana", "54321", 5000);

        int resposta = -1;
        Scanner scanner = new Scanner(System.in);
        TransferenciaService service = new TransferenciaService();

        // Terminal de comandos
        while (resposta != 0) {
            System.out.print(
                    "\n1 - Consultar Saldos" +
                            "\n2 - Depositar" +
                            "\n3 - Sacar" +
                            "\n4 - Transferir" +
                            "\n5 - Criar Conta" +
                            "\n0 - Sair" +
                            "\nEscolha uma opção: ");

            try {

                // Ferramenta que pega o valor digitado
                resposta = scanner.nextInt();

                double valor;
                String nome;
                String cpf;
                double saldo; 

                switch (resposta) {
                    case 0:
                        break;
                    case 1:
                        for (ContaBancaria conta : contas) {
                            System.out.println("Titular: " + conta.getNome() +
                                    " | CPF: " + conta.getCpf() +
                                    " | Saldo: " + conta.getSaldo());
                        }
                        break;
                    case 2:
                        System.out.print("Digite o valor do depósito: ");
                        valor = scanner.nextDouble();
                        primeiraConta.depositar(valor);
                        break;
                    case 3:
                        System.out.print("Digite o valor de saque: ");
                        valor = scanner.nextDouble();
                        primeiraConta.sacar(valor);
                        break;
                    case 4:
                        System.out.print("Digite o valor para transferir: ");
                        valor = scanner.nextDouble();
                        service.transferir(primeiraConta, segundaConta, valor);
                        break;
                    case 5:
                        System.out.print("Digite o nome: ");
                        nome = scanner.nextLine();
                        System.out.print("Digite o CPF: ");  
                        cpf = scanner.nextLine();
                        System.out.print("Digite o saldo: "); 
                        saldo = scanner.nextDouble();                 
                        contas.add(new ContaBancaria(nome,cpf,saldo));

                    default:
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
