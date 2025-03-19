package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class ContaPoupanca extends Conta {
    public ContaPoupanca(String titular, double saldo, int numeroConta) {
        super(titular, saldo, numeroConta);
    }

    @Override
    public void sacar(double valor) {
        if (saldo > 0 && saldo >= valor){
            saldo -= valor;
        }else{
            System.out.println("Valor de saque nao autorizado");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo = saldo + valor;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("A conta de numero: " + numeroConta + " tem como titular: " + titular + " e o saldo e: " + saldo);
    }
}
