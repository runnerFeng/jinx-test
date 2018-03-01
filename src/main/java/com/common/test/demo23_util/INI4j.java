package com.common.test.demo23_util;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lvxy on 2017/2/20.
 */
public class INI4j {
    /**
     * 用linked hash map 来保持有序的读取
     *
     */
    final LinkedHashMap<String,LinkedHashMap<String, String>>  coreMap = new LinkedHashMap<String, LinkedHashMap<String,String>>();
    /**
     * 当前Section的引用
     */
    String currentSection = null;

    /**
     * 读取
     * @param file 文件
     * @throws FileNotFoundException
     */
    public INI4j(File file) throws FileNotFoundException, UnsupportedEncodingException {
            this.init(new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8")));
    }
    /***
     * 重载读取
     * @param path 给文件路径
     * @throws FileNotFoundException
     */
    public INI4j(String path) throws FileNotFoundException, UnsupportedEncodingException {
        if(org.apache.commons.lang3.StringUtils.startsWithIgnoreCase(path, "file:/")){
            URL url = null;
            try {
                url = new URL(path);
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(url.toURI())), "UTF-8"));
                this.init(br);
            } catch (MalformedURLException | URISyntaxException e) {
                e.printStackTrace();
                throw new FileNotFoundException();
            }
        }else{
            this.init(new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8")));
        }

    }
    /***
     * 重载读取
     * @param source ClassPathResource 文件，如果文件在resource 里，那么直接 new ClassPathResource("file name");
     * @throws IOException
     */
    public INI4j(ClassPathResource source) throws IOException {
        this(source.getFile());
    }

    void init(BufferedReader bufferedReader){
        try {
            read(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("IO Exception:" + e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 读取文件
     * @param reader
     * @throws IOException
     */
    void read(BufferedReader reader) throws IOException {
        String line = null;
        while((line=reader.readLine())!=null) {
            parseLine(line);
        }
    }

    /**
     * 转换
     * @param line
     */
    void parseLine(String line) {
        line = line.trim();
        // 此部分为注释
        if(line.matches("^\\#.*$")) {
            return;
        }else if (line.matches("^\\[[\\S\\s]+\\]$")) {
            // section
            String section = line.replaceFirst("^\\[([\\S\\s]+)\\]$","$1");
            addSection(section.trim());
        }else if (line.matches("^[\\S\\s]+=[\\S\\s]*$")) {
            // key ,value
            int i = line.indexOf("=");
            String key = line.substring(0, i).trim();
            String value =line.substring(i + 1).trim();
            addKeyValue(currentSection,key,value);
        }
    }


    /**
     * 增加新的Key和Value
     * @param currentSection
     * @param key
     * @param value
     */
    void addKeyValue(String currentSection,String key, String value) {
        if(!coreMap.containsKey(currentSection)) {
            return;
        }
        Map<String, String> childMap = coreMap.get(currentSection);
        childMap.put(key, value);
    }


    /**
     * 增加Section
     * @param section
     */
    void addSection(String section) {
        if (!coreMap.containsKey(section)) {
            currentSection = section;
            LinkedHashMap<String,String> childMap = new LinkedHashMap<String,String>();
            coreMap.put(section, childMap);
        }
    }

    /**
     * 获取配置文件指定Section和指定子键的值
     * @param section
     * @param key
     * @return
     */
    public String get(String section,String key){
        if(coreMap.containsKey(section)) {
            return  get(section).containsKey(key) ?  get(section).get(key): null;
        }
        return null;
    }



    /**
     * 获取配置文件指定Section的子键和值
     * @param section
     * @return
     */
    public LinkedHashMap<String, String> get(String section){
        return  coreMap.containsKey(section) ? coreMap.get(section) : null;
    }

    /**
     * 获取这个配置文件的节点和值
     * @return
     */
    public LinkedHashMap<String, LinkedHashMap<String, String>> get(){
        return coreMap;
    }

    public static void main(String[] args) throws Exception {

        System.out.println(System.getProperty("user.dir"));

        //windows ok, linux ok too
        INI4j ini4j = new INI4j("D:\\tomcat-admin\\bin\\config\\security\\security-filter-config.ini");

        // windows ok, linux not work
        // INI4j ini4j = new INI4j("file:/D:\\tomcat-admin\\bin\\config\\security\\security-filter-config.ini");

        LinkedHashMap<String, String> a = ini4j.get("base_auth");

        LinkedHashMap<String, String> b = ini4j.get("filterChainDefinitions");

        System.out.println("a:" + a);
        System.out.println("b:" + b);

        String path = "/nt.html?ada=1&bd=3?";
        path = org.apache.commons.lang3.StringUtils.substringBefore(path,"?");
        System.out.println("aa" + path);



    }
}
