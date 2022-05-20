package de.uni_hamburg.informatik.swt.se2.mediathek.services.verleih;

import java.util.List;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Datum;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.Kunde;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.Verleihkarte;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.Vormerkkarte;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;
import de.uni_hamburg.informatik.swt.se2.mediathek.services.ObservableService;

/**
 * Der VerleihService erlaubt es, Medien auszuleihen und zurückzugeben.
 * 
 * Für jedes ausgeliehene Medium wird eine neue Verleihkarte angelegt. Wird das
 * Medium wieder zurückgegeben, so wird diese Verleihkarte wieder gelöscht.
 * 
 * VerleihService ist ein ObservableService, als solcher bietet er die
 * Möglichkeit über Verleihvorgänge zu informieren. Beobachter müssen das
 * Interface ServiceObserver implementieren.
 * 
 * @author SE2-Team
 * @version SoSe 2021
 */
public interface VerleihService extends ObservableService
{
    /**
     * Verleiht Medien an einen Kunden. Dabei wird für jedes Medium eine neue
     * Verleihkarte angelegt.
     * 
     * @param kunde Ein Kunde, an den ein Medium verliehen werden soll
     * @param medien Die Medien, die verliehen werden sollen
     * @param ausleihDatum Der erste Ausleihtag
     * 
     * @throws ProtokollierException Wenn beim Protokollieren des
     *             Verleihvorgangs ein Fehler auftritt.
     * 
     * @require kundeImBestand(kunde)
     * @require sindAlleNichtVerliehen(medien)
     * @require ausleihDatum != null
     * 
     * @ensure sindAlleVerliehenAn(kunde, medien)
     */
    void verleiheAn(Kunde kunde, List<Medium> medien, Datum ausleihDatum)
            throws ProtokollierException;

    /**
     * Prüft ob die ausgewählten Medium für den Kunde ausleihbar sind
     * 
     * @param kunde Der Kunde für den geprüft werden soll
     * @param medien Die medien
     * 
     * 
     * @return true, wenn das Entleihen für diesen Kunden möglich ist, sonst
     *         false
     * 
     * @require kundeImBestand(kunde)
     * @require medienImBestand(medien)
     */
    boolean istVerleihenMoeglich(Kunde kunde, List<Medium> medien);

    /**
     * Liefert den Entleiher des angegebenen Mediums.
     * 
     * @param medium Das Medium.
     * 
     * @return Den Entleiher des Mediums.
     * 
     * @require istVerliehen(medium)
     * 
     * @ensure result != null
     */
    Kunde getEntleiherFuer(Medium medium);

    /**
     * Liefert alle Medien, die von dem gegebenen Kunden ausgeliehen sind.
     * 
     * @param kunde Der Kunde.
     * @return Alle Medien, die von dem gegebenen Kunden ausgeliehen sind.
     *         Liefert eine leere Liste, wenn der Kunde aktuell nichts
     *         ausgeliehen hat.
     * 
     * @require kundeImBestand(kunde)
     * 
     * @ensure result != null
     */
    List<Medium> getAusgelieheneMedienFuer(Kunde kunde);

    /**
     * @return Eine Listenkopie aller Verleihkarten. Für jedes ausgeliehene
     *         Medium existiert eine Verleihkarte. Ist kein Medium verliehen,
     *         wird eine leere Liste zurückgegeben.
     * 
     * @ensure result != null
     */
    List<Verleihkarte> getVerleihkarten();

    /**
     * Nimmt zuvor ausgeliehene Medien zurück. Die entsprechenden Verleihkarten
     * werden gelöscht.
     * 
     * 
     * @param medien Die Medien.
     * @param rueckgabeDatum Das Rückgabedatum.
     * 
     * @require sindAlleVerliehen(medien)
     * @require rueckgabeDatum != null
     * 
     * @ensure sindAlleNichtVerliehen(medien)
     */
    void nimmZurueck(List<Medium> medien, Datum rueckgabeDatum)
            throws ProtokollierException;

    /**
     * Prüft ob das angegebene Medium verliehen ist.
     * 
     * @param medium Ein Medium, für das geprüft werden soll ob es verliehen
     *            ist.
     * @return true, wenn das gegebene medium verliehen ist, sonst false.
     * 
     * @require mediumImBestand(medium)
     */
    boolean istVerliehen(Medium medium);

    /**
     * Prüft ob alle angegebenen Medien nicht verliehen sind.
     * 
     * @param medien Eine Liste von Medien.
     * @return true, wenn alle gegebenen Medien nicht verliehen sind, sonst
     *         false.
     * 
     * @require medienImBestand(medien)
     */
    boolean sindAlleNichtVerliehen(List<Medium> medien);

    /**
     * Prüft ob alle angegebenen Medien verliehen sind.
     * 
     * @param medien Eine Liste von Medien.
     * 
     * @return true, wenn alle gegebenen Medien verliehen sind, sonst false.
     * 
     * @require medienImBestand(medien)
     */
    boolean sindAlleVerliehen(List<Medium> medien);

    /**
     * Prüft, ob alle angegebenen Medien an einen bestimmten Kunden verliehen
     * sind.
     * 
     * @param kunde Ein Kunde
     * @param medien Eine Liste von Medien
     * @return true, wenn alle Medien an den Kunden verliehen sind, sonst false.
     * 
     * @require kundeImBestand(kunde)
     * @require medienImBestand(medien)
     */
    boolean sindAlleVerliehenAn(Kunde kunde, List<Medium> medien);

    /**
     * Prüft, ob ein Medium an einen bestimmten Kunden verliehen ist.
     * 
     * @param kunde Ein Kunde
     * @param medium Ein Medium
     * @return true, wenn das Medium an den Kunden verliehen ist, sonst false.
     * 
     * @require kundeImBestand(kunde)
     * @require mediumImBestand(medium)
     */
    boolean istVerliehenAn(Kunde kunde, Medium medium);

    /**
     * Prüft ob der angebene Kunde existiert. Ein Kunde existiert, wenn er im
     * Kundenstamm enthalten ist.
     * 
     * @param kunde Ein Kunde.
     * @return true wenn der Kunde existiert, sonst false.
     * 
     * @require kunde != null
     */
    boolean kundeImBestand(Kunde kunde);

    /**
     * Prüft ob das angebene Medium existiert. Ein Medium existiert, wenn es im
     * Medienbestand enthalten ist.
     * 
     * @param medium Ein Medium.
     * @return true wenn das Medium existiert, sonst false.
     * 
     * @require medium != null
     */
    boolean mediumImBestand(Medium medium);

    /**
     * Prüft ob die angebenen Medien existierien. Ein Medium existiert, wenn es
     * im Medienbestand enthalten ist.
     * 
     * @param medien Eine Liste von Medien.
     * @return true wenn die Medien existieren, sonst false.
     * 
     * @require medien != null
     * @require !medien.isEmpty()
     */
    boolean medienImBestand(List<Medium> medien);

    /**
     * Gibt alle Verleihkarten für den angegebenen Kunden zurück.
     * 
     * @param kunde Ein Kunde.
     * @return Alle Verleihkarten des angebenen Kunden. Eine leere Liste, wenn
     *         der Kunde nichts entliehen hat.
     * 
     * @require kundeImBestand(kunde)
     * 
     * @ensure result != null
     */
    List<Verleihkarte> getVerleihkartenFuer(Kunde kunde);

    /**
     * Gibt die Verleihkarte für das angegebene Medium zurück, oder null wenn
     * das Medium nicht verliehen ist.
     * 
     * @param medium Ein Medium.
     * @return Die Verleihkarte für das angegebene Medium.
     * 
     * @require istVerliehen(medium)
     * 
     * @ensure (result != null)
     */
    Verleihkarte getVerleihkarteFuer(Medium medium);

    /**
     * Gibt zurück, ob alle ausgewählten Medien von dem Kunden vorgemerkt sind.
     * 
     * @param kunde Der Kunde
     * @param medien Die Medien
     * @return true, wenn alle Medien vom Kunden vorgemerkt sind, sonst false
     * 
     * @require kundeImBestand(kunde)
     * @require medienImBestand(medien)
     */
    boolean sindAlleVorgemerkt(Kunde kunde, List<Medium> medien);

    /**
     * Merkt die ausgewählten Medien für den Kunden vor.
     * @param kunde Der Kunde der die Medien vormerken moechte.
     * @param medien Die Liste der vorzumerkenden Medien
     * 
     * @require kundeImBestand(kunde)
     * @require medienImBestand(medien)
     * @require istVormerkenMoeglich(kunde, medien)
     */
    void merkeVor(Kunde kunde, List<Medium> medien);

    /**
     * Gibt den vormerkzustand einer Liste von Medien zurück. True,
     * wenn alle Medien vom Kunden vorgemerkt werden koennen, False sonst.
     * @param kunde Ein Kunde.
     * @param medien Eine Liste von M<edien
     * @return Wahrheitswert
     * 
     * @require kundeImBestand(kunde)
     * @require medienImBestand(medien)
     */
    boolean istVormerkenMoeglich(Kunde kunde, List<Medium> medien);

    /**
     * Testet, ob bereits eine Vormerkkarte zu medium existiert.
     * Gibt Wahrheitswert über Zustand zurück.
     * @param medium Ein Medium
     * @return Wahrheitswert ob Vormerkkarte existiert.
     * 
     * @require mediumImBestand(medium)
     */
    boolean istVormerkkarteVorhanden(Medium medium);

    /**
     * Gibt Vormerkkarten zu Medien, erstellt neue falls noch keine existiert
     * 
     * @param medien Eine Liste an  Medien
     * @return Die Liste Vormerkkarten zu den Medien
     * 
     * @require medienImBestand(medien)
     */
    List<Vormerkkarte> gibVormerkkarten(List<Medium> medien);

    /**
     * Gibt Vormerkkarte zu Medium, erstellt neue falls noch keine existiert
     * @param medium Ein Medium
     * @return Vormerkkarte zu dem Medium
     * 
     * @require mediumImBestand(medium)
     */
    Vormerkkarte gibVormerkkarte(Medium medium);


}
