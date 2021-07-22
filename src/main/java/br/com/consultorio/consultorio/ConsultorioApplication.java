package br.com.consultorio.consultorio;

import br.com.consultorio.consultorio.Entity.*;
import br.com.consultorio.consultorio.Repository.*;
import br.com.consultorio.consultorio.dto.PatientResultDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

@SpringBootApplication
public class ConsultorioApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConsultorioApplication.class, args);

        IPatientRepository patientRepository = configurableApplicationContext.getBean(IPatientRepository.class);
        IDentistRepository dentistRepository = configurableApplicationContext.getBean(IDentistRepository.class);
        IDiaryRepository diaryRepository = configurableApplicationContext.getBean(IDiaryRepository.class);
        ITurnRepository turnRepository = configurableApplicationContext.getBean(ITurnRepository.class);
        ITurnStatusRepository turnStatusRepository = configurableApplicationContext.getBean(ITurnStatusRepository.class);
        IUserRepository userRepository = configurableApplicationContext.getBean(IUserRepository.class);

        Patient patient1 = new Patient("Patient 1", "Last1", "Rua 1", "123",
                LocalDate.of(1999, Month.APRIL, 12), "12345678", "email1@mock.com.br");
        Patient patient2 = new Patient("Patient 2", "Last2", "Rua 2", "223",
                LocalDate.of(1998, Month.JULY, 28), "87654321", "email2@mock.com.br");
        Patient patient3 = new Patient("Patient 3", "Last3", "Rua 3", "323",
                LocalDate.of(2001, Month.SEPTEMBER, 14), "98765432", "email3@mock.com.br");
        Patient patient4 = new Patient("Patient 4", "Last4", "Rua 4", "423",
                LocalDate.of(1987, Month.JANUARY, 2), "12345670", "email4@mock.com.br");
        Patient patient5 = new Patient("Patient 5", "Last5", "Rua 5", "523",
                LocalDate.of(1999, Month.OCTOBER, 12), "12345679", "email5@mock.com.br");

        List<Patient> patientList = new ArrayList<>(Arrays.asList(patient1, patient2, patient3, patient4, patient5));

        patientRepository.saveAll(patientList);

        Dentist dentist1 = new Dentist("Dentist 1", "Last1", "Rua 1", "123",
                LocalDate.of(1999, Month.OCTOBER, 20), "12345678", "dentist1@email.com", "ABC1");
        Dentist dentist2 = new Dentist("Dentist 2", "Last2", "Rua 2", "223",
                LocalDate.of(1997, Month.JANUARY, 20), "12345689", "dentist2@email.com", "ABC2");
        Dentist dentist3 = new Dentist("Dentist 3", "Last3", "Rua 3", "323",
                LocalDate.of(1987, Month.FEBRUARY, 27), "32345678", "dentist3@email.com", "ABC3");
        Dentist dentist4 = new Dentist("Dentist 4", "Last4", "Rua 4", "423",
                LocalDate.of(1978, Month.JUNE, 20), "42345678", "dentist4@email.com", "ABC4");
        Dentist dentist5 = new Dentist("Dentist 5", "Last5", "Rua 5", "523",
                LocalDate.of(1989, Month.DECEMBER, 1), "52345678", "dentist5@email.com", "ABC5");

        List<Dentist> dentistList = new ArrayList<>(Arrays.asList(dentist1, dentist2, dentist3, dentist4, dentist5));

        dentistRepository.saveAll(dentistList);

        TurnStatus statusConcluido = new TurnStatus(TurnStatusEnum.CONCLUIDO, "Atendimento concluído");
        TurnStatus statusCancelado = new TurnStatus(TurnStatusEnum.CANCELADO, "Atendimento cancelado");
        TurnStatus statusPendente = new TurnStatus(TurnStatusEnum.PENDENTE, "Atendimento pendente");

        List<TurnStatus> turnStatusList = new ArrayList<>(Arrays.asList(statusConcluido, statusCancelado, statusPendente));

        turnStatusRepository.saveAll(turnStatusList);

        Diary diary1 = new Diary(LocalDateTime.of(2021, Month.JULY, 21, 10, 0),
                LocalDateTime.of(2021, Month.JULY, 21, 10, 30), dentist1);

        Diary diary2 = new Diary(LocalDateTime.of(2021, Month.JULY, 21, 10, 30),
                LocalDateTime.of(2021, Month.JULY, 21, 11, 0), dentist2);

        Diary diary3 = new Diary(LocalDateTime.of(2021, Month.JULY, 22, 11, 0),
                LocalDateTime.of(2021, Month.JULY, 22, 11, 30), dentist3);

        Diary diary4 = new Diary(LocalDateTime.of(2021, Month.JULY, 21, 11, 30),
                LocalDateTime.of(2021, Month.JULY, 21, 12, 0), dentist4);

        Diary diary5 = new Diary(LocalDateTime.of(2021, Month.JULY, 20, 14, 0),
                LocalDateTime.of(2021, Month.JULY, 20, 14, 30), dentist5);

        List<Diary> diaryList = new ArrayList<>(Arrays.asList(diary1, diary2, diary3, diary4, diary5));

        diaryRepository.saveAll(diaryList);

        Turn turn1 = new Turn(LocalDate.of(2021, Month.JULY, 20), statusCancelado, diary5, patient5);
        Turn turn2 = new Turn(LocalDate.of(2021, Month.JULY, 21), statusConcluido, diary1, patient2);
        Turn turn3 = new Turn(LocalDate.of(2021, Month.JULY, 21), statusConcluido, diary2, patient3);
        Turn turn4 = new Turn(LocalDate.of(2021, Month.JULY, 21), statusPendente, diary4, patient1);
        Turn turn5 = new Turn(LocalDate.of(2021, Month.JULY, 22), statusPendente, diary3, patient4);

        List<Turn> turnList = new ArrayList<>(Arrays.asList(turn1, turn2, turn3, turn4, turn5));

        turnRepository.saveAll(turnList);

        /*================================================Exercício 1================================================*/
        Collection<PatientResultDTO> findAllPatients = patientRepository.findAllPatientsWithConcludedAppointment(LocalDate.of(2021, Month.JULY, 21));
        System.out.println(findAllPatients);

        /*================================================Exercício 2================================================*/


        /*================================================Exercício 3================================================*/


        /*================================================Exercício 4================================================*/


        /*================================================Exercício 5================================================*/


        /*================================================Exercício 6================================================*/


    }

}
