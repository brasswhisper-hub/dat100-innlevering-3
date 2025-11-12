package no.hvl.dat100.oppgave2;

import no.hvl.dat100.oppgave1.*;

public class Tekst extends Innlegg {

	protected String tekst;
	
	public Tekst(int id, String bruker, String dato, String tekst) {
		
		this(id, bruker, dato, 0, tekst);
	}
	
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
		
		super(id, bruker, dato, likes);
        this.tekst = tekst;
	}
	
	public String getTekst() {
		
		return tekst;
	}

	public void setTekst(String tekst) {
		
		this.tekst = tekst;
	}

	@Override
	public String toString() {
		
		return super.toString("TEKST")
		+ this.tekst + "\n";
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	@Override
	public String toHTML() {
		
		return super.toHTML("<p>" + this.tekst + "</p>");
	}
}
