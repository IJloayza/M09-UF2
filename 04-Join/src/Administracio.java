public class Administracio {
    private static int num_poblacio_activa = 50;
    private static Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];

    public static void main(String[] args) throws InterruptedException {
        //Initialize all the Treballadors with a name , anually payment, age to start working and retirement
        for(int i = 0; i < poblacio_activa.length; i++){
            String name = String.format("Ciutadà-%d", i);
            poblacio_activa[i] = new Treballador(name, 25000, 20, 65);
        }
        // Join all the Threads and wait to show the result
        for (int i = 0; i < poblacio_activa.length; i++) {
            poblacio_activa[i].start();
        }

        for (int i = 0; i < poblacio_activa.length; i++) {
            poblacio_activa[i].join();
        }

        //Print the las Treaballador information
        for (int i = 0; i < poblacio_activa.length; i++) {
            System.out.println(poblacio_activa[i].toString());
        }
    }
}
