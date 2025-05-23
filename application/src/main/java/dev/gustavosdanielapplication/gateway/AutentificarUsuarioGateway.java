package dev.gustavosdanielapplication.gateway;

public interface AutentificarUsuarioGateway {

    Boolean autenticar(String nomeUsuario, String senha);
}
