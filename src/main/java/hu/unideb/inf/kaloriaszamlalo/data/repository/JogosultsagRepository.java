package hu.unideb.inf.kaloriaszamlalo.data.repository;

import hu.unideb.inf.kaloriaszamlalo.data.entity.Jogosultsag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogosultsagRepository extends JpaRepository<Jogosultsag, Long> {

    Jogosultsag findByName(String name);
}