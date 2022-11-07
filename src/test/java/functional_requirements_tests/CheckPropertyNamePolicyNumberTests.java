package functional_requirements_tests;

import lombok.SneakyThrows;
import models.errors.ErrorLogs;
import models.errors.ErrorSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;
import steps.ContactWithAllParamSteps;

import java.util.ArrayList;

public class CheckPropertyNamePolicyNumberTests {
    /**
     * 1. Check Property name policyNumber use 13 characters
     */
    @SneakyThrows
    @Test
    @DisplayName("Check Property name policyNumber use 13 characters - Negative")
    public void checkingAddingContractPolicyNumberUse13CharactersTest() {
        ErrorSimple errorSimpleResp = ContactWithAllParamSteps.createContactNotUniquePolicyNumberParam("72d7036d-990a-4f84-9efa-ef5f40f6044b",
                "0HLOCKDKQPKIU", "CE004","policyNumber","Max 12 characters",
                "Parameter is invalid (wrong data format)","DS39396150245", "BMBA6W92010EC91111",
                "2022-03-23", "2022-03-25", "2023-03-24", "BMBA6W92010EC91111-1",
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
        Assertions.assertEquals("CE004", errorCode);
        Assertions.assertEquals("policyNumber", invalidParameter);
        Assertions.assertEquals("Max 12 characters", validationRule);
        Assertions.assertEquals("Parameter is invalid (wrong data format)", description);
    }

    /**
     * 1. Check Property name policyNumber use 13 characters
     */
    @SneakyThrows
    @Test
    @DisplayName("Check Property name policyNumber use 13 characters - Negative")
    public void checkingAddingContractPolicyNumberUse0CharactersTest() {
        ErrorSimple errorSimpleResp = ContactWithAllParamSteps.createContactNotUniquePolicyNumberParam("72d7036d-990a-4f84-9efa-ef5f40f6044b",
                "0HLOCKDKQPKIU", "CE003","policyNumber","",
                "Required parameter is missing","", "BMBA6W92010EC91111",
                "2022-03-23", "2022-03-25", "2023-03-24", "BMBA6W92010EC91111-1",
                "AFSAD9823KCPR5563Z", "Max", "Mustermann", "1964-02-01", "Male");

        String faultId =  errorSimpleResp.getFault().getFaultId();
        String traceId =  errorSimpleResp.getFault().getTraceId();
        ArrayList<ErrorLogs> errorLogsArrayList = errorSimpleResp.getFault().getErrors();
        String errorCode = errorLogsArrayList.get(0).getErrorCode();
        String invalidParameter = errorLogsArrayList.get(0).getInvalidParameter();
        String description = errorLogsArrayList.get(0).getDescription();

        Assertions.assertEquals("72d7036d-990a-4f84-9efa-ef5f40f6044b", faultId);
        Assertions.assertEquals("0HLOCKDKQPKIU", traceId);
        Assertions.assertEquals("CE003", errorCode);
        Assertions.assertEquals("policyNumber", invalidParameter);
        Assertions.assertEquals("Required parameter is missing", description);
    }
}

