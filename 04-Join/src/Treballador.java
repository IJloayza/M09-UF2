import java.util.Random;

public class Treballador extends Thread{
    //Attributes for Teballador 
    float anualBrut;
    int ageStart;
    int ageEnd;
    int ageCurrent = 0;
    float cobrat = 0;
    float pagaMensual;
    Random rnd = new Random();

    public Treballador(String name, float anualBrut, int ageStart, int ageEnd){
        super(name);
        this.anualBrut = anualBrut;
        this.ageStart = ageStart;
        this.ageCurrent = ageStart;
        this.ageEnd = ageEnd;
        this.pagaMensual = anualBrut / 12;
    }
    public void cobra(){
        cobrat += pagaMensual;
    }
    public void pagaImpostos(){
        //24% of taxes in the payment
        cobrat -= (pagaMensual * 0.24); 
    }
    @Override
    public void run() {
        //While the age is not enough for retirement the Treballador gets paid 12 times a year and pay taxes for each payment till retirement
        while (ageCurrent != ageEnd) {
            for (int i = 0; i < 12; i++) {
                cobra();
                delay();
                pagaImpostos();
                delay();
            }
            ageCurrent++;
        }
    }
    public float getCobrat() {
        return cobrat;
    }
    public int getEdat() {
        return ageCurrent;
    }
    private void delay(){
        int delay = rnd.nextInt(10);
        try {
            sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }
    @Override
    public String toString() {
        return String.format("%-10s -> edat: %d / total: %f", this.getName(), getEdat(), getCobrat());
    }
}