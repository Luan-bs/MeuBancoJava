package com.meubanco.service;

import com.meubanco.model.ContaBancaria;


public class TransferenciaService {

    public void transferir(ContaBancaria origem, ContaBancaria destino, double valor) {

        if (valor > 0 && origem.getSaldo() >= valor) {
            origem.sacar(valor);
            destino.depositar(valor);
            System.out.println("Transferência bem sucedida!");
        } else {
            System.out.println("Valor precisa ser maior que 0 e igual ou menor que o saldo!");
        }

    }


}