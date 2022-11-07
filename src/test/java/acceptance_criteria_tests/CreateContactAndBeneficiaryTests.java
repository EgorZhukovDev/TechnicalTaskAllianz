package acceptance_criteria_tests;

import lombok.SneakyThrows;
import models.Beneficiary;
import models.Contact;
import models.errors.ErrorLogs;
import models.errors.ErrorSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;
import steps.ContactWithAllParamSteps;

import java.util.ArrayList;

public class CreateContactAndBeneficiaryTests {
    /**
     * 1. Check adding a (sub) contract - Create one new Contract and Beneficiary
     */
    @SneakyThrows
    @Test
    @DisplayName("Check adding a (sub) contract - Positive")
    public void checkingAddingContractOneBenefPositiveTest() {
        Contact resp = ContactWithAllParamSteps.createContactOneBenefWithAllParam("DS393961502", "BMBA6W92010EC94814",
                "2022-03-23", "2022-03-25", "2023-03-24", "BMBA6W92010EC94814-1",
                "AFSAD9823KCPR5563Z", "Max", "Mustermann", "1964-02-01", "Male");

        String policyNumber = resp.getPolicyNumber();
        String contractNumber = resp.getContractNumber();
        String contractPurchaseDate = resp.getContractPurchaseDate();
        String startDate = resp.getContractValidityPeriod().getStartDate();
        String endDate = resp.getContractValidityPeriod().getEndDate();
        ArrayList<Beneficiary> beneficiaries = resp.getBeneficiaries();
        String beneficiaryNumber = beneficiaries.get(0).getBeneficiaryNumber();
        String customerNumber = beneficiaries.get(0).getCustomerNumber();
        String firstName = beneficiaries.get(0).getFirstName();
        String lastName = beneficiaries.get(0).getLastName();
        String birthDate = beneficiaries.get(0).getBirthDate();
        String genderIdentity = beneficiaries.get(0).getGenderIdentity();

        Assertions.assertEquals("DS393961502", policyNumber);
        Assertions.assertEquals("BMBA6W92010EC94814", contractNumber);
        Assertions.assertEquals("2022-03-23", contractPurchaseDate);
        Assertions.assertEquals("2022-03-25", startDate);
        Assertions.assertEquals("2023-03-24", endDate);
        Assertions.assertEquals("BMBA6W92010EC94814-1", beneficiaryNumber);
        Assertions.assertEquals("AFSAD9823KCPR5563Z", customerNumber);
        Assertions.assertEquals("Max", firstName);
        Assertions.assertEquals("Mustermann", lastName);
        Assertions.assertEquals("1964-02-01", birthDate);
        Assertions.assertEquals("Male", genderIdentity);
    }

    /**
     * 1. Check adding one or more beneficiaries on the (sub)contract - Create new Contract and two Beneficiaries
     */
    @SneakyThrows
    @Test
    @DisplayName("Check adding one or more beneficiaries on the (sub)contract - Positive")
    public void checkingAddingContractTwoBenefPositiveTest() {
        Contact resp = ContactWithAllParamSteps.createContactTwoBenefWithAllParam("DS393961502", "BMBA6W92010EC94814",
                "2022-03-23", "2022-03-25", "2023-03-24",
                "BMBA6W92010EC94814-1", "AFSAD9823KCPR5563Z", "Max", "Mustermann", "1964-02-01", "Male",
                "BMBA6W92010EC94814-2", "AFSAD9823KCPR5563X", "Oleg", "Gold", "1988-05-11", "Male");
        
        String policyNumber = resp.getPolicyNumber();
        String contractNumber = resp.getContractNumber();
        String contractPurchaseDate = resp.getContractPurchaseDate();
        String startDate = resp.getContractValidityPeriod().getStartDate();
        String endDate = resp.getContractValidityPeriod().getEndDate();
        ArrayList<Beneficiary> beneficiaries = resp.getBeneficiaries();
        String beneficiaryNumber1 = beneficiaries.get(0).getBeneficiaryNumber();
        String customerNumber1 = beneficiaries.get(0).getCustomerNumber();
        String firstName1 = beneficiaries.get(0).getFirstName();
        String lastName1 = beneficiaries.get(0).getLastName();
        String birthDate1 = beneficiaries.get(0).getBirthDate();
        String genderIdentity1 = beneficiaries.get(0).getGenderIdentity();
        String beneficiaryNumber2 = beneficiaries.get(1).getBeneficiaryNumber();
        String customerNumber2 = beneficiaries.get(1).getCustomerNumber();
        String firstName2 = beneficiaries.get(1).getFirstName();
        String lastName2 = beneficiaries.get(1).getLastName();
        String birthDate2 = beneficiaries.get(1).getBirthDate();
        String genderIdentity2 = beneficiaries.get(1).getGenderIdentity();

        Assertions.assertEquals("DS393961502", policyNumber);
        Assertions.assertEquals("BMBA6W92010EC94814", contractNumber);
        Assertions.assertEquals("2022-03-23", contractPurchaseDate);
        Assertions.assertEquals("2022-03-25", startDate);
        Assertions.assertEquals("2023-03-24", endDate);
        Assertions.assertEquals("BMBA6W92010EC94814-1", beneficiaryNumber1);
        Assertions.assertEquals("AFSAD9823KCPR5563Z", customerNumber1);
        Assertions.assertEquals("Max", firstName1);
        Assertions.assertEquals("Mustermann", lastName1);
        Assertions.assertEquals("1964-02-01", birthDate1);
        Assertions.assertEquals("Male", genderIdentity1);
        Assertions.assertEquals("BMBA6W92010EC94814-2", beneficiaryNumber2);
        Assertions.assertEquals("AFSAD9823KCPR5563X", customerNumber2);
        Assertions.assertEquals("Oleg", firstName2);
        Assertions.assertEquals("Gold", lastName2);
        Assertions.assertEquals("1988-05-11", birthDate2);
        Assertions.assertEquals("Male", genderIdentity2);
    }

    /**
     * 1. Check adding a (sub) contract with NOT unique scope policyNumber of the different business partners - Create two new Contracts and Beneficiary
     */
    @SneakyThrows
    @Test
    @DisplayName("Check adding a (sub) contract with NOT unique scope policyNumber of the different business partners - Positive")
    public void checkingAddingTwoContractsOneBenefPositiveTest() {
        Contact resp1 = ContactWithAllParamSteps.createContactOneBenefWithAllParam("DS393961502", "BMBA6W92010EC94814",
                "2022-03-23", "2022-03-25", "2023-03-24", "BMBA6W92010EC94814-1",
                "AFSAD9823KCPR5563Z", "Max", "Mustermann", "1964-02-01", "Male");

        String policyNumber1 = resp1.getPolicyNumber();
        String contractNumber1 = resp1.getContractNumber();
        String contractPurchaseDate1 = resp1.getContractPurchaseDate();
        String startDate1 = resp1.getContractValidityPeriod().getStartDate();
        String endDate1 = resp1.getContractValidityPeriod().getEndDate();
        ArrayList<Beneficiary> beneficiaries1 = resp1.getBeneficiaries();
        String beneficiaryNumber1 = beneficiaries1.get(0).getBeneficiaryNumber();
        String customerNumber1 = beneficiaries1.get(0).getCustomerNumber();
        String firstName1 = beneficiaries1.get(0).getFirstName();
        String lastName1 = beneficiaries1.get(0).getLastName();
        String birthDate1 = beneficiaries1.get(0).getBirthDate();
        String genderIdentity1 = beneficiaries1.get(0).getGenderIdentity();

        Contact resp2 = ContactWithAllParamSteps.createContactOneBenefWithAllParam("DS393961503", "BMBA6W92010EC94814",
                "2022-03-23", "2022-03-25", "2023-03-24", "BMBA6W92010EC94814-1",
                "AFSAD9823KCPR5563Z", "Oleg", "Mustermann", "1964-02-01", "Male");

        String policyNumber2 = resp2.getPolicyNumber();
        String contractNumber2 = resp2.getContractNumber();
        String contractPurchaseDate2 = resp2.getContractPurchaseDate();
        String startDate2 = resp2.getContractValidityPeriod().getStartDate();
        String endDate2 = resp2.getContractValidityPeriod().getEndDate();
        ArrayList<Beneficiary> beneficiaries2 = resp2.getBeneficiaries();
        String beneficiaryNumber2 = beneficiaries2.get(0).getBeneficiaryNumber();
        String customerNumber2 = beneficiaries2.get(0).getCustomerNumber();
        String firstName2 = beneficiaries2.get(0).getFirstName();
        String lastName2 = beneficiaries2.get(0).getLastName();
        String birthDate2 = beneficiaries2.get(0).getBirthDate();
        String genderIdentity2 = beneficiaries2.get(0).getGenderIdentity();

        Assertions.assertEquals("DS393961502", policyNumber1);
        Assertions.assertEquals("BMBA6W92010EC94814", contractNumber1);
        Assertions.assertEquals("2022-03-23", contractPurchaseDate1);
        Assertions.assertEquals("2022-03-25", startDate1);
        Assertions.assertEquals("2023-03-24", endDate1);
        Assertions.assertEquals("BMBA6W92010EC94814-1", beneficiaryNumber1);
        Assertions.assertEquals("AFSAD9823KCPR5563Z", customerNumber1);
        Assertions.assertEquals("Max", firstName1);
        Assertions.assertEquals("Mustermann", lastName1);
        Assertions.assertEquals("1964-02-01", birthDate1);
        Assertions.assertEquals("Male", genderIdentity1);

        Assertions.assertEquals("DS393961503", policyNumber2);
        Assertions.assertEquals("BMBA6W92010EC94814", contractNumber2);
        Assertions.assertEquals("2022-03-23", contractPurchaseDate2);
        Assertions.assertEquals("2022-03-25", startDate2);
        Assertions.assertEquals("2023-03-24", endDate2);
        Assertions.assertEquals("BMBA6W92010EC94814-1", beneficiaryNumber2);
        Assertions.assertEquals("AFSAD9823KCPR5563Z", customerNumber2);
        Assertions.assertEquals("Oleg", firstName2);
        Assertions.assertEquals("Mustermann", lastName2);
        Assertions.assertEquals("1964-02-01", birthDate2);
        Assertions.assertEquals("Male", genderIdentity2);
    }

    /**
     * 1. Check adding a (sub) contract with NOT unique scope policyNumber of the one business partner - Create two new Contracts and Beneficiary
     */
    @SneakyThrows
    @Test
    @DisplayName("Check adding a (sub) contract with NOT unique scope policyNumber of the one business partner - Negative")
    public void checkingAddingTwoContractsTwoBenefNegativeTest() {
        Contact resp1 = ContactWithAllParamSteps.createContactOneBenefWithAllParam("DS393961502", "BMBA6W92010EC94814",
                "2022-03-23", "2022-03-25", "2023-03-24", "BMBA6W92010EC94814-1",
                "AFSAD9823KCPR5563Z", "Max", "Mustermann", "1964-02-01", "Male");

        String policyNumber1 = resp1.getPolicyNumber();
        Assertions.assertEquals("DS393961502", policyNumber1);

        ErrorSimple errorSimpleResp = ContactWithAllParamSteps.createContactNotUniquePolicyNumberParam("72d7036d-990a-4f84-9efa-ef5f40f6044b",
                "0HLOCKDKQPKIU", "CE015","policyNumber","Open policy with this identifier have been created",
                "Parameter is invalid (use case-specific violation)","DS393961502", "BMBA6W92010EC91111",
                "2022-03-23", "2022-03-25", "2023-03-24", "BMBA6W92010EC91111-1",
                "AFSAD9823KCPR5111Z", "Oleg", "Mustermann", "1964-02-01", "Male");

        String faultId =  errorSimpleResp.getFault().getFaultId();
        String traceId =  errorSimpleResp.getFault().getTraceId();
        ArrayList<ErrorLogs> errorLogsArrayList = errorSimpleResp.getFault().getErrors();
        String errorCode = errorLogsArrayList.get(0).getErrorCode();
        String invalidParameter = errorLogsArrayList.get(0).getInvalidParameter();
        String validationRule = errorLogsArrayList.get(0).getValidationRule();
        String description = errorLogsArrayList.get(0).getDescription();

        Assertions.assertEquals("72d7036d-990a-4f84-9efa-ef5f40f6044b", faultId);
        Assertions.assertEquals("0HLOCKDKQPKIU", traceId);
        Assertions.assertEquals("CE015", errorCode);
        Assertions.assertEquals("policyNumber", invalidParameter);
        Assertions.assertEquals("Open policy with this identifier have been created", validationRule);
        Assertions.assertEquals("Parameter is invalid (use case-specific violation)", description);

    }

    /**
     * 1. Check adding a (sub) contract without body
     */
    @SneakyThrows
    @Test
    @DisplayName("Check adding a (sub) contract without body - Negative")
    public void checkingAddingContractEmptyBodyNegativeTest() {

        ErrorSimple errorSimpleResp = ContactWithAllParamSteps.createContactWithoutBody("72d7036d-990a-4f84-9efa-ef5f40f6044b",
                "0HLOCKDKQPKIU", "CE015","No body sent in the request");

        String faultId =  errorSimpleResp.getFault().getFaultId();
        String traceId =  errorSimpleResp.getFault().getTraceId();
        ArrayList<ErrorLogs> errorLogsArrayList = errorSimpleResp.getFault().getErrors();
        String errorCode = errorLogsArrayList.get(0).getErrorCode();
        String description = errorLogsArrayList.get(0).getDescription();

        Assertions.assertEquals("72d7036d-990a-4f84-9efa-ef5f40f6044b", faultId);
        Assertions.assertEquals("0HLOCKDKQPKIU", traceId);
        Assertions.assertEquals("CE002", errorCode);
        Assertions.assertEquals("No body sent in the request", description);
    }
    /**
     * 1. Check that the beneficiary ID is NOT unique within the scope of the one (sub)contract
     */
    @SneakyThrows
    @Test
    @DisplayName("Check that the beneficiary ID is NOT unique within the scope of the one (sub)contract - Negative")
    public void checkingAddingContractTwoBenefNegativeTest() {
        ErrorSimple errorSimpleResp = ContactWithAllParamSteps.createContactTwoBenefWithAllParamNegative("72d7036d-990a-4f84-9efa-ef5f40f6044b",
                "0HLOCKDKQPKIU", "CE015","customerNumber","Open policy with this identifier have been created",
                "Parameter is invalid (use case-specific violation)","DS393961502", "BMBA6W92010EC91111",
                "2022-03-23", "2022-03-25", "2023-03-24", "BMBA6W92010EC91111-1",
                "AFSAD9823KCPR5111Z", "Max", "Mustermann", "1964-02-01", "Male", "BMBA6W92010EC91111-1",
                "AFSAD9823KCPR5111Z", "Oleg", "Gold", "1988-05-11", "Male");

        String faultId =  errorSimpleResp.getFault().getFaultId();
        String traceId =  errorSimpleResp.getFault().getTraceId();
        ArrayList<ErrorLogs> errorLogsArrayList = errorSimpleResp.getFault().getErrors();
        String errorCode = errorLogsArrayList.get(0).getErrorCode();
        String invalidParameter = errorLogsArrayList.get(0).getInvalidParameter();
        String validationRule = errorLogsArrayList.get(0).getValidationRule();
        String description = errorLogsArrayList.get(0).getDescription();

        Assertions.assertEquals("72d7036d-990a-4f84-9efa-ef5f40f6044b", faultId);
        Assertions.assertEquals("0HLOCKDKQPKIU", traceId);
        Assertions.assertEquals("CE015", errorCode);
        Assertions.assertEquals("customerNumber", invalidParameter);
        Assertions.assertEquals("Open policy with this identifier have been created", validationRule);
        Assertions.assertEquals("Parameter is invalid (use case-specific violation)", description);
    }

    /**
     * 1. Check that the beneficiary ID is NOT unique within the scope of the one (sub)contract
     */
    @SneakyThrows
    @Test
    @DisplayName("Check that the beneficiary ID is NOT unique within the scope of the one (sub)contract - Negative")
    public void checkingAddingContractOneBenefOverwriteTest() {
        Contact resp1 = ContactWithAllParamSteps.createContactOneBenefWithAllParam("DS393961502", "BMBA6W92010EC94814",
                "2022-03-23", "2022-03-25", "2023-03-24", "BMBA6W92010EC94814-1",
                "AFSAD9823KCPR5563Z", "Max", "Mustermann", "1964-02-01", "Male");

        String policyNumber1 = resp1.getPolicyNumber();
        Assertions.assertEquals("DS393961502", policyNumber1);

        ErrorSimple errorSimpleResp = ContactWithAllParamSteps.createContactNotUniquePolicyNumberParam("72d7036d-990a-4f84-9efa-ef5f40f6044b",
                "0HLOCKDKQPKIU", "CE015","policyNumber","Open policy with this identifier have been created",
                "Parameter is invalid (use case-specific violation)","DS393961502", "BMBA6W92010EC91111",
                "2022-03-23", "2022-03-25", "2023-03-24", "BMBA6W92010EC94814-1",
                "AFSAD9823KCPR5563Z", "Max", "Mustermann", "1964-02-01", "Male");

        String faultId =  errorSimpleResp.getFault().getFaultId();
        String traceId =  errorSimpleResp.getFault().getTraceId();
        ArrayList<ErrorLogs> errorLogsArrayList = errorSimpleResp.getFault().getErrors();
        String errorCode = errorLogsArrayList.get(0).getErrorCode();
        String invalidParameter = errorLogsArrayList.get(0).getInvalidParameter();
        String validationRule = errorLogsArrayList.get(0).getValidationRule();
        String description = errorLogsArrayList.get(0).getDescription();

        Assertions.assertEquals("72d7036d-990a-4f84-9efa-ef5f40f6044b", faultId);
        Assertions.assertEquals("0HLOCKDKQPKIU", traceId);
        Assertions.assertEquals("CE015", errorCode);
        Assertions.assertEquals("policyNumber", invalidParameter);
        Assertions.assertEquals("Open policy with this identifier have been created", validationRule);
        Assertions.assertEquals("Parameter is invalid (use case-specific violation)", description);
    }

}

