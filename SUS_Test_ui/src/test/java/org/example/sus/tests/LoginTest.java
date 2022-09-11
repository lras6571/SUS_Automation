package org.example.sus.tests;

import com.syscolabs.sus.functions.terminal5250.T5250Home;
import org.example.sus.common.Constants;
import org.example.sus.data.AccessCodeData;
import org.example.sus.data.OpCoData;
import org.example.sus.functions.sus.*;
import org.example.sus.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    String OpCoID = OpCoData.OPCO_056;

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test
    public void testLogin() throws Exception {

        SUSLogin.loginToSUS(Constants.SUS_USER_NAME, Constants.SUS_PASSWORD, Constants.SUS_IP, Constants.SUS_NAME);
        T5250Home.navigateToQuickAccessPage();
        T5250Home.enterQuickAccessCode(AccessCodeData.QUICK_ACCESS_CODE_SHIP_TO_MAINTENANCE, AccessCodeData.QUICK_ACCESS_TYPE, AccessCodeData.QUICK_ACCESS_NUMBER);
        ShipToMaintenancePrompt.selectPrompt();
        ShipToMaintenancePrompt.clickStatus();
        ShipToList.selectActiveAccount("AC");
        System.out.println("Ship To Number is :" + ShipToMaintenanceDemographics.getShipToNumber());
        ShipToMaintenanceDemographics.editShipToAddressLineTwoDetails("changed");
        ShipToMaintenanceDemographics.saveRecord();


//        ShipToInquiryPrompt.viewShipToDetails(OpCoID, "166548");
//        softAssert.assertEquals(ShipToInquiry.getShipToNumber(), "166548", "Incorrect Ship-To number displayed in SUS");
//        System.out.println("Bill To Number :" + ShipToInquiry.getBillToNumber());
//        System.out.println("Ship To Number :" + ShipToInquiry.getBillToName());
//        ShipToMaintenancePrompt.editShipToAddressLineTwoDetails(OpCoID, "changed");


    }
}