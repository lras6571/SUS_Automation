package org.example.sus.functions.sus;

/**
 * Created by Lasan Rashmika on 08/09/2022.
 */

import com.syscolabs.functions.TN5250FunctionBase;
import framework.KeyMnemonic;

import java.util.logging.Logger;

public class ShipToMaintenancePrompt extends TN5250FunctionBase {

    public static final Logger logger = Logger.getLogger(ShipToMaintenancePrompt.class.getName());


    //Click F4 Button for Prompt
    public static void selectPrompt() throws Exception {

        sendKeys(KeyMnemonic.PF4);
    }

    //Click F17 Button for Prompt
    public static void clickStatus() throws Exception {
        sendKeys(KeyMnemonic.PF17);
    }


}