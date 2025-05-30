package dev.gustavosdaniel.infrastructure.repository;

import dev.gustavosdaniel.infrastructure.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioEntityRepository extends JpaRepository<UsuarioEntity, Long> {

    Boolean existsByNumeroCPF(String cpfValidado);
    Boolean existsByEmail(String email);
}
