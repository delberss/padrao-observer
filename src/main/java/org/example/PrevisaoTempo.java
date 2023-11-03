package org.example;

import java.util.Observable;

public class PrevisaoTempo extends Observable {

    private String clima;
    private Integer temperatura;

    public PrevisaoTempo(String clima, Integer temperatura) {
        this.clima = clima;
        this.temperatura = temperatura;
    }

    public void notificarMudancaTempo() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "PrevisaoTempo{" +
                "clima='" + clima + '\'' +
                ", temperatura=" + temperatura +
                '}';
    }
}