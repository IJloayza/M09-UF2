import java.util.ArrayList;
import java.util.List;

public class Organitzador {
    private static final int numAsisstents = 10;
    public static void main(String[] args) {
        Esdeveniment event = new Esdeveniment(5);
        List<Assistent> assistents = new ArrayList<>(numAsisstents);
        iniciaAssistents(assistents, event);
        startAssistent(assistents);
    }
    private static void iniciaAssistents(List<Assistent> assistents, Esdeveniment event){
        for (int i = 0; i < 10; i++) {
            assistents.add(new Assistent(String.format("Assitent-%d", i), event));
        }
    }
    private static void startAssistent(List<Assistent> assistents){
        for (int i = 0; i < numAsisstents; i++) {
            assistents.get(i).start();
        }
    }
}
