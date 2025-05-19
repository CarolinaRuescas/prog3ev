package org.ies.tierno.prog3ev.exceptions;

import lombok.Getter;

@Getter
public class ProfessorNotFoundException extends Exception {
  private final String nif;

  public ProfessorNotFoundException(String nif) {
    super("No existe un profesor con el nif " + nif);
    this.nif = nif;
  }
}
