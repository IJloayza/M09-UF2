package org.example;

import java.util.Random;

public class Barber extends Thread{
    private Barberia barberia = Barberia.instancia;
    private Object condBarber = barberia.condBarber;
    private String nom;
    private boolean seguir = true;
    private Random rnd = new Random();
    public Barber(String nom){
        super(nom);
    }

    @Override
    public void run() {
        while(seguir){
            //Si el metodo seguent client devuelve algo talla el cabell
            Client client = barberia.seguentClient();
            if(client == null){
                //Sino duerme
                System.out.println("Barber Manolo s'en va a dormir");
                synchronized( condBarber ){
                    if( condBarber != null ) {
                        try {
                            condBarber.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }else{
                client.tallarseElCabell();
                sleeping(100);
            }
        }
    }

    private void sleeping(int plus) {
        try{
            sleep(900 + plus);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
