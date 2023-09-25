package com.haha.tankgame2;

import javax.swing.*;
import java.awt.event.KeyListener;

/**
 * @author hhm
 * @version 1.0
 */
public class hhTankGame02 extends JFrame {
    //定义MyPanel
    MyPanel mp=null;
    public static void main(String[] args) {
        hhTankGame02 hhTankGame01 = new hhTankGame02();

    }

    //构造器
    public hhTankGame02(){
        mp=new MyPanel();
        this.add(mp);//游戏的绘图区域
        this.addKeyListener(mp);//让JFrame监听mp的键盘事件
        this.setSize(1000,750);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}
