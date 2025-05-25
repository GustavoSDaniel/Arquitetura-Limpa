package dev.gustavosdaniel.infrastructure.controller;

import dev.gustavosdaniel.infrastructure.dto.request.CreateUsuarioRequest;
import dev.gustavosdaniel.infrastructure.dto.response.BaseResponse;
import dev.gustavosdaniel.infrastructure.mapper.UsuarioMapper;
import dev.gustavosdanielapplication.usecaseimpl.CriarUsuarioUseCaseImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi/usuario")
public class UsuarioController {

    private CriarUsuarioUseCaseImpl criarUsuarioUseCase;
    private UsuarioMapper usuarioMapper;

    public UsuarioController(CriarUsuarioUseCaseImpl criarUsuarioUseCase, UsuarioMapper usuarioMapper) {
        this.criarUsuarioUseCase = criarUsuarioUseCase;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping("/createUsuario")
    public BaseResponse<String> criarUsuario(@RequestBody CreateUsuarioRequest request) throws Exception {
        criarUsuarioUseCase.criar(usuarioMapper.paraUsuario(request), request.pin());
        return BaseResponse.<String>builder().success(true).mensagem("Usuario criado com sucesso").build();
    }

}
