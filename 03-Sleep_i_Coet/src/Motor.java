import java.util.Random;

public class Motor extends Thread{
    private int ptObjective = 0;
    private int ptActual = 0;
    private Random rnd = new Random();
    private volatile boolean seguir = true;
    public Motor(String name){
        super(name);
    }

    public void setPtObjective(int ptObjective) {
        if(ptObjective < 0) throw new IllegalArgumentException("The objective potence should be positive");
        this.ptObjective = ptObjective;
    }

    public void off(){
        seguir = false;
    }

    @Override
    public void run() {
        while (seguir) {
            if(ptActual != ptObjective){
                if(ptActual < ptObjective){
                    incrementPt();
                }else if(ptActual > ptObjective){
                    decrementPt();
                }else{
                    break;
                }
            }
        }
    }

    private void incrementPt(){
        for (int i = ptActual; i < ptObjective; i++) {
            ptActual++;
            if(ptActual == ptObjective){
                System.out.printf("%-10s: FerRes. Objectiu: %d Actual: %d%n", this.getName(), ptObjective, ptActual);
            }else{
                System.out.printf("%-10s: Incre. Objectiu: %d Actual: %d%n", this.getName(), ptObjective, ptActual);
            }
            delay();
        }  
        
    }

    private void decrementPt(){
        for (int i = ptActual; i >= ptObjective; i--) {
            if(ptActual == ptObjective){
                System.out.printf("%-10s: FerRes. Objectiu: %d Actual: %d%n", this.getName(), ptObjective, ptActual);
            }else{
                System.out.printf("%-10s: Decre. Objectiu: %d Actual: %d%n", this.getName(), ptObjective, ptActual);
            }
            ptActual--;
            delay();
        } 
    }

    private void delay(){
        int changePotenceTime = 1000 + rnd.nextInt(1001);
        try {
            sleep(changePotenceTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }
}
