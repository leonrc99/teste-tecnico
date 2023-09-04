package com.resolve.testetecnicosulamerica.reset;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Slf4j
@Service
public class ResetService {
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public String reset() {
        int beneficiariosExcluidos = jdbcTemplate.update("DELETE FROM TbBeneficiario");
        var result = "[Database reseted] Beneficiarios: " + beneficiariosExcluidos;
        log.info(result);
        return result;
    }

}