package com.resolve.testetecnicosulamerica.reset.tests;

import com.resolve.testetecnicosulamerica.reset.ResetService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.mockito.Mockito.*;

@SpringJUnitConfig
@SpringBootTest
public class ResetServiceTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testReset() {
        ResetService resetService = new ResetService(jdbcTemplate);

        // Simular o comportamento do jdbcTemplate
        when(jdbcTemplate.update(anyString())).thenReturn(2);

        resetService.reset();

        // Verificar se o método update foi chamado
        verify(jdbcTemplate, times(1)).update(anyString());
    }
}