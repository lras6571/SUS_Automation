package org.example.sus.functions.sus;

/**
 * Created by Lasan Rashmika on 08/09/2022.
 */

import com.syscolabs.functions.TN5250FunctionBase;
import framework.KeyMnemonic;
import org.example.sus.pages.sus.ShipToListPage;

import java.util.logging.Logger;


public class ShipToList extends TN5250FunctionBase {

    public static final Logger logger = Logger.getLogger(ShipToList.class.getName());

    public static void selectActiveAccount(String statusCode) throws Exception {

        sendText(statusCode, ShipToListPage.ROW_NO_STATUS_TYPE, ShipToListPage.COL_NO_STATUS_TYPE);
        sendKeys(KeyMnemonic.FIELD_EXIT);
        sendKeys(KeyMnemonic.ENTER);

        sendText(String.valueOf(ShipToListPage.SELECT_ACCOUNT), ShipToListPage.ROW_NO_SHIP_TO_ACCOUNT, ShipToListPage.COL_NO_SHIP_TO_ACCOUNT);
        sendKeys(KeyMnemonic.ENTER);
        logger.info("Enter Option Key in front of the Account Name");
        sendKeys(KeyMnemonic.ENTER);
        logger.info("Select the Account From the List - Clicked Enter");

    }
}

