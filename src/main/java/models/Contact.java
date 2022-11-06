package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {
    @JsonProperty("policyNumber")
    public String policyNumber;
    @JsonProperty("contractNumber")
    public String contractNumber;
    @JsonProperty("contractPurchaseDate")
    public String contractPurchaseDate;
    @JsonProperty("contractValidityPeriod")
    public ContractValidityPeriod contractValidityPeriod;
    @JsonProperty("beneficiaries")
    public ArrayList<Beneficiary> beneficiaries;
}
