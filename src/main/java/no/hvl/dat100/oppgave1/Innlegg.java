package no.hvl.dat100.oppgave1;

public abstract class Innlegg {
	
	protected int id;
    private String bruker;
    protected String dato;
    protected int likes;

	public Innlegg(int id, String bruker, String dato) {

		this(id,bruker,dato,0);
	}

	public Innlegg(int id, String bruker, String dato, int likes) {

		this.id = id;
        this.bruker = bruker;
        this.dato = dato;
        this.likes = likes;
	}
	
	public String getBruker() {
		
		return this.bruker;
	}

	public void setBruker(String bruker) {

        this.bruker = bruker;
	}

	public String getDato() {
		
		return this.dato;
	}

	public void setDato(String dato) {

        this.dato = dato;
	}

	public int getId() {

        return this.id;
	}

    public void setId(int id) {
        
		this.id = id;
    }

	public int getLikes() {

        return this.likes;
	}
	
	public void doLike () {

        this.likes++;
	}
	
	public boolean erLik(Innlegg innlegg) {

		return innlegg.getId() == this.id;
	}
	
	// eg ser kje ka som blir overrida her? -LBB
	@Override
	public String toString() {
		
		return this.toString("");
	}
	
	protected String toString(String prefix) {
		
		return prefix
		+ this.id + "\n"
		+ this.bruker + "\n" 
		+ this.dato + "\n" 
		+ this.likes + "\n";
	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		return this.toHTML("");
	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	protected  String toHTML(String innerHTML) {
		
		return "<div id=\""
		+ this.id
		+ "\" user=\""
		+ this.bruker
		+ "\" dato=\""
		+ this.dato
		+ "\" likes=\""
		+ this.likes
		+ "\">"
		+ innerHTML
		+ "</div";
	}
}
