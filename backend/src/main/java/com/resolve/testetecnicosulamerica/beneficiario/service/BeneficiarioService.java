package com.resolve.testetecnicosulamerica.beneficiario.service;

import com.resolve.testetecnicosulamerica.beneficiario.model.BeneficiarioModel;
import com.resolve.testetecnicosulamerica.beneficiario.repository.BeneficiarioJdbcRespository;
import com.resolve.testetecnicosulamerica.beneficiario.repository.BeneficiarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiarioService {
    private final BeneficiarioJdbcRespository beneficiarioJdbcRepository;

    @Autowired
    public BeneficiarioService(BeneficiarioJdbcRespository beneficiarioJdbcRepository) {
        this.beneficiarioJdbcRepository = beneficiarioJdbcRepository;
    }

    public BeneficiarioModel findByCpf(String cpf) {
        return beneficiarioJdbcRepository.findByCpf(cpf);
    }

    public BeneficiarioModel cadastrarBeneficiario(BeneficiarioModel beneficiario) {
        return beneficiarioJdbcRepository.save(beneficiario);
    }
}