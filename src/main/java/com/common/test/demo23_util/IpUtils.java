package com.common.test.demo23_util;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;


public class IpUtils {
    /*
     * 随机生成国内IP地址
     */
    public static String getRandomIp() {

        //ip范围
        int[][] range = {{607649792, 608174079},//36.56.0.0-36.63.255.255
                {1038614528, 1039007743},//61.232.0.0-61.237.255.255
                {1783627776, 1784676351},//106.80.0.0-106.95.255.255
                {2035023872, 2035154943},//121.76.0.0-121.77.255.255
                {2078801920, 2079064063},//123.232.0.0-123.235.255.255
                {-1950089216, -1948778497},//139.196.0.0-139.215.255.255
                {-1425539072, -1425014785},//171.8.0.0-171.15.255.255
                {-1236271104, -1235419137},//182.80.0.0-182.92.255.255
                {-770113536, -768606209},//210.25.0.0-210.47.255.255
                {-569376768, -564133889}, //222.16.0.0-222.95.255.255
        };

        Random rdint = new Random();
        int index = rdint.nextInt(10);
        String ip = num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
        return ip;
    }

    /*
     * 将十进制转换成ip地址
     */
    private static String num2ip(int ip) {
        int[] b = new int[4];
        String x = "";

        b[0] = (int) ((ip >> 24) & 0xff);
        b[1] = (int) ((ip >> 16) & 0xff);
        b[2] = (int) ((ip >> 8) & 0xff);
        b[3] = (int) (ip & 0xff);
        x = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer.toString(b[3]);

        return x;
    }


    /**
     * 从request对象中获取客户端真实的ip地址
     *
     * @param request request对象
     * @return 客户端的IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        //System.out.print("x-forwarded-for::::::::::::::" + ip);
        if (StringUtils.isNotEmpty(ip) && ip.contains(",")) {
            // 如果通过多级反向代理，X-Forwarded-For的值不止一个，而是一串用逗号分隔的IP值，此时取X-Forwarded-For中第一个非unknown的有效IP字符串
            String[] array = ip.split(",");
            for (String element : array) {
                if (isEffective(element)) {
                    return element;
                }
            }
        }
        if (isEffective(ip)) return ip;

        ip = request.getHeader("WL-Proxy-Client-IP");
        //System.out.print("WL-Proxy-Client-IP::::::::::::::" + ip);
        if (isEffective(ip)) return ip;

        ip = request.getHeader("X-Real-IP");
        //System.out.print("X-Real-IP::::::::::::::" + ip);
        if (isEffective(ip)) return ip;

        ip = request.getRemoteAddr();
        //System.out.print("RemoteAddr::::::::::::::" + ip);
        if (isEffective(ip)) return ip;

        return ip;
    }


    /**
     * 远程地址是否有效.
     *
     * @param remoteAddr 远程地址
     * @return true代表远程地址有效，false代表远程地址无效
     */
    private static boolean isEffective(final String remoteAddr) {
        if (StringUtils.isNotEmpty(remoteAddr) && !org.apache.commons.lang3.StringUtils.equalsIgnoreCase("unknown", remoteAddr)) {
            return isIpv4(remoteAddr) || isIpv6(remoteAddr);
        }
        return false;
    }


    private static final Pattern IPV4_PATTERN =
            Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                    + "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                    + "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                    + "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");

    private static boolean isIpv4(String ipAddress) {
        return IPV4_PATTERN.matcher(ipAddress).matches();
    }


    private static final Pattern IPV6_PATTERN =
            Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    private static boolean isIpv6(String ipAddress) {
        return IPV6_PATTERN.matcher(ipAddress).matches();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(IpUtils.getRandomIp());
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
