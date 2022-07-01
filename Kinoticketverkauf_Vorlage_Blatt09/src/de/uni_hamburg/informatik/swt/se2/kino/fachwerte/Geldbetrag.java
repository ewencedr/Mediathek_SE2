package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.util.HashMap;
import java.util.Map;

public final class Geldbetrag
{
    private final int _eurocent;
    private final static Map<String, Geldbetrag> WERTEMENGE = new HashMap<>();;

    private Geldbetrag(int eurocent)
    {
        _eurocent = eurocent;
    }

    public static Geldbetrag select(int eurocent)
    {
        assert eurocent >= 0 : "Vorbedingung verletzt: eurocent >= 0";

        return select("" + eurocent);
    }

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

    public static boolean istGueltigerGeldstring(String eurocent)
    {

    }

    public static Geldbetrag addiere(Geldbetrag summand1, Geldbetrag summand2)
    {

    }

    public static boolean istAddierenMoeglich(Geldbetrag summand1,
            Geldbetrag summand2)
    {

    }

    public static Geldbetrag subtrahiere(Geldbetrag summand1,
            Geldbetrag summand2)
    {

    }

    public static Geldbetrag multipliziere(Geldbetrag multiplikant, int faktor)
    {

    }

    public static boolean istMultiplizierenMoeglich(Geldbetrag multiplikant, int faktor)           )
    {

    }

    public static boolean istGroesserGleich(Geldbetrag betrag1,
            Geldbetrag betrag2)
    {

    }

    @Override
    public String toString()
    {

    }
}
