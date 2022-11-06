package allianz_tests;

import lombok.SneakyThrows;
import models.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;
import steps.ContactWithAllParamSteps;

public class CreateContactTests {
    /**
     * 1. Create new Contract and Beneficiary
     */
    @SneakyThrows
    @Test
    @DisplayName("First positive test, check PolicyNumber")
    public void firstPositiveTest() {
        Contact resp = ContactWithAllParamSteps.createContactWithAllParam("DS393961502", "", "", "", "", "",
                "", "", "", "", "");

        String policyNumber = resp.getPolicyNumber();

        Assertions.assertEquals("DS393961502", policyNumber);

    }
}

