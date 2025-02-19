package org.example;

public class Taula {
    private static Filosof[] comensals;
    private static Forquilla[] forquilles;

    public static void main(String[] args) {
        initFilosofsAndForquillas(5);
        showTaula();
        cridaTaula();
    }

    private static void initFilosofsAndForquillas(int numero){
        comensals = new Filosof[numero];
        forquilles = new Forquilla[numero];
        for (int i = 0; i < forquilles.length; i++) {
            forquilles[i] = new Forquilla(i);
        }
        for(int i = 0; i < comensals.length; i++){
            comensals[i] = new Filosof(String.format("fil%d", i), i, forquilles[i], forquilles[(i + 1) % forquilles.length]);
        }
    }

    private static void showTaula(){
        for (int i = 0; i < comensals.length; i++) {
            System.out.printf("Comensal: %s esq:%d dret:%d%n", comensals[i].getName(), comensals[i].getForquillaEsquerra().getNum(), comensals[i].getForquillaDreta().getNum());
        }
        System.out.println("----------------------------------------------");
    }

    private static void cridaTaula(){
        for (int i = 0; i < comensals.length; i++) {
            try {
                comensals[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < comensals.length; i++) {
            comensals[i].start();
        }
    }
}
