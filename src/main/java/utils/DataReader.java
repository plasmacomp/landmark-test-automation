package utils;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataReader {


    public static String suiteName;
    private static List<Data> dataObjectRepo = new ArrayList<Data>();
    public static Map<String, String> pageObjRepoMap=new HashMap<String, String>();
    File baseDirectory = new File(".");

    public void setupDataSheet() throws IOException {

        String testDataPath = baseDirectory.getCanonicalPath() + File.separator + "testdata" + File.separator + "testdata_";

        String pageObjRepoPath=baseDirectory.getCanonicalPath() + File.separator + "ObjectRepository"+File.separator+"PageObjectRepository.xlsx";

        setDataObject(testDataPath+GlobalVars.prop.getProperty("environment")+ ".xlsx");

        initializePageObjRepo(pageObjRepoPath);

    }


    public static List<Data> getDataObjectRepo(){
        return dataObjectRepo;
    }
    /**
     * Presets all page objects at once from the excel sheet and loads it to memory for faster page object reference.
     * <br> This should be only be referenced in before scenario methods.
     *
     * @author A Rahman
     */
    private void initializePageObjRepo(String pageObjRepoPath) throws IOException {
        org.apache.poi.ss.usermodel.Sheet repoSheet=null;
        File file = new File(pageObjRepoPath);
        if (file.exists() && !file.isDirectory()) {
            FileInputStream inputStream = new FileInputStream(file);
            @SuppressWarnings("resource")
            Workbook workBook = new XSSFWorkbook(inputStream);

            //Initializing Object repository based on the platform

            if(GlobalVars.platform.equalsIgnoreCase("web"))
                repoSheet = workBook.getSheetAt(0);
            else
                repoSheet = workBook.getSheetAt(1);

            for (int row = 1; row <= repoSheet.getLastRowNum(); row++) {
                Row dataRow = repoSheet.getRow(row);
                try {
                    String elementName=dataRow.getCell(0).getStringCellValue().trim();
                    String value=dataRow.getCell(2).getStringCellValue().trim();
                    pageObjRepoMap.put(elementName, value);

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }

    }

    /**
     * Presets all test case data from the excel sheet.
     * <br> This should be only be referenced in before scenario methods.
     *
     * @author A Rahman
     */
    private void setDataObject(String dataObjectFilePath) throws IOException {
        //long startTime = System.currentTimeMillis();
        File file = new File(dataObjectFilePath);
        if (file.exists() && !file.isDirectory()) {
            FileInputStream inputStream = new FileInputStream(file);
            @SuppressWarnings("resource")
            Workbook workBook = new XSSFWorkbook(inputStream);
            int totalSheetCount = workBook.getNumberOfSheets();
            try{

                //Initializing GeneralConfig data into Global variables
                org.apache.poi.ss.usermodel.Sheet generalConfigSheet = workBook.getSheetAt(0);
                generalConfigSheet.getRow(1).getCell(1);
                GlobalVars.platform = getCellData(generalConfigSheet.getRow(1).getCell(1));
                GlobalVars.apkFileName = getCellData(generalConfigSheet.getRow(5).getCell(1));
                GlobalVars.deviceName = getCellData(generalConfigSheet.getRow(6).getCell(1));
                GlobalVars.platformVersion = getCellData(generalConfigSheet.getRow(7).getCell(1));
                GlobalVars.platform = getCellData(generalConfigSheet.getRow(8).getCell(1));
                GlobalVars.appiumServerIp = getCellData(generalConfigSheet.getRow(9).getCell(1));
                GlobalVars.appiumServerPort = getCellData(generalConfigSheet.getRow(10).getCell(1));


                //Initializing the test cases
                for (int sheetNumber = 1; sheetNumber < totalSheetCount; sheetNumber++) {
                    Sheet sheet = (Sheet) workBook.getSheetAt(sheetNumber);
                    Map<String, DataElements> dataElementsMap = getDataElements((org.apache.poi.ss.usermodel.Sheet) sheet);

                    dataObjectRepo.add(new Data(((XSSFSheet) sheet).getSheetName(), dataElementsMap));
                }


            }catch(Exception e){
                e.printStackTrace();
            }

        } else {
            //logger.error("Data object file not found at: " + file.getAbsolutePath());
            throw new SkipException("Data object file not found at: " + file.getAbsolutePath());
        }
    }



    /**
     * @param cell
     * @return
     * @description: This function takes a cell as an argument and returns the cell value based on the type of cell value type
     */
    @SuppressWarnings("deprecation")
    public String getCellData(Cell cell){
        String cellData="";
        try{

            switch(cell.getCellType()){

                case Cell.CELL_TYPE_STRING:
                    cellData=cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    cellData=(int)cell.getNumericCellValue()+"";
                    break;
                case Cell.CELL_TYPE_BLANK:
                    cellData="";
                    break;
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return cellData.trim();

    }

    /**
     * support method for getPageObjects
     * <br>Fetches all page elements in a page
     *
     * @param sheet takes the Sheet object returned from the workbook
     * @return return the map of page elements with element name and object of pageElement for the same.
     *
     */
    private Map<String, DataElements> getDataElements(org.apache.poi.ss.usermodel.Sheet sheet) {
        Map<String, DataElements> dataElementsMap = new HashMap<String, DataElements>();
        String testCaseName="";
        String runStatus="";
        String params="";
        //Ignoring title row [0] starting from row [1]
        for (int row = 1; row <= sheet.getLastRowNum(); row++) {
            Row dataRow = sheet.getRow(row);
            //int titleValueIndex = 0;

            try{

                testCaseName=getCellData(dataRow.getCell(0));
                runStatus=getCellData(dataRow.getCell(1));
                params=getCellData(dataRow.getCell(2));

            }catch(Exception e){
                e.printStackTrace();

            }

            dataElementsMap.put(testCaseName, new DataElements(testCaseName, runStatus,	params));
        }
        return dataElementsMap;
    }

    /**
     * Fetches page locators from in-memory pageObjectRepo
     * Improved for performance considerations.
     *
     * @param testSuiteName name of the page where the element will be queried
     * @return org.openqa.selenium.By pageElement
     *
     */
    protected Map<String, DataElements> getClassData(String testSuiteName) {
        //logger.debug("Finding" + testSuiteName + "in data sheet");
        Map<String, DataElements> dataElementMap = new HashMap<String, DataElements>();
        for (Data data : dataObjectRepo) {
            if (data.getSuiteName().equalsIgnoreCase(testSuiteName)) {
                dataElementMap = data.getElementList();
            }
        }
        return dataElementMap;
    }

    public void setSuiteName(String suite_name) {
        suiteName = suite_name;
    }
}
