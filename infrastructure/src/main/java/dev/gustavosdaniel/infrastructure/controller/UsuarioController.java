package dev.gustavosdaniel.infrastructure.controller;

import dev.gustavosdaniel.infrastructure.dto.request.CreateUsuarioRequest;
import dev.gustavosdaniel.infrastructure.dto.response.BaseResponse;
import dev.gustavosdaniel.infrastructure.mapper.UsuarioMapper;
import dev.gustavosdaniel.usecase.AvaliarEmailUseCase;
import dev.gustavosdaniel.usecase.CriarUsuarioUseCase;
import dev.gustavosdaniel.usecase.ValidarCPFUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static dev.gustavosdaniel.infrastructure.utils.Utilites.log;
//DESSA FORMA EU CONSIGO CHAMAR O METODO DIRETO SEM PRECISAR CHAMAR O NOME DA CLASSE

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {

    final private CriarUsuarioUseCase criarUsuarioUseCase;
    final private UsuarioMapper usuarioMapper;
    final private AvaliarEmailUseCase avaliarEmailUseCase;
    final private ValidarCPFUseCase validarCPFUseCase;

    public UsuarioController(CriarUsuarioUseCase criarUsuarioUseCase, UsuarioMapper usuarioMapper, AvaliarEmailUseCase avaliarEmailUseCase, ValidarCPFUseCase validarCPFUseCase) {
        this.criarUsuarioUseCase = criarUsuarioUseCase;
        this.usuarioMapper = usuarioMapper;
        this.avaliarEmailUseCase = avaliarEmailUseCase;
        this.validarCPFUseCase = validarCPFUseCase;
    }

    @PostMapping("/createUsuario")
    public BaseResponse<String> criarUsuario(@RequestBody CreateUsuarioRequest request) throws Exception {
        log.info("Inicio da criação do usuario:: UsuarioController");
        avaliarEmailUseCase.emailValidado(request.email());
        validarCPFUseCase.validarCPF(request.numeroCPF());
        criarUsuarioUseCase.criar(usuarioMapper.paraUsuario(request), request.pin());
        log.info("Usuario criado com sucesso: UsuarioController");

        return BaseResponse.<String>builder().success(true).mensagem("Usuario criado com sucesso").build();
    }

}
