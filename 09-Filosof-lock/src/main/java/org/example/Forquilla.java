package org.example;

import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private int num;
    private ReentrantLock bloqueig = new ReentrantLock(true);
    public Forquilla(int num){
        this.num = num;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public void agafar(){
        bloqueig.lock();
    }

    public void deixar(){
        bloqueig.unlock();
    }
}
