package org.example.sus.utils;

import com.syscolab.qe.core.excelUtils.ReadExcel;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.example.sus.common.Constants;
import org.example.sus.data.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Lasan Rashmika on 08/09/2022.
 */
public class ExcelUtil {
    private ExcelUtil(){}

    static Logger logger = Logger.getLogger(ExcelUtil.class.getName());
    public static final String HOME_DIRECTORY = "user.dir";
    
    public static LoginData getLoginData(String key) {
        Object loginObject = ReadExcel.getDataFromExcelSheet(key, System.getProperty(HOME_DIRECTORY)+ Constants.TEST_DATA_PATH +"TestData.xls", 0, LoginData.class);
        return (LoginData) loginObject;
    }

    public static FTRData getProspectData(String fileName, String key) {
        Object ftrObject = ReadExcel.getDataFromExcelSheet(key, System.getProperty(HOME_DIRECTORY)+Constants.TEST_DATA_PATH +fileName, 0, FTRData.class);
        return (FTRData) ftrObject;
    }

    public static int getNumberOfRecords(String fileName){
        Sheet sheet = ReadExcel.readExcelSheet(System.getProperty(HOME_DIRECTORY)+Constants.TEST_DATA_PATH +fileName, 0);
        int rowCount = sheet.getRows()-1;
        return rowCount;
    }

    public static TestMailData getTestMailData(String key) {
        Object testMailObject = ReadExcel.getDataFromExcelSheet(key, System.getProperty(HOME_DIRECTORY)+Constants.TEST_DATA_PATH +"TestData.xls", 1, TestMailData.class);
        return (TestMailData) testMailObject;
    }

    public static void writeDataToExcel(String fileName, String key, String field, String value) throws Exception{
    Workbook workbook1 = Workbook.getWorkbook(new File(System.getProperty(HOME_DIRECTORY) + Constants.TEST_DATA_PATH +fileName));
    Sheet sheet = ReadExcel.readExcelSheet(System.getProperty(HOME_DIRECTORY) + Constants.TEST_DATA_PATH +fileName, 0);
    WritableWorkbook copy = Workbook.createWorkbook(new File(System.getProperty(HOME_DIRECTORY) + Constants.TEST_DATA_PATH +fileName), workbook1);
    WritableSheet sheet2 = copy.getSheet(0);
    int dataRow = -1;
    int dataColumn = -1;
    int rowCount = sheet.getRows();
    int colCount = sheet.getColumns();
    for(int i = 0; i < rowCount; ++i) {
        for(int j = 0; j < colCount; ++j) {
            String cellData  = sheet.getCell(j, i).getContents();
            if (i == 0 && cellData.equals(field)){
                dataColumn = j;
            } else {
                if (cellData.equals(key)) {
                    dataRow = i;
                    break;
                }
            }
        }
    }
    WritableCell cell = sheet2.getWritableCell(dataColumn, dataRow);
    Label label = new Label(dataColumn, dataRow, value);
    sheet2.addCell(label);
    if (cell.getType() .equals(CellType.LABEL))
    {
        Label l = (Label) cell;
        l.setString(value);
    }
    copy.write();
    copy.close();
}

    public static VertexTaxData getOpCoDataForVertexTaxVerification(String fileName, String key) {
        Object vertexTaxObject = ReadExcel.getDataFromExcelSheet(key, System.getProperty(HOME_DIRECTORY)+Constants.TEST_DATA_PATH +fileName, 0, VertexTaxData.class);
        VertexTaxData vertexTaxData = (VertexTaxData) vertexTaxObject;
        return vertexTaxData;
    }

    public static List<String> getCORAOpCoData(String fileName){
        Sheet sheet = ReadExcel.readExcelSheet(System.getProperty(HOME_DIRECTORY)+Constants.TEST_DATA_PATH +fileName, 0);
        List<String> opcoList = new ArrayList<>();
        for (int i=1; i<sheet.getRows(); i++){
            opcoList.add(sheet.getCell(0, i).getContents());
        }
        return opcoList;
    }

    public static void updateCORACreditApplicationDetails(String fileName, String opCo, String strField, String strValue){
        try {
            Workbook workbook1 = Workbook.getWorkbook(new File(System.getProperty(HOME_DIRECTORY) + Constants.TEST_DATA_PATH +fileName));
            Sheet sheet = ReadExcel.readExcelSheet(System.getProperty(HOME_DIRECTORY) + Constants.TEST_DATA_PATH +fileName, 0);
            int rowCount = sheet.getRows();
            int columnCount = sheet.getColumns();

            for (int column=0; column<columnCount; column++){
                String columnName = sheet.getCell(column,0).getContents();
                if (columnName.equals(strField)){
                    for (int row=1; row<rowCount; row++){
                        if (sheet.getCell(0,row).getContents().equals(opCo)){

                            WritableWorkbook copy = Workbook.createWorkbook(new File(System.getProperty(HOME_DIRECTORY) + Constants.TEST_DATA_PATH + fileName), workbook1);
                            WritableSheet copySheet = copy.getSheet(0);
                            WritableCell cell = copySheet.getWritableCell(column, row);
                            Label label = new Label(column, row, strValue);
                            copySheet.addCell(label);
                            if (cell.getType().equals(CellType.LABEL)) {
                                Label l = (Label) cell;
                                l.setString(strValue);
                            }
                            copy.write();
                            copy.close();

                            break;
                        }
                    }
                }
            }
        }
        catch (WriteException | IOException | BiffException e){
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

//    public static void generatePersonaEnablementOutputExcel(String fileName, PersonaEnablementData personaEnablementData){
//        try {
//            String filePath = System.getProperty(HOME_DIRECTORY) + Constants.TEST_OUTPUT_PATH+fileName+".xls";
//            String dirPath = System.getProperty(HOME_DIRECTORY)+Constants.TEST_OUTPUT_PATH;
//            WritableWorkbook workbook ;
//            WritableSheet sheet ;
//            File directory = new File(dirPath);
//            File file = new File(filePath);
//            if (!directory.exists()) {
//                if (directory.mkdir()) {
//                    logger.info("Directory is created!");
//                } else {
//                    logger.info("Failed to create directory!");
//                }
//            }
//
//            if(!file.exists()){
//                workbook = Workbook.createWorkbook(file);
//                sheet = workbook.createSheet("PersonaEnablement", 0);
//                int headerRow = 0;
//                Label label = new Label(0, headerRow, "No");
//                sheet.addCell(label);
//                label = new Label(1, headerRow, "User Role");
//                sheet.addCell(label);
//                label = new Label(2, headerRow, "User Name");
//                sheet.addCell(label);
//                label = new Label(3, headerRow, "Account Name");
//                sheet.addCell(label);
//                label = new Label(4, headerRow, "Account Status");
//                sheet.addCell(label);
//                label = new Label(5, headerRow, "Support Request");
//                sheet.addCell(label);
//            }
//            else {
//                //Get a working copy
//                workbook = Workbook.createWorkbook(file);
//                sheet = workbook.getSheet(0);
//            }
//            int rowCount = sheet.getRows();
//
//            //Since the row index starts from 0, the next editable row available for the user would have the index same as the row count
//            int rowToBeUpdated = rowCount;
//
//            Label label = new Label(0, rowToBeUpdated, String.valueOf(rowToBeUpdated));
//            sheet.addCell(label);
//            label = new Label(1, rowToBeUpdated, personaEnablementData.getUserRole());
//            sheet.addCell(label);
//            label = new Label(2, rowToBeUpdated, personaEnablementData.getUserName());
//            sheet.addCell(label);
//            label = new Label(3, rowToBeUpdated, personaEnablementData.getAccountName());
//            sheet.addCell(label);
//            label = new Label(4, rowToBeUpdated, personaEnablementData.getAccountStatus());
//            sheet.addCell(label);
//            label = new Label(5, rowToBeUpdated, personaEnablementData.getSupportRequest());
//            sheet.addCell(label);
//
//            workbook.write();
//            workbook.close();
//            logger.info("Your excel file has been generated!");
//
//        } catch ( Exception e) {
//            logger.info(e.getMessage());
//        }
//    }

    public static List<String> getUSStatesList(){
        String splitBy = ",";
        List<String> statesList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File
                (System.getProperty(HOME_DIRECTORY) + Constants.TEST_DATA_PATH +"US_State_Codes.csv"))){
            scanner.useDelimiter(splitBy);
            while (scanner.hasNext()) {
                statesList.add(scanner.next());
            }
        }
        catch (IOException e) {
            logger.info(e.getMessage());
        }
        return statesList;
    }

    public static CORARequestData getCORARequestData(String key) {
        Object coraRequestObject = ReadExcel.getDataFromExcelSheet(key, System.getProperty(HOME_DIRECTORY)+Constants.TEST_DATA_PATH +"CORARequestData.xls", 0, CORARequestData.class);
        return (CORARequestData) coraRequestObject;
    }

    public static void createTokenRefreshStatusFile(String strMessage) throws FileNotFoundException{
        String fileName = "TokenRefreshResult.txt";
        String pathName = System.getProperty("user.dir") + Constants.TEST_OUTPUT_PATH;
        File folder = new File(pathName);
        if (!folder.exists()){
            folder.mkdir();
        }
        String filepath = pathName + fileName;
        File f = new File(filepath);
        if (f.exists()) {
            f.delete();
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filepath);
            writer.write(strMessage);
        }
        finally {
            writer.close();
        }
    }
    
}
