package org.example.sus.data;

/**
 * Created by Resitha Subbiah on 08/15/2019.
 */

public enum SUSScreenData {

    SYSTEMS_UTILITIES_ARCHIVES_OFFICE_EXIT_HELP(" Systems Utilities Archives Office eXit Help"),
    REFERENCE_FILE_MAINTENANCE("REFERENCE FILE MAINTENANCE"),
    WORK_WITH_SUBMITTED_JOBS("Work with Submitted Jobs"),
    DISPLAY_DATA("Display data"),
    ENTER_SQL_STATEMENTS("Enter SQL Statements"),
    TRUE_VENDOR_LIST("True Vendor List"),
    HOME_PAGE("Systems Utilities Archives Office eXit Help"),
    WD("Data Routing"),
    MORE_DATA("More..."),
    BOTTOM("Bottom"),
    TOP(" Already at top of area."),
    STI("Customer Ship-to Inquiry"),
    STI_PROMPT("Ship-to Inquiry Prompt"),
    STI_INVOICING("Invoicing"),
    ;

    private String value;

    private SUSScreenData(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
