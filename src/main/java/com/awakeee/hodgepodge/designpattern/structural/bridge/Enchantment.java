package com.awakeee.hodgepodge.designpattern.structural.bridge;


//附魔
public interface Enchantment {

    void onActivate();//激活

    void apply();

    void onDeactivate();//失效
}
