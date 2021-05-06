package com.common.test.demo43_excelTest;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Aug
 * @Date: 2021-05-06 13:34
 * @Desc:
 */
public class RateReportUtil {

    public static ExcelWriter getWriter(OutputStream out, List<RateReportResponse> rows) {
        ExcelWriter writer = ExcelUtil.getWriter("/Users/jinx/Desktop/test.xlsx");
        writer.addHeaderAlias("id", "No");
        writer.addHeaderAlias("customerName", "Customer Name");
        writer.addHeaderAlias("currency", "Currency");
        writer.addHeaderAlias("date", "Period Folder");
        writer.addHeaderAlias("price", "Unrealized gain and loss");
        // 合并单元格后的标题行，使用默认标题样式
//        writer.merge(rows.size()-1, "一班成绩单");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
        //out为OutputStream，需要写出到的目标流
//        writer.flush(out);
        // 关闭writer，释放内存
        writer.close();
        return writer;
    }

    public static void main(String[] args) {
        List<RateReportResponse> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            RateReportResponse response = new RateReportResponse();
            response.setCurrency("BTC");
            response.setCustomerName("i" + i);
            response.setDate("5-5");
            response.setPrice(new BigDecimal(i));
            response.setId((long) i);

            list.add(response);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        RateReportUtil.getWriter(bos, list);
    }

}
