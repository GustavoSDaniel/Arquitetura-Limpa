package dev.gustavosdaniel.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carteira")
public class CarteiraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;

    @OneToOne
    @JoinColumn(name = "usuario_id") // Coluna FK na tabela atual
    private UsuarioEntity usuario;

    @OneToOne
    @JoinColumn(name = "transicao_pin_id") // Coluna FK na tabela atual
    private TransicaoPinEntity transicaoPin;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criandoAt;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoAt;

    public CarteiraEntity(UsuarioEntity usuario, BigDecimal saldo, TransicaoPinEntity transicaoPin, LocalDateTime criandoAt, LocalDateTime atualizadoAt) {
        this.usuario = usuario;
        this.saldo = saldo;
        this.transicaoPin = transicaoPin;
        this.criandoAt = criandoAt;
        this.atualizadoAt = atualizadoAt;
    }
}
