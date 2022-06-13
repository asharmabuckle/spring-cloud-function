package com.buckle.poc.springcf.packagedfunc;

import com.buckle.poc.springcf.jpa.ContractDetailsRepository;
import com.buckle.poc.springcf.model.DBQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
@Qualifier("jpasupplier")
@Slf4j
public class JPAasSupplier implements Supplier<DBQueryResponse> {

    @Autowired
    ContractDetailsRepository contractDetailsRepository;

    @Override
    public DBQueryResponse get() {
        return DBQueryResponse.builder().status("success").rowCount(contractDetailsRepository.count()).build();
    }
}
