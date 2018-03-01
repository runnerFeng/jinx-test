package com.common.test.demo23_util;


import com.common.test.demo12_responseJsonResult.JsonResp;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by lvxy on 2017/2/20.
 */
public class HttpRequestUtils {

    /**
     * 判断是否为Ajax请求
     * @param request   HttpServletRequest
     * @return  是true, 否false
     */
    public static boolean isJsonContent(ServletRequest request) {
        String contentType = ((HttpServletRequest)request).getHeader("Content-type");
        if(StringUtils.isNotBlank(contentType)){
            if(StringUtils.indexOfIgnoreCase(contentType, "application/json")>=0){
                return true;
            }
        }
        return false;
    }

    /*
        当前url：http://localhost:8080/CarsiLogCenter_new/idpstat.jsp?action=idp.sptopn
        request.getRequestURL() http://localhost:8080/CarsiLogCenter_new/idpstat.jsp
        request.getRequestURI() /CarsiLogCenter_new/idpstat.jsp
        request.getContextPath()/CarsiLogCenter_new
        request.getServletPath() /idpstat.jsp
        request.getQueryString()action=idp.sptopn
     */
    public static boolean isHTML(ServletRequest request) {
        HttpServletRequest req = (HttpServletRequest)request;
        String servletPath = req.getServletPath();
        String contextType = req.getContentType();
        String method = req.getMethod();
        return isHTML(servletPath, method, contextType);
    }

    public static boolean isHTML(String servletPath, String method, String contextType) {
        String urlExtension = StringUtils.substringAfterLast(servletPath, ".");
        return ("HTML".equalsIgnoreCase(urlExtension) || "HTM".equalsIgnoreCase(urlExtension))
                && "GET".equalsIgnoreCase(method)
                && StringUtils.containsIgnoreCase(contextType,"text/html");
    }

    public static String readJsonReq(ServletRequest request){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
            StringBuilder sb = new StringBuilder();
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    public static void writeJsonResp(JsonResp resp, ServletResponse response){
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(HttpStatus.SC_OK);

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(JsonUtils.toJsonString(resp));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static void writeJsonResp(JsonResp resp, ServletResponse response, int httpStatusCode){
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(httpStatusCode);

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(JsonUtils.toJsonString(resp));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static void main(String[] args){
        System.out.println(isHTML("/idpstat.html", "get", "text/html;charset=utf-8"));
        System.out.println(isHTML("/idpstat.htm", "get", "text/html;charset=utf-8"));
        System.out.println(isHTML("/idpstat.html", "get", "text/html;charset=utf-8"));

    }

}
