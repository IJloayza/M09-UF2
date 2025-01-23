package src;
import java.util.Random;

public class Soci extends Thread{
    private Compte compte = Compte.getInstance();
    private final float aportacio = 10f;
    private final int esperaMax = 100;
    private final Random rnd = new Random();
    private final int maxAnys = 10;

    public Soci(){}

    @Override
    public void run() {
        for (int i = 0; i < maxAnys; i++) {
            for (int j = 0; j < 12; j++) {
                gestionaPagament(j);
                delay();
            }
        }
    }

    private void gestionaPagament(int mesNum){
        float saldo = compte.getSaldo();
        saldo += mesNum % 2 == 0? aportacio: -aportacio;
        compte.setSaldo(saldo);
    }

    private void delay(){
        int delay = rnd.nextInt(esperaMax);
        try {
            sleep(delay);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public Compte getCompte(){
        return compte;
    }
}
