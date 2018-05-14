package com.common.test.demo26_fileUtil;

/**
 * @author jinx
 * @date 2018/5/14 16:03
 * Desc:
 */
public interface FileProcessor {
    void processorByLine(String filePath, LineProcessor processor);
}
