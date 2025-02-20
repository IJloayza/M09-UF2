package org.example;

import java.util.Random;

public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;

    private long iniciGana;
    private long fiGana;
    private int gana;

    private Random rnd = new Random();
    public Filosof(String name, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        super(name);
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
    }

    public void menjar() throws InterruptedException {
        agafarForquilles(forquillaEsquerra, forquillaDreta);
        fiGana = System.currentTimeMillis();
        long GanaActual = calcularGana();
        System.out.printf("%s menja amb gana %d%n", this.getName(), GanaActual);
        delay(1000, 2000);
        System.out.printf("%s ha acabat de menjar%n", this.getName());
        deixarForquillas();
    }

    public void pensar(){
        resetGana();
        System.out.printf("%s pensant%n", this.getName(), getName());
        delay(1000, 2000);
    }

    @Override
    public void run() {
        iniciGana = System.currentTimeMillis();
        while (true) {
            try {
                menjar();
                pensar();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
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

    private void agafarForquillaEsquerra(Forquilla fork) {
        fork.agafar();
    }
    private void agafarForquillaDreta(Forquilla fork) {
        fork.agafar();
    }

    private void agafarForquilles(Forquilla esquerra, Forquilla dreta) throws InterruptedException {
        agafarForquillaEsquerra(esquerra);
        agafarForquillaDreta(dreta);
        System.out.printf("%s té forquilles esq(%d) dreta(%d)%n", this.getName(), forquillaEsquerra.getNum(), forquillaDreta.getNum());
    }

    private void deixarForquilla(Forquilla fork){
        fork.deixar();
    }

    private void deixarForquillas(){
        deixarForquilla(forquillaDreta);
        deixarForquilla(forquillaEsquerra);
        System.out.printf("%s deixar les forquilles%n", this.getName());
    }

    private long calcularGana(){
        gana = (int) (fiGana - iniciGana) / 1000;
        return gana;
    }

    private void resetGana(){
        gana = 0;
        iniciGana = System.currentTimeMillis();
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }
}
