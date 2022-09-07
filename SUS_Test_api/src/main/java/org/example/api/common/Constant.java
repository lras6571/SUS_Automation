package org.example.api.common;

public class Constant {


    public static final String TEST_ENV = System.getProperty("tests.env", "QA");
    public static final String TEST_RELEASE = System.getProperty("tests.release", "<your project>");
    public static final String TEST_PROJECT = System.getProperty("tests.project", "<your release>");
    public static final boolean UPDATE_DASHBOARD = Boolean.parseBoolean(System.getProperty("update.dashboard", "true"));

    Constant() {

    }


}
