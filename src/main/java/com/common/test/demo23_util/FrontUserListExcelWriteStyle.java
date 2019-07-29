/*
 * Copyright (c) 2017. juzhen.io. All rights reserved.
 */

package com.common.test.demo23_util;

import com.github.fartherp.framework.poi.excel.WriteDeal;
import com.github.fartherp.framework.poi.excel.write.AbstractExcelWrite;
import com.github.fartherp.framework.poi.excel.write.ExcelWrite;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.github.fartherp.framework.poi.excel.ExcelUtils.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2017/11/29
 */
public class FrontUserListExcelWriteStyle<T> extends AbstractExcelWrite<T> {
    private ExcelWrite excelWrite;

    /**
     * 头
     */
    private String head;

    /**
     * 条件
     */
    private String condition;

    /**
     * 总计
     */
    private String total;

    private CellStyle lightColorStrong;

    private CellStyle colorStrong;

    private CellStyle noColor;

    public FrontUserListExcelWriteStyle(ExcelWrite<T> excelWrite) {
        super(excelWrite.getTitle(), excelWrite.getFileName());
        this.excelWrite = excelWrite;
    }

    public ExcelWrite<T> deal(WriteDeal<T> deal) {
        excelWrite.deal(deal);
        return this;
    }

    public ExcelWrite<T> list(List<T> list) {
        // 当前总数
        excelWrite.setTotal(excelWrite.getTotal() + list.size());
        createSheet(list, true);
        for (T t : list) {
            createSheet(list, false);
            // 创建一行
            Row dataRow = excelWrite.getCurrentSheet().createRow(excelWrite.getCurrentRow());
            dataRow.setHeight(excelWrite.getDeal().setHeight());
            // 得到要插入的每一条记录
            String[] data = excelWrite.getDeal().dealBean(t);
            for (int k = 0; k < data.length; k++) {
                // 在一行内循环
                Cell cell = dataRow.createCell(k);
                cell.setCellValue(setRichTextString(excelWrite.getType(), data[k]));
                cell.setCellStyle(noColor);
            }
            excelWrite.setCurrentRow(excelWrite.getCurrentRow() + 1);
        }
        return this;
    }

    public void createSheet(List<T> list, boolean flag) {
        // excel处理的最大行数
        int maxRows = excelWrite.getDeal().setMaxRows();
        if ((flag && excelWrite.getTotal() == list.size()) || (excelWrite.getTotal() > maxRows && excelWrite.getCurrentRow() == maxRows)) {
            excelWrite.setTotal(excelWrite.getTotal() + 3);
            excelWrite.setCurrentRow(0);
            // 第一个sheet(数量相等), 第二个及以后(超过最大行)
            // sheet 对应一个工作页
            excelWrite.setCurrentSheet(excelWrite.getWb().createSheet("sheet" + excelWrite.getCurrentSheetNumber()));

            CellRangeAddress region0 = new CellRangeAddress(excelWrite.getCurrentRow(), excelWrite.getCurrentRow(), (short) 0, (short) excelWrite.getTitle().length - 1);
            excelWrite.getCurrentSheet().addMergedRegion(region0);

            Row row0 = excelWrite.getCurrentSheet().createRow(excelWrite.getCurrentRow());
            row0.setHeight(excelWrite.getDeal().setHeight());
            excelWrite.setCurrentRow(excelWrite.getCurrentRow() + 1);

            Cell cell0 = row0.createCell(0);
            cell0.setCellValue(setRichTextString(excelWrite.getType(), head));

            if (lightColorStrong == null) {
                lightColorStrong = setStyleLightColorStrong(excelWrite.getWb());
            }
            setRegionStyle(excelWrite.getCurrentSheet(), region0, lightColorStrong);

            CellRangeAddress region1 = new CellRangeAddress(excelWrite.getCurrentRow(), excelWrite.getCurrentRow(), (short) 0, (short) excelWrite.getTitle().length - 1);
            excelWrite.getCurrentSheet().addMergedRegion(region1);

            Row row1 = excelWrite.getCurrentSheet().createRow(excelWrite.getCurrentRow());
            row1.setHeight(excelWrite.getDeal().setHeight());
            excelWrite.setCurrentRow(excelWrite.getCurrentRow() + 1);

            Cell cell1 = row1.createCell(0);
            cell1.setCellValue(setRichTextString(excelWrite.getType(), condition));

            setRegionStyle(excelWrite.getCurrentSheet(), region1, lightColorStrong);

            /** total start */
            CellRangeAddress totalRegion = new CellRangeAddress(excelWrite.getCurrentRow(), excelWrite.getCurrentRow(), (short) 0, (short) this.title.length - 1);
            excelWrite.getCurrentSheet().addMergedRegion(totalRegion);

            Row totalRow = excelWrite.getCurrentSheet().createRow(excelWrite.getCurrentRow());
            totalRow.setHeight(excelWrite.getDeal().setHeight());
            excelWrite.setCurrentRow(excelWrite.getCurrentRow() + 1);

            Cell totalCell = totalRow.createCell(0);
            totalCell.setCellValue(setRichTextString(excelWrite.getType(), total));

            setRegionStyle(excelWrite.getCurrentSheet(), totalRegion, lightColorStrong);
            /** total end */

            Row titleRow = excelWrite.getCurrentSheet().createRow(excelWrite.getCurrentRow());
            titleRow.setHeight(excelWrite.getDeal().setHeight());
            excelWrite.setCurrentRow(excelWrite.getCurrentRow() + 1);

            if (colorStrong == null) {
                colorStrong = setStyleColorStrong(excelWrite.getWb());
            }
            int[] columnWidth = excelWrite.getDeal().setColumnWidth(excelWrite.getTitle());
            for (int i = 0; i < excelWrite.getTitle().length; i++) {
                Cell cell = titleRow.createCell(i);
                cell.setCellValue(setRichTextString(excelWrite.getType(), excelWrite.getTitle()[i]));
                cell.setCellStyle(colorStrong);
                excelWrite.getCurrentSheet().setColumnWidth(i, columnWidth[i]);
            }
            excelWrite.setCurrentSheetNumber(excelWrite.getCurrentSheetNumber() + 1);
            if (noColor == null) {
                noColor = setStyleNoColor(excelWrite.getWb());
            }
        }
    }

    public ExcelWrite<T> createOutputStream() {
        throw new IllegalArgumentException("no outputStream");
    }

    public void write() {
        // 创建文件输出流，准备输出电子表格
        try {
            excelWrite.getWb().write(excelWrite.getOutputStream());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (excelWrite.getOutputStream() != null) {
                try {
                    excelWrite.getOutputStream().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public FrontUserListExcelWriteStyle<T> head(String head) {
        this.head = head;
        return this;
    }

    public FrontUserListExcelWriteStyle<T> condition(String condition) {
        this.condition = condition;
        return this;
    }

    public FrontUserListExcelWriteStyle<T> total(String total) {
        this.total = total;
        return this;
    }
}
