package org.sistema_pasaportes.Repository;

import org.sistema_pasaportes.Model.Pasaporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasaporteRepository extends JpaRepository<Pasaporte,Long> {
}
