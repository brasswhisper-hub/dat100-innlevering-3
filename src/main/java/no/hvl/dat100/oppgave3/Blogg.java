package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggstabell;
    private int nesteledig;

	public Blogg() {

        this(20);
    }
	public Blogg(int lengde) {

        this.innleggstabell = new Innlegg[lengde];
        this.nesteledig = 0;
    }

	public int getAntall() {

        return innleggstabell.length;
	}
	
	public Innlegg[] getSamling() {
		
        return innleggstabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {

        for (int i = 0; i < this.nesteledig; i++) {
            if(this.innleggstabell[i].erLik(innlegg)) {
                return i;
            }
        }
        return -1;
	}

	public boolean finnes(Innlegg innlegg) {

		return -1 != finnInnlegg(innlegg);
	}

	public boolean ledigPlass() {

		return this.nesteledig < this.innleggstabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {

        if (!this.ledigPlass()) {
            return false;
        }

        try {
            this.innleggstabell[this.nesteledig] = innlegg;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
	}

	public String toString() {
		String melding = "";

        if (this.nesteledig < 1) {
            return melding;
        }

        for (Innlegg innlegg : this.innleggstabell) {
            melding += innlegg.toString();
        }
        
        return getAntall() + "\n"
        + melding +"\n";
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {

        Innlegg[] større = new Innlegg[innleggstabell.length * 2];

        for (int i = 0; i < this.nesteledig; i++) {
            større[i] = this.innleggstabell[i];
        }

        this.innleggstabell = større;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

        if (this.finnes(innlegg)) {
            return false;
        }

        if (!this.ledigPlass()) {
            this.utvid();
        }
		
        return this.leggTilUtvid(innlegg);
	}
	
	public boolean slett(Innlegg innlegg) {
		
        int pos = this.finnInnlegg(innlegg);

		if (pos == -1) { //sjekker om den ikke finnes.
            return false;
        }

        try {
            this.innleggstabell[pos] = null;
            this.nesteledig--;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
	}
	
	public int[] search(String keyword) {
        
		throw new UnsupportedOperationException(TODO.method());
	}
}