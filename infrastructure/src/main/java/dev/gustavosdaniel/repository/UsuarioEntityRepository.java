package dev.gustavosdaniel.repository;

import dev.gustavosdaniel.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioEntityRepository extends JpaRepository<UsuarioEntity, Long> {
}
