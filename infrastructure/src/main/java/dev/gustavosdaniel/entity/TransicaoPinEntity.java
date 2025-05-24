package dev.gustavosdaniel.entity;

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

    @Column(name = "atualizado_em", nullable = false)
    private LocalDateTime atualizadoAt;

}
