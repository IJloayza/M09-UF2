package org.example;

public class Client {
    private String nom;
    public Client(int id) {
        this.nom = Integer.toString(id);
    }

    public void tallarseElCabell(){
        System.out.printf("Tallant cabell a Client-%s%n", nom);
    }

    public String getNom() {
        return nom;
    }
}
