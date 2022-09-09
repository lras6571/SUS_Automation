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

}
