package nedioit.dione.ms_employe.repository;

import nedioit.dione.ms_employe.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
