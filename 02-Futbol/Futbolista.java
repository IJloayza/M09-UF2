import java.util.Random;

public class Futbolista extends Thread{
    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;
    // Se llama al constructor de Thread para nombrar el hilo
    public Futbolista(String name){
        super(name);
    }

    public static int tirades(Futbolista player){
        int gols = 0;
        Random r =new Random();
        for(int i = 0; i < NUM_TIRADES; i++){
            //El jugador realiza las tiradas con una probailidad de 50% usando un Random float
            if(r.nextFloat() <= PROBABILITAT){
                gols++;
            }
        }
        return gols;
    }

    public static void main(String[] args) {
        //Los nombres de los jugadores son creados por mi y coinciden con el numero de jugadores en total
        String[] name_players = {
            "Piqué",
            "Vinicius",
            "Torres",
            "Ramos",
            "Ronaldo",
            "Lewan",
            "Belli",
            "Arnau",
            "Aspas",
            "Messi",
            "MBapé"
        };
        // Por cada jugador realizo las tiradas posibles para cada uno
        for (int i = 0; i < NUM_JUGADORS; i++) {
            Futbolista player = new Futbolista(name_players[i]);
            int gols = tirades(player);
            // Se printea el nombre del Thread y los goles anotados en estas tiradas
            // Decidí hacer tirades un método puro
            System.out.println(String.format( "%-10s   -> %d gols", player.getName(), gols));
        }
    }
}