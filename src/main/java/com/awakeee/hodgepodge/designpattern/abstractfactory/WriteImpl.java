package com.awakeee.hodgepodge.designpattern.abstractfactory;

public class WriteImpl implements Operate {
    @Override
    public void operate() {
        System.out.println("写");
    }
}
