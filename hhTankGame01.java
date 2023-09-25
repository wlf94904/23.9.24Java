package com.haha.tankgame;

import javax.swing.*;

/**
 * @author hhm
 * @version 1.0
 */
public class hhTankGame01 extends JFrame {
    //定义MyPanel
    MyPanel mp=null;
    public static void main(String[] args) {
        hhTankGame01 hhTankGame01 = new hhTankGame01();

    }

    //构造器
    public hhTankGame01(){
        mp=new MyPanel();
        this.add(mp);//游戏的绘图区域
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}
