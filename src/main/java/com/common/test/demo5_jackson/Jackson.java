package com.common.test.demo5_jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

/**
 * Desc:
 * Created by lf on 2017/2/23
 */
public class Jackson {
    private static ObjectMapper mapper = new ObjectMapper();

    private static String jsonStr = "{\"status\":\"OK\",\"data\":{\"facade\":\"0\",\"item\":{\"name\":\"秦龙\",\"cardno\":\"522732198701074213\",\"sex\":\"男\",\"folk\":\"水\",\"birthday\":\"1987年01月07日\",\"address\":\"贵州省三都水族自治县都江镇上江村五组\",\"issue_authority\":[],\"valid_period\":[],\"header_pic\":[]}}}";

    private static String jsonStr1 = "{\n" +
            "    \"userId\": \"0xf3cadf0f4f0a2728524cc1955062fe22af479d50\",\n" +
            "    \"userName\": \"小黑\",\n" +
            "    \"matter\": \"\",\n" +
            "    \"count\": 0,\n" +
            "    \"reason\": \"\",\n" +
            "    \"contact\": \"\",\n" +
            "    \"createTime\": 0,\n" +
            "    \"financierInfos\": [\n" +
            "        {\n" +
            "            \"infoId\": 18,\n" +
            "            \"infoDetail\": {\n" +
            "                \"id\": 18,\n" +
            "                \"businessNo\": \"F011706290015\",\n" +
            "                \"userId\": \"0xf3cadf0f4f0a2728524cc1955062fe22af479d50\",\n" +
            "                \"userName\": \"小黑\",\n" +
            "                \"userType\": 1,\n" +
            "                \"secAccount\": \"123456\",\n" +
            "                \"secCode\": \"430719\",\n" +
            "                \"secName\": \"九鼎集团\",\n" +
            "                \"hideFlag\": 2,\n" +
            "                \"pledgeNum\": 30000,\n" +
            "                \"closePrice\": 0,\n" +
            "                \"industry\": 5,\n" +
            "                \"minAmountScale\": 2000,\n" +
            "                \"maxAmountScale\": 200000,\n" +
            "                \"minAmountLastDate\": 12,\n" +
            "                \"maxAmountLastDate\": 19,\n" +
            "                \"purpose\": 5,\n" +
            "                \"createTimestamp\": 1498725729000,\n" +
            "                \"endTimestamp\": 1506614400000,\n" +
            "                \"status\": 2\n" +
            "            },\n" +
            "            \"infoType\": 1,\n" +
            "            \"userName\": \"小黑\",\n" +
            "            \"userId\": \"0xf3cadf0f4f0a2728524cc1955062fe22af479d50\",\n" +
            "            \"reason\": \"你民工\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"infoId\": 16,\n" +
            "            \"infoDetail\": {\n" +
            "                \"id\": 16,\n" +
            "                \"businessNo\": \"F011706290013\",\n" +
            "                \"userId\": \"0xf3cadf0f4f0a2728524cc1955062fe22af479d50\",\n" +
            "                \"userName\": \"小黑\",\n" +
            "                \"userType\": 1,\n" +
            "                \"secAccount\": \"123456\",\n" +
            "                \"secCode\": \"430719\",\n" +
            "                \"secName\": \"九鼎集团\",\n" +
            "                \"hideFlag\": 2,\n" +
            "                \"pledgeNum\": 30000,\n" +
            "                \"closePrice\": 0,\n" +
            "                \"industry\": 5,\n" +
            "                \"minAmountScale\": 2000,\n" +
            "                \"maxAmountScale\": 99900,\n" +
            "                \"minAmountLastDate\": 12,\n" +
            "                \"maxAmountLastDate\": 19,\n" +
            "                \"purpose\": 5,\n" +
            "                \"createTimestamp\": 1498725705000,\n" +
            "                \"endTimestamp\": 1514476800000,\n" +
            "                \"status\": 2\n" +
            "            },\n" +
            "            \"infoType\": 1,\n" +
            "            \"userName\": \"hjjj\",\n" +
            "            \"userId\": \"0xb9874077417735fa5bb811ad63930918e3a5bad6\",\n" +
            "            \"reason\": \"监控\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"investorInfos\": [\n" +
            "        {\n" +
            "            \"infoId\": 21,\n" +
            "            \"infoDetail\": {\n" +
            "                \"id\": 21,\n" +
            "                \"userId\": \"0xf3cadf0f4f0a2728524cc1955062fe22af479d50\",\n" +
            "                \"businessNo\": \"F021706290017\",\n" +
            "                \"userName\": \"小黑\",\n" +
            "                \"userType\": 1,\n" +
            "                \"organizationType\": 0,\n" +
            "                \"area\": 3,\n" +
            "                \"industry\": [\n" +
            "                    4,\n" +
            "                    5,\n" +
            "                    6\n" +
            "                ],\n" +
            "                \"minAmountScale\": 100,\n" +
            "                \"maxAmountScale\": 99900,\n" +
            "                \"minAmountLastDate\": 1,\n" +
            "                \"maxAmountLastDate\": 999,\n" +
            "                \"createTimestamp\": 1498725578000,\n" +
            "                \"endTimestamp\": 1506614400000,\n" +
            "                \"status\": 2\n" +
            "            },\n" +
            "            \"infoType\": 2,\n" +
            "            \"userName\": \"小黑\",\n" +
            "            \"userId\": \"0xf3cadf0f4f0a2728524cc1955062fe22af479d50\",\n" +
            "            \"reason\": \"徐璐是曾小波美丽健康大方的姐姐徐璐是曾小波美丽健康大方的姐姐徐璐是曾小波美丽健康大方的姐姐徐璐是曾小波美丽健康大方的姐姐徐璐是曾小波美丽健康大方的姐姐徐璐是曾小波美丽健康大方的姐姐\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"audit\": {\n" +
            "        \"auditorId\": \"0x0000000000000000000000000000000000000000\",\n" +
            "        \"auditComment\": \"\",\n" +
            "        \"operateCode\": 0,\n" +
            "        \"methodName\": \"\",\n" +
            "        \"auditTime\": 0\n" +
            "    }\n" +
            "}";

    public static void main(String[] args) throws IOException {
//测试通过json获取Object对象
        Object obj = getObjectByJson(jsonStr, "data.facade", TypeEnum.string); //层级递归String
        Object obj1 = getObjectByJson(jsonStr, "data.item", TypeEnum.map); //层级递归String
        System.out.println(obj.toString());
        System.out.println(obj1);
        System.out.println(mapper.writeValueAsString(obj1));
        System.out.println(mapper.readValue(mapper.writeValueAsString(obj1), IDCardInfo.class).getName());
        System.out.println(((Map) obj1).get("name"));

        System.out.println(getObjectByJson(jsonStr1, "", TypeEnum.map));

    }

    /**
     * 复杂嵌套Map转Json
     */
    public static String getJsonByObject(Object obj) {
        String str = "";
        try {
            str = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            System.out.println("###[Error] getObjectToJson() " + e.getMessage());
        }
        return str;
    }

    /**
     * 复杂嵌套Json层级展示
     */
    public static Object viewJsonTree(Object m) {
        if (m == null) {
            System.out.println("over...");
            return false;
        }

        try {
            Map mp = null;
            List ls = null;
            if (m instanceof Map || m instanceof LinkedHashMap) {
                mp = (LinkedHashMap) m;
                for (Iterator ite = mp.entrySet().iterator(); ite.hasNext(); ) {
                    Map.Entry e = (Map.Entry) ite.next();

                    if (e.getValue() instanceof String) {
                        System.out.println("[String]" + e.getKey() + " | " + e.getValue());
                    } else if (e.getValue() instanceof LinkedHashMap) {
                        System.out.println("{Map}" + e.getKey() + " | " + e.getValue());
                        viewJsonTree((LinkedHashMap) e.getValue());
                    } else if (e.getValue() instanceof ArrayList) {
                        System.out.println("[Array]" + e.getKey() + " | " + e.getValue());
                        viewJsonTree((ArrayList) e.getValue());
                    }
                }
            }
            if (m instanceof List || m instanceof ArrayList) {
                ls = (ArrayList) m;
                for (int i = 0; i < ls.size(); i++) {
                    if (ls.get(i) instanceof LinkedHashMap) {
                        viewJsonTree((LinkedHashMap) ls.get(i));
                    } else if (ls.get(i) instanceof ArrayList) {
                        viewJsonTree((ArrayList) ls.get(i));
                    }
                }
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("###[Error] viewJsonTree() " + e.getMessage());
        }
        return null;
    }


    private static int i = 0;

    /**
     * 复杂嵌套Json获取Object数据
     */
    public static Object getObjectByJson(String jsonStr, String argsPath, TypeEnum argsType) {
        if (argsPath == null || argsPath.equals("") || argsType == null) {
            return null;
        }

        Object obj = null;
        try {
            Map maps = mapper.readValue(jsonStr, Map.class);
            //多层获取
            if (argsPath.indexOf(".") >= 0) {
                //类型自适应
                obj = getObject(maps, argsPath, argsType);
            } else { //第一层获取
                if (argsType == TypeEnum.string) {
                    obj = maps.get(argsPath).toString();
                } else if (argsType == TypeEnum.map) {
                    obj = (Map) maps.get(argsPath);
                } else if (argsType == TypeEnum.arrayList) {
                    obj = (List) maps.get(argsPath);
                } else if (argsType == TypeEnum.arrayMap) {
                    obj = (List<Map>) maps.get(argsPath);
                }
            }
        } catch (Exception e) {
            System.out.println("###[Error] getObjectByJson() " + e.getMessage());
        }
        i = 0;
        return obj;
    }

    //递归获取object
    private static Object getObject(Object m, String key, TypeEnum type) {
        if (m == null) {
            return null;
        }
        Object o = null;
        Map mp = null;
        List ls = null;
        try {
            //对象层级递归遍历解析
            if (m instanceof Map || m instanceof LinkedHashMap) {
                mp = (LinkedHashMap) m;
                for (Iterator ite = mp.entrySet().iterator(); ite.hasNext(); ) {
                    Map.Entry e = (Map.Entry) ite.next();

                    if (i < key.split("\\.").length && e.getKey().equals(key.split("\\.")[i])) {
                        i++;
                        if (e.getValue() instanceof String) {
                            if (i == key.split("\\.").length) {
                                o = e.getValue();
                                return o;
                            }
                        } else if (e.getValue() instanceof LinkedHashMap) {
                            if (i == key.split("\\.").length) {
                                if (type == TypeEnum.map) {
                                    o = (LinkedHashMap) e.getValue();
                                    return o;
                                }
                            } else {
                                o = getObject((LinkedHashMap) e.getValue(), key, type);
                            }
                            return o;
                        } else if (e.getValue() instanceof ArrayList) {
                            if (i == key.split("\\.").length) {
                                if (type == TypeEnum.arrayList) {
                                    o = (ArrayList) e.getValue();
                                    return o;
                                }
                                if (type == TypeEnum.arrayMap) {
                                    o = (ArrayList<Map>) e.getValue();
                                    return o;
                                }
                            } else {
                                o = getObject((ArrayList) e.getValue(), key, type);
                            }
                            return o;
                        }
                    }
                }
            }
            //数组层级递归遍历解析
            if (m instanceof List || m instanceof ArrayList) {
                ls = (ArrayList) m;
                for (int i = 0; i < ls.size(); i++) {
                    if (ls.get(i) instanceof LinkedHashMap) {
                        if (i == key.split("\\.").length) {
                            if (type == TypeEnum.map) {
                                o = (LinkedHashMap) ls.get(i);
                                return o;
                            }
                        } else {
                            o = getObject((LinkedHashMap) ls.get(i), key, type);
                        }
                        return o;
                    } else if (ls.get(i) instanceof ArrayList) {
                        if (i == key.split("\\.").length) {
                            if (type == TypeEnum.arrayList) {
                                o = (ArrayList) ls.get(i);
                                return o;
                            }
                            if (type == TypeEnum.arrayMap) {
                                o = (ArrayList<Map>) ls.get(i);
                                return o;
                            }
                        } else {
                            o = getObject((ArrayList) ls.get(i), key, type);
                        }
                        return o;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("###[Error] getObject() " + e.getMessage());
        }

        return o;
    }


    /*
     * Json数据解析返回数据类型枚举
     */
    public enum TypeEnum {
        /**
         * 单纯的键值对，通过key获取valus
         */
        string,
        /**
         * 通过key获取到Map对象
         */
        map,
        /**
         * 通过key获取到ArrayList数组
         */
        arrayList,
        /**
         * 通过key获取到ArrayMap数组对象
         */
        arrayMap
    }

}
