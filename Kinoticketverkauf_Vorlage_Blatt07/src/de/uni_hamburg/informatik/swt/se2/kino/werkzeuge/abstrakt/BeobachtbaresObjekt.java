package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.abstrakt;

import java.util.HashSet;
import java.util.Set;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.kasse.Beobachter;

public abstract class BeobachtbaresObjekt
{
    protected Set<Beobachter> _beobachter;

    public BeobachtbaresObjekt()
    {
        _beobachter = new HashSet<Beobachter>();
    }

    //TODO: Kommentare + tests
    public void fuegeBeobachterHinzu(Beobachter beobachter)
    {
        assert beobachter != null : "Vorbedingung verletzt: beobachter ist null";
        _beobachter.add(beobachter);
    }

    //TODO: Kommentare + tests
    public void entferneBeobachter(Beobachter beobachter)
    {
        assert beobachter != null : "Vorbedingung verletzt: beobachter ist null";
        assert _beobachter.contains(beobachter) : "beobachter nicht enthalten";
        _beobachter.remove(beobachter);
    }

    //TODO: Kommentare + tests
    protected void meldeAenderung()
    {
        for (Beobachter beobachter : _beobachter)
        {
            beobachter.reagiereAufAenderungen("abstract");
        }
    }
}
