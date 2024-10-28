package hu.unideb.inf.kaloriaszamlalo.data.repository;

import hu.unideb.inf.kaloriaszamlalo.data.entity.EtelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtelRepository extends JpaRepository<EtelEntity, Long> {
    //select * from Etel where tipus = ?tipus
    List<EtelEntity> findAllByTipus(String tipus);
}
