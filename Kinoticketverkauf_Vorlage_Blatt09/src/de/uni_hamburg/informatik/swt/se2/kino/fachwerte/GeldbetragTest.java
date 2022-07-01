package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeldbetragTest
{

    @Test
    public void testeAddiereSubtrahiere()
    {
        Geldbetrag betrag1 = Geldbetrag.select(600);
        Geldbetrag betrag2 = Geldbetrag.select(3);
        Geldbetrag betrag3 = Geldbetrag.select(603);
        Geldbetrag betrag4 = Geldbetrag.select(Integer.MAX_VALUE);

        assertEquals(betrag3, Geldbetrag.addiere(betrag1, betrag2));
        assertFalse(Geldbetrag.istAddierenMoeglich(betrag2, betrag4));
        assertTrue(Geldbetrag.istAddierenMoeglich(betrag2, betrag3));

    }

    @Test
    public void testeSubtrahiere()
    {
        Geldbetrag betrag1 = Geldbetrag.select(600);
        Geldbetrag betrag2 = Geldbetrag.select(3);
        Geldbetrag betrag3 = Geldbetrag.select(603);
        Geldbetrag betrag4 = Geldbetrag.select(597);
        Geldbetrag betrag5 = Geldbetrag.select(0);

        assertEquals(betrag4, Geldbetrag.subtrahiere(betrag2, betrag1));
        assertEquals(betrag1, Geldbetrag.subtrahiere(betrag2, betrag3));
        assertEquals(betrag5, Geldbetrag.subtrahiere(betrag5, betrag5));
        assertEquals(betrag1, Geldbetrag.subtrahiere(betrag1, betrag5));
    }

    @Test
    public void testeMultipliziere()
    {
        Geldbetrag betrag1 = Geldbetrag.select(600);
        Geldbetrag betrag2 = Geldbetrag.select(3);
        Geldbetrag betrag3 = Geldbetrag.select(1800);
        Geldbetrag betrag4 = Geldbetrag.select(12);
        Geldbetrag betrag5 = Geldbetrag.select(Integer.MAX_VALUE);
        Geldbetrag betrag6 = Geldbetrag.select(0);

        assertEquals(betrag3, Geldbetrag.multipliziere(betrag1, 3));
        assertEquals(betrag4, Geldbetrag.multipliziere(betrag2, 4));
        assertEquals(betrag6, Geldbetrag.multipliziere(betrag2, 0));

        assertFalse(Geldbetrag.istMultiplizierenMoeglich(betrag5, 2));
        assertTrue(Geldbetrag.istMultiplizierenMoeglich(betrag2, 20));
    }

    @Test
    public void testeSelectString()
    {
        Geldbetrag betrag1 = Geldbetrag.select(200);
        Geldbetrag betrag2 = Geldbetrag.select("200");
        Geldbetrag betrag3 = Geldbetrag.select(317);

        assertEquals(betrag1, betrag2);
        assertEquals("317", betrag3.toString());
        assertNotEquals(betrag3, betrag2);

        assertFalse(Geldbetrag.istGueltigerGeldstring("20,26"));
        assertFalse(Geldbetrag.istGueltigerGeldstring("45,00"));
        assertFalse(Geldbetrag.istGueltigerGeldstring("10,ab"));
        assertFalse(Geldbetrag.istGueltigerGeldstring("20ab"));
        assertFalse(Geldbetrag.istGueltigerGeldstring("20.26"));
        assertFalse(Geldbetrag.istGueltigerGeldstring("20,2605"));
        assertFalse(Geldbetrag.istGueltigerGeldstring("2.026"));
        assertTrue(Geldbetrag.istGueltigerGeldstring("2050"));
    }
}
