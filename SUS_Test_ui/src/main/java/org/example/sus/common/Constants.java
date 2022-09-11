package org.example.sus.common;

public class Constants {

    private Constants(){}

    //QCenter related
    public static final String TEST_ENV = System.getProperty("test.env", "Staging");
    public static final String TEST_RELEASE = System.getProperty("test.release", "sysco_mdm_customer_FY2202");
    public static final String TEST_PROJECT = System.getProperty("test.project", "MDM Customer Portal");
    public static final boolean UPDATE_DASHBOARD = Boolean.parseBoolean(System.getProperty("update.dashboard", "false"));
    public static final boolean RUN_LOCALLY = Boolean.parseBoolean(System.getProperty("run.locally", "true"));

    //Build Generation
    public static final boolean QLYTICS_QMETRY_RELEASE = Boolean.parseBoolean(System.getProperty("qmetry.release.name", "false"));
    public static final boolean QLYTICS_DAILY_WEEKLY_BUILD = Boolean.parseBoolean(System.getProperty("daily.weekly.build", "None"));

    //JIRA related
    public static final boolean JIRA_USERNAME = Boolean.parseBoolean(System.getProperty("jira.username", ""));
    public static final boolean JIRA_TOKEN = Boolean.parseBoolean(System.getProperty("jira.token", ""));

    public static final String APP_URL = System.getProperty("app.url", "https://sysco--staging.lightning.force.com/");
    public static final String ACCOUNT_TRANSACTION_URL = System.getProperty("app.url", "https://sysco--staging.lightning.force.com/a8w");
    public static final String APP_OS = System.getProperty("app.os", "WIN10");
    public static final String APP_BROWSER = System.getProperty("app.browser", "chrome");
    public static final String GMAIL_URL = "https://mail.google.com";
    public static final String TEST_DATA_PATH = "/src/main/resources/testData/";
    public static final String TEST_OUTPUT_PATH = "/src/main/resources/testOuptut/";

    public static final String CORA_TOKEN_BASE_URI = "https://test.salesforce.com";
    public static String SALESFORCE_BASE_URI = "https://sysco--staging.lightning.force.com";

    //CORA API connected app
    public static final String CLIENT_KEY_STAGING = System.getProperty("client.key", "");
    public static final String CLIENT_SECRET_STAGING = System.getProperty("client.secret", "");

    public static String shipToSSAID = System.getProperty("ship.to.ssaid", "");
    public static String billToSSAID = System.getProperty("bill.to.ssaid", "");

    public static final String CADD_BASE_URI = "https://api.sysco.com/token";
    public static final String CC360_BASE_URI = "https://api-qa.sysco.com/token";

    public static final String SFDC_USER_NAME = System.getProperty("sfdc.username", "subbiah.resitha@corp.sysco.com");
    public static final String SFDC_NETWORK_ID = System.getProperty("sfdc.network.id", "");
    public static final String SFDC_NETWORK_ID_PASSWORD = System.getProperty("sfdc.network.id.password", ""); //update password before running scripts

    //Token Refresh
    public static final boolean REFRESH_CADD = Boolean.parseBoolean(System.getProperty("refresh.cadd", "false"));
    public static final boolean REFRESH_CC360 = Boolean.parseBoolean(System.getProperty("refresh.cc360", "false"));
    public static final boolean REFRESH_CORAQA = Boolean.parseBoolean(System.getProperty("refresh.coraqa", "true"));
    public static final String RecipientMailIDs = System.getProperty("recipient.mail.id", "");
    public static final String SENDER_MAIL_ID = System.getProperty("sender.email.id", "");
    public static final String SENDER_MAIL_PASSWORD = System.getProperty("sender.email.password", "");

    public static final String SR_TO_VERIFY = "";


    //SUS Box Credentials
    public static final String SUS_USER_NAME = "C056IRDD";
    public static final String SUS_PASSWORD = "SYSCO123@";
    public static final String SUS_IP = "10.201.225.73";
    public static final String SUS_NAME = "as242k";

}
