package org.example.sus.tests;

import com.syscolabs.sus.functions.terminal5250.DataRoutingControl;
import com.syscolabs.sus.functions.terminal5250.T5250Home;
import org.example.sus.data.*;
import org.example.sus.functions.sus.SUSLogin;
import org.example.sus.functions.sus.ShipToInquiry;
import org.example.sus.functions.sus.ShipToInquiryPrompt;
import org.example.sus.utils.ExcelUtil;
import org.example.sus.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginTest extends TestBase {

    LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);
    SoftAssert softAssert;
    String OpCoID = OpCoData.OPCO_056;

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test
    public void testLogin() throws Exception {

        loginData = ExcelUtil.getLoginData(ExcelKeyData.SUS_AS242K_KEY);
        SUSLogin.loginToSUS(loginData);
        T5250Home.navigateToQuickAccessPage();
        T5250Home.enterQuickAccessCode(AccessCodeData.QUICK_ACCESS_CODE_SHIP_TO_MAINTENANCE,AccessCodeData.QUICK_ACCESS_TYPE,AccessCodeData.QUICK_ACCESS_NUMBER);
        ShipToInquiryPrompt.viewShipToDetails(OpCoID,"166548");

        softAssert.assertEquals(ShipToInquiry.getShipToNumber(),"166548","Incorrect Ship-To number displayed in SUS");
        boolean abc = T5250Home.verifyScreen(SUSScreenData.STI.getValue());
        System.out.println(abc);

//        softAssert.assertTrue(T5250Home.verifyScreen(SUSScreenData.STI.getValue()),"User not in "+SUSScreenData.STI.getValue()+" screen");
//        softAssert.assertEquals(ShipToInquiry.getShipToNumber(),"166548","Incorrect Ship-To number displayed in SUS");
//        softAssert.assertEquals(ShipToInquiry.getShipToName(),secondaryAccountShippingData.getAccountName(),"Incorrect Ship-To name displayed in SUS");

    }
}