import java.util.Random;

public class Motor extends Thread{
    private int ptObjective = 0;
    private int ptActual = 0;
    private Random rnd = new Random();
    private boolean seguir = true;
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
                changePotence();
            }
        }
    }

    private void changePotence(){
        while(ptActual != ptObjective){
            boolean moreOrLess = ptActual > ptObjective;
            ptActual += moreOrLess? -1: 1;
            String mode = ptActual == ptObjective? "FerRes": moreOrLess? "Decre": "Incre";
            String printMessage = String.format("%-10s: %s. Objectiu: %d Actual: %d", this.getName(),
            mode,
            ptObjective, ptActual);
            System.out.println(printMessage);
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
