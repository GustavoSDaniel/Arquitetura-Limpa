package dev.gustavosdaniel.entity;

import dev.gustavosdanielcore.domain.enums.TransicaoStatusEnum;
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
@Table(name = "transacao")
public class TransacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "para_carteira", nullable = false)
    @ManyToOne // MUITAS TRANSAÇÕES PARA UMA CARTEIRA
    @JoinColumn(name = "transacao")
    private CarteiraEntity paraCarteira;

    @Column(name = "de_carteira", nullable = false)
    @ManyToOne // MUITAS TRANSAÇÕES PARA UMA CARTEIRA
    @JoinColumn(name = "transacao")
    private CarteiraEntity deCarteira;

    @Column(name = "valor_da_transacao", nullable = false)
    private BigDecimal valor;


    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransicaoStatusEnum status;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criandoAt;

    @Column(name = "atualizado_em", nullable = false)
    private LocalDateTime atualizadoAt;
}
