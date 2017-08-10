package com.pattern.demo5.facade;

/**
 * Desc:
 * Created by jinx on 2017/8/10.
 */
public interface LetterProcess {
    void writeContext(String context);

    void fillEvelope(String address);

    void letterIntoEvelope();

    void sendLetter();
}
