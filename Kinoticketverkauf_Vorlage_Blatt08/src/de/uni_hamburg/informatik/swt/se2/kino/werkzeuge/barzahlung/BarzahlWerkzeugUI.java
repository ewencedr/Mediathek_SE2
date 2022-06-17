package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BarzahlWerkzeugUI
{

    // Die Widgets, aus denen das UI sich zusammensetzt
    private JDialog _hauptDialog;
    private JPanel _buttonPanel;
    private JFormattedTextField _restBetrag;
    private JFormattedTextField _bezahlterBetrag;
    private JFormattedTextField _zuzahlenderBetrag;
    private JButton _abbrechenButton;
    private JButton _okButton;
    private JLabel _zuzahlenLabel;
    private JLabel _bezahltLabel;
    private JLabel _restLabel;

    private NumberFormat euroFormat;

    private int _vorstellungspreis;

    /**
     * Initialisiert die UI.
     */
    public BarzahlWerkzeugUI(int preis)
    {
        euroFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode()
            .getWidth();
        int screenHeight = gd.getDisplayMode()
            .getHeight();
        _vorstellungspreis = preis;
        JPanel panel = erstelleHauptdialog();
        _hauptDialog = new JDialog();
        //_hauptDialog.setBounds(new Rectangle(500,500));
        int width = 500;
        int height = 500;
        _hauptDialog.setBounds(screenWidth / 2 - width / 2,
                screenHeight / 2 - height / 2, width, height);
        _hauptDialog.add(panel);
        //_hauptDialog.pack();
        _hauptDialog.setVisible(true);

    }

    /**
     * Erzeugt das Panel, in dem der Kinosaal mit den Sitzplätzen dargestellt
     * wird.
     */
    private JPanel erstelleHauptdialog()
    {
        JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        _zuzahlenderBetrag = new JFormattedTextField(euroFormat);
        _zuzahlenderBetrag.setValue((float) _vorstellungspreis / 100);
        _zuzahlenderBetrag.setEditable(false);

        _bezahlterBetrag = new JFormattedTextField(euroFormat);
        _bezahlterBetrag.setValue(0);

        _restBetrag = new JFormattedTextField(euroFormat);
        _restBetrag.setEditable(false);
        _restBetrag.setValue(0);

        _zuzahlenLabel = new JLabel("Zuzahlender Betrag: ");
        _bezahltLabel = new JLabel("Gezahlter Betrag: ");
        _restLabel = new JLabel("Restbetrag");

        panel.add(_zuzahlenLabel);
        panel.add(_zuzahlenderBetrag);
        panel.add(_bezahltLabel);
        panel.add(_bezahlterBetrag);
        panel.add(_restLabel);
        panel.add(_restBetrag);

        _buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        _okButton = new JButton("OK");
        _abbrechenButton = new JButton("Abbrechen");
        _buttonPanel.add(_abbrechenButton);
        _buttonPanel.add(_okButton);

        panel.add(_buttonPanel);

        return panel;
    }

    public JButton getOkayButton()
    {
        return _okButton;
    }

    public JButton getAbbrechenButton()
    {
        return _abbrechenButton;
    }

    public JFormattedTextField getRueckgabeFeld()
    {
        return _restBetrag;
    }

    public JFormattedTextField getBezahlFeld()
    {
        return _bezahlterBetrag;
    }

    public void schliesseFenster()
    {
        _hauptDialog.dispose();
    }
}
