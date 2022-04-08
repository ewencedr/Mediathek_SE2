import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VideospielTest
{
    {
        private static final String KOMMENTAR = "Kommentar";
        private static final String TITEL = "Titel";
        private static final String BEZEICHNUNG = "Videospiel";
        private static final String KONSOLE = "Konsole";
        private static final String GENRE = "Genre";
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
            assertEquals(videospielBezeichnung, _videospiel1.getMedienBezeichnung());
        }

        @Test
        public void testKonstruktor()
        {
            assertEquals(TITEL, _videospiel1.getTitel());
            assertEquals(KOMMENTAR, _videospiel1.getKommentar());
            assertEquals(GENRE, _videospiel1.getGenre());
            assertEquals(KONSOLE, _videospiel1.getKonsole());
        }

        @Test
        /*
         * Von ein und dem selben Spiel kann es mehrere Exemplare geben, die von
         * unterschiedlichen Personen ausgeliehen werden können.
         */
        public void testEquals()
        {
            assertFalse("Mehrere Exemplare des gleichen Videospiels sollten ungleich sein",
                    _videospiel1.equals(_videospiel2));
            assertTrue("Dasselbe Exemplare des gleichen Viedeospiels sollte gleich sein",
                    _videospiel1.equals(_videospiel2));
        }

        protected Videospiel getMedium()
        {
            return new Videospiel(TITEL, KOMMENTAR, GENRE, KONSOLE);
        }

}
