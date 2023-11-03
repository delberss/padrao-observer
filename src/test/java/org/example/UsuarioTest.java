package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void deveNotificarUmUsuario() {
        PrevisaoTempo previsao = new PrevisaoTempo("Ensolarado", 25);
        Usuario usuario = new Usuario("Usuario 1");
        usuario.inscrever(previsao);
        previsao.notificarMudancaTempo();
        assertEquals("Usuario 1, a previsão do tempo mudou: PrevisaoTempo{clima='Ensolarado', temperatura=25}", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarios() {
        PrevisaoTempo previsao = new PrevisaoTempo("Ensolarado", 25);
        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 2");
        usuario1.inscrever(previsao);
        usuario2.inscrever(previsao);
        previsao.notificarMudancaTempo();
        assertEquals("Usuario 1, a previsão do tempo mudou: PrevisaoTempo{clima='Ensolarado', temperatura=25}", usuario1.getUltimaNotificacao());
        assertEquals("Usuario 2, a previsão do tempo mudou: PrevisaoTempo{clima='Ensolarado', temperatura=25}", usuario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarUsuario() {
        PrevisaoTempo previsao = new PrevisaoTempo("Ensolarado", 25);
        Usuario usuario = new Usuario("Usuario 1");
        previsao.notificarMudancaTempo();
        assertEquals(null, usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarioPrevisaoChuvoso() {
        PrevisaoTempo previsaoChuvoso = new PrevisaoTempo("Chuvoso", 18);
        PrevisaoTempo previsaoEnsolarado = new PrevisaoTempo("Ensolarado", 25);

        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 2");

        usuario1.inscrever(previsaoChuvoso);
        usuario2.inscrever(previsaoEnsolarado);

        previsaoChuvoso.notificarMudancaTempo();

        assertEquals("Usuario 1, a previsão do tempo mudou: PrevisaoTempo{clima='Chuvoso', temperatura=18}", usuario1.getUltimaNotificacao());
        assertEquals(null, usuario2.getUltimaNotificacao());
    }

}