/**
 * Ein Videospiel ist ein {@link Medium}. Zusätzlich zu den Eigenschaften eines Mediums erfasst
 * sie Informationen zur Konsole und Genre.
 * 
 * @author SE2-Team
 * @version SoSe 2019
 */
public class Videospiel implements Medium
{
    /**
     * Ein Kommentar zum Medium
     */
    private String _kommentar;

    /**
     * Der Titel des Mediums
     * 
     */
    private String _titel;

    /**
    
     * Ein Genre des Mediums
    
     */

    //private String _genre;

    /**
    
     * Die Plattform des Mediums
    
     *
    
     */

    private String _konsole;

    /**
    
     * Initialisiert eine neues Videospiel mit den gegebenen Daten.
    
     *
    
     * @param titel Der Titel des Spiels.
    
     * @param kommentar Ein Kommentar zum Spiel.
    
     * @param genre Genre des Spiels.
    
     * @param konsole Die Plattform des Spiels.
    
     *
    
     * @require titel != null
    
     * @require kommentar != null
    
     * @require genre != null
    
     * @require konsole != null
    
     *
    
     * @ensure {@link #getTitel()} == titel
    
     * @ensure {@link #getKommentar()} == kommentar
    
     * @ensure {@link #getRegisseur()} == regisseur
    
     * @ensure {@link #getLaufzeit()} == laufzeit
    
     */

    public Videospiel(String titel, String kommentar, String konsole)

    {

        assert titel != null : "Vorbedingung verletzt: titel != null";

        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";

        assert konsole != null : "Vorbedingung verletzt: konsole != null";

        //assert genre != null : "Vorbedingung verletzt: genre != null";

        _titel = titel;

        _kommentar = kommentar;

        _konsole = konsole;

    }

    public String getKonsole()

    {

        return _konsole;

    }

    //public String getGenre()

    //{
    //  return _genre;
    //}

    @Override
    public String getMedienBezeichnung()
    {
        return "Videospiel";
    }

    @Override
    public String getKommentar()
    {
        return _kommentar;
    }

    @Override
    public String getTitel()
    {
        return _titel;
    }

    @Override
    public String getFormatiertenString()
    {
        String string = getTitel() + "\n" + getKommentar();
        return string;
    }

}
