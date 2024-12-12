public class Fil implements Runnable {
    private String nom;
    public Fil(String nom){
        this.nom = nom;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if(i ==10){
                System.out.println("Termina el fil " + nom);
            }else{
                System.out.println(nom + " " + i);            
            }
            Thread.yield();
        }
    }


}
