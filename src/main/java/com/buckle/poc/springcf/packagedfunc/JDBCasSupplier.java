package com.buckle.poc.springcf.packagedfunc;

import com.buckle.poc.springcf.model.DBQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
@Qualifier("jdbcsupplier")
@Slf4j
public class JDBCasSupplier implements Supplier<DBQueryResponse> {

    @Autowired
    JdbcTemplate rdsJdbcTemplate;

    String query = "SELECT COUNT(*) FROM pch.contract_details";

    @Override
    public DBQueryResponse get() {
        Long rows = rdsJdbcTemplate.queryForObject(query, Long.class);
        return DBQueryResponse.builder().status("success").rowCount(rows).build();
    }
}
