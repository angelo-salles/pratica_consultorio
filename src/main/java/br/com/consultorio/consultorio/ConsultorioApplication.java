package br.com.consultorio.consultorio;

import br.com.consultorio.consultorio.Entity.Patient;
import br.com.consultorio.consultorio.Repository.IPatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collection;

@SpringBootApplication
public class ConsultorioApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConsultorioApplication.class, args);

        IPatientRepository iPatientRepository = configurableApplicationContext.getBean(IPatientRepository.class);
        Collection<Patient> findAllPatients = iPatientRepository.findAllPatients();
        System.out.println(findAllPatients);
    }

}
