package dev.gustavosdaniel.repository;

import dev.gustavosdaniel.entity.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoEntityRepository extends JpaRepository<TransacaoEntity, Long> {
}
