import java.util.ArrayList;
import java.util.List;

public class Esdeveniment{
    private int places;
    private List<Assistent> assistents = new ArrayList<Assistent>(places);
    public Esdeveniment(int places){
        this.places = places;
    }
    public boolean ferReserva(Assistent assistent){
        if(places == 0) return false;
        assistents.add(assistent);
        places--;
        System.out.printf("%s ha fet una reserva. Places disponibles: %d%n", assistent.getName(), places);
        return true;
    }
    public boolean cancelarReserva(Assistent assistent){

        if (!assistents.remove(assistent)) {
            System.out.printf("%s no ha pogut cancel·lar una reserva inexistent. Places disponibles: %d%n", assistent.getName(), places);
            return false;
        }
        places++;
        
        System.out.printf("%s ha cancelat una reserva. Places disponibles: %d%n", assistent.getName(), places);
        return true;
    }
    public List<Assistent> getAssistants(){
        return assistents;
    }

    public boolean disponibles() { return places > 0;}
}