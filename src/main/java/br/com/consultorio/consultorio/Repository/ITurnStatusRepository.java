package br.com.consultorio.consultorio.Repository;

import br.com.consultorio.consultorio.Entity.TurnStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnStatusRepository extends JpaRepository<TurnStatus, Long> {
}
