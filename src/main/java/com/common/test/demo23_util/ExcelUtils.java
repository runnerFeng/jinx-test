package com.common.test.demo23_util;

import com.alibaba.fastjson.JSONObject;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Desription: 数据对象写入、读取表格
 * @Author: rui
 * @Create: 2017-11-20.15:41
 */
public class ExcelUtils {

    public static String readExcel(File file) {
        StringBuffer sb = new StringBuffer();
        Workbook wb = null;
        try {
            // 构造Workbook（工作薄）对象
            wb = Workbook.getWorkbook(file);
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (wb == null)
            return null;

        // 获得了Workbook对象之后，就可以通过它得到Sheet（工作表）对象了
        Sheet[] sheet = wb.getSheets();

        if (sheet != null && sheet.length > 0) {
            // 对每个工作表进行循环
            for (int i = 0; i < sheet.length; i++) {
                // 得到当前工作表的行数
                int rowNum = sheet[i].getRows();
                for (int j = 0; j < rowNum; j++) {
                    // 得到当前行的所有单元格
                    Cell[] cells = sheet[i].getRow(j);
                    if (cells != null && cells.length > 0) {
                        // 对每个单元格进行循环
                        for (int k = 0; k < cells.length; k++) {
                            // 读取当前单元格的值
                            String cellValue = cells[k].getContents();
                            sb.append(cellValue + "\t");
                        }
                    }
                    sb.append("\r\n");
                }
                sb.append("\r\n");
            }
        }
        // 最后关闭资源，释放内存
        wb.close();
        return sb.toString();
    }


    /**
     * 写入excel 表中
     * @param fileName 名称
     * @param list 对象
     */
    public static void writeExcel(String fileName,List<Object[]> list) {
        WritableWorkbook wwb = null;
        try {
            // 首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
            wwb = Workbook.createWorkbook(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (wwb != null) {
            // 创建一个可写入的工作表
            // Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
            WritableSheet ws = wwb.createSheet("sheet1", 0);

            // 下面开始添加单元格
            for (int i = 0; i < list.size(); i++) {
                Object[] obj=list.get(i);
                for (int j = 0; j <obj.length; j++) {
                    // 这里需要注意的是，在Excel中，第一个参数表示列，第二个表示行
                    Label labelC = new Label(j, i, obj[j].toString());
                    try {
                        // 将生成的单元格添加到工作表中
                        ws.addCell(labelC);
                    } catch (RowsExceededException e) {
                        e.printStackTrace();
                    } catch (WriteException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                // 从内存中写入文件中
                wwb.write();
                // 关闭资源，释放内存
                wwb.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1","hk");
        jsonObject.put("2","cn");
        List<JSONObject> list = new ArrayList<>();
        list.add(jsonObject);
        /*final JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        File file = null;
        FileInputStream fis = null;
        try {
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
            }
            fis = new FileInputStream(file.getPath());
        }catch (IOException e){
            e.printStackTrace();
        }*/
        //ExcelUtils.writeExcel(file.getName(), list);
    }
}
