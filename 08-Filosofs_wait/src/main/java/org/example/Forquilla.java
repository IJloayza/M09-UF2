package org.example;

public class Forquilla {
    private int num;
    private final int LLIURE = -1;
    private int propietari = LLIURE;
    public Forquilla(int num){
        this.num = num;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    synchronized public boolean isUsed() {
        return propietari != LLIURE;
    }

    synchronized public void setUsed(int propietari) throws InterruptedException {
        while (this.propietari != LLIURE) {
            wait(); // Espera si la forquilla está en uso
        }
        this.propietari = propietari;
    }

    synchronized public void setLliure() {
        this.propietari = LLIURE;
        notifyAll(); // Notifica a otros hilos de que la forquilla está libre
    }
}
