package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BarzahlWerkzeug
{
    private BarzahlWerkzeugUI _ui;

    private int _vorstellungspreis;
    private boolean _bezahlzustand;

    public BarzahlWerkzeug(int preis)
    {
        _vorstellungspreis = preis;
        _bezahlzustand = false;
        _ui = new BarzahlWerkzeugUI(_vorstellungspreis);

        _ui.getOkayButton()
            .setEnabled(false);
        registriereUIAktionen();
        _ui.modalTyp();
    }

    /**
     * Registriert UI aktionen
     */
    private void registriereUIAktionen()
    {
        _ui.getOkayButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _bezahlzustand = true;
                    _ui.schliesseFenster();
                    
                }
            });

        _ui.getAbbrechenButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _ui.schliesseFenster();
                 
                }
            });

        _ui.getBezahlFeld()
            .addPropertyChangeListener(new PropertyChangeListener()
            {
                @Override
                public void propertyChange(PropertyChangeEvent e)
                {
                    String val = _ui.getBezahlFeld()
                        .getText().replace(".", "");
                    int int_val = 0;
                    try
                    {
                    	boolean latch = val.matches("[1-9]+[0-9]*");
                        
                        if (latch) {
                        	 int_val= Integer.parseInt(val);
                        }
                    } catch(NumberFormatException exc)
                    {
                    
                    } finally {
                    	_ui.getRueckgabeFeld().setValue(restpreisBerechnen(int_val));
                    	_ui.getBezahlFeld().setValue(int_val);
                    	reagiereAufEingabe(int_val);
					}
                    	
                    
                }
            });
    }

    private int restpreisBerechnen(int eingabe)
    {
        return -(_vorstellungspreis - eingabe);
    }

    private boolean istBezahlbar(int eingabe)
    {
        //TODO: Auslesefunktion im UI
        if (restpreisBerechnen(eingabe) >= 0)
        {
            return true;
        }
        return false;
    }

    private void reagiereAufEingabe(int eingabe)
    {
        _ui.getOkayButton()
            .setEnabled(istBezahlbar(eingabe));
    }

    public boolean getBezahltWorden()
    {
        return _bezahlzustand;
    }
}
