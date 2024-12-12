public class Principal{
    public static void main(String[] args) {
        Fil juan = new Fil("Juan");
        Fil pepe = new Fil("Pepe");
        System.out.println("Termina thread main");
        Thread j = new Thread(juan);
        Thread p = new Thread(pepe);
        p.setPriority(9);
        j.setPriority(1);
        p.start();
        j.start();
    }
}