package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull; //hinzugefuegt
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class VormerkkarteTest
{
    private Vormerkkarte _karte;
    private Kunde _kunde;
    private Kunde _kunde2;
    private Kunde _kunde3;
    private Kunde _kunde4;
    
    private LinkedList<Kunde> _vmlist;
    
    private Medium _medium;

    public VormerkkarteTest()
    {
        _kunde  = new Kunde(new Kundennummer(123456), "ich", "du");
        _kunde2 = new Kunde(new Kundennummer(654321), "er", "sie");
        _kunde3 = new Kunde(new Kundennummer(123456), "es", "wir");
        _kunde4 = new Kunde(new Kundennummer(654321), "ihr", "sie");
        
        _vmlist = new LinkedList<Kunde>();
        _vmlist.add(_kunde);
        _vmlist.add(_kunde2);
        _vmlist.add(_kunde3);
        
        _medium = new CD("bar", "baz", "foo", 123);
        _karte = new Vormerkkarte(_medium);
    }
    
    @Test
    public void testegibErstenVormerker()
    {
    	_karte.fuegeVormerkerhinzu(_kunde);
    	assertEquals(_kunde, _karte.gibErstenVormerker());
    }

    @Test
    public void testefuegeVormerkerhinzu()
    {
    	_karte.fuegeVormerkerhinzu(_kunde);
        assertEquals(_kunde, _karte.gibErstenVormerker());
    }
    
    @Test
    public void testeentferneVormerker()
    {
    	_karte.fuegeVormerkerhinzu(_kunde);
    	_karte.fuegeVormerkerhinzu(_kunde2);
    	_karte.entferneVormerker();
        assertEquals(_kunde2, _karte.gibErstenVormerker());
        _karte.entferneVormerker();
        assertNotSame(_kunde2, _karte.gibErstenVormerker());
    }

    @Test
    public void testeKonstruktor()
    {
    	_karte.fuegeVormerkerhinzu(_kunde);
    	_karte.fuegeVormerkerhinzu(_kunde2);
    	_karte.fuegeVormerkerhinzu(_kunde3);
        assertEquals(_medium, _karte.getMedium());
        assertEquals(_vmlist, _karte.getVormerkerListe());
    }


    @Test
    public void testgibVormerker()
    {
    	_karte.fuegeVormerkerhinzu(_kunde);
    	_karte.fuegeVormerkerhinzu(_kunde2);
    	
    	assertEquals(_kunde, _karte.gibVormerker(0));
    	assertEquals(_kunde2, _karte.gibVormerker(1));
    	assertNull(_karte.gibVormerker(2));
    }
    
    @Test
    public void testistVormerkbar()
    {
    	assertTrue(_karte.istVormerkbar(_kunde));
    	
    	_karte.fuegeVormerkerhinzu(_kunde);
    	_karte.fuegeVormerkerhinzu(_kunde2);
    	
    	assertFalse(_karte.istVormerkbar(_kunde));
    	assertFalse(_karte.istVormerkbar(_kunde2));
    	
    	_karte.fuegeVormerkerhinzu(_kunde3);
    	
    	assertFalse(_karte.istVormerkbar(_kunde4));
    }

}
