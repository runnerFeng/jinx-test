package com.common.test.demo24_excelUtil;


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author jinx
 * @date 2018/3/1 12:58
 * Desc:
 */
public class ExcelUtils2 {

    private static void setCellValue(Cell cell, Object obj) {
        if (obj == null) {
        } else if (obj instanceof String) {
            cell.setCellValue((String) obj);
        } else if (obj instanceof Date) {
            Date date = (Date) obj;
            if (date != null) {
                cell.setCellValue(DateUtils.dfDateTime.format(date));
            }
        } else if (obj instanceof Calendar) {
            Calendar calendar = (Calendar) obj;
            if (calendar != null) {
                cell.setCellValue(DateUtils.dfDateTime.format(calendar.getTime()));
            }
        } else if (obj instanceof Timestamp) {
            Timestamp timestamp = (Timestamp) obj;
            if (timestamp != null) {
                cell.setCellValue(DateUtils.dfDateTime.format(new Date(timestamp.getTime())));
            }
        } else if (obj instanceof Double) {
            cell.setCellValue((Double) obj);
        } else {
            cell.setCellValue(obj.toString());
        }
    }

    public static void ExportWithResponse(String sheetName, String titleName, String fileName, String queryTitle,
                                   int[] columnWidth, Map<String, String> headMap, List<MpcApp> mpcAppList,
                                   HttpServletResponse response) throws Exception {
        List<Map<String, Object>> dataList = assembleData(mpcAppList);

        HSSFWorkbook wb = exportNoResponse(sheetName, titleName, queryTitle, columnWidth, headMap, dataList);

        // 第六步，将文件存到浏览器设置的下载位置
        String filename = fileName + ".xls";
        response.setContentType("application/ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                .concat(String.valueOf(URLEncoder.encode(filename, "UTF-8"))));
        OutputStream out = response.getOutputStream();
        try {
            // 将数据写出去
            wb.write(out);
            String str = "导出" + fileName + "成功！";
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
            String str1 = "导出" + fileName + "失败！";
            System.out.println(str1);
        } finally {
            out.close();
        }
    }

    public static void ExportNoResponse(String sheetName, String titleName, String fileName, String queryTitle, int[] columnWidth,
                                 Map<String, String> headMap, List<MpcApp> mpcAppList) {

        List<Map<String, Object>> dataList = assembleData(mpcAppList);

        HSSFWorkbook wb = exportNoResponse(sheetName, titleName, queryTitle, columnWidth, headMap, dataList);

        try {
            FileOutputStream fout = new FileOutputStream("D:\\hh.xls");
            wb.write(fout);
            String str = "导出" + fileName + "成功！";
            System.out.println(str);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
            String str1 = "导出" + fileName + "失败！";
            System.out.println(str1);
        }
    }

    private static List<Map<String, Object>> assembleData(List<MpcApp> mpcAppList) {
        List<Map<String, Object>> dataList = new ArrayList<>();
        try {
            for (MpcApp t : mpcAppList) {
                Map<String, Object> map = new HashMap<String, Object>();
                Field[] fields = t.getClass().getDeclaredFields();
                if (fields != null) {
                    for (Field field : fields) {
                        field.setAccessible(true);
                        map.put(field.getName(), field.get(t));
                    }
                }
                dataList.add(map);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    private static HSSFWorkbook exportNoResponse(String sheetName, String titleName, String queryTitle, int[] columnWidth, Map<String, String> headMap, List<Map<String, Object>> dataList) {
        Set<String> keys = headMap.keySet();
        //1.创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();

        // 2.在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);
        for (int i = 0; i < keys.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    // 单独设置每列的宽
                    sheet.setColumnWidth(i, columnWidth[j] * 256);
                }
            }
        }

        // 3.创建第0行 也就是标题
        HSSFRow row0 = sheet.createRow(0);
        // 设置标题的高度
        row0.setHeightInPoints(25);
        // 创建单元格样式style0以及字体样式headerFont0
        HSSFCellStyle style0 = setCellStyleAndFont(wb, 0);
        // 创建标题第一列
        HSSFCell cell0 = row0.createCell(0);
        // 合并列标题
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, keys.size() - 1));
        // 设置值标题
        cell0.setCellValue(titleName);
        // 设置标题样式
        cell0.setCellStyle(style0);

        HSSFRow row1 = sheet.createRow(1);
        row1.setHeightInPoints(25);
        HSSFCellStyle style1 = setCellStyleAndFont(wb, 1);
        HSSFCell cell1 = row1.createCell(0);
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, keys.size() - 1));
        cell1.setCellValue(queryTitle);
        cell1.setCellStyle(style1);

        // 5.创建第2行
        HSSFRow row2 = sheet.createRow(2);
        row2.setHeightInPoints(15);
        HSSFCellStyle style2 = setCellStyleAndFont(wb, 2);

        // 创建cell
        int i = 0, j = 0;
        //表头
        for (String key : keys) {
            Cell cell = row2.createCell(j++);
            cell.setCellValue(headMap.get(key));
            cell.setCellStyle(style2);
        }

        //6 填充数据
        if (dataList != null && !dataList.isEmpty()) {
            for (Map<String, Object> map : dataList) {
                row2 = sheet.createRow((i++) + 3);

                // 为数据内容设置特点新单元格样式2 自动换行 上下居中左右也居中
                HSSFCellStyle style = wb.createCellStyle();
                style = setCellStyle(style);
                j = 0;
                for (String key : keys) {
                    Cell cell = row2.createCell(j++);
                    setCellValue(cell, map.get(key));
                    cell.setCellStyle(style);
                }
            }
        }
        return wb;
    }

    private static HSSFCellStyle setCellStyleAndFont(HSSFWorkbook wb, int rowNumber) {
        HSSFCellStyle style = wb.createCellStyle();
        //是否缩进
        if (0 == rowNumber) {
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        } else if (1 == rowNumber) {
            style.setIndention((short) 10);
        } else if (2 == rowNumber) {
            style.setWrapText(true);
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        }

        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(HSSFColor.TAN.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //边框显示黑色
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);

        // 创建字体样式
        HSSFFont headerFont0 = wb.createFont();
        // 字体加粗
        headerFont0.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 设置字体类型
        headerFont0.setFontName("微软雅黑");
        // 设置字体大小
        headerFont0.setFontHeightInPoints((short) 11);
        // 为标题样式设置字体样式
        style.setFont(headerFont0);
        return style;
    }

    private static HSSFCellStyle setCellStyle(HSSFCellStyle style) {
        style.setWrapText(true);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        // 设置边框
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        return style;
    }

}


