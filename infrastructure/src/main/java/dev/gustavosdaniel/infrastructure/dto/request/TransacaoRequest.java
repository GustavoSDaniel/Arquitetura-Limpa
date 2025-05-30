package dev.gustavosdaniel.infrastructure.dto.request;

import java.math.BigDecimal;

public record TransacaoRequest(String deCPF, String paraCPF, BigDecimal valor, String pin) {
}
