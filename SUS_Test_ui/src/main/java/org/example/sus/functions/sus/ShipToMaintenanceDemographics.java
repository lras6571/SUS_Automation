package org.example.sus.functions.sus;

/**
 * Created by Lasan Rashmika on 09/09/2022.
 */

import com.syscolabs.functions.TN5250FunctionBase;
import framework.KeyMnemonic;
import org.example.sus.pages.sus.ShipToInquiryPage;
import org.example.sus.pages.sus.ShipToMaintenanceDemographicsPage;

import java.util.logging.Logger;


public class ShipToMaintenanceDemographics extends TN5250FunctionBase {

    public static final Logger logger = Logger.getLogger(ShipToMaintenanceDemographics.class.getName());


    public static void editShipToAddressLineTwoDetails(String strShipToNumber) throws Exception {

        sendText(strShipToNumber, ShipToMaintenanceDemographicsPage.ROW_NO_SHIP_TO_ADDRESS_TWO, ShipToMaintenanceDemographicsPage.COL_NO_SHIP_TO_ADDRESS_TWO);
        logger.info("Save the Change");
    }


    public static void saveRecord() throws Exception {
        sendKeys(KeyMnemonic.PF7);
    }

    public static String getShipToNumber(){

        return getLabelText(ShipToMaintenanceDemographicsPage.ROW_NO_SHIP_TO_NUMBER, ShipToMaintenanceDemographicsPage.COL_NO_SHIP_TO_NUMBER, ShipToMaintenanceDemographicsPage.LEN_SHIP_TO_NUMBER);
    }


    public static String getBillToNumber(){
        return getLabelText(ShipToInquiryPage.ROW_NO_BILL_TO_NUMBER,ShipToInquiryPage.COL_NO_BILL_TO_NUMBER,ShipToInquiryPage.LEN_BILL_TO_NUMBER);
    }

    public static String getBillToName(){
        return getLabelText(ShipToInquiryPage.ROW_NO_BILL_TO_NAME,ShipToInquiryPage.COL_NO_BILL_TO_NAME,ShipToInquiryPage.LEN_BILL_TO_NAME);
    }

}
