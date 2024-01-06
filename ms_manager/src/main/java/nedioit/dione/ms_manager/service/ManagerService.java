package nedioit.dione.ms_manager.service;

import nedioit.dione.ms_manager.dto.ManagerRequest;
import nedioit.dione.ms_manager.dto.ManagerResponse;
import nedioit.dione.ms_manager.entities.Manager;

import java.util.List;

public interface ManagerService {

    ManagerResponse addManager(ManagerRequest managerRequest);

    List<Manager> getAllManager();

    ManagerResponse updateManager(Long id, ManagerRequest managerRequest);

    void deleteManager(Long id);

    ManagerResponse getManagerById(Long id);

}
