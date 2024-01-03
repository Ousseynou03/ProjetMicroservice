package nedioit.dione.ms_manager.repository;

import nedioit.dione.ms_manager.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagementRepository extends JpaRepository<Manager, Long> {
}
