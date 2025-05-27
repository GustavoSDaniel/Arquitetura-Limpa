package dev.gustavosdaniel.infrastructure.controller;

import dev.gustavosdaniel.infrastructure.dto.request.CreateUsuarioRequest;
import dev.gustavosdaniel.infrastructure.dto.response.BaseResponse;
import dev.gustavosdaniel.infrastructure.mapper.UsuarioMapper;
import dev.gustavosdaniel.usecase.CriarUsuarioUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static dev.gustavosdaniel.infrastructure.utils.Utilites.log;
//DESSA FORMA EU CONSIGO CHAMAR O METODO DIRETO SEM PRECISAR CHAMAR O NOME DA CLASSE

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {

    private CriarUsuarioUseCase criarUsuarioUseCase;
    private UsuarioMapper usuarioMapper;

    public UsuarioController(CriarUsuarioUseCase criarUsuarioUseCase, UsuarioMapper usuarioMapper) {
        this.criarUsuarioUseCase = criarUsuarioUseCase;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping("/createUsuario")
    public BaseResponse<String> criarUsuario(@RequestBody CreateUsuarioRequest request) throws Exception {
        log.info("Inicio da criação do usuario:: UsuarioController");
        criarUsuarioUseCase.criar(usuarioMapper.paraUsuario(request), request.pin());
        log.info("Usuario criado com sucesso: UsuarioController");

        return BaseResponse.<String>builder().success(true).mensagem("Usuario criado com sucesso").build();
    }

}
