package com.example.models;

abstract class Conta {

        protected String titular;
        protected double saldo;
        protected int numeroConta;

        public Conta(String titular, double saldo, int numeroConta){
            this.titular = titular;
            this.saldo = saldo;
            this.numeroConta = numeroConta;
        }

        public abstract void depositar(double valor);

        public abstract void sacar(double valor);

        public abstract void exibirInformacoes();

    }

