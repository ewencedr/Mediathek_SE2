package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.kasse;

/**
 * Interface eines Beobachters, der bei Änderungen der Vorstellung und des Datums reagiert.
 * 
 * @author Schrödingers Frauen
 * @version SoSe 2022
 */

public interface Beobachter
{
    /**
     * Dieser Operation wird bei Aenderungen des beobachteten Werkzeugs aufgerufen.
     * 
     * @param herkunft des Methodenaufrufs
     */
    public void reagiereAufAenderungen(Object herkunft);
}
