package dev.gustavosdaniel.repository;

import dev.gustavosdaniel.entity.CarteiraEntity;
import dev.gustavosdaniel.entity.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraEntityRepository extends JpaRepository<CarteiraEntity, Long> {
}
