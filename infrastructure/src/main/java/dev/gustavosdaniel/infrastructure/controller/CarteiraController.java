package dev.gustavosdaniel.infrastructure.controller;

import dev.gustavosdaniel.infrastructure.dto.request.TransacaoRequest;
import dev.gustavosdaniel.infrastructure.dto.response.BaseResponse;
import dev.gustavosdaniel.infrastructure.dto.response.ConsultaSaldoResponse;
import dev.gustavosdaniel.usecase.ConsultarSaldoUseCase;
import dev.gustavosdaniel.usecase.ValidarTransacaoUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/carteira")
public class CarteiraController {

    private ConsultarSaldoUseCase consultarSaldoUseCase;
    private ValidarTransacaoUseCase transacaoUseCase;

    public CarteiraController(ConsultarSaldoUseCase consultarSaldoUseCase, ValidarTransacaoUseCase transacaoUseCase) {
        this.consultarSaldoUseCase = consultarSaldoUseCase;
        this.transacaoUseCase = transacaoUseCase;
    }

    @GetMapping("/consultarSaldo/{numeroCPF}")
    public BaseResponse<ConsultaSaldoResponse>consultarSaldo(@PathVariable("numeroCPF") String numeroCPF) throws Exception {
        var saldo = consultarSaldoUseCase.consultar(numeroCPF);

        return BaseResponse.<ConsultaSaldoResponse>builder().success(true).resultado(new ConsultaSaldoResponse(saldo)).build();
    }

    @PostMapping("/transferir")
    public BaseResponse<String> trasnferir(@RequestBody TransacaoRequest transacaoRequest){
        transacaoUseCase.trasnferir(transacaoRequest.deCPF(), transacaoRequest.paraCPF(), transacaoRequest.valor(), transacaoRequest.pin());

    }



}
