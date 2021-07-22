package br.com.consultorio.consultorio.Repository;

import br.com.consultorio.consultorio.Entity.Diary;
import br.com.consultorio.consultorio.dto.DiaryResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface IDiaryRepository extends JpaRepository<Diary, Long> {

  @Query("SELECT new br.com.consultorio.consultorio.dto.DiaryResultDTO(d.startTime, d.endingTime," +
          "dt.name, dt.codeMp)\n" +
          "FROM Diary d\n" +
          "INNER JOIN d.dentist dt\n" +
          "WHERE dt.id = :dentistId")
  Collection<DiaryResultDTO> findAllAppointmentsDentistInADay(Long dentistId);
}
