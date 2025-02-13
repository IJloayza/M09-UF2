public class Forquilla {
    private int num;
    private boolean used = false;
    public Forquilla(int num, boolean used){
        this.num = num;
        this.used = used;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public boolean isUsed() {
        return used;
    }
    public void setUsed(boolean used) {
        this.used = used;
    }
}
