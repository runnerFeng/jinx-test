package com.common.test.demo26_fileUtil;

/**
 * @author jinx
 * @date 2018/5/14 16:08
 * Desc:
 */
public class LineProcessorImpl implements LineProcessor {

    private static final String SYMBOL = "#";
    @Override
    public void doSomeThing(String oneLine) {
        if (oneLine.contains(SYMBOL)){
            return;
        }
        String[] s = oneLine.split("\t");
        VcfData vcfData = new VcfData();
        vcfData.setChrom(s[0]);
        vcfData.setPos(s[1]);
        vcfData.setRef(s[3]);
        vcfData.setAlt(s[4]);
        vcfData.setInfo(s[s.length-1].split(";")[0].split("=")[1]);
        System.out.println(vcfData.getInfo());
        if (vcfData.getInfo().equals("INS")){

        }

    }
}
