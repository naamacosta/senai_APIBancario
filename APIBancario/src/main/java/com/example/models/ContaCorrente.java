package com.example.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class ContaCorrente extends Conta {
    public ContaCorrente(String titular, double saldo, int numeroConta) {
        super(titular, saldo, numeroConta);
    }

    @Override
    public void sacar(double valor) {
        saldo = saldo - valor -5;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("A conta de numero: " + numeroConta + " tem como titular: " + titular + " e o saldo é: " + saldo);
    }
}
