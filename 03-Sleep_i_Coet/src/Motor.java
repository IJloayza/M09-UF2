import java.util.Random;

public class Motor extends Thread{
    private int ptObjective = 0;
    private int ptActual;
    private Random rnd = new Random();

    public Motor(String name){
        super(name);
    }

    public void setPtObjective(int ptObjective) {
        if(ptObjective < 0) throw new IllegalArgumentException("The objective potence should be positive");
        this.ptObjective = ptObjective;
    }

    @Override
    public void run() {
        if(ptActual < ptObjective){
            incrementPt();
        }else{
            decrementPt();
        }
         
    }

    private void incrementPt(){
        int changePotenceTime = 1000 + rnd.nextInt(1001);
        for (int i = 0; i < ptObjective; i++) {
            ptActual++;
            if(ptActual == ptObjective){
                System.out.printf("%-10s: FerRes. Objectiu: %d Actual: %d%n", this.getName(), ptObjective, ptActual);
            }else{
                System.out.printf("%-10s: Incre. Objectiu: %d Actual: %d%n", this.getName(), ptObjective, ptActual);
            }
        }  
        try {
            sleep(changePotenceTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    private void decrementPt(){
        int changePotenceTime = 1000 + rnd.nextInt(1001);
        for (int i = ptObjective; i >= 0; i--) {
            ptActual--;
            if(ptActual == 0){
                System.out.printf("%-10s: FerRes. Objectiu: %d Actual: %d%n", this.getName(), ptObjective, ptActual);
            }else{
                System.out.printf("%-10s: Decre. Objectiu: %d Actual: %d%n", this.getName(), ptObjective, ptActual);
            }
        }  
        try {
            sleep(changePotenceTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }
}
