package com.buckle.poc.springcf.jpa;

public class QueryConstants {
    public static final String SEARCH_POLICIES_BY_NUMBER_AND_LOSS_DATE = "SELECT * " +
            " FROM pch.contract_details c " +
            " WHERE c.contract_number = :contractNum " +
            " AND c.contract_id IN (SELECT MAX(contract_id) max_cid " +
            " FROM pch.contract_details c " +
            " WHERE :lossDate BETWEEN c.revision_effective_date AND c.revision_expiration_date " +
            " GROUP BY contract_number) " +
            " ORDER BY c.contract_id DESC " +
            " LIMIT :maxResult ";
    public static final String SEARCH_POLICIES_BY_LOSS_DATE = "SELECT * " +
            " FROM pch.contract_details c " +
            " WHERE c.contract_id IN (SELECT MAX(contract_id) max_cid " +
            " FROM pch.contract_details c " +
            " WHERE :lossDate BETWEEN c.revision_effective_date AND c.revision_expiration_date " +
            " GROUP BY contract_number) " +
            " ORDER BY c.contract_id DESC " +
            " LIMIT :maxResult";
    public static final String SEARCH_POLICIES_BY_INSURED_NAME = "SELECT DISTINCT c.* " +
            " FROM pch.contract_details c " +
            " ,jsonb_array_elements(c.policy_json -> 'people') ppl_arr" +
            " WHERE c.contract_id IN (SELECT MAX(contract_id) max_cid " +
            " FROM pch.contract_details c " +
            " WHERE :lossDate BETWEEN c.revision_effective_date AND c.revision_expiration_date " +
            " GROUP BY contract_number) " +
            "  AND (" +
            "        (:firstName != '' AND lower(ppl_arr ->> 'first_name') like '%' || :firstName || '%') " +
            "        OR " +
            "        (:lastName != '' AND lower(ppl_arr ->> 'last_name') like '%' || :lastName || '%') " +
            "    ) " +
            " ORDER BY c.contract_id DESC " +
            " LIMIT :maxResult ";
    public static final String RETRIEVE_POLICY_BY_NUMBER_EFFDATE_AND_EXPDATE = "SELECT * FROM " +
            " pch.contract_details c WHERE c.contract_number =:contractNum " +
            " AND :lossDate BETWEEN c.revision_effective_date AND c.revision_expiration_date " +
            " AND DATE(c.revision_effective_date) =:effDate " +
            " AND DATE(c.revision_expiration_date) =:expDate " +
            " ORDER BY c.contract_id DESC " +
            " LIMIT :maxResult";
    public static final String GET_POLICY_BY_CONTRACT_ID = "SELECT * FROM pch.contract_details c WHERE " +
            "c.contract_id = :contractId";
}
