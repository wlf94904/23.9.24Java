package com.haha.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author hhm
 * @version 1.0
 * 演示如何在面板上画出圆
 */
@SuppressWarnings({"all"})
public class DrawCircle extends JFrame{//JFrame对应一个窗口,可以理解成是一个画框
    //定义一个面板
    private MyPanel mp=null;
    public static void main(String[] args) {
        new DrawCircle();
        System.out.println("退出程序~");
    }

    public DrawCircle(){//构造器
        //初始化面板
        mp=new MyPanel();
        //把面板放入窗口（画框）
        this.add(mp);
        //设置窗口的大小
        this.setSize(400,300);
        //当点击窗口的小x，程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可以显示

    }
}

//1.先定义一个MyPanel(面板），继承JPanel类，画图形，就在面板上画
class MyPanel extends JPanel {
    //MyPanel对象就是一个画板
    //Graphics g把g理解成一支画笔
    //Graphics 提供了很多绘图的方法
    //Graphics g
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类的方法完成初始化
//        System.out.println("paint方法已经被调用~");
        //画出一个圆形
//        g.drawOval(10,10,100,100);

        //演示绘制不同的图形
//        g.drawLine(10,10,100,100);
        //矩形（无颜色）
//        g.drawRect(10,10,100,100);
//填充矩形（可以有颜色）
        //设置画笔的颜色
//        g.setColor(Color.blue);
//        g.fillRect(10,10,100,100);

        //填充椭圆
//        g.setColor(Color.red);
//        g.fillOval(10,10,100,100);

        //画图片
        //1.获取图片资源,/bg.png表示在该项目的根目录去获取bg.png图片资源
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.jpg"));
//        g.drawImage(image,10,10,474,266,this);

        //画字符串（写字）
        //给画笔设置颜色和字体
        g.setColor(Color.red);
        g.setFont(new Font("草书",Font.BOLD,50));
        g.drawString("北京你好",100,100);


    }
}