package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggstabell;
    private int nesteledig;

	public Blogg() {

    }
	public Blogg(int lengde) {

        innleggstabell = new Innlegg[lengde];
        this.nesteledig = lengde;
    }

	public int getAntall() {

        return innleggstabell.length;
	}
	
	public Innlegg[] getSamling() {
		
        return innleggstabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {

		boolean funnet = false;
        int pos = 0;
        while (pos<nesteledig && !funnet) {
            if (innleggstabell[pos].erLik(innlegg)) {
                funnet = true;
            } else {
                pos++;
            }
        }
        if (funnet) {
            return pos;
        } else {
            return -1;
        }
	}

	public boolean finnes(Innlegg innlegg) {
		int pos = finnInnlegg(innlegg);
        if (pos >= 0) {
            return true;
        } else {
            return false;
        }
	}

	public boolean ledigPlass() {
		boolean ledig = false;
        for (int i = 0; i<innleggstabell.length; i++) {
            if (innleggstabell[i] == null) {
                ledig = true;
            } else {
                i++;
            }
        }
        return ledig;
	}
	
	public boolean leggTil(Innlegg innlegg) {

		boolean nyttInnlegg = finnInnlegg(innlegg) == -1;
        if ( nyttInnlegg && nesteledig < innleggstabell.length) {
            innleggstabell[nesteledig] = innlegg;
            nesteledig++;
            return true;
        } else {
            return false;
        }
	}

	public String toString() {
		return getAntall() + "\n" + innleggstabell +"\n";
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] større = new Innlegg[innleggstabell.length*2];
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		int pos = finnInnlegg(innlegg);
        if (pos >= 0) {
            nesteledig--;
            innleggstabell[pos] = innleggstabell[nesteledig];
            innleggstabell[nesteledig] = null;
            return true;
        } else {
            return false;
        }
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}