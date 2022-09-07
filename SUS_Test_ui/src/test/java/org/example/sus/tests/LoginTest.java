package org.example.sus.tests;

import com.syscolabs.sus.functions.terminal5250.DataRoutingControl;
import com.syscolabs.sus.functions.terminal5250.T5250Home;
import org.example.sus.data.AccessCodeData;
import org.example.sus.data.ExcelKeyData;
import org.example.sus.data.LoginData;
import org.example.sus.data.SUSScreenData;
import org.example.sus.functions.sus.SUSLogin;
import org.example.sus.utils.ExcelUtil;
import org.example.sus.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginTest extends TestBase {

    LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);
    SoftAssert softAssert;

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test
    public void testLogin() throws Exception {

        loginData = ExcelUtil.getLoginData(ExcelKeyData.SUS_AS242K_KEY);
        SUSLogin.loginToSUS(loginData);
//        softAssert.assertTrue(T5250Home.verifyScreen(SUSScreenData.HOME_PAGE.getValue()),"User is not in Home page");
        T5250Home.navigateToQuickAccessPage();
        T5250Home.enterQuickAccessCode(AccessCodeData.QUICK_ACCESS_CODE_SHIP_TO_MAINTENANCE,AccessCodeData.QUICK_ACCESS_TYPE,AccessCodeData.QUICK_ACCESS_NUMBER);
//        softAssert.assertTrue(T5250Home.verifyScreen(SUSScreenData.WD.getValue()),"User not in WD screen");
//        DataRoutingControl.enterTRANID(transactionID);

    }
}