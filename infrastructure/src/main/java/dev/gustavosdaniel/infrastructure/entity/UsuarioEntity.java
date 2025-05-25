package dev.gustavosdaniel.infrastructure.entity;

import dev.gustavosdanielcore.domain.enums.TipoUsuarioEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor //CRIA UM CONSTRUTOR SEM ARGUMENTOS
@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "numero_cpf", nullable = false)
    private String numeroCPF;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoUsuarioEnum tipo;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criandoAt;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoAt;

    public UsuarioEntity(String nomeCompleto,String email,String numeroCPF,String senha, TipoUsuarioEnum tipo,    LocalDateTime criandoAt, LocalDateTime atualizadoAt) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.numeroCPF = numeroCPF;
        this.senha = senha;
        this.tipo = tipo;
        this.criandoAt = criandoAt;
        this.atualizadoAt = atualizadoAt;
    }
}
