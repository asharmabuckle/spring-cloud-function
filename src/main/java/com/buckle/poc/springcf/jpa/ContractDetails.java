package com.buckle.poc.springcf.jpa;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "contract_details", schema = "pch")
@TypeDef(
        name = "jsonb",
        typeClass = JsonType.class
)
public class ContractDetails {

    @Id
    @Column(name = "contract_id")
    private String contractId;

    @Column(name = "contract_number", nullable = false)
    private String contractNumber;

    @Column(name = "revision_effective_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp effectiveDate;

    @Column(name = "revision_expiration_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp expirationDate;

    @Column(name = "last_updated_ts", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp lastUpdatedTs;

    @Column(name = "mga", nullable = false)
    private String mga;

    @Column(name = "policy_json", nullable = false)
    @Type(type = "jsonb")
    private String policyJson;
}
