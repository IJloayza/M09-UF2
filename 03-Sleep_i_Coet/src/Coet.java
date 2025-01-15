import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coet {
    private Motor[] engines;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public Coet(int p){
        engines = new Motor[p];
    }
    public static void main(String[] args) throws IOException{
        boolean seguir = true;
        int potence = 1;
        Coet coet = new Coet(4); 
        for(int i = 0; i < coet.engines.length; i++){
            coet.engines[i] = new Motor(String.format("Motor %d", i));
        }
        coet.arrenca();
        while (seguir) {
            String potenceStr = bf.readLine();
            potence = Integer.parseInt(potenceStr);
            coet.passaAPotencia(potence);
            if(potence == 0){
                coet.motorsOff();
                seguir = false;
            }
        }
    }

    public void passaAPotencia(int p){
        if(p < 0 && p > 10)throw new IllegalArgumentException("Potence should be between 0 - 10");
        for(int i = 0; i < engines.length; i++){
            engines[i].setPtObjective(p);
        }
    }

    private void arrenca()throws IOException{
        for(int i = 0; i < engines.length; i++){
            engines[i].start();
        }
    }

    private void motorsOff(){
        for (Motor motor : engines) {
            motor.off();
        }
    }
}
