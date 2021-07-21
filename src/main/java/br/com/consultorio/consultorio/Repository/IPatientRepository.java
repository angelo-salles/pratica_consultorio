package br.com.consultorio.consultorio.Repository;

import br.com.consultorio.consultorio.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p.id as patient_id, p.name as patient_name\n" +
            "FROM Patient p\n" +
            "INNER JOIN Turn t\n" +
            "INNER JOIN TurnStatus ts\n" +
            "WHERE ts.name = 'CONCLUIDO'")
    Collection<Patient> findAllPatients();
}
