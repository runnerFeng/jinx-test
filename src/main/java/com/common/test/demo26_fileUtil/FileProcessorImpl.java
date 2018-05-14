package com.common.test.demo26_fileUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author jinx
 * @date 2018/5/14 16:05
 * Desc:
 */
public class FileProcessorImpl implements FileProcessor {
    @Override
    public void processorByLine(String filePath, LineProcessor processor) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filePath));
            for (String line = bf.readLine(); line != null; line = bf.readLine()) {
                processor.doSomeThing(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
