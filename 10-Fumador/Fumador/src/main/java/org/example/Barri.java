package org.example;

import java.util.ArrayList;
import java.util.List;

public class Barri {
    private static Estanc estanc;
    private static List<Fumador> fumadors;

    public Barri(int numFumadors) {
        this.estanc = new Estanc();
        this.fumadors = new ArrayList<>(numFumadors);
    }

    public static void main(String[] args) throws InterruptedException {
        Barri barri = new Barri(3);
        barri.iniciaFumadors();
        barri.iniciaEstanc();
        barri.joinFumadors();
        barri.estanc.tancarEstanc();
    }

    private void joinFumadors() throws InterruptedException {
        for(int i=0; i<fumadors.size(); i++){
            fumadors.get(i).join();
        }
    }

    private void iniciaFumadors(){
        for(int i=0; i<3; i++){
            fumadors.add(new Fumador(estanc, i));
        }
        for(Fumador fumador : fumadors){
            fumador.start();
        }
    }

    private void iniciaEstanc(){
        estanc.startEstanc();
    }
}
