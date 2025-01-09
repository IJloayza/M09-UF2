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
        while (seguir) {
            if(potence == 0)seguir = false;
            String potenceStr = bf.readLine();
            potence = Integer.parseInt(potenceStr);
            Coet coet = new Coet(potence); 
            for(int i = 0; i < coet.engines.length; i++){
                coet.engines[i] = new Motor(String.format("Motor %d", i));
            }
            coet.passaAPotencia(potence);
        }
    }

    public void passaAPotencia(int p){
        if(p < 0 && p > 10)throw new IllegalArgumentException("Potence should be between 0 - 10");
        for(Motor e: engines){
            e.setPtObjective(p);
            e.start();
        }
    }

    private void setMotors()throws IOException{
        
    }
}
