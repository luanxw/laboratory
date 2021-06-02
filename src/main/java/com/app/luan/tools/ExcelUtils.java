package com.app.luan.tools;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;


/**
 * @Author allen
 * @Date  2021/5/28
 */
public class ExcelUtils {
    private static Logger logger = Logger.getLogger(ExcelUtils.class.getName());

    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";

    /**
     * 获取第一列列所有数据
     * @param file
     * @return
     */
    public static List<String> getFirstColumn(MultipartFile file) {
        try {
            //直接使用file.getInputStream()进行文件类型判断和读取，会报不支持输入流的错误，版本兼容问题，使用BufferedInputStream中转一下即可
            BufferedInputStream inputStream = new BufferedInputStream(file.getInputStream());
            Workbook workbook = getWorkbookByMagic(inputStream, FileMagic.valueOf(inputStream));
            // 读取excel中的数据
            return parseExcel(workbook);
        } catch (IOException e) {
            logger.warning("解析Excel失败，文件名： 错误信息：" + e.getMessage());
            throw new RuntimeException("解析Excel失败，文件名： 错误信息：" + e.getMessage());
        }
    }


    /**
     * 读取Excel文件内容,默认读取第一个sheet的第一行数据
     * @param inputStream 要读取的Excel文件流
     * @return 读取结果列表，读取失败时返回null
     */
    public static List<String> readExcel(InputStream inputStream, String fileType) {

        Workbook workbook = null;
        try {
            workbook = getWorkbook(inputStream, fileType);
            // 读取excel中的数据
            return parseExcel(workbook);
        } catch (Exception e) {
            logger.warning("解析Excel失败，文件名： 错误信息：" + e.getMessage());
            throw new RuntimeException("解析Excel失败，文件名： 错误信息：" + e.getMessage());
        } finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (Exception e) {
                logger.warning("关闭数据流出错！错误信息：" + e.getMessage());
                return null;
            }
        }
    }

    /**
     * 根据文件后缀名类型获取对应的工作簿对象
     * @param inputStream 读取文件的输入流
     * @param fileType 文件后缀名类型（xls或xlsx）
     * @return 包含文件数据的工作簿对象
     * @throws IOException
     */
    public static Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
        Workbook workbook = null;
        if (fileType.equalsIgnoreCase(XLS)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSX)) {
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }

    /**
     * 根据文件后缀名类型获取对应的工作簿对象
     * @param inputStream 读取文件的输入流
     * @throws IOException
     */
    public static Workbook getWorkbookByMagic(InputStream inputStream, FileMagic magic) throws IOException {
        if (Objects.equals(magic, FileMagic.OOXML)){
           return new XSSFWorkbook(inputStream);
        }else if (Objects.equals(magic, FileMagic.OLE2)){
            return new HSSFWorkbook(inputStream);
        }else {
            //不是xls或xlsx文件类型
            throw new RuntimeException("不是excel文件。");
        }
    }


    /**
     * 解析Excel数据
     * @param workbook Excel工作簿对象
     * @return 解析结果
     */
    private static List<String> parseExcel(Workbook workbook) {
        List<String> resultDataList = new ArrayList<>();
           // 目前只解析第一个sheet的数据
            Sheet sheet = workbook.getSheetAt(0);
            // 校验sheet是否合法
            if (sheet == null) {
                logger.warning("sheet中不存在数据！！！");
                throw new RuntimeException("sheet中不存在数据！！！");
            }

            // 获取第一行数据
            int firstRowNum = sheet.getFirstRowNum();
            Row firstRow = sheet.getRow(firstRowNum);
            if (null == firstRow) {
                logger.warning("解析Excel失败，在第一行没有读取到任何数据！");
                throw new RuntimeException("Excel第一行没有读取到任何数据！");
            }
            // 解析每一行的数据，构造数据对象
            int rowStart = firstRowNum;
            int rowEnd = sheet.getPhysicalNumberOfRows();
            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row row = sheet.getRow(rowNum);
                if (null == row) {
                    continue;
                }
                //只读取第一列的数据
                String resultData = convertCellValueToString(row.getCell(0));
                if (null == resultData) {
                    logger.warning("第 " + row.getRowNum() + "行数据不合法，已忽略！");
                    continue;
                }
                resultDataList.add(resultData);
            }
        return resultDataList;
    }

    /**
     * 将单元格内容转换为字符串
     * @param cell
     * @return
     */
    private static String convertCellValueToString(Cell cell) {
        if(cell==null){
            return null;
        }
        String returnValue = null;
        switch (cell.getCellTypeEnum()) {
            case NUMERIC:   //数字
                Double doubleValue = cell.getNumericCellValue();
                // 格式化科学计数法，取一位整数
                DecimalFormat df = new DecimalFormat("0");
                returnValue = df.format(doubleValue);
                break;
            case STRING:    //字符串
                returnValue = cell.getStringCellValue();
                break;
            case BOOLEAN:   //布尔
                Boolean booleanValue = cell.getBooleanCellValue();
                returnValue = booleanValue.toString();
                break;
            case BLANK:     // 空值
                break;
            case FORMULA:   // 公式
                returnValue = cell.getCellFormula();
                break;
            case ERROR:     // 故障
                break;
            default:
                break;
        }
        return returnValue;
    }

}
