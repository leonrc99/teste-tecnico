package com.resolve.testetecnicosulamerica.beneficiario.repository;

import com.resolve.testetecnicosulamerica.beneficiario.model.BeneficiarioModel;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class BeneficiarioJdbcRespository implements BeneficiarioRespository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public BeneficiarioModel findByCpf(String cpf) {
        return null;
    }

    @Override
    public BeneficiarioModel save(BeneficiarioModel novo) {

        StringBuilder query = new StringBuilder();
        query.append("\n INSERT ");
        query.append("\n   INTO TbBeneficiario(CPF,NM_BENEFICIARIO,DT_NASCIMENTO) ");
        query.append("\n VALUES (?,?,?) ");

        this.jdbcTemplate.update(query.toString(),
                novo.getCpf(),
                novo.getNome(),
                novo.getDataNascimento());

        return findByCpf(novo.getCpf());

    }

}
