package study.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
public class ExcelReader {
    /**
     * 获取整个sheet的值
     * @param path
     * @param sheetName
     * @return
     */
    public static String[][] getExpectationData(String path, String sheetName) {
        try {
            File file = new File(java.lang.String.valueOf(path));
            FileInputStream fis = new FileInputStream(file);
            HSSFWorkbook workBook = new HSSFWorkbook(fis);
            //获取工作表
            HSSFSheet sheet1 = workBook.getSheet(String.valueOf(sheetName));
            //获取总行数
            int rowNum = sheet1.getLastRowNum();
            //获取总列数
            int colNum = sheet1.getRow(0).getLastCellNum();
            System.out.println("总行数：" + rowNum);
            System.out.println("总列数：" + colNum);
            ArrayList<String[]> results = new ArrayList<>();
            for (int i = 1; i <= rowNum; i++) {
                //获取当前行
                HSSFRow row = sheet1.getRow(i);
                int colNum1 = row.getLastCellNum();
                String[] data = new String[colNum1];
                //获取当前行的所有列
                for (int j = 0; j < colNum1; j++) {
                    try {
                        data[j] = getCellValue(row.getCell(j));
                        System.out.println("第" + i + "行的列：" + data[j]);
                    } catch (NullPointerException e) {
                        data[j] = "";
                    }
                }
                System.out.println("data:" + Arrays.toString(data));
                //每行的数据存入集合
                results.add(data);
            }
            //打印集合
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i< results.size(); i++){
                sb.append(Arrays.toString(results.get(i)));
            }
            System.out.println("results: "+ sb.toString());
            //关闭输入流
            fis.close();

            String[][] returnArray = new String[results.size()][colNum];
            System.out.println("results.size():" + results.size());
            System.out.println("colNum:" + colNum);
            System.out.println("returnArray.length:" + returnArray.length);

            for (int i = 0; i < returnArray.length; i++){
                returnArray[i] = (String[])results.get(i);
            }
            return returnArray;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 对Excel的各个单元格的格式进行判断并转换
     * @return
     */
    public static String getCellValue(HSSFCell cell) throws NullPointerException{

        String cellValue = null;
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                cellValue = cell.getRichStringCellValue().getString().trim();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue()).trim();
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                cellValue = cell.getCellFormula();
                break;
            default:
                cellValue = "";
        }
        return cellValue;
    }

    /**
     * 获取EXCEL指定行列数据
     * @param path
     * @param sheetName
     * @param row1
     * @param col
     * @throws IOException
     */
    public static String Readrowandcol(String path, String sheetName, int row1, int col) throws IOException {
        File file = new File(java.lang.String.valueOf(path));
        FileInputStream fis = new FileInputStream(file);
        HSSFWorkbook workBook = new HSSFWorkbook(fis);
        //获取工作表
        HSSFSheet sheet1 = workBook.getSheet(String.valueOf(sheetName));
        //获取总行数
        HSSFRow row = sheet1.getRow(row1-1);
        String cellValue = getCellValue(row.getCell(col-1));
        System.out.println(cellValue);
        return cellValue;
    }
}
