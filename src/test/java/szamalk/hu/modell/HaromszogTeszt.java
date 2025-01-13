package szamalk.hu.modell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HaromszogTeszt {


    @Test
    void testKonstruktor() {
        Haromszog hsz = new Haromszog();

        Assertions.assertTrue(hsz.getA() > 0);
        Assertions.assertTrue(hsz.getB() > 0);
        Assertions.assertTrue(hsz.getC() > 0);

    }
    @Test
    void testKonstruktorParameteres() {
        Haromszog hsz = new Haromszog(2, 2, 2);

        Assertions.assertEquals(2, hsz.getA());
        Assertions.assertEquals(2, hsz.getB());
        Assertions.assertEquals(2, hsz.getC());

    }
    @Test
    void testKonstruktor1Parameteres() {
        Haromszog hsz = new Haromszog(5);

        Assertions.assertEquals(5, hsz.getA());
        Assertions.assertEquals(5, hsz.getB());
        Assertions.assertEquals(5, hsz.getC());

    }

    @Test
    void testKonstruktorNemSzerkesztheto() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Haromszog(1, 2, 3));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Haromszog(1, 3, 2));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Haromszog(2,1,3));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Haromszog(2,3,1));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Haromszog(3,2,1));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Haromszog(3,1,2));
    }

    @Test
    void tesztSetA_nemszerkesztheto() {
        Haromszog hsz= new Haromszog();
        Assertions.assertThrows(IllegalArgumentException.class, () -> hsz.setA(0));

    }
    @Test
    void tesztSetB_nemszerkesztheto() {
        Haromszog hsz= new Haromszog();
        Assertions.assertThrows(IllegalArgumentException.class, () -> hsz.setB(0));

    }
    @Test
    void tesztSetC_nemszerkesztheto() {
        Haromszog hsz= new Haromszog();
        Assertions.assertThrows(IllegalArgumentException.class, () -> hsz.setC(0));

    }



}