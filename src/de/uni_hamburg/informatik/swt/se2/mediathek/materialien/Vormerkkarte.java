package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.LinkedList;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

/**
 * Vormerkkarte
 * @author xewen
 *
 */
public class Vormerkkarte {

	private LinkedList<Kunde> _vormerker;
	private final Medium _medium;
	private final int _size = 3;
	
	
	public Vormerkkarte(Medium medium) {
		_medium = medium;
		_vormerker = new LinkedList<Kunde>();
	}
	
	/**
	 * fügt einen neuen Kunden der Vormerkkarte hinzu
	 * @param kunde Ein Kunde der das Medium vormerkt
	 */
	public void fuegeVormerkerhinzu(Kunde kunde) {
		assert istVormerkbar(kunde) : "Ist nicht vormerkbar";
		_vormerker.add(kunde);
	}
	
	/**
	 * Entfernt den obersten Vormerker.
	 */
	public void entferneVormerker() {
		_vormerker.remove();
	}
	
	/**
	 * Gibt den ersten Kunden auf der VormerkerListe aus.
	 * @return kunde Der erste Vormerker
	 */
	public Kunde gibErstenVormerker() {
		return _vormerker.peek();
	}
	
	/**
	 * Gibt den Vormerker an der angegebenen Stelle aus
	 * @param index Die anzugebende Stelle der Vormerkerliste
	 * @return kunde Der Kunde an der angegebenen Stelle, falls index>Listengroesse: return null.
	 */
	public Kunde gibVormerker(int index) {
		if (_vormerker.size()>index) {
			return _vormerker.get(index);
		}
		return null;
	}

	/**
	 * Testet, ob Kunde bereits in Vormerkerliste ist.
	 * @param kunde Der Kunde, der nachsieht ob er in der liste ist.
	 * @return boolean Wahrheitswert der obigen Frage.
	 */
	public boolean istInQueue(Kunde kunde) {
		return _vormerker.contains(kunde);
	}
	
	/**
	 * Testet, ob Medium vom Kunden vorgemerkt werden kann.
	 * @param kunde Der Kunde der vormerken moechte.
	 * @return boolean Wahrheitswert der obigen Frage
	 */
	public boolean istVormerkbar(Kunde kunde) {
		return _vormerker.size()<_size && !istInQueue(kunde);
	}
	
	/**
	 * Gibt Liste der Vormerker zurueck.
	 * @return LinkedList<Kunde> Die Vormerkerliste
	 */
	public LinkedList<Kunde> getVormerkerListe(){
		return _vormerker;				
	}
	
	/**
	 * Gibt das Medium zurueck fuer das die Vormerkkarte ist.
	 * @return Medium Das festgelegte Medium.
	 */
	public Medium getMedium() {
		return _medium;
	}
	
}
