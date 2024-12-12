public class Principal{
    public static void main(String[] args) {
        try {
            Fil juan = new Fil("Juan");
            Fil pepe = new Fil("Pepe");
            System.out.println("Termina thread main");
            Thread j = new Thread(juan);
            Thread p = new Thread(pepe);
            p.setPriority(5);
            j.setPriority(5);
            
            p.start();
            j.start();

            p.join();
            j.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}