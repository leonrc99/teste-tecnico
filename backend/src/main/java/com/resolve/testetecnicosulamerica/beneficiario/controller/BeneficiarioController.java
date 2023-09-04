package com.resolve.testetecnicosulamerica.beneficiario.controller;

import com.resolve.testetecnicosulamerica.beneficiario.model.BeneficiarioModel;
import com.resolve.testetecnicosulamerica.beneficiario.service.BeneficiarioService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {
    private final BeneficiarioService beneficiarioService;

    @Autowired
    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<BeneficiarioModel> findByCpf(@PathParam("cpf") String cpf) {
        BeneficiarioModel beneficiario = beneficiarioService.findByCpf(cpf);
        if (beneficiario != null) {
            return ResponseEntity.ok(beneficiario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<BeneficiarioModel> cadastrarBeneficiario(@RequestBody BeneficiarioModel beneficiario) {
        BeneficiarioModel novoBeneficiario = beneficiarioService.cadastrarBeneficiario(beneficiario);
        return ResponseEntity.created(URI.create("/beneficiarios/" + novoBeneficiario.getCpf())).body(novoBeneficiario);
    }

}
