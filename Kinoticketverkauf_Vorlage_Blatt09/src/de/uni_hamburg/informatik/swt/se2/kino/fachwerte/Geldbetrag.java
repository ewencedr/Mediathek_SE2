package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.util.HashMap;
import java.util.Map;

public final class Geldbetrag
{
    private final int _eurocent;
    private final static Map<String, Geldbetrag> WERTEMENGE = new HashMap<>();;

    /**
     * Konstruktor der Klasse.
     * 
     * @param eurocent intbetrag des Geldes
     */
    private Geldbetrag(int eurocent)
    {
        _eurocent = eurocent;
    }

    /**
     * Fuegt einen neuen Geldbetrag hinzu.
     * 
     * @param eurocent Integer der intbetrag des Geldbetrags
     * @return Geldbetrag Objekt des neuen Geldbetrags
     */
    public static Geldbetrag select(int eurocent)
    {
        assert eurocent >= 0 : "Vorbedingung verletzt: eurocent >= 0";

        return select("" + eurocent);
    }

    /**
     * Fuegt einen neuen Geldbetrag hinzu.
     * 
     * @param eurocent String des Betrages des Geldbetrags
     * @return Geldbetrag Objekt des neuen Geldbetrags
     */
    public static Geldbetrag select(String eurocent)
    {
        assert istGueltigerGeldstring(
                eurocent) : "Vorbedingung verletzt: istGueltigerGeldstring(eurocent)";

        if (!(WERTEMENGE.containsKey(eurocent)))
        {
            Geldbetrag geldobjekt = new Geldbetrag(Integer.parseInt(eurocent));
            WERTEMENGE.put(eurocent, geldobjekt);
        }

        return WERTEMENGE.get(eurocent);
    }

    /**
     * Schaut ob dies ein gueltiger String ist.
     * @param eurocent zu ueberpruefender String
     * @return boolean ob gueltiger String oder nicht
     */
    public static boolean istGueltigerGeldstring(String eurocent) 
    {
    	String GELD_REGEX = "([0-9])*([,.]){1}([0-9]){2}";
    	
    	if (eurocent.matches(GELD_REGEX)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    /**
     * Summiert zwei Geldbetraege. 
     * @param summand1 Geldbetrag als summand
     * @param summand2 GEldbetrag als summand
     * @return Geldbetrag Objekt des Geldbetrags.
     */
    public static Geldbetrag addiere(Geldbetrag summand1, Geldbetrag summand2)
    {
    	//TODO: Assert ist addieren moeglich
    	return Geldbetrag.select(summand1.returnValue() + summand2.returnValue());
    }

    /**
     * Ueberprueft ob man summieren der zwei Geldbetraege darf. 
     * @param summand1 Geldbetrag als summand
     * @param summand2 GEldbetrag als summand
     * @return boolean True wenn summieren erlaubt ist.
     */
    public static boolean istAddierenMoeglich(Geldbetrag summand1,
            Geldbetrag summand2)
    {
    	int sum = summand1.returnValue() + summand2.returnValue();
    	if(sum >= Integer.MAX_VALUE)
    	{
    		return false;
    	}
    	else {
    		return true;
    	}
    }

    /**
     * Subtrahiert zwei Geldbetraege. 
     * 
     * @param summand1 erster Subtraktor
     * @param summand2 zweiter Subtraktor
     * @return ergebnis von der subtraktion
     */
    public static Geldbetrag subtrahiere(Geldbetrag summand1,
            Geldbetrag summand2)
    {
    	if (Geldbetrag.istGroesserGleich(summand1, summand2))
    	{
    		return Geldbetrag.select(summand1.returnValue() - summand2.returnValue());
    	}
    	else
    	{
    		return Geldbetrag.select(summand2.returnValue() - summand1.returnValue());
    	}
    	
    }
    
    /**
     * Multipliziert zwei Geldbetraege. 
     * 
     * @param summand1 erster Subtraktor
     * @param summand2 zweiter Subtraktor
     * @return ergebnis von der subtraktion
     */
    public static Geldbetrag multipliziere(Geldbetrag multiplikant, int faktor)
    {
    	return Geldbetrag.select(multiplikant.returnValue() * faktor);
    }

    /**
     * Ueberprueft ob man produkt der zwei Geldbetraege erzeugen kann. 
     * @param summand1 Geldbetrag als multiplikant
     * @param faktor zweiter multiplikant
     * @return boolean True wenn summieren erlaubt ist.
     */
    public static boolean istMultiplizierenMoeglich(Geldbetrag multiplikant, int faktor)
    {
    	int produkt = multiplikant.returnValue() * faktor;
    	if(produkt >= Integer.MAX_VALUE)
    	{
    		return false;
    	}
    	else {
    		return true;
    	}
    }

    /**
     * Schaut ob der erste Betrag groesser ist als der zweite.
     * @param betrag1 erster Betrag
     * @param betrag2 zweiter Betrag
     * @return boolean True wenn erster Betrag groesser ist
     */
    public static boolean istGroesserGleich(Geldbetrag betrag1,
            Geldbetrag betrag2)
    {
    	if (betrag1.returnValue() >= betrag2.returnValue())
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    @Override
    public String toString()
    {
    	return ""+_eurocent;
    }
    
    /**
     * Returnt int value vom Geldbetrag.
     * 
     * @return int des Geldbetrages
     */
    private int returnValue()
    {
        return _eurocent;
    }
}
