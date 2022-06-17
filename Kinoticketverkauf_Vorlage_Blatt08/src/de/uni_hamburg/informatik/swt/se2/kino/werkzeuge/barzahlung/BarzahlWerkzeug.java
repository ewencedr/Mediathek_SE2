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
    }

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
                    //TODO: Wie wissen wir, dass bezahlt wurde?
                }
            });

        _ui.getAbbrechenButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _ui.schliesseFenster();
                    //TODO: Wie wissen wir, dass NICHT bezahlt wurde?
                }
            });

        _ui.getBezahlFeld()
            .addPropertyChangeListener(new PropertyChangeListener()
            {
                //TODO: Änderung von formatted Textfield zählt auch als Aktion performed?
                @Override
                public void propertyChange(PropertyChangeEvent e)
                {
                    String val = _ui.getBezahlFeld()
                        .getText()
                        .trim()
                        .replace("€", "")
                        .replace(".", "")
                        .replace(",", "");

                    int int_val = Integer.parseInt(val);
                    System.out.println(val + " " + int_val);
                    _ui.getRueckgabeFeld()
                        .setValue((float) restpreisBerechnen(int_val) / 100);
                    reagiereAufEingabe(int_val);
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
