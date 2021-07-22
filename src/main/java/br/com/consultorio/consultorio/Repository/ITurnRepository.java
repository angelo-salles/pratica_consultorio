package br.com.consultorio.consultorio.Repository;

import br.com.consultorio.consultorio.Entity.Turn;
import br.com.consultorio.consultorio.Entity.TurnStatus;
import br.com.consultorio.consultorio.Entity.TurnStatusEnum;
import br.com.consultorio.consultorio.dto.TurnResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ITurnRepository extends JpaRepository<Turn, Long> {

  @Query("")
  Collection<TurnResultDTO> findAllTurnsByStatus(TurnStatusEnum status);
}
