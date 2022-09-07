package org.example.sus.functions.sus;

/**
 * Created by Lasan Rashmika on 08/09/2022.
 */

//import com.syscolabs.sus.data.excelData.MessageData;
import org.example.sus.data.WorkingDirectoryData;
import org.example.sus.pages.sus.*;
import org.example.sus.data.MessageData;
//import com.sysco.mdm_customer.data.WorkingDirectoryData;
////import com.sysco.mdm_customer.pages.sus.WorkingDirectoryPage;
////import com.sysco.mdm_customer.utils.DateUtils;
import com.syscolabs.functions.TN5250FunctionBase;
import framework.KeyMnemonic;
import org.example.sus.utils.DateUtils;

import java.util.logging.Logger;

public class WorkingDirectory extends TN5250FunctionBase {
    
    public static final Logger logger = Logger.getLogger(WorkingDirectory.class.getName());
    
    public static String getTransactionTimeDetails(String strTransaction, String strStatus, String strData) throws Exception {
        boolean isTransactionGenerated = false;
        String timeDetails = "";
        String strOption = WorkingDirectoryData.OPTION_DISPLAY_DETAIL;

        for(int jRefreshCount = 1; jRefreshCount < 2; ++jRefreshCount) {
            int irow = WorkingDirectoryPage.ROW_NO_TRANSACTION_START;

            while(irow <= WorkingDirectoryPage.ROW_NO_TRANSACTION_END && !isTransactionGenerated) {
                if (getLabelText(irow, WorkingDirectoryPage.COL_NO_TRANSACTION_NAME, WorkingDirectoryPage.LENGTH_TRANSACTION_NAME).equals(strTransaction) &&
                    getLabelText(irow, WorkingDirectoryPage.COL_NO_TRANSACTION_STATUS, WorkingDirectoryPage.LENGTH_TRANSACTION_STATUS).contains(strStatus)) {
                    String strDate = getLabelText(irow,WorkingDirectoryPage.COL_NO_DISPLAYED_DATE,WorkingDirectoryPage.LENGTH_DISPLAYED_DATE);
                    String strTime = getLabelText(irow,WorkingDirectoryPage.COL_NO_DISPLAYED_TIME,WorkingDirectoryPage.LENGTH_DISPLAYED_TIME);
                    timeDetails = strDate+" "+strTime;
                    sendText(strOption, irow, WorkingDirectoryPage.COL_NO_OPTION);
                    sendKeys(KeyMnemonic.TAB);
                    sendKeys(KeyMnemonic.ENTER);
                    isTransactionGenerated = isDataPresentInTransaction(strData);
                }
                ++irow;
            }
            sendKeys(KeyMnemonic.PF5);
            sendKeys(KeyMnemonic.PF5);
        }

        return timeDetails;
    }

    public static boolean isDataPresentInTransaction(String strExpectedData) throws Exception{
        String strValue;
        boolean isDataPresent = false;
        int kdataRow = WorkingDirectoryPage.ROW_NO_DATA;
        sendKeys(KeyMnemonic.PF21);
        while(kdataRow <= WorkingDirectoryPage.ROW_NO_DATA_END) {
            strValue = getLabelText(kdataRow, WorkingDirectoryPage.COL_NO_DATA, WorkingDirectoryPage.LENGTH_DATA);
            if (strValue.contains(strExpectedData)) {
                isDataPresent = true;
                kdataRow =  WorkingDirectoryPage.ROW_NO_DATA_END + 2;
            }
            ++kdataRow;
            if (kdataRow == WorkingDirectoryPage.ROW_NO_DATA_END+1 && verifyTextInScreen("More...")){
                sendKeys(KeyMnemonic.PAGE_DOWN);
                kdataRow = WorkingDirectoryPage.ROW_NO_DATA;
            }
        }
        sendKeys(KeyMnemonic.PF21);
        sendKeys(KeyMnemonic.PF12);

        return isDataPresent;
    }

    public static String getCustomerNumber(String strTransaction, String strStatus, String strDate) throws Exception{
        String strCustomerNumber = "";
        String strValue;
        String strOption = WorkingDirectoryData.OPTION_DISPLAY_DETAIL;
        String strFutureDate = DateUtils.getTransmissionDate(strDate,1);
        for(int jRefreshCount = 1; jRefreshCount <= 5; ++jRefreshCount) {
            int irow = WorkingDirectoryPage.ROW_NO_TRANSACTION_START;

            while(irow <= WorkingDirectoryPage.ROW_NO_TRANSACTION_END && strCustomerNumber.isEmpty()) {
                if (getLabelText(irow, WorkingDirectoryPage.COL_NO_TRANSACTION_NAME, WorkingDirectoryPage.LENGTH_TRANSACTION_NAME).equals(strTransaction) &&
                        getLabelText(irow, WorkingDirectoryPage.COL_NO_TRANSACTION_STATUS, WorkingDirectoryPage.LENGTH_TRANSACTION_STATUS).contains(strStatus)) {
                    String strDate1 = getLabelText(irow, WorkingDirectoryPage.COL_NO_DISPLAYED_DATE, WorkingDirectoryPage.LENGTH_DISPLAYED_DATE);
                    if (strDate1.equals(strDate) || strDate1.equals(strFutureDate)) {
                        sendText(strOption, irow, WorkingDirectoryPage.COL_NO_OPTION);
                        sendKeys(KeyMnemonic.TAB);
                        sendKeys(KeyMnemonic.ENTER);
                        int dataRow = WorkingDirectoryPage.ROW_NO_DATA;
                        sendKeys(KeyMnemonic.PF21);
                        while (dataRow <= WorkingDirectoryPage.ROW_NO_DATA_END) {
                            strValue = getLabelText(dataRow, WorkingDirectoryPage.COL_NO_DATA, WorkingDirectoryPage.LENGTH_DATA);
                            if (strValue.contains(MessageData.CUSTOMER_CREATED)) {
                                strCustomerNumber = getLabelText(WorkingDirectoryPage.ROW_NO_DATA,WorkingDirectoryPage.COL_CUSTOMER_NUMBER,WorkingDirectoryPage.LEN_CUSTOMER_NUMBER);
                                break;
                            }
                            ++dataRow;
                        }
                        sendKeys(KeyMnemonic.PF21);
                        sendKeys(KeyMnemonic.PF12);
                    }
                }
                ++irow;
            }
            if (!strCustomerNumber.isEmpty()) {
                break;
            }
            sendKeys(KeyMnemonic.PF5, 2);
        }
        return strCustomerNumber;
    }
}
