package com.common.test.demo5_jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

/**
 * Desc:
 * Created by jinx on 2017/7/12.
 */
public class JacksonTest {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws IOException {
//        String jsonStr = "{\"message\":\"成功\",\"ret\":0,\"tdyOpenPrice\":\"20\",\"transDate\":\"20170122\",\"ydyClsPrice\":\"20\"}";
//        String result = (String) ((Map) JSON.parse(jsonStr)).get("ydyClsPrice");
//        if (result.equals("20")) {
//            ((Map) JSON.parse(jsonStr)).put("ydyClsPrice", 30);
//        }
//        System.out.println(result);
//        String jsonStr1  = "{\"data\":{\"accountType\":\"01\",\"captlPrpty\":\"1\",\"certNo\":\"330106000109207\",\"certType\":\"1\",\"items\":[{\"bonus\":\"1000\",\"industy\":\"证券\",\"managedUnit\":\"723200\",\"managedUnitName\":\"申万宏源托管一单元\",\"settlement\":\"1000\",\"stockAviNum\":\"1000\",\"stockCode\":\"430719\",\"stockInterest\":\"1000\",\"stockLeaveNum\":\"1000\",\"stockName\":\"九鼎集团\",\"stockNature\":\"00\",\"stockNum\":\"1000\",\"stockShortName\":\"九鼎集团\",\"stockType\":\"0\"},{\"bonus\":\"1000\",\"industy\":\"证券\",\"managedUnit\":\"723200\",\"managedUnitName\":\"申万宏源托管一单元\",\"settlement\":\"1000\",\"stockAviNum\":\"1000\",\"stockCode\":\"430719\",\"stockInterest\":\"1000\",\"stockLeaveNum\":\"1000\",\"stockName\":\"九鼎集团\",\"stockNature\":\"01\",\"stockNum\":\"1000\",\"stockShortName\":\"九鼎集团\",\"stockType\":\"1\"}],\"jjcp\":\"1\",\"pubPrpty\":\"1\",\"shrType\":\"0\",\"stateOwnPrpty\":\"1\",\"total\":\"2\",\"zczh\":\"1\"},\"message\":\"成功\",\"ret\":0}";
//        String jsonStr2 = "{\"accountType\":\"01\",\"captlPrpty\":\"1\",\"certNo\":\"330106000109207\",\"certType\":\"1\",\"items\":[{\"bonus\":\"1000\",\"industy\":\"证券\",\"managedUnit\":\"723200\",\"managedUnitName\":\"申万宏源托管一单元\",\"settlement\":\"1000\",\"stockAviNum\":\"1000\",\"stockCode\":\"430719\",\"stockInterest\":\"1000\",\"stockLeaveNum\":\"1000\",\"stockName\":\"九鼎集团\",\"stockNature\":\"00\",\"stockNum\":\"1000\",\"stockShortName\":\"九鼎集团\",\"stockType\":\"0\"},{\"bonus\":\"1000\",\"industy\":\"证券\",\"managedUnit\":\"723200\",\"managedUnitName\":\"申万宏源托管一单元\",\"settlement\":\"1000\",\"stockAviNum\":\"1000\",\"stockCode\":\"430719\",\"stockInterest\":\"1000\",\"stockLeaveNum\":\"1000\",\"stockName\":\"九鼎集团\",\"stockNature\":\"01\",\"stockNum\":\"1000\",\"stockShortName\":\"九鼎集团\",\"stockType\":\"1\"}],\"jjcp\":\"1\",\"pubPrpty\":\"1\",\"shrType\":\"0\",\"stateOwnPrpty\":\"1\",\"total\":\"2\",\"zczh\":\"1\"}";
//
//        List<Data> object = (List<Data>) Jackson.getObjectByJson(jsonStr1,"data", Jackson.TypeEnum.map);
//        System.out.println(object);
//        System.out.println(OBJECT_MAPPER.writeValueAsString(object));
//        Object data = OBJECT_MAPPER.readValue(OBJECT_MAPPER.writeValueAsString(object), Data.class);
//
//        System.out.println(data);

        String jsonStr3 = "[{\"bonus\":\"1000\",\"industy\":\"证券1\",\"managedUnit\":\"1\",\"managedUnitName\":\"申万宏源托管一单元\",\"settlement\":\"1000\",\"stockAviNum\":\"1000\",\"stockCode\":\"1\",\"stockInterest\":\"1000\",\"stockLeaveNum\":\"1000\",\"stockName\":\"九鼎集团\",\"stockNature\":\"1\",\"stockNum\":\"1000\",\"stockShortName\":\"九鼎集团\",\"stockType\":\"0\"}," +
                "{\"bonus\":\"1000\",\"industy\":\"证券2\",\"managedUnit\":\"2\",\"managedUnitName\":\"申万宏源托管一单元\",\"settlement\":\"1000\",\"stockAviNum\":\"1000\",\"stockCode\":\"2\",\"stockInterest\":\"1000\",\"stockLeaveNum\":\"1000\",\"stockName\":\"九鼎集团\",\"stockNature\":\"4\",\"stockNum\":\"1000\",\"stockShortName\":\"九鼎集团\",\"stockType\":\"1\"}," +
                "{\"bonus\":\"1000\",\"industy\":\"证券3\",\"managedUnit\":\"2\",\"managedUnitName\":\"申万宏源托管一单元\",\"settlement\":\"1000\",\"stockAviNum\":\"1000\",\"stockCode\":\"2\",\"stockInterest\":\"1000\",\"stockLeaveNum\":\"1000\",\"stockName\":\"九鼎集团\",\"stockNature\":\"3\",\"stockNum\":\"1000\",\"stockShortName\":\"九鼎集团\",\"stockType\":\"1\"}," +
                "{\"bonus\":\"1000\",\"industy\":\"证券4\",\"managedUnit\":\"3\",\"managedUnitName\":\"申万宏源托管一单元\",\"settlement\":\"1000\",\"stockAviNum\":\"1000\",\"stockCode\":\"3\",\"stockInterest\":\"1000\",\"stockLeaveNum\":\"1000\",\"stockName\":\"九鼎集团\",\"stockNature\":\"2\",\"stockNum\":\"1000\",\"stockShortName\":\"九鼎集团\",\"stockType\":\"1\"}," +
                "{\"bonus\":\"1000\",\"industy\":\"证券5\",\"managedUnit\":\"4\",\"managedUnitName\":\"申万宏源托管一单元\",\"settlement\":\"1000\",\"stockAviNum\":\"1000\",\"stockCode\":\"4\",\"stockInterest\":\"1000\",\"stockLeaveNum\":\"1000\",\"stockName\":\"九鼎集团\",\"stockNature\":\"5\",\"stockNum\":\"1000\",\"stockShortName\":\"九鼎集团\",\"stockType\":\"1\"}]";
        List<Items> itemsList = OBJECT_MAPPER.readValue(jsonStr3, new TypeReference<List<Items>>() {
        });

        itemsList.sort(Comparator.comparing(Items::getStockCode).thenComparing(Items::getManagedUnit).thenComparing(Items::getStockNature));

//        itemsList.forEach(System.out::println);
        for (Items items : itemsList) {
            System.out.println(items.getIndusty() + "------" + "stockCode" + items.getStockCode() + "----" + "manageUnit" + items.getManagedUnit() + "-------" + "stockNature" + items.getStockNature());
        }
    }

}
