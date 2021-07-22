package br.com.consultorio.consultorio.Repository;

import br.com.consultorio.consultorio.Entity.Dentist;
import br.com.consultorio.consultorio.dto.DentistResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {

  @Query("SELECT new br.com.consultorio.consultorio.dto.DentistResultDTO(d.id, d.name," +
          "d.lastName, d.address, d.dni, d.birthDate, d.phone, d.email, d.codeMp)\n" +
          "FROM Turn t\n" +
          "INNER JOIN t.diary dr\n" +
          "INNER JOIN dr.dentist d\n" +
          "WHERE t.day = :day\n" +
          "GROUP BY d.id, d.name, d.lastName, d.address, d.dni, d.birthDate, d.phone, d.email, d.codeMp\n" +
          "HAVING COUNT(t.diary) >= 2")
  Collection<DentistResultDTO> findAllDentistsWithMoreThanOneAppointmentInADay(LocalDate day);
}
