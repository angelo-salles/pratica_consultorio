package br.com.consultorio.consultorio.Repository;

import br.com.consultorio.consultorio.Entity.Turn;
import br.com.consultorio.consultorio.Entity.TurnStatus;
import br.com.consultorio.consultorio.Entity.TurnStatusEnum;
import br.com.consultorio.consultorio.dto.TurnResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface ITurnRepository extends JpaRepository<Turn, Long> {

  @Query("SELECT new br.com.consultorio.consultorio.dto.TurnResultDTO(t.day, ts.name," +
          "d.name, d.codeMp, p.name)\n" +
          "FROM Turn t\n" +
          "INNER JOIN t.turnStatus ts\n" +
          "INNER JOIN t.patient p\n" +
          "INNER JOIN t.diary dr\n" +
          "INNER JOIN dr.dentist d\n" +
          "WHERE ts.name = :status")
  Collection<TurnResultDTO> findAllTurnsByStatus(TurnStatusEnum status);

    @Query("SELECT new br.com.consultorio.consultorio.dto.TurnResultDTO(t.day, ts.name," +
            "d.name, d.codeMp, p.name)\n" +
            "FROM Turn t\n" +
            "INNER JOIN t.turnStatus ts\n" +
            "INNER JOIN t.patient p\n" +
            "INNER JOIN t.diary dr\n" +
            "INNER JOIN dr.dentist d\n" +
            "WHERE ts.name = 'PENDENTE'\n" +
            "AND t.day = :day")
  Collection<TurnResultDTO> findAllPendingTurnsOfADay(LocalDate day);

  @Query("SELECT new br.com.consultorio.consultorio.dto.TurnResultDTO(t.day, ts.name," +
          "d.name, d.codeMp, p.name)\n" +
          "FROM Turn t\n" +
          "INNER JOIN t.turnStatus ts\n" +
          "INNER JOIN t.patient p\n" +
          "INNER JOIN t.diary dr\n" +
          "INNER JOIN dr.dentist d\n" +
          "WHERE ts.name = 'REMARCADO'\n" +
          "AND d.id = :id")
  Collection<TurnResultDTO> findAllRemarkedStatusOfADentist(Long id);
}
