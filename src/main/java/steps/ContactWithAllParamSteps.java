package steps;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.Beneficiary;
import models.Contact;
import models.ContractValidityPeriod;
import models.errors.ErrorFault;
import models.errors.ErrorLogs;
import models.errors.ErrorSimple;

import java.util.ArrayList;


public class ContactWithAllParamSteps {
    private static final RequestSpecification REQUEST_SPECIFICATION =
            new RequestSpecBuilder()
                    .setBaseUri("https://baseUri/contracts")
                    .setBasePath("/services/v1/")
                    .setContentType(ContentType.JSON)
                    .build();

    public static Contact createContactOneBenefWithAllParam(String policyNumber, String contractNumber, String contractPurchaseDate, String startDate, String endDate,
                                                            String beneficiaryNumber, String customerNumber, String firstName, String lastName, String birthDate, String genderIdentity){
        Contact req = new Contact();

        req.setPolicyNumber(policyNumber);
        req.setContractNumber(contractNumber);
        req.setContractPurchaseDate(contractPurchaseDate);

        ContractValidityPeriod contractValidityPeriod = new ContractValidityPeriod();
        contractValidityPeriod.setStartDate(startDate);
        contractValidityPeriod.setEndDate(endDate);
        req.setContractValidityPeriod(contractValidityPeriod);

        ArrayList<Beneficiary> beneficiaryArrayList = new ArrayList<>();
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setBeneficiaryNumber(beneficiaryNumber);
        beneficiary.setCustomerNumber(customerNumber);
        beneficiary.setFirstName(firstName);
        beneficiary.setLastName(lastName);
        beneficiary.setBirthDate(birthDate);
        beneficiary.setGenderIdentity(genderIdentity);
        beneficiaryArrayList.add(beneficiary);
        req.setBeneficiaries(beneficiaryArrayList);

        return RestAssured.given()
                .spec(REQUEST_SPECIFICATION)
                .header("Authorization",
                        "Bearer " + "TOKEN")
                .body(req)
                .when().post()
                .then().statusCode(201).extract().as(Contact.class);
    }

    public static Contact createContactTwoBenefWithAllParam(String policyNumber, String contractNumber, String contractPurchaseDate, String startDate, String endDate,
                                                            String beneficiaryNumber1, String customerNumber1, String firstName1, String lastName1, String birthDate1, String genderIdentity1,
                                                            String beneficiaryNumber2, String customerNumber2, String firstName2, String lastName2, String birthDate2, String genderIdentity2){
        Contact req = new Contact();

        req.setPolicyNumber(policyNumber);
        req.setContractNumber(contractNumber);
        req.setContractPurchaseDate(contractPurchaseDate);

        ContractValidityPeriod contractValidityPeriod = new ContractValidityPeriod();
        contractValidityPeriod.setStartDate(startDate);
        contractValidityPeriod.setEndDate(endDate);
        req.setContractValidityPeriod(contractValidityPeriod);

        ArrayList<Beneficiary> beneficiaryArrayList = new ArrayList<>();
        Beneficiary beneficiary1 = new Beneficiary();
        beneficiary1.setBeneficiaryNumber(beneficiaryNumber1);
        beneficiary1.setCustomerNumber(customerNumber1);
        beneficiary1.setFirstName(firstName1);
        beneficiary1.setLastName(lastName1);
        beneficiary1.setBirthDate(birthDate1);
        beneficiary1.setGenderIdentity(genderIdentity1);
        beneficiaryArrayList.add(beneficiary1);
        Beneficiary beneficiary2 = new Beneficiary();
        beneficiary2.setBeneficiaryNumber(beneficiaryNumber2);
        beneficiary2.setCustomerNumber(customerNumber2);
        beneficiary2.setFirstName(firstName2);
        beneficiary2.setLastName(lastName2);
        beneficiary2.setBirthDate(birthDate2);
        beneficiary2.setGenderIdentity(genderIdentity2);
        beneficiaryArrayList.add(beneficiary2);
        req.setBeneficiaries(beneficiaryArrayList);

        return RestAssured.given()
                .spec(REQUEST_SPECIFICATION)
                .header("Authorization",
                        "Bearer " + "TOKEN")
                .body(req)
                .when().post()
                .then().statusCode(201).extract().as(Contact.class);
    }

    public static ErrorSimple createContactNotUniquePolicyNumberParam(String faultId, String traceId, String errorCode, String invalidParameter, String validationRule,
                                                                      String description, String policyNumber, String contractNumber,
                                                                      String contractPurchaseDate, String startDate, String endDate, String beneficiaryNumber,
                                                                      String customerNumber, String firstName, String lastName, String birthDate, String genderIdentity){
        ErrorSimple errorSimple = new ErrorSimple();
        ErrorFault errorFault = new ErrorFault();
        errorFault.setFaultId(faultId);
        errorFault.setTraceId(traceId);
        ArrayList<ErrorLogs> errorLogsArrayList = new ArrayList<>();
        ErrorLogs errorLogs = new ErrorLogs();
        errorLogs.setErrorCode(errorCode);
        errorLogs.setDescription(description);
        errorLogs.setInvalidParameter(invalidParameter);
        errorLogs.setValidationRule(validationRule);
        errorLogsArrayList.add(errorLogs);
        errorFault.setErrors(errorLogsArrayList);
        errorSimple.setFault(errorFault);

        Contact req = new Contact();
        req.setPolicyNumber(policyNumber);
        req.setContractNumber(contractNumber);
        req.setContractPurchaseDate(contractPurchaseDate);

        ContractValidityPeriod contractValidityPeriod = new ContractValidityPeriod();
        contractValidityPeriod.setStartDate(startDate);
        contractValidityPeriod.setEndDate(endDate);
        req.setContractValidityPeriod(contractValidityPeriod);

        ArrayList<Beneficiary> beneficiaryArrayList = new ArrayList<>();
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setBeneficiaryNumber(beneficiaryNumber);
        beneficiary.setCustomerNumber(customerNumber);
        beneficiary.setFirstName(firstName);
        beneficiary.setLastName(lastName);
        beneficiary.setBirthDate(birthDate);
        beneficiary.setGenderIdentity(genderIdentity);
        beneficiaryArrayList.add(beneficiary);
        req.setBeneficiaries(beneficiaryArrayList);

        return RestAssured.given()
                .spec(REQUEST_SPECIFICATION)
                .header("Authorization",
                        "Bearer " + "TOKEN")
                .body(req)
                .when().post()
                .then().statusCode(400).extract().as(ErrorSimple.class);
    }

    public static ErrorSimple createContactTwoBenefWithAllParamNegative(String faultId, String traceId, String errorCode, String invalidParameter, String validationRule,
                                                                        String description, String policyNumber, String contractNumber, String contractPurchaseDate,
                                                                        String startDate, String endDate, String beneficiaryNumber1, String customerNumber1, String firstName1,
                                                                        String lastName1, String birthDate1, String genderIdentity1, String beneficiaryNumber2, String customerNumber2,
                                                                        String firstName2, String lastName2, String birthDate2, String genderIdentity2){
        ErrorSimple errorSimple = new ErrorSimple();
        ErrorFault errorFault = new ErrorFault();
        errorFault.setFaultId(faultId);
        errorFault.setTraceId(traceId);
        ArrayList<ErrorLogs> errorLogsArrayList = new ArrayList<>();
        ErrorLogs errorLogs = new ErrorLogs();
        errorLogs.setErrorCode(errorCode);
        errorLogs.setDescription(description);
        errorLogs.setInvalidParameter(invalidParameter);
        errorLogs.setValidationRule(validationRule);
        errorLogsArrayList.add(errorLogs);
        errorFault.setErrors(errorLogsArrayList);
        errorSimple.setFault(errorFault);

        Contact req = new Contact();
        req.setPolicyNumber(policyNumber);
        req.setContractNumber(contractNumber);
        req.setContractPurchaseDate(contractPurchaseDate);

        ContractValidityPeriod contractValidityPeriod = new ContractValidityPeriod();
        contractValidityPeriod.setStartDate(startDate);
        contractValidityPeriod.setEndDate(endDate);
        req.setContractValidityPeriod(contractValidityPeriod);

        ArrayList<Beneficiary> beneficiaryArrayList = new ArrayList<>();
        Beneficiary beneficiary1 = new Beneficiary();
        beneficiary1.setBeneficiaryNumber(beneficiaryNumber1);
        beneficiary1.setCustomerNumber(customerNumber1);
        beneficiary1.setFirstName(firstName1);
        beneficiary1.setLastName(lastName1);
        beneficiary1.setBirthDate(birthDate1);
        beneficiary1.setGenderIdentity(genderIdentity1);
        beneficiaryArrayList.add(beneficiary1);

        Beneficiary beneficiary2 = new Beneficiary();
        beneficiary2.setBeneficiaryNumber(beneficiaryNumber2);
        beneficiary2.setCustomerNumber(customerNumber2);
        beneficiary2.setFirstName(firstName2);
        beneficiary2.setLastName(lastName2);
        beneficiary2.setBirthDate(birthDate2);
        beneficiary2.setGenderIdentity(genderIdentity2);
        beneficiaryArrayList.add(beneficiary2);

        req.setBeneficiaries(beneficiaryArrayList);

        return RestAssured.given()
                .spec(REQUEST_SPECIFICATION)
                .header("Authorization",
                        "Bearer " + "TOKEN")
                .body(req)
                .when().post()
                .then().statusCode(400).extract().as(ErrorSimple.class);
    }

    public static ErrorSimple createContactWithoutBody(String faultId, String traceId, String errorCode, String description){
        ErrorSimple errorSimple = new ErrorSimple();
        ErrorFault errorFault = new ErrorFault();
        errorFault.setFaultId(faultId);
        errorFault.setTraceId(traceId);
        ArrayList<ErrorLogs> errorLogsArrayList = new ArrayList<>();
        ErrorLogs errorLogs = new ErrorLogs();
        errorLogs.setErrorCode(errorCode);
        errorLogs.setDescription(description);
        errorLogsArrayList.add(errorLogs);
        errorFault.setErrors(errorLogsArrayList);
        errorSimple.setFault(errorFault);

        return RestAssured.given()
                .spec(REQUEST_SPECIFICATION)
                .header("Authorization",
                        "Bearer " + "TOKEN")
                .body("")
                .when().post()
                .then().statusCode(400).extract().as(ErrorSimple.class);
    }
}
