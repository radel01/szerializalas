package szamalk.hu;

import szamalk.hu.modell.Haromszog;
import szamalk.hu.modell.NemSzerkeszthetoExeption;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        new  Main();
    }

    public Main() {
        //hasznalat();
        //egyenloseg();
        szerializalas();
    }

    private void szerializalas() {
        Haromszog h1=new Haromszog();
        ObjectOutputStream objKi=null;
        try {
            objKi = new ObjectOutputStream(new FileOutputStream("egyHaromszog.ser"));
            System.out.println("ha volt kivétel, ez a sor nem jelenik meg...");
            objKi.writeObject(h1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Haromszog h2=new Haromszog(2);
        try {
            objKi = new ObjectOutputStream(new FileOutputStream("masodikHaromszog.bin"));
            objKi.writeObject(h1);
            objKi.writeObject(h2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Haromszog h3=new Haromszog(5);
        Haromszog haromszogek[]={h1, h2, h3};
        try {
            objKi = new ObjectOutputStream(new FileOutputStream("tombkHaromszog.dat"));
            objKi.writeObject(haromszogek);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void egyenloseg() {
        Haromszog h1= new Haromszog();
        System.out.println("h1: "+h1);
        System.out.println("h1 hashcode: "+h1.hashCode());

        Haromszog h2= new Haromszog();
        System.out.println("h2: "+h2);
        System.out.println("h2 hashcode: "+h2.hashCode());

        System.out.println("h1.equals(h2)"+h1.equals(h2));
    }

    void hasznalat(){
        //megfelelő  használat
        Haromszog hsz = new Haromszog(7);
        System.out.println("A háromszög létrejött.");
        System.out.println("hsz = "+hsz);
        hsz.setC(8);
        System.out.println("Módosítás után:");
        System.out.println("hsz = "+hsz);

        //hibás használat konstruktorral
        try{
            Haromszog h = new Haromszog(5, 6, 17);
        }catch (NemSzerkeszthetoExeption  e){
            System.err.println("A háromszög nem jött létre!");
            System.err.println("A hiba oka: "+ e.getMessage());
        }

        //hibás használat setterrel
        Haromszog h = new Haromszog();
        h.setC(-3);


    }
}