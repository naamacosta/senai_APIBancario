package com.example.services;

import com.example.models.ContaCorrente;
import com.example.models.ContaPoupanca;
import com.example.repositories.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class BancoService {

    private BancoRepository bancoRepository;

    @Autowired
    public BancoService(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }

    public ResponseEntity<ContaCorrente> createConta(ContaCorrente contaCorrente) {
        return null;
    }

    public ResponseEntity<ContaPoupanca> createConta(ContaPoupanca contaPoupanca) {
        return null;
    }

    public ResponseEntity<List<ContaCorrente>> getSaldoCC() {
    }

    public ResponseEntity<List<ContaPoupanca>> getSaldoCP() {
    }

    public ResponseEntity<ContaCorrente> depositarCC(int numeroConta, ContaCorrente contaCorrente) {
        Optional<ContaCorrente> optionalCC = bancoRepository.findByNumeroConta(numeroConta);
        if (optionalCC.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        ContaCorrente ccDepositar = optionalCC.get();
        ccDepositar.depositar(contaCorrente.depositar());

        bancoRepository.save(ccDepositar);

        return ResponseEntity.ok(ccDepositar);
    }

    public ResponseEntity<ContaPoupanca> depositarCP(int numeroConta, ContaPoupanca contaPoupanca) {
        Optional<ContaPoupanca> optionalCP = bancoRepository.findByNumeroConta(numeroConta);
        if (optionalCP.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        ContaPoupanca cpDepositar = optionalCP.get();
        cpDepositar.depositar(contaPoupanca.depositar());

        bancoRepository.save(cpDepositar);

        return ResponseEntity.ok(cpDepositar);
    }

    public ResponseEntity<ContaCorrente> sacarCC(int numeroConta, ContaCorrente contaCorrente) {
        Optional<ContaCorrente> optionalCC = bancoRepository.findByNumeroConta(numeroConta);
        if (optionalCC.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        ContaCorrente ccSacar = optionalCC.get();
        ccSacar.sacar(contaCorrente.sacar());

        bancoRepository.save(ccSacar);

        return ResponseEntity.ok(ccSacar);
    }

    public ResponseEntity<ContaPoupanca> sacarCP(int numeroConta, ContaPoupanca contaPoupanca) {
        Optional<ContaPoupanca> optionalCP = bancoRepository.findByNumeroConta(numeroConta);
        if (optionalCP.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        ContaPoupanca cpSacar = optionalCP.get();
        cpSacar.sacar(contaPoupanca.sacar());

        bancoRepository.save(cpSacar);

        return ResponseEntity.ok(cpSacar);
    }
}
