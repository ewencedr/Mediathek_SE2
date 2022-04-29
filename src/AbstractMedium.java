
public abstract class AbstractMedium implements Medium {

	
	/**
     * Der Kommentar des Mediums
     * 
     */
	protected String _kommentar;

    /**
     * Der Titel des Mediums
     * 
     */
    protected String _titel;

    /**
     * Die Medienbezeichnung des Mediums
     * 
     */
    protected String _medienbezeichnung;
    
    protected int _mietgebuehr;
	
    public AbstractMedium(String titel, String kommentar) {
    	assert titel != null : "Vorbedingung verletzt: titel != null";
        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
    	_kommentar = kommentar;
    	_titel = titel;
    	_mietgebuehr = 300;
    }
    
	@Override
	public String getFormatiertenString() {
		return getMedienBezeichnung() + ":\n" + "    " + "Titel: " + _titel
                + "\n" + "    " + "Kommentar: " + _kommentar+ "\n";
	}

	@Override
	public String getKommentar() {
		return _kommentar;
	}

	@Override
	public void setKommentar(String kommentar) {
		assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
	    _kommentar = kommentar;

	}

	@Override
	public String getMedienBezeichnung() {
		return _medienbezeichnung;
	}

	@Override
	public String getTitel() {
		return _titel;
	}

	@Override
	public void setTitel(String titel) {
		assert titel != null : "Vorbedingung verletzt: titel != null";
	    _titel = titel;
	}
	
	
	@Override
	public Geldbetrag berechneMietgebuehr(int mietTage)
	{
		assert mietTage > 0 : "Miettage negativ";
		return new Geldbetrag(mietTage * _mietgebuehr);
	}

}


