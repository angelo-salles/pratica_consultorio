package br.com.consultorio.consultorio.Repository;

import br.com.consultorio.consultorio.Entity.Patient;
import br.com.consultorio.consultorio.dto.PatientResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT new br.com.consultorio.consultorio.dto.PatientResultDTO(p.id, p.name," +
            "p.lastName, p.address, p.dni, p.birthDate, p.email, p.phone)\n" +
            "FROM Turn t\n" +
            "INNER JOIN t.patient p\n" +
            "INNER JOIN t.turnStatus ts\n" +
            "INNER JOIN t.diary d\n" +
            "WHERE ts.name = 'CONCLUIDO'\n" +
            "AND t.day = :day")
    Collection<PatientResultDTO> findAllPatientsWithConcludedAppointment(LocalDate day);
}
