package com.example.controllers;

import com.example.models.ContaCorrente;
import com.example.models.ContaPoupanca;
import com.example.services.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="api/v1/conta")

public class BancoController {
    private final BancoService bancoService;

    @Autowired
    public BancoController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @PostMapping
    public ResponseEntity<ContaCorrente> create(@ResponseBody ContaCorrente contaCorrente) {
        return bancoService.createConta(contaCorrente);
    }

    @PostMapping
    public ResponseEntity<ContaPoupanca> create(@ResponseBody ContaPoupanca contaPoupanca) {
        return bancoService.createConta(contaPoupanca);
    }

    @GetMapping
    public ResponseEntity<List<ContaCorrente>> saldoCC() {
        return bancoService.getSaldoCC();
    }

    @GetMapping
    public ResponseEntity<List<ContaPoupanca>> saldoCP() {
        return bancoService.getSaldoCP();
    }

    @PutMapping(path = "{numeroConta}")
    public ResponseEntity<ContaCorrente> depositar(@PathVariable int numeroConta, @RequestBody ContaCorrente contaCorrente){
        return bancoService.depositarCC(numeroConta, contaCorrente);
    }

    @PutMapping(path = "{numeroConta}")
    public ResponseEntity<ContaPoupanca> depositar(@PathVariable int numeroConta, @RequestBody ContaPoupanca contaPoupanca){
        return bancoService.depositarCP(numeroConta, contaPoupanca);
    }

    @PutMapping(path = "{numeroConta}")
    public ResponseEntity<ContaCorrente> sacar(@PathVariable int numeroConta, @RequestBody ContaCorrente contaCorrente){
        return bancoService.sacarCC(numeroConta, contaCorrente);
    }

    @PutMapping(path = "{numeroConta}")
    public ResponseEntity<ContaPoupanca> sacar(@PathVariable int numeroConta, @RequestBody ContaPoupanca contaPoupanca){
        return bancoService.sacarCP(numeroConta, contaPoupanca);
    }
}
