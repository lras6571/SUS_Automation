package org.example.sus.functions.sus;

import org.example.sus.pages.sus.BillToProfilePage;
import com.syscolabs.functions.TN5250FunctionBase;
import framework.KeyMnemonic;

public class BillToProfile extends TN5250FunctionBase {

    public static String getPriceVerification(){
        return getLabelText(BillToProfilePage.ROW_NO_BILL_PRICE_VERIFICATION, BillToProfilePage.COL_NO_BILL_PRICE_VERIFICATION,
                BillToProfilePage.LEN_BILL_PRICE_VERIFICATION);
    }

    public static void navigateToShipToScreen() throws Exception{
        sendKeys(KeyMnemonic.PF3);
    }

    public static String getCustomerType(){
        return getLabelText(BillToProfilePage.ROW_NO_CUSTOMER_TYPE, BillToProfilePage.COL_NO_CUSTOMER_TYPE, BillToProfilePage.LEN_CUSTOMER_TYPE);
    }
}
