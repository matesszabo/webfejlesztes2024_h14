package hu.unideb.inf.kaloriaszamlalo.data.repository;

import hu.unideb.inf.kaloriaszamlalo.data.entity.KaloriaBevitelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KaloriaBevitelRepository extends JpaRepository<KaloriaBevitelEntity, Long> {
}
