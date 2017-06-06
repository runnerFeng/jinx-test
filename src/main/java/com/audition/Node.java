package com.audition;

/**
 * Desc:二叉树求最大值
 * Created by jinx on 2017/6/3.
 */
public class Node {
    private int valuel;

    public int getValuel() {
        return this.valuel;
    }

    public Node[] getChileNodes() {
        return null;
    }

    public int getMaxValue() {

        valuel = this.getValuel();
        Node[] nodes = this.getChileNodes();
        for (Node node : nodes) {
            if (node.getMaxValue() > valuel)
                valuel = node.getMaxValue();
        }
        return valuel;
    }

}
