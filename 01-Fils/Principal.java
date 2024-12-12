public class Principal{
    public static void main(String[] args) {
        Fil juan = new Fil("Juan");
        Fil pepe = new Fil("Pepe");
        System.out.println("Termina thread main");
        new Thread(juan).start();
        new Thread(pepe).start();
    }
}