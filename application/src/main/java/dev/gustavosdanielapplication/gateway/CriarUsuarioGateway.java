package dev.gustavosdanielapplication.gateway;

import dev.gustavosdanielcore.domain.Carteira;
import dev.gustavosdanielcore.domain.TransicaoPin;
import dev.gustavosdanielcore.domain.Usuario;

public interface CriarUsuarioGateway {

    Boolean criar(Usuario usuario, Carteira carteira);
}
