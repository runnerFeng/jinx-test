package com.common.test.demo23_util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.*;

public class JsonUtils {
    private static Logger logger = LogManager.getLogger(JsonUtils.class);

    protected static PropertyFilter filter = new PropertyFilter() {
        //过滤不需要的字段
        public boolean apply(Object source, String name, Object value) {

            if(value instanceof List){
                return true;
            }

            if(value == null){
                return false;
            }
            return true;

            /*if(value instanceof List){
                if(value == null || ((List)value).size()==0){
                    return false;
                }
            }
            if(value instanceof Map){
                if(value == null || ((Map)value).isEmpty()){
                    return false;
                }
            }
            return true;*/
        }
    };


    protected static ValueFilter valueFilter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if(v==null) {
                if (obj instanceof Map) {
                    //对于map类型，无法判断v对应的类型，所以返回""
                    return "";
                } else {
                    //其他类型，默认都是POJO,则找出属性s对应的类型，如果是int，则返回0
                    try {
                        Field field = obj.getClass().getDeclaredField(s);
                        Class type = (Class)field.getGenericType();
                        if (type.getName().equals("java.lang.Integer")) {
                            return 0;
                        } else if (type.getName().equals("java.lang.Double")) {
                            return 0.00;
                        } else if (type.getName().equals("java.lang.String")) {
                            return "";
                        } else{
                            return null;
                        }
                    } catch (NoSuchFieldException e) {
                        //e.printStackTrace();
                    }
                }
            }
            return v;
        }
    };

    public static String toJsonString(Object data){
        return  JSON.toJSONString(data,
                new SerializeFilter[]{filter},
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.DisableCircularReferenceDetect);

       /* return  JSON.toJSONString(data,
                new SerializeFilter[]{filter,valueFilter},
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.DisableCircularReferenceDetect);
        */
    }

    public static Object fromJson(String jsonString) {
        Object jsonObject = JSON.parse(jsonString);
        if(jsonObject instanceof JSONArray){
            return handleJSONArray((JSONArray)jsonObject);
        }else if(jsonObject instanceof JSONObject){
            return handleJSONObject((JSONObject)jsonObject);
        }else{
            return jsonObject;
        }
    }


    /**
     * 首先要明确知道jsonString的最外层表示的就是个Map时，才能用此方法
     *
     * 建议使用以下方法
     * @See JsonUtils#fromJson(java.lang.String)
     *
     * @param jsonString
     * @return
     * @deprecated
     */
    public static HashMap<String, Object> fromJson2Map(String jsonString) {
        HashMap jsonMap = JSON.parseObject(jsonString, HashMap.class);
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        for(Iterator iter = jsonMap.keySet().iterator(); iter.hasNext();){
            String key = (String)iter.next();
            if(jsonMap.get(key) instanceof JSONArray){
                resultMap.put(key, handleJSONArray((JSONArray)jsonMap.get(key)));
            }else if(jsonMap.get(key) instanceof JSONObject){
                resultMap.put(key, handleJSONObject((JSONObject)jsonMap.get(key)));
            }else{
                resultMap.put(key, jsonMap.get(key));
            }
        }
        return resultMap;
    }

    private static List handleJSONArray(JSONArray jsonArray){
        List list = new ArrayList();
        for (Object object : jsonArray) {
            if(object instanceof JSONArray){
                list.add(handleJSONArray((JSONArray) object));
            }else if(object instanceof JSONObject){
                JSONObject jsonObject = (JSONObject) object;
                HashMap<String, Object> map = new HashMap();
                for (Map.Entry entry : jsonObject.entrySet()) {
                    if(entry.getValue() instanceof JSONArray){
                        map.put((String)entry.getKey(), handleJSONArray((JSONArray)entry.getValue()));
                    }else if(entry.getValue() instanceof JSONObject){
                        map.put((String)entry.getKey(), handleJSONObject((JSONObject) entry.getValue()));
                    }else{
                        map.put((String)entry.getKey(), entry.getValue());
                    }
                }
                list.add(map);
            }else{
                list.add(object);
            }
        }
        return list;
    }

    private static HashMap<String, Object> handleJSONObject(JSONObject jsonObject){
        HashMap<String, Object> map = new HashMap();
        for (Map.Entry entry : jsonObject.entrySet()) {
            if(entry.getValue() instanceof JSONArray){
                map.put((String)entry.getKey(), handleJSONArray((JSONArray)entry.getValue()));
            }else if(entry.getValue() instanceof JSONObject){
                map.put((String)entry.getKey(), handleJSONObject((JSONObject) entry.getValue()));
            }else{
                map.put((String) entry.getKey(), entry.getValue());
            }
        }
        return map;
    }


    public static void main(String[] args){

        System.out.println("commentList:");
    }




    public static void main2(String[] args){
        String jsonData = "{" +
                "    \"user_id\": 5300, " +
                "    \"flag\": 0, " +
                "    \"configs\": [" +
                "        {" +
                "            \"user_id\": 5300, " +
                "            \"config_item_id\": 1015, " +
                "            \"type\": 0" +
                "        }, " +
                "        {" +
                "            \"user_id\": 5300, " +
                "            \"config_item_id\": 1016, " +
                "            \"type\": 0" +
                "        }" +
                "    ]" +
                "}";

        jsonData = "{\n" +
                "    \"user_id\": 5300, \n" +
                "    \"flag\": 0, \n" +
                "    \"configs\": [\n" +
                "        {\n" +
                "            \"user_id\": 5300, \n" +
                "            \"config_item_id\": 1015, \n" +
                "            \"type\": 0,\n" +
                "            \"settings\":[\n" +
                "                {\n" +
                "                    \"setting_name1\": 1, \n" +
                "                    \"setting_name2\": 2                    \n" +
                "                },\n" +
                "                {\n" +
                "                    \"setting_name1\": 3, \n" +
                "                    \"setting_name2\": 4                    \n" +
                "                }\n" +
                "            ]\n" +
                "        }, \n" +
                "        {\n" +
                "            \"user_id\": 5300, \n" +
                "            \"config_item_id\": 1016, \n" +
                "            \"type\": 0\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        jsonData = "{\n" +
                "    \"user_id\": 5300, \n" +
                "    \"flag\": 0, \n" +
                "    \"configs\": [\n" +
                "        {\n" +
                "            \"user_id\": 5300, \n" +
                "            \"config_item_id\": 1015, \n" +
                "            \"type\": 0,\n" +
                "            \"settings\":[\n" +
                "                {\n" +
                "                    \"setting_name1\": 1, \n" +
                "                    \"setting_name2\": 2                    \n" +
                "                },\n" +
                "                {\n" +
                "                    \"setting_name1\": 3, \n" +
                "                    \"setting_name2\": 4                    \n" +
                "                }\n" +
                "            ]\n" +
                "        }, \n" +
                "        {\n" +
                "            \"user_id\": 5300, \n" +
                "            \"config_item_id\": 1016, \n" +
                "            \"type\": 0,\n" +
                "            \"settings\":[\n" +
                "                {\n" +
                "                    \"setting_name1\": 1, \n" +
                "                    \"setting_name2\": 2                    \n" +
                "                },\n" +
                "                {\n" +
                "                    \"setting_name1\": 3, \n" +
                "                    \"setting_name2\": 4                    \n" +
                "                },\n" +
                "                {\n" +
                "                    \"setting_name1\": 5, \n" +
                "                    \"setting_name2\": 6                    \n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        jsonData = "{\n" +
                "    \"user_id\": 5300, \n" +
                "    \"flag\": 0, \n" +
                "    \"configs\": [\n" +
                "        {\n" +
                "            \"user_id\": 5300, \n" +
                "            \"config_item_id\": 1015, \n" +
                "            \"type\": 0,\n" +
                "            \"settings\":[\n" +
                "                {\n" +
                "                    \"setting_name1\": 1, \n" +
                "                    \"setting_name2\": 2,\n" +
                "                    \"params\":[\n" +
                "                        {\n" +
                "                            \"param_1\": 1, \n" +
                "                            \"param_2\": 2                    \n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"param_1\": 3, \n" +
                "                            \"param_2\": 4                    \n" +
                "                        }\n" +
                "                    ]                    \n" +
                "                },\n" +
                "                {\n" +
                "                    \"setting_name1\": 3, \n" +
                "                    \"setting_name2\": 4                    \n" +
                "                }\n" +
                "            ]\n" +
                "        }, \n" +
                "        {\n" +
                "            \"user_id\": 5300, \n" +
                "            \"config_item_id\": 1016, \n" +
                "            \"type\": 0,\n" +
                "            \"settings\":[\n" +
                "                {\n" +
                "                    \"setting_name1\": 1, \n" +
                "                    \"setting_name2\": 2                    \n" +
                "                },\n" +
                "                {\n" +
                "                    \"setting_name1\": 3, \n" +
                "                    \"setting_name2\": 4                    \n" +
                "                },\n" +
                "                {\n" +
                "                    \"setting_name1\": 5, \n" +
                "                    \"setting_name2\": 6                    \n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        jsonData = "{  \n" +
                "    \"user_id\": 5300,   \n" +
                "    \"flag\": 0,   \n" +
                "    \"configs\": [  \n" +
                "        {  \n" +
                "            \"user_id\": 5300,   \n" +
                "            \"config_item_id\": 1015,   \n" +
                "            \"type\": 0  \n" +
                "        },   \n" +
                "        {  \n" +
                "            \"user_id\": 5300,   \n" +
                "            \"config_item_id\": 1016,   \n" +
                "            \"type\": 0  \n" +
                "        }  \n" +
                "    ]  \n" +
                "}  ";
        //Map<String, Map<String, Object>> jsonMap = JSON.parseObject(jsonData, new TypeReference<Map<String,Map<String,Object>>>(){});

        //HashMap jsonMap = JSON.parseObject(jsonData, HashMap.class);
        HashMap jsonMap = fromJson2Map(jsonData);
        List<HashMap> configDataList = (List<HashMap>)jsonMap.get("configs");
        for(HashMap configData : configDataList ){//这行出错
            int roleId = (Integer)configData.get("type");
            System.out.println("config.type:" + roleId);
        }
       /* List<HashMap> configDataList = (List<HashMap>)jsonMap.get("configs");
        for(Map configData : configDataList ){ //
            int roleId = (Integer)configData.get("config_item_id");
            List<HashMap> settingsList = (List<HashMap>)configData.get("settings");
            if(settingsList!=null) {
                for (Map settings : settingsList) {
                    int setting_name1 = (Integer) settings.get("setting_name1");
                    List<HashMap> paramsList = (List<HashMap>) settings.get("params");
                    if (paramsList != null) {
                        for (HashMap params : paramsList) {
                            for (Object key : params.keySet()) {
                                System.out.println("key:" + key);
                                System.out.println("value:" + params.get(key));
                            }
                        }
                    }
                }
            }
        }*/

        /*Gson gson = new Gson();
        HashMap jsonMap = gson.fromJson(jsonData, HashMap.class);
        List<HashMap> configDataList = (List<HashMap>)jsonMap.get("configs");
        for(HashMap configData : configDataList ){ //
            Integer roleId = (Integer)configData.get("type");
            //int roleId = 0;
            System.out.println("config.type:" + roleId);
        }*/

       /* HashMap<String,Object> jsonMap = fromJson2Map(jsonData);
        List<HashMap> configDataList = (List<HashMap>)jsonMap.get("configs");
        for(HashMap configData : configDataList ){ //
            Integer roleId = (Integer)configData.get("type");
            //int roleId = 0;
            System.out.println("config.type:" + roleId);
        }*/
    }
}
