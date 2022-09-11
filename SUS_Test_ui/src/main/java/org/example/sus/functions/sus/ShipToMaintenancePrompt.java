package org.example.sus.functions.sus;

/**
 * Created by Lasan Rashmika on 08/09/2022.
 */

import com.syscolabs.functions.TN5250FunctionBase;
import framework.KeyMnemonic;
import org.example.sus.pages.sus.ShipToInquiryPromptPage;
import org.example.sus.pages.sus.ShipToMaintenancePromptPage;

import java.util.logging.Logger;

public class ShipToMaintenancePrompt extends TN5250FunctionBase {

    public static final Logger logger = Logger.getLogger(ShipToMaintenancePrompt.class.getName());

    public static void editShipToAddressLineTwoDetails(String strOpCo, String strShipToNumber) throws Exception{

        sendText(strShipToNumber, ShipToMaintenancePromptPage.ROW_NO_SHIP_TO_NUMBER,ShipToMaintenancePromptPage.COL_NO_SHIP_TO_NUMBER);
        ShipToMaintenance.saveRecord();
//        sendKeys(KeyMnemonic.FIELD_EXIT);
//        sendText(ShipToInquiryPromptPage.SCREEN_01,ShipToInquiryPromptPage.ROW_NO_DESIRED_SCREEN,ShipToInquiryPromptPage.COL_NO_DESIRED_SCREEN);
//        sendKeys(KeyMnemonic.ENTER);
    }
}