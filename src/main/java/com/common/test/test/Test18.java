package com.common.test.test;

/**
 * @Author jinx
 * @Date 2023/10/26
 * @Desc 比较version大小
 */
public class Test18 {

    public static void main(String[] args) {
        String version1 = "1.1.1";
        String version2 = "1.1.0";
        int result = compareVersions(version1, version2);
        System.out.println(result);
    }

//    private static int compareVersions(String version1, String version2) {
//        String[] v1 = version1.split("\\.");
//        String[] v2 = version2.split("\\.");
//        int x = 0, y = 0;
//        for (int i = 0; i < v1.length || i < v2.length; i++) {
//            if (i < v1.length) {
//                x = Integer.parseInt(v1[i]);
//            }
//            if (i < v2.length) {
//                y = Integer.parseInt(v2[i]);
//            }
//            if (x > y) {
//                return 1;
//            }
//            if (x < y) {
//                return -1;
//            }
//        }
//        return 0;
//    }

    private static int compareVersions(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int x = 0, y = 0;
        for (int i = 0; i < split1.length || i < split2.length; i++) {
            if (i < split1.length) {
                x = Integer.parseInt(split1[i]);
            }
            if (i < split2.length) {
                y = Integer.parseInt(split2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }
}
