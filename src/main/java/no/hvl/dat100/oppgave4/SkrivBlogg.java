package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
        String melding = "alt ok";
        try (PrintWriter skriver = new PrintWriter(filnavn)) {
            skriver.println(samling.toString());
            System.out.println("Tekst lagt til filen");
        }
        catch (FileNotFoundException e) {
            melding = "fil ikke funnet";
        }
        return true;
	}
}
