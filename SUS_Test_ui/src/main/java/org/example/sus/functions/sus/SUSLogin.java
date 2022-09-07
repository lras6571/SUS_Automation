package org.example.sus.functions.sus;

/**
 * SUSLogin - This class is for logging into the SUS box
 *
 * @author Lasan Rashmika
 * @since 08/09/2022
 * @version 1.0
 */

import com.syscolabs.functions.TN5250FunctionBase;
import framework.KeyMnemonic;
import org.example.sus.data.LoginData;
import org.example.sus.pages.sus.SUSLoginPage;

import java.util.logging.Logger;

public class SUSLogin extends TN5250FunctionBase {
    static Logger logger = Logger.getLogger(SUSLogin.class.getName());
    
    public static void loginToSUS(LoginData loginData) throws Exception{
        connectToBox(loginData.iPAddress, loginData.box);
        if (waitForScreenwithText("USER ID", 5)) {
            logger.info("Connected to SUS box");
        }
        sendText(loginData.userName, SUSLoginPage.ROW_NO_SUS_USER_NAME, SUSLoginPage.COL_NO_SUS_USER_NAME);
        sendText(loginData.password, SUSLoginPage.ROW_NO_SUS_PASSWORD, SUSLoginPage.COL_NO_SUS_PASSWORD);
        sendKeys(KeyMnemonic.ENTER);
        if (verifyScreen("Display Program Message")) {
            sendKeys(KeyMnemonic.ENTER);
        }

        if (verifyScreen("FreshPoint IT Main Menu")) {
            sendText("4", SUSLoginPage.ROW_NO_FRESHPOINT_IT_HOME, SUSLoginPage.COL_NO_FRESHPOINT_IT_HOME);
            sendKeys(KeyMnemonic.ENTER);
        }

        if (verifyScreen("FreshPoint Distribution System")) {
            sendText("3", SUSLoginPage.ROW_NO_FRESHPOINT_DISTRIBUTION, SUSLoginPage.COL_NO_FRESHPOINT_DISTRIBUTION);
            sendKeys(KeyMnemonic.ENTER);
        }

        if (verifyScreen("Order Entry Menu")) {
            sendText("4", SUSLoginPage.ROW_NO_FRESHPOINT_ORDER_ENTRY, SUSLoginPage.COL_NO_FRESHPOINT_ORDER_ENTRY);
            sendKeys(KeyMnemonic.ENTER);
        }
    }
}
