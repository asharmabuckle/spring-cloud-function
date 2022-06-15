CREATE SCHEMA  IF NOT EXISTS pch;

CREATE TABLE IF NOT EXISTS pch.contract_details
(
  contract_id VARCHAR(50) NOT NULL PRIMARY KEY, -- primary key column
  contract_number VARCHAR(100) NOT NULL,
  revision_effective_date TIMESTAMP NOT NULL,
  revision_expiration_date TIMESTAMP NOT NULL,
  last_updated_ts TIMESTAMP NOT NULL,
  mga VARCHAR(10),
  policy_json json
);
COMMIT;
