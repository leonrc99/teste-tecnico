package com.resolve.testetecnicosulamerica.beneficiario.repository;

import com.resolve.testetecnicosulamerica.beneficiario.model.BeneficiarioModel;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiarioRespository {

    BeneficiarioModel findByCpf(String cpf);
    BeneficiarioModel save(BeneficiarioModel novo);

}
