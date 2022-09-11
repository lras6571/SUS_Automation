package org.example.sus.functions.sus;

/**
 * Created by Lasan Rashmika on 08/09/2022.
 */
import org.example.sus.pages.sus.*;
import com.syscolabs.functions.TN5250FunctionBase;
import framework.KeyMnemonic;

import java.util.logging.Logger;

public class ShipToInquiryPrompt extends TN5250FunctionBase {

    public static final Logger logger = Logger.getLogger(ShipToInquiryPrompt.class.getName());

    public static void viewShipToDetails(String strOpCo, String strShipToNumber) throws Exception{

        sendText(strOpCo,ShipToInquiryPromptPage.ROW_NO_OPCO,ShipToInquiryPromptPage.COL_NO_OPCO);
        sendKeys(KeyMnemonic.FIELD_EXIT);
        sendText(strShipToNumber,ShipToInquiryPromptPage.ROW_NO_SHIP_TO_NUMBER,ShipToInquiryPromptPage.COL_NO_SHIP_TO_NUMBER);
        sendKeys(KeyMnemonic.FIELD_EXIT);
        sendText(ShipToInquiryPromptPage.SCREEN_01,ShipToInquiryPromptPage.ROW_NO_DESIRED_SCREEN,ShipToInquiryPromptPage.COL_NO_DESIRED_SCREEN);
        sendKeys(KeyMnemonic.ENTER);
    }
}
