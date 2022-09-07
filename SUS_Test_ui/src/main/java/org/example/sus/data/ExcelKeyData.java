package org.example.sus.data;

import java.util.HashMap;
import java.util.Map;

public class ExcelKeyData {
    private ExcelKeyData() {
        Map<String, String> loginMap = new HashMap<>();
    }

    Map<String, String> loginMap;
    public void setLoginKeyData(){
        loginMap = new HashMap<String, String>();
        loginMap.put("Staging", "$MDM_1");
        loginMap.put("CCA", "$MDM_3");
        loginMap.put("OSD", "$MDM_5");
    }

    public void getLoginKeyData(){
        loginMap = new HashMap<String, String>();
        loginMap.put("Staging", "$MDM_1");
        loginMap.put("CCA", "$MDM_3");
        loginMap.put("OSD", "$MDM_5");
    }

    public static final String MDM_LOGIN_KEY_01 = "$MDM_1";
    public static final String MDM_LOGIN_KEY_02 = "$MDM_2";
    public static final String SUS_AS242K_KEY = "$as242k";
    public static final String GMAIL_KEY_01 = "$GMAIL";
    public static final String MDM_CCA_LOGIN_KEY_01 = "$MDM_3";
    public static final String MDM_STAGING_API_LOGIN_KEY = "$MDM_4";

    public static final String MDM_CADD_CREDENTIAL = "$CADD";
    public static final String MDM_CC360_CREDENTIAL = "$CC360";
    public static final String MDM_CORA_CREDENTIAL = "$CORAQA";

    public static final String CORA_SUBMISSION_REQ_KEY_01 = "shipToRequest_001";
    public static final String CORA_TRANSMISSION_REQ_KEY_01 = "shipToRequest_004";
    public static final String CORA_LEGACY_SHIPTO_REQ_KEY_01 = "shipToRequest_003";//Tax Exempt is No
    public static final String CORA_LEGACY_BILLTO_REQ_KEY_01 = "billToRequest_003";

    public static final String CORA_SHOP_SHIPTO_REQ_KEY_01 = "shipToRequest_002";//Tax Exempt is Yes
    public static final String CORA_SHOP_BILLTO_REQ_KEY_01 = "billToRequest_002";

    public static final String CORA_LEGACY_SHIPTO_REQ_KEY_02 = "shipToRequest_005"; //To update mandatory Ship To fields
}
