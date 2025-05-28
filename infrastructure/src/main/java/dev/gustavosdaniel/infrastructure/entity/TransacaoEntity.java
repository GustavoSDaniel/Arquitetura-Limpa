package dev.gustavosdaniel.infrastructure.entity;

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

    @ManyToOne // MUITAS TRANSAÇÕES PARA UMA CARTEIRA
    @JoinColumn(name = "para_carteira") // Coluna FK na tabela atual
    private CarteiraEntity paraCarteira;

    @ManyToOne // MUITAS TRANSAÇÕES PARA UMA CARTEIRA
    @JoinColumn(name = "de_carteira") // Coluna FK na tabela atual
    private CarteiraEntity deCarteira;

    @Column(name = "valor_da_transacao", nullable = false)
    private BigDecimal valor;


    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransicaoStatusEnum status;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criandoAt;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoAt;

    public TransacaoEntity(CarteiraEntity deCarteira, CarteiraEntity paraCarteira,  BigDecimal valor, TransicaoStatusEnum status, LocalDateTime criandoAt, LocalDateTime atualizadoAt) {
        this.deCarteira = deCarteira;
        this.paraCarteira = paraCarteira;
        this.valor = valor;
        this.status = status;
        this.criandoAt = criandoAt;
        this.atualizadoAt = atualizadoAt;
    }
}
