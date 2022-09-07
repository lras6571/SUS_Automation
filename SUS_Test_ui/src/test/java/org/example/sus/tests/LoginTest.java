package org.example.sus.tests;

import org.example.sus.data.ExcelKeyData;
import org.example.sus.data.LoginData;
import org.example.sus.functions.sus.SUSLogin;
import org.example.sus.utils.ExcelUtil;
import org.example.sus.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    LoginData loginData = ExcelUtil.getLoginData(ExcelKeyData.MDM_LOGIN_KEY_01);

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test
    public void testLogin() throws Exception {

        loginData = ExcelUtil.getLoginData(ExcelKeyData.SUS_AS242K_KEY);
        SUSLogin.loginToSUS(loginData);

    }
}