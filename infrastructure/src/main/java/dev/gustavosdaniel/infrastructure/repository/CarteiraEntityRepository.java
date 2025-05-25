package dev.gustavosdaniel.infrastructure.repository;

import dev.gustavosdaniel.infrastructure.entity.CarteiraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraEntityRepository extends JpaRepository<CarteiraEntity, Long> {
}
