package com.haha.tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author hhm
 * @version 1.0
 * 坦克大战的绘图区域
 */

//为了监听键盘事件，实现KeyListener
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero=null;
    //定义敌人的坦克，放入到Vector中
    Vector<EnemyTank> enemyTanks=new Vector<>();
    int enemyTankSize=3;
    public MyPanel(){
        hero=new Hero(100,100);//初始化自己坦克
        //初始化敌人的坦克
        for(int i=0;i<enemyTankSize;i++){
            //创建一个敌人的坦克
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            //设置方向
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }

        hero.setSpeed(1);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形，默认黑色

        //画出自己坦克-封装方法
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);

        //画出敌人的坦克，遍历Vector
        for(int i=0;i<enemyTanks.size();i++){
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),0);

        }




    }
    //编写方法，画出坦克
    //x坦克左上角x坐标，y：坦克左上角y坐标，g：画笔，direct:方向（上下左右），type：坦克的类型
    public void drawTank(int x,int y,Graphics g,int direct,int type){
        //根据不同类型坦克，设置不同颜色
        switch(type){
            case 0://敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1://我们的坦克
                g.setColor(Color.yellow);
                break;

        }

        //根据坦克方向，来绘制对应形状坦克
        //direct表示方向，0:向上，1：向右，2：向下，3：向左
        switch(direct){
            case 0://向上
                g.fill3DRect(x,y,10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x+30,y,10,60,false);//画出坦克右边的轮子
                g.fill3DRect(x+10,y+10,20,40,false);//画出坦克中间的盖子
                g.fillOval(x+10,y+20,20,20);//画出圆形盖子
                g.drawLine(x+20,y+30,x+20,y);//画出炮筒
                break;
            case 1://向右
                g.fill3DRect(x,y,60,10,false);//画出坦克上边的轮子
                g.fill3DRect(x,y+30,60,10,false);//画出坦克下边的轮子
                g.fill3DRect(x+10,y+10,40,20,false);//画出坦克中间的盖子
                g.fillOval(x+20,y+10,20,20);//画出圆形盖子
                g.drawLine(x+30,y+20,x+60,y+20);//画出炮筒
                break;
            case 2://向下，只用把向上的炮筒方向换一下
                g.fill3DRect(x,y,10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x+30,y,10,60,false);//画出坦克右边的轮子
                g.fill3DRect(x+10,y+10,20,40,false);//画出坦克中间的盖子
                g.fillOval(x+10,y+20,20,20);//画出圆形盖子
                g.drawLine(x+20,y+30,x+20,y+60);//画出炮筒//注意x向右，y轴向下
                break;
            case 3://向左，只用把向右的炮筒方向换一下
                g.fill3DRect(x,y,60,10,false);//画出坦克上边的轮子
                g.fill3DRect(x,y+30,60,10,false);//画出坦克下边的轮子
                g.fill3DRect(x+10,y+10,40,20,false);//画出坦克中间的盖子
                g.fillOval(x+20,y+10,20,20);//画出圆形盖子
                g.drawLine(x+30,y+20,x,y+20);//画出炮筒

                break;
            default:
                System.out.println("暂时没有处理");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理键wdsa按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){//按下W键
            //改变坦克的方向
            hero.setDirect(0);
            //修改坦克的坐标y-=1，向上，在这个坐标上（x向右，y向下）所以向上是y减去1
            hero.moveUp();

        }else if(e.getKeyCode()==KeyEvent.VK_D){
            hero.setDirect(1);
            hero.moveRight();
        }else if(e.getKeyCode()==KeyEvent.VK_S){
            hero.setDirect(2);
            hero.moveDown();
        }else if(e.getKeyCode()==KeyEvent.VK_A){
            hero.setDirect(3);
            hero.moveLeft();
        }
        //让面板重绘
        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
