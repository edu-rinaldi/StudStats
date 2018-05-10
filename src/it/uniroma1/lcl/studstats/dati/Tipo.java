package it.uniroma1.lcl.studstats.dati;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface Tipo {
    String tipo();
}
