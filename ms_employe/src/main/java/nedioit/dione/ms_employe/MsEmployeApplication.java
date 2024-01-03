package nedioit.dione.ms_employe;

import nedioit.dione.ms_employe.entities.Employe;
import nedioit.dione.ms_employe.repository.EmployeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class MsEmployeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsEmployeApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EmployeRepository employeRepository){
        return args -> {
            ArrayList<String> emp = new ArrayList<>(Arrays.asList("Dione","Ousseynou","Automation Tester", "15000"));
            for(int i=0;i<=10;i++){
                Random random = new Random();
                int indcat = random.nextInt(0,3);
                double prx = random.nextDouble(100,500);
                Employe employe = Employe.builder()
                        .nom("prod"+i)
                        .prenom(emp.get(indcat))
                        .poste(emp.get(indcat))
                        .salaire(prx)
                        .build();
                employeRepository.save(employe);
            }
        };
    }



}
