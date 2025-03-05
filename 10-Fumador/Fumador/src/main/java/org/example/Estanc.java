package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc {
    private List<Fumador> fumadors;
    private List<Llumi> llumins;
    private List<Tabac> tabacs;
    private List<Paper> papers;
    private Random rnd = new Random();
    private boolean seguir = true;
    private int fumadorsFinalitzats = 0;

    public Estanc() {
        this.fumadors = new ArrayList<>();
        this.llumins = new ArrayList<>();
        this.tabacs = new ArrayList<>();
        this.papers = new ArrayList<>();
    }

    public void startEstanc() {
        System.out.println("Estanc obert");
        while(seguir){
            nouSubministrament();
            delay(500, 1000);
        }
    }

    private void nouSubministrament(){
        int choice = rnd.nextInt(3);
        switch (choice){
            case 0:
                addLlumins();
                break;
            case 1:
                addPaper();
                break;
            case 2:
                addTabac();
                break;
            default:
                break;
        }
        delay(500, 1000);
    }

    private synchronized void addTabac(){
        System.out.println("Afegint tabac");
        tabacs.add(new Tabac());
        notifyAll();
    }

    private synchronized void addLlumins(){
        System.out.println("Afegint llumins");
        llumins.add(new Llumi());
        notifyAll();
    }

    private synchronized void addPaper(){
        System.out.println("Afegint paper");
        papers.add(new Paper());
        notifyAll();
    }

    public synchronized Tabac venTabac(){
        if(tabacs.size() > 0){
            Tabac tabac = tabacs.get(0);
            tabacs.remove(0);
            return tabac;
        }
        return null;
    }

    public synchronized Paper venPaper(){
        if(papers.size() > 0){
            Paper paper = papers.get(0);
            papers.remove(0);
            return paper;
        }
        return null;
    }

    public synchronized Llumi venLlumi(){
        if(llumins.size() > 0){
            Llumi llumi = llumins.get(0);
            llumins.remove(0);
            return llumi;
        }
        return null;
    }

    public void tancarEstanc(){
        seguir = false;
    }

    public synchronized void notificarFumadorFinalitzat() {
        fumadorsFinalitzats++;
        if (fumadorsFinalitzats >= 3) {
            System.out.println("Tots els fumadors han acabat de fumar");
            seguir = false;
        }
    }

    private void delay(int init, int end){
        int delay = rnd.nextInt(init, end);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
