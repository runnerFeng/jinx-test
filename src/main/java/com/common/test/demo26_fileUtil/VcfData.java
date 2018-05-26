package com.common.test.demo26_fileUtil;

import lombok.Data;

/**
 * @author jinx
 * @date 2018/5/14 16:16
 * Desc:
 */
@Data
public class VcfData {
    /**
     * 染色体编号
     */
    private String chrom;
    /**
     * 点位，这个染色体上的位置信息
     */
    private String pos;
    /**
     * 参考串碱基
     */
    private String ref ;
    /**
     * 变异后的碱基
     */
    private String alt;
    /**
     * 操作类型
     */
    private String info;
}
