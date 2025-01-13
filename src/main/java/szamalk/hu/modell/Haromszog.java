package szamalk.hu.modell;

import java.io.Serializable;
import java.util.Objects;

//JavaBean: Egy szabványosított Java-osztály adattárolásra, amely getterekkel, setterekkel
// és paraméter nélküli konstruktorral rendelkezik, és gyakran implementálja a Serializable interfészt.
//
//POJO: Egy egyszerű, szabályoktól mentes Java-osztály, amely bármilyen célra használható,
// de jellemzően adattárolásra alkalmazzák.

public class Haromszog implements Serializable {

    private int A;
    private int B;
    private int C;

    public Haromszog(int a, int b, int c) {
        this.A=a;
        this.B=b;
        this.C=c;
        szerkeszthetosegVizsgalat();
    }


    public Haromszog(int a) {
        this(a,a,a);
    }

    public Haromszog() {
        this(1,1,1);
    }

    public int getA() {
        return A;
    }

    public int getB() {
        return B;
    }

    public int getC() {
        return C;
    }

    public void setA(int a) {
        this.A = a;
        szerkeszthetosegVizsgalat();
    }

    public void setB(int b) {
        this.B = b;
        szerkeszthetosegVizsgalat();
    }

    public void setC(int c) {
        this.C = c;
        szerkeszthetosegVizsgalat();
    }
    public void szerkeszthetosegVizsgalat(){
        if((A+B)<=C || (A+C)<=B || (C+B)<=A){
            throw new NemSzerkeszthetoExeption("Nem szerkeszthető a háromszög.");
        }

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Haromszog haromszog = (Haromszog) o;
        return A == haromszog.A && B == haromszog.B && C == haromszog.C;
    }

    //hashcode egy int, de minden objektum alapértelmezetten a memóriacímet adja vissza
    @Override
    public int hashCode() {
        return Objects.hash(A,B,C);
    }

    @Override
    public String toString() {
        return "Haromszog{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                '}';
    }
}
