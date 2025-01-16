import java.util.Random;

public class Treballador extends Thread{
    float anualBrut;
    int ageStart;
    int ageEnd;
    int ageCurrent = 0;
    float cobrat = 0;
    float pagaMensual = anualBrut / 12;
    Random rnd = new Random();

    public Treballador(String name, float anualBrut, int ageStart, int ageEnd){
        super(name);
        this.anualBrut = anualBrut;
        this.ageStart = ageStart;
        this.ageCurrent = ageStart;
        this.ageEnd = ageEnd;
    }
    public void cobra(){
        cobrat += pagaMensual;
    }
    public void pagaImpostos(){
        cobrat -= (pagaMensual * 0.24); 
    }
    @Override
    public void run() {
        while (ageCurrent != ageEnd) {
            cobra();
            pagaImpostos();
            ageCurrent++;
        }
    }
    public float getCobrat() {
        return cobrat;
    }
    public int getEdat() {
        return ageCurrent;
    }
    @Override
    public String toString() {
        return String.format("%-10s -> edat: %d / total: %f", this.getName(), getEdat(), getCobrat());
    }
}