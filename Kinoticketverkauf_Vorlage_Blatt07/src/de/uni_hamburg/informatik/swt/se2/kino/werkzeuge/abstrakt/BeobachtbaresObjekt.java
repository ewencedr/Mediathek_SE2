package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.abstrakt;

import java.util.HashSet;
import java.util.Set;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.kasse.Beobachter;

public abstract class BeobachtbaresObjekt
{
    private Set<Beobachter> _beobachter;

    public BeobachtbaresObjekt()
    {
        _beobachter = new HashSet<Beobachter>();
    }

    /**
     * Diese Methode fügt einen Beobachter für das beobachtbare Objekt hinzu.
     *
     * @param beobachter Neuer Beobachter für das Objekt
     */
    public void fuegeBeobachterHinzu(Beobachter beobachter)
    {
        assert beobachter != null : "Vorbedingung verletzt: beobachter ist null";
        _beobachter.add(beobachter);
    }

    /**
     * Entfernt einen Beobachter für das beobachtbare Objekt.
     * 
     * @param beobachter Zu entfernender Beobachter für das Objekt
     */
    public void entferneBeobachter(Beobachter beobachter)
    {
        assert beobachter != null : "Vorbedingung verletzt: beobachter ist null";
        assert _beobachter.contains(beobachter) : "beobachter nicht enthalten";
        _beobachter.remove(beobachter);
    }

    /**
     * Diese Methode teilt jedem Beobachter mit, dass eine Änderung im Objekt passiert ist.
     */
    protected void meldeAenderung()
    {
        for (Beobachter beobachter : _beobachter)
        {
            beobachter.reagiereAufAenderungen(this);
        }
    }
}
