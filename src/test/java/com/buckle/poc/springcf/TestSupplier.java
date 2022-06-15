package com.buckle.poc.springcf;

import com.buckle.poc.springcf.jpa.ContractDetailsRepository;
import com.buckle.poc.springcf.packagedfunc.JDBCasSupplier;
import com.buckle.poc.springcf.packagedfunc.JPAasSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class TestSupplier {

    @Autowired
    JPAasSupplier jpAasSupplier;
    @Autowired
    JDBCasSupplier jdbCasSupplier;
    @Autowired
    @Qualifier("h2JdbcTemplate")
    JdbcTemplate h2JdbcTemplate;
    @MockBean
    private ContractDetailsRepository contractDetailsRepositoryMocked;

    @BeforeEach
    public void setup() throws Exception {

    }

    @Test
    void testJPA() {
        // Mock JPA layer
        Mockito.when(contractDetailsRepositoryMocked.count()).thenReturn(2L);

        var resp = jpAasSupplier.get();
        assertNotNull(resp);
        assertTrue(resp.getRowCount() > 0);
    }

    @Test
    void testJdbc() {
        jdbCasSupplier.rdsJdbcTemplate = h2JdbcTemplate;
        var resp = jdbCasSupplier.get();
        assertNotNull(resp);
        assertTrue(resp.getRowCount() > 0);
    }
}
