package dev.gustavosdaniel.infrastructure.repository;

import dev.gustavosdaniel.infrastructure.entity.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoEntityRepository extends JpaRepository<TransacaoEntity, Long> {
}
