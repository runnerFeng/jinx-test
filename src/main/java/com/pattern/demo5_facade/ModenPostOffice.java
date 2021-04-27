package com.pattern.demo5_facade;

/**
 * Desc:
 * Created by jinx on 2017/8/10.
 */
public class ModenPostOffice {
    private LetterProcess letterProcess = new LetterProcessImpl();

    public void sendLetter(String context, String address) {
        letterProcess.writeContext(context);
        letterProcess.fillEvelope(address);
        letterProcess.letterIntoEvelope();
        letterProcess.sendLetter();

    }
}
