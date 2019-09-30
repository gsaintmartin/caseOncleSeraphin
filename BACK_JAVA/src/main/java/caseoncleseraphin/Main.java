package caseoncleseraphin;

import caseoncleseraphin.exception.BadRequestException;
import javassist.NotFoundException;

public class Main {

	public static void main(String[] args) throws BadRequestException, NotFoundException {

		Lanceur lanceur = new Lanceur();
		lanceur.creationClient();
}
}