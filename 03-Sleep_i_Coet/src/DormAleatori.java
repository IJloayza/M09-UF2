import java.util.Random;

public class DormAleatori extends Thread {
    private long creationTime = 1;
    private static Random rand = new Random();
    public DormAleatori(String name){
        super(name);
        this.creationTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            
            int sleepTime = rand.nextInt(1000);
            System.out.printf("%-10s(%d)  %-5dms total %d%n", this.getName(), i, sleepTime, System.currentTimeMillis() - creationTime);
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("-- Fi de main -----------");
    }
}
