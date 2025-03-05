package org.example;

import java.util.Random;

public class Fumador extends Thread{
    private Estanc estanc;
    private int id;
    private Tabac tabac;
    private Llumi llumi;
    private Paper paper;
    private int fumades;
    private Random rnd = new Random();

    public Fumador(Estanc estanc, int id){
        this.estanc = estanc;
        this.id = id;
    }

    @Override
    public void run() {
        while(fumades < 3){
            synchronized (estanc){
                compraTabac();
                compraLlumi();
                compraPaper();
                fuma();
            }
        }
    }

    public void fuma(){
        if (tabac != null && llumi != null && paper != null){
            System.out.printf("Fumador %d fumant\n", id);
            fumades++;
            System.out.println();
            delay(500, 1000);
            System.out.printf("Fumador %d ha fumat %d vegades\n", id, fumades);
        }
        synchronized (estanc) {
            estanc.notifyAll();
        }

        if (fumades >= 3) {
            System.out.printf("Fumador %d ha acabat de fumar\n", id);
            estanc.notificarFumadorFinalitzat();
            return;
        }
    }

    private void delay(int init, int end){
        int delay = rnd.nextInt(init, end);
        try {
            sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void compraTabac() {
        synchronized (estanc) {
            System.out.printf("Fumador %d comprant Tabac\n", id);
            while (tabac == null) {
                tabac = estanc.venTabac();
                if (tabac == null) {
                    try {
                        estanc.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void compraLlumi(){
        synchronized (estanc) {
            System.out.printf("Fumador %d comprant Llumí\n", id);
            while (llumi == null) {
                llumi = estanc.venLlumi();
                if (llumi == null) {
                    try {
                        estanc.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void compraPaper(){
        synchronized (estanc) {
            System.out.printf("Fumador %d comprant Paper\n", id);
            while (paper == null) {
                paper = estanc.venPaper();
                if (paper == null) {
                    try {
                        estanc.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
