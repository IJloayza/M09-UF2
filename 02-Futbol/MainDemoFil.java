public class MainDemoFil {
    public static void main(String[] args) {
        // El hilo actual se llama con currentThread
        Thread current = Thread.currentThread();
        
        System.out.println("MainDemoFil.main:");
        // La prioridad predefinida 5
        System.out.println("Prioritat -> " + current.getPriority());
        // El nombre del hilo
        System.out.println("Nom -> " + current.getName());
        // Usando el metodo toString ya existente en Thread
        System.out.println("toString() -> " + current.toString());
    }
}
