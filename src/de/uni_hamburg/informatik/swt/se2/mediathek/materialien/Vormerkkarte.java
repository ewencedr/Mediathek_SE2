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
	
	public void fuegeVormerkerhinzu(Kunde kunde) {
		assert istVormerkbar(kunde) : "Ist nicht vormerkbar";
		_vormerker.add(kunde);
	}
	
	public void entferneVormerker() {
		_vormerker.remove();
	}
	
	public Kunde gibErstenVormerker() {
		return _vormerker.peek();
	}
	
	public Kunde gibVormerker(int index) {
		if (_vormerker.size()>index) {
			return _vormerker.get(index);
		}
		return null;
	}

	
	public boolean istInQueue(Kunde kunde) {
		return _vormerker.contains(kunde);
	}
	
	public boolean istVormerkbar(Kunde kunde) {
		return _vormerker.size()<_size;
	}
	
}
