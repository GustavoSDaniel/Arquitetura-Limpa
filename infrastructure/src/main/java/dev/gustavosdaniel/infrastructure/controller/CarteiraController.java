package dev.gustavosdaniel.infrastructure.controller;

import dev.gustavosdaniel.infrastructure.dto.response.BaseResponse;
import dev.gustavosdaniel.infrastructure.dto.response.ConsultaSaldoResponse;
import dev.gustavosdaniel.usecase.ConsultarSaldoUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/carteira")
public class CarteiraController {

    private ConsultarSaldoUseCase consultarSaldoUseCase;

    public CarteiraController(ConsultarSaldoUseCase consultarSaldoUseCase) {
        this.consultarSaldoUseCase = consultarSaldoUseCase;
    }

    @GetMapping("/consultarSaldo/{numeroCPF}")
    public BaseResponse<ConsultaSaldoResponse>consultarSaldo(@PathVariable String numeroCPF) throws Exception {
        var saldo = consultarSaldoUseCase.consultar(numeroCPF);

        return BaseResponse.<ConsultaSaldoResponse>builder().resultado(new ConsultaSaldoResponse(saldo)).build();
    }

}
