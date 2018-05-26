package com.common.test.demo26_fileUtil;

/**
 * @author jinx
 * @date 2018/5/14 16:09
 * Desc:
 */
public class Test {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessorImpl();
        LineProcessor lineProcessor = new LineProcessorImpl();
        fileProcessor.processorByLine("f:\\imageTest\\test.vcf",lineProcessor);
    }
}
