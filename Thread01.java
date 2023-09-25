package com.haha.threaduse;

/**
 * @author hhm
 * @version 1.0
 * 演示通过继承Thread类创建线程
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        //创建Cat对象，可以当做线程使用
        Cat cat = new Cat();
        //真正实现多线程的效果，是start0()，而不是run
        cat.start();//启动线程->最终会执行Cat的run方法
//        cat.run();//run方法就是一个普通的方法，没有真正的启动一个线程，就会把run方法执行完毕，才会向下执行
        //当main线程启动一个子线程Thread-0，主线程不会阻塞，会继续执行
        //这时，主线程和子线程是交替执行的
        System.out.println("主线程继续执行："+Thread.currentThread().getName());//名字main
        for(int i=0;i<60;i++){
            System.out.println("主线程 i="+i);
            //让主线程休眠
            Thread.sleep(1000);
        }


    }
}


//1.当一个类继承了Thread类，该类就可以当做线程使用
//2.重写run方法，写生自己的业务代码
//3.run Thread类实现了Runnable 类接口的run方法

class Cat extends Thread{

    int times=0;
    @Override
    public void run() {

        while(true){


        //重写run方法，写上自己的业务逻辑
        System.out.println("喵喵，我是小猫咪"+(++times)+"线程名："+Thread.currentThread().getName());
        //让该线程休眠一秒钟,ctrl+alt+t,快捷键
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(times==80){
            break;//当times到了80，退出while循环，这时也就退出线程
        }
        }
    }
}
