package steps;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.Beneficiary;
import models.Contact;
import models.ContractValidityPeriod;

import java.util.ArrayList;


public class ContactWithAllParamSteps {
    private static final RequestSpecification REQUEST_SPECIFICATION =
            new RequestSpecBuilder()
                    .setBaseUri("https://baseUri/contracts")
                    .setBasePath("/services/v1/")
                    .setContentType(ContentType.JSON)
                    .build();

    public static Contact createContactWithAllParam(String policyNumber, String contractNumber, String contractPurchaseDate, String startDate, String endDate,
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
}
