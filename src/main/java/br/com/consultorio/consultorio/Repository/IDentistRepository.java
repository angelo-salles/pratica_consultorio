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

//  @Query("")
//  Collection<DentistResultDTO> findAllDentistsWithMoreThanOneAppointmentInADay(LocalDate day);
}
