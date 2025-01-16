public class Administracio {
    private static int num_poblacio_activa = 50;
    private static Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < poblacio_activa.length; i++){
            String name = String.format("Ciutadà-%d", i);
            poblacio_activa[i] = new Treballador(name, 25000, 20, 65);
        }

        for (int i = 0; i < poblacio_activa.length; i++) {
            poblacio_activa[i].join();
            poblacio_activa[i].start();
        }

        for (int i = 0; i < poblacio_activa.length; i++) {
            System.out.println(poblacio_activa[i].toString());
        }
    }
}
