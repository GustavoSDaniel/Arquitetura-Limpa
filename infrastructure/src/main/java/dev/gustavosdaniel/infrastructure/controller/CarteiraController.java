package dev.gustavosdaniel.infrastructure.controller;

import dev.gustavosdaniel.infrastructure.dto.request.TransacaoRequest;
import dev.gustavosdaniel.infrastructure.dto.response.BaseResponse;
import dev.gustavosdaniel.infrastructure.dto.response.ConsultaSaldoResponse;
import dev.gustavosdaniel.usecase.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/carteira")
public class CarteiraController {

    final private ConsultarSaldoUseCase consultarSaldoUseCase;
    final private TransferirUseCase transacaoUseCase;
    final private CriarTransicaoUseCase criarTransicaoUseCase;
    final private BuscarCarteiraCPFUseCase buscarCarteiraCPFUseCase;
    final private ValidarTransacaoUseCase validarTransacaoUseCase;
    final private ValidarTransacaoPinUseCase validarTransacaoPinUseCase;
    final private UsuarioNotificacaoUseCase usuarioNotificacaoUseCase;

    public CarteiraController(ConsultarSaldoUseCase consultarSaldoUseCase, ValidarTransacaoUseCase transacaoUseCase, TransferirUseCase transacaoUseCase1, CriarTransicaoUseCase criarTransicaoUseCase, BuscarCarteiraCPFUseCase buscarCarteiraCPFUseCase, ValidarTransacaoUseCase validarTransacaoUseCase, ValidarTransacaoPinUseCase validarTransacaoPinUseCase, UsuarioNotificacaoUseCase usuarioNotificacaoUseCase) {
        this.consultarSaldoUseCase = consultarSaldoUseCase;
        this.transacaoUseCase = transacaoUseCase1;
        this.criarTransicaoUseCase = criarTransicaoUseCase;
        this.buscarCarteiraCPFUseCase = buscarCarteiraCPFUseCase;
        this.validarTransacaoUseCase = validarTransacaoUseCase;
        this.validarTransacaoPinUseCase = validarTransacaoPinUseCase;
        this.usuarioNotificacaoUseCase = usuarioNotificacaoUseCase;
    }

    @GetMapping("/consultarSaldo/{numeroCPF}")
    public BaseResponse<ConsultaSaldoResponse>consultarSaldo(@PathVariable("numeroCPF") String numeroCPF) throws Exception {
        var saldo = consultarSaldoUseCase.consultar(numeroCPF);

        return BaseResponse.<ConsultaSaldoResponse>builder().success(true).resultado(new ConsultaSaldoResponse(saldo)).build();
    }

    @PostMapping("/transferir")
    public BaseResponse<String> trasnferir(@RequestBody TransacaoRequest transacaoRequest) throws Exception {

        var deCarteira = buscarCarteiraCPFUseCase.findByCPFValido(transacaoRequest.deCPF());

        validarTransacaoPinUseCase.validar(deCarteira.getTransicaoPin(), transacaoRequest.pin());

        var paraCarteira = buscarCarteiraCPFUseCase.findByCPFValido(transacaoRequest.paraCPF());

        var transacao = criarTransicaoUseCase.criar(deCarteira, paraCarteira, transacaoRequest.valor());
        validarTransacaoUseCase.validar(transacao);

        transacaoUseCase.tranferir(transacao);

        usuarioNotificacaoUseCase.notificar(transacao, deCarteira.getUsuario().getEmail());
        return BaseResponse.<String>builder().success(true).mensagem("Transferencia Realizada com sucesso").build();
    }



}
