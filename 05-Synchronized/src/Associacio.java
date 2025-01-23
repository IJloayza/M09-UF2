package src;
public class Associacio {
    private final int numSocis = 1000;
    private Soci[] socis = new Soci[numSocis];
    
    public Associacio(){
        for (int i = 0; i < socis.length; i++) {
            socis[i] = new Soci();
        }
    }

    private void iniciaCompteTempsSocis(){
        for (Soci soci : socis) {
            soci.start();
        }
    }

    private void esperaPeriodeSocis(){
        for (Soci soci : socis) {
            try {
                soci.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void mostraBalancComptes(){
        float saldo = socis[1].getCompte().getSaldo();
        System.out.printf("Saldo: %.2f", saldo);
    }

    public static void main(String[] args) {
        Associacio a = new Associacio();
        a.iniciaCompteTempsSocis();
        a.esperaPeriodeSocis();
        a.mostraBalancComptes();
    }
}
