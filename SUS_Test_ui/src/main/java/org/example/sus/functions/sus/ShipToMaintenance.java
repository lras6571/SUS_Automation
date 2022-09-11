package org.example.sus.functions.sus;

/**
 * Created by Lasan Rashmika on 09/09/2022.
 */

import com.syscolabs.functions.TN5250FunctionBase;
import framework.KeyMnemonic;


public class ShipToMaintenance extends TN5250FunctionBase {

    public static void saveRecord() throws Exception {
        sendKeys(KeyMnemonic.PF7);
    }


    //Click F4 Button for Prompt
    public static void clickPrompt() throws Exception {

        sendKeys(KeyMnemonic.PF4);
    }

    //Click F17 Button for Prompt
    public static void clickStatus() throws Exception {
        sendKeys(KeyMnemonic.PF17);
    }

}
