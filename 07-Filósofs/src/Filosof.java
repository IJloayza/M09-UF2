import java.util.Random;

public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra; 
    private int gana = 0;
    private Random rnd = new Random();
    public Filosof(String name, Forquilla forquillaEsquerra, Forquilla forquillaDreta){
        super(name);     
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
    }

    public void menjar(){
        boolean seguir = true;
        while (seguir) {
            if(!forquillaEsquerra.isUsed()){
                cogerForquilla(forquillaEsquerra);
                if(!forquillaDreta.isUsed()){
                    cogerForquilla(forquillaDreta);
                    System.out.printf("Filósof: %s menja%n", getName());
                    gana = 0;
                    delay(1000, 2000);
                    deixarForquilla(forquillaDreta);
                    deixarForquilla(forquillaEsquerra);
                    System.out.printf("Filósof: %s ha acabat de menjar%n", getName());
                    break;
                }else{
                    deixarForquilla(forquillaEsquerra);
                    gana++;
                    System.out.printf("Filósof: %s deixa l'esquerra (%d) i espera (dreta ocupada)%n", getName(), forquillaEsquerra.getNum());
                    System.out.printf("Filósof: %s gana = %d%n", getName(), gana);
                    delay(500, 1000);
                }
            }else {
                gana++;
                System.out.printf("Filósof: %s gana = %d%n", getName(), gana);
                delay(500, 1000);
            }
    
            
        }
    }

    public void pensar(){
        System.out.printf("Filósof: %s pensant%n", getName());
        delay(1000, 2000);
    }

    @Override
    public void run() {
        while (true) {
            menjar();
            pensar();
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

    private void cogerForquilla(Forquilla fork){
        fork.setUsed(true);
    }

    private void deixarForquilla(Forquilla fork){
        fork.setUsed(false);
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }

    public int getGana() {
        return gana;
    }

    public void setGana(int gana) {
        this.gana = gana;
    }

    public Random getRnd() {
        return rnd;
    }

    public void setRnd(Random rnd) {
        this.rnd = rnd;
    }
}
