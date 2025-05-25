package dev.gustavosdaniel.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transicãoPin")
public class TransicaoPinEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "pin", nullable = false)
    private String pin;

    @Column(name = "quantidade_de_tentativas", nullable = false)
    private Integer quantidadeDeTentativa;

    @Column(name = "bloqueado", nullable = false)
    private Boolean bloqueado;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criandoAt;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoAt;

    public TransicaoPinEntity(String pin,Integer quantidadeDeTentativa,Boolean bloqueado,  LocalDateTime criandoAt,  LocalDateTime atualizadoAt) {
        this.pin = pin;
        this.quantidadeDeTentativa = quantidadeDeTentativa;
        this.bloqueado = bloqueado;
        this.criandoAt = criandoAt;
        this.atualizadoAt = atualizadoAt;
    }
}
