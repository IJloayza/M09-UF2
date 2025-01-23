package src;
public class Compte {
    private static Compte compte = null;
    private float saldo;

    private Compte(){
        saldo = 0;
        if ( compte != null) {
            throw new IllegalArgumentException("No es pot fer mès instàncies");
        }
    }

    public static Compte getInstance(){
        if(compte == null){
            compte = new Compte();
        }
        return compte;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo += saldo;
    }
}