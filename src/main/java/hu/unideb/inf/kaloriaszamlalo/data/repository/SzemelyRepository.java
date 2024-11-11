package hu.unideb.inf.kaloriaszamlalo.data.repository;

import hu.unideb.inf.kaloriaszamlalo.data.entity.SzemelyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SzemelyRepository extends JpaRepository<SzemelyEntity, Long> {
    //select * from szemely where email = ?email
    SzemelyEntity findByEmail(String email);
}