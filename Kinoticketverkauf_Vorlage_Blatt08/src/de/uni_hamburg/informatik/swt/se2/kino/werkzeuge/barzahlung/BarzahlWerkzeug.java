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

                    if (_ui.getBezahlFeld()
                        .isEditValid())
                    {
                        String val = _ui.getBezahlFeld()
                            .getValue()
                            .toString();

                        int int_val = rechnePreisUm(val);
                        _ui.getRueckgabeFeld()
                            .setValue(
                                    (float) restpreisBerechnen(int_val) / 100);
                        reagiereAufEingabe(int_val);
                    }

                }
            });
    }

    private int rechnePreisUm(String val)
    {
        int int_val = 0;
        if (val.contains("."))
        {
            String[] string_array = val.split("[.]");
            String euro = string_array[0];
            String cent = string_array[1];
            if (cent.length() > 2)
            {
                String new_cent = cent.substring(0, 2);
                int int_temp2 = Integer.parseInt(new_cent);
                char temp = cent.charAt(2);
                int temp_int = Character.getNumericValue(temp);

                if (temp_int > 4)
                {
                    System.out.println("Temp_int: " + temp_int);
                    int_temp2++;
                    cent = String.valueOf(int_temp2);
                }
                else
                {
                    cent = cent.substring(0, 2);
                }

            }
            else if (cent.length() == 1)
            {
                cent = cent + "0";
            }
            String output = euro + cent;
            int_val = Integer.parseInt(output);
        }
        else
        {
            int_val = 100 * Integer.parseInt(val);
        }
        return int_val;
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
