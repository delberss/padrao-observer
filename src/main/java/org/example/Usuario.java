package org.example;

import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void inscrever(PrevisaoTempo previsao) {
        previsao.addObserver(this);
    }

    public void update(Observable previsao, Object arg1) {
        this.ultimaNotificacao = this.nome + ", a previsão do tempo mudou: " + previsao.toString();
    }
}
