package org.example;

import java.util.Random;

public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra; 
    private int gana = 0;
    private int comensalNum;
    private Random rnd = new Random();
    public Filosof(String name, int comensal, Forquilla forquillaEsquerra, Forquilla forquillaDreta){
        super(name);
        this.comensalNum = comensal;
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
    }

    public void menjar() throws InterruptedException {
        if (comensalNum % 2 == 0) {
            agafarForquilles(forquillaEsquerra, forquillaDreta);
        } else {
            agafarForquilles(forquillaDreta, forquillaEsquerra);
        }
    }

    public void pensar(){
        System.out.printf("Filósof: %s pensant%n", getName());
        delay(1000, 2000);
    }

    @Override
    public void run() {
        while (true) {
            try {
                menjar();
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

    private boolean agafarForquillaEsquerra(Forquilla fork) throws InterruptedException {
        boolean agafat;
            if(fork.isUsed()){
                gana++;
                agafat = true;
                System.out.printf("Filósof: %s no pot agafar la forquilla esquerra(ocupada)%n", getName());
                System.out.printf("Filósof: %s gana = %d%n", getName(), gana);
                delay(500, 1000);
            }else{
                fork.setUsed(comensalNum);
                agafat = false;
            }
        return agafat;
    }
    private boolean agafarForquillaDreta(Forquilla fork) throws InterruptedException {
        boolean agafat;
            if(!fork.isUsed()){
                agafat = false;
                fork.setUsed(comensalNum);
                System.out.printf("Filósof: %s menja%n", getName());
                gana = 0;
                delay(1000, 2000);
                deixarForquillas();
                System.out.printf("Filósof: %s ha acabat de menjar%n", getName());
                pensar();
            }else{
                deixarForquilla(forquillaEsquerra);
                gana++;
                agafat = true;
                System.out.printf("Filósof: %s deixa l'esquerra (%d) i espera (dreta ocupada)%n", getName(), forquillaEsquerra.getNum());
                System.out.printf("Filósof: %s gana = %d%n", getName(), gana);
                delay(500, 1000);
            }
        return agafat;
    }

    private boolean agafarForquilles(Forquilla esquerra, Forquilla dreta) throws InterruptedException {
        boolean agafat;
        synchronized (esquerra){
            agafat = agafarForquillaEsquerra(esquerra);
            synchronized (dreta){
                agafat = agafat && agafarForquillaDreta(dreta);
            }
        }
        return agafat;
    }

    private void deixarForquilla(Forquilla fork){
        fork.setLliure();
    }

    private void deixarForquillas(){
        forquillaEsquerra.setLliure();
        forquillaDreta.setLliure();
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }
}
