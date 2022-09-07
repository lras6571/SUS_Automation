package org.example.sus.functions.sus;

/**
 * Created by Resitha Subbiah on 10/02/2019.
 */
import org.example.sus.pages.sus.ShipToInquiryPage;
import com.syscolabs.functions.TN5250FunctionBase;
import com.syscolabs.sus.functions.terminal5250.T5250Home;

import framework.KeyMnemonic;



public class ShipToInquiry extends TN5250FunctionBase {

    public static void navigateToMainScreen() throws Exception{
        sendKeys(KeyMnemonic.PF3);
    }

    public static void navigateToBillToInquiry() throws Exception{
        sendKeys(KeyMnemonic.PF21);
    }

    public static void navigateToPageInSTIScreen(String strPageName) throws Exception{
        while ((!T5250Home.verifyScreen(strPageName))){
            sendKeys(KeyMnemonic.ENTER);
        }
    }

    public static String getShipToNumber(){
        return getLabelText(ShipToInquiryPage.ROW_NO_SHIP_TO_NUMBER,ShipToInquiryPage.COL_NO_SHIP_TO_NUMBER,ShipToInquiryPage.LEN_SHIP_TO_NUMBER);
    }

    public static String getShipToName(){
        return getLabelText(ShipToInquiryPage.ROW_NO_SHIP_TO_NAME,ShipToInquiryPage.COL_NO_SHIP_TO_NAME,ShipToInquiryPage.LEN_SHIP_TO_NAME);
    }

    public static String getBillToNumber(){
        return getLabelText(ShipToInquiryPage.ROW_NO_BILL_TO_NUMBER,ShipToInquiryPage.COL_NO_BILL_TO_NUMBER,ShipToInquiryPage.LEN_BILL_TO_NUMBER);
    }

    public static String getBillToName(){
        return getLabelText(ShipToInquiryPage.ROW_NO_BILL_TO_NAME,ShipToInquiryPage.COL_NO_BILL_TO_NAME,ShipToInquiryPage.LEN_BILL_TO_NAME);
    }

    public static String getShippingDocOrInvoiceValue(){
        return getLabelText(ShipToInquiryPage.ROW_NO_DOC_INVOICE, ShipToInquiryPage.COL_NO_DOC_INVOICE, ShipToInquiryPage.LEN_DOC_INVOICE);
    }

    public static String getCustomerType(){
        return getLabelText(ShipToInquiryPage.ROW_NO_CUSTOMER_TYPE, ShipToInquiryPage.COL_NO_CUSTOMER_TYPE, ShipToInquiryPage.LEN_CUSTOMER_TYPE);
    }
}
