package dev.gustavosdaniel.entity;

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

    @Column(name = "usuario_id", nullable = false)
    @OneToOne
    @JoinColumn(name = "carteira") // Coluna FK na tabela atual
    private UsuarioEntity usuario;

    @Column(name = "transicao_pin_id", nullable = false)
    @OneToOne
    @JoinColumn(name = "carteira") // Coluna FK na tabela atual
    private TransicaoPinEntity transicaoPin;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criandoAt;

    @Column(name = "atualizado_em", nullable = false)
    private LocalDateTime atualizadoAt;
}
