package org.example;

import java.util.LinkedList;

public class Barberia extends Thread{
    private LinkedList<Client> salaDeEspera;
    private int cadires;
    private boolean seguir = true;
    public Object condBarber = new Object();
    public static Barberia instancia = new Barberia(3);
    private Barberia(int numCadires) {
        salaDeEspera = new LinkedList<>();
        cadires = numCadires;
    }

    public static Barberia getInstancia() {
        return instancia;
    }

    public void setCadires(int cadires) {
        this.cadires = cadires;
    }

    public Client seguentClient(){
        //Retorna el siguiente cliente una vez acabado el anterior
        if(salaDeEspera.isEmpty()){
            //Si no hay ninguno retorna null
            return null;
        }else{
            Client client = salaDeEspera.getFirst();
            System.out.printf("Li toca al client Client-%s%n", client.getNom());
            salaDeEspera.removeFirst();
            return client;
        }
    }

    private void entrarClient(Client c){
        //Acepta un cliente si hay lugar en la sala
        if(salaDeEspera.size() < cadires){
            salaDeEspera.add(c);
            System.out.printf("Client-%s en espera%n", c.getNom());
            //Despierta al barbero
            synchronized (condBarber){
                condBarber.notifyAll();
            }
        }else{
            //Si no hay lugar marcha
            System.out.printf("No queden cadires, Client-%s se'n va%n", c.getNom());
        }
    }

    @Override
    public void run(){
        int num = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                //Hace entrar a 10 clientes, uno cada 0.5 segundos
                num++;
                Client client = new Client(num);
                entrarClient(client);
                delay(500);
            }
            //Espera 10 segundos
            delay(10000);
        }
    }

    public static void main(String[] args) {
        //Crear la sala con 3 sillas
        Barberia instancia = Barberia.getInstancia();
        instancia.setCadires(3);
        //Crear al barbero
        Barber barber = new Barber("Manolo");
        //Iniciar
        instancia.start();
        barber.start();
    }

    private void delay(int max) {
        try{
            sleep(max);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
