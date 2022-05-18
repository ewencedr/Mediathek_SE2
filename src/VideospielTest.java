import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VideospielTest
{
    private static final String KOMMENTAR = "Kommentar";
    private static final String TITEL = "Titel";
    private static final String BEZEICHNUNG = "Videospiel";
    private static final String KONSOLE = "Konsole";
    //private static final String GENRE = "GENRE";
    private Videospiel _videospiel1;
    private Videospiel _videospiel2;

    public VideospielTest()
    {
        _videospiel1 = getMedium();
        _videospiel2 = getMedium();
    }

    @Test
    public void testGetMedienBezeichnung()
    {
        String videospielBezeichnung = BEZEICHNUNG;
        assertEquals(videospielBezeichnung,
                _videospiel1.getMedienBezeichnung());
    }

    @Test
    public void testGetKonsole()
    {
        String videospielKonsole = KONSOLE;
        assertEquals(videospielKonsole, _videospiel1.getKonsole());
    }

    @Test
    public void testGetTitel()
    {
        String videospielTitel = TITEL;
        assertEquals(videospielTitel, _videospiel1.getTitel());
    }

    @Test
    public void testGetKommentar()
    {
        String videospielKommentar = KOMMENTAR;
        assertEquals(videospielKommentar, _videospiel1.getKommentar());
    }

    @Test
    public void testKonstruktor()
    {
        assertEquals(TITEL, _videospiel1.getTitel());
        assertEquals(KOMMENTAR, _videospiel1.getKommentar());
    }

    @Test
    /*
     * Von ein und dem selben Spiel kann es mehrere Exemplare geben, die von
     * unterschiedlichen Personen ausgeliehen werden können.
     */
    public void testEquals()
    {
        assertFalse(
                "Mehrere Exemplare des gleichen Spiels sollten ungleich sein",
                _videospiel1.equals(_videospiel2));
        assertTrue("Dasselbe Exemplare des gleichen Spiels sollte gleich sein",
                _videospiel1.equals(_videospiel1));
    }

    @Test
    public void testGetFormatiertenString()
    {
        assertEquals(TITEL + "\n" + KOMMENTAR,
                _videospiel1.getFormatiertenString());
    }

    private Videospiel getMedium()
    {
        return new Videospiel(TITEL, KOMMENTAR, KONSOLE);
    }

}
