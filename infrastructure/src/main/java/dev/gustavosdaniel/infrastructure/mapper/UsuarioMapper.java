package dev.gustavosdaniel.infrastructure.mapper;

import dev.gustavosdaniel.infrastructure.dto.request.CreateUsuarioRequest;
import dev.gustavosdaniel.infrastructure.entity.UsuarioEntity;
import dev.gustavosdanielcore.domain.Usuario;
import dev.gustavosdanielcore.domain.ValidandoCPF;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioEntity paraUsuarioEntity(Usuario usuario){
        return new UsuarioEntity(
                usuario.getNomeCompleto(),
                usuario.getEmail(),
                usuario.getTaxNumber().getValue(),
                usuario.getSenha(),
                usuario.getTipo(),
                usuario.getCriandoAt(),
                usuario.getAtualizandoAt()
        );
    }

    public Usuario paraUsuario(CreateUsuarioRequest request) throws Exception {
        return new Usuario(
                request.tipoUsuarioEnum(),
                new ValidandoCPF(request.numeroCPF()),
                request.senha(),
                request.senha(),
                request.email()
        );
    }
}
