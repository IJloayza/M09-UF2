import java.util.Random;

public class Assistent extends Thread {
    private Esdeveniment event;
    private Random rnd = new Random();
    public Assistent(String name, Esdeveniment event){
        super(name);
        this.event = event;
    }
    @Override
    public void run() {
        while (true) {
            if (rnd.nextFloat() > 0.5) {
                synchronized(event){
                    while (!event.disponibles()) {
                        waiting();
                    }

                    event.ferReserva(this);
                }
            }else{
                synchronized(event){
                    boolean disponible = event.cancelarReserva(this);
                    if(disponible){
                        notifyAll();
                    }
                }
            }
            delay();
        }
    }

    private void delay(){
        int delay = rnd.nextInt(1000);
        try {
            sleep(delay);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    } 

 

    private void waiting(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
