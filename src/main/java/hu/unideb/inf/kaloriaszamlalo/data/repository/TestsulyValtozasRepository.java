package hu.unideb.inf.kaloriaszamlalo.data.repository;

import hu.unideb.inf.kaloriaszamlalo.data.entity.TestsulyValtozasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsulyValtozasRepository extends JpaRepository<TestsulyValtozasEntity, Long>, JpaSpecificationExecutor<TestsulyValtozasEntity> {
}