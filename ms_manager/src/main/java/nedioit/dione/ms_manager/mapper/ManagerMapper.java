package nedioit.dione.ms_manager.mapper;

import nedioit.dione.ms_manager.dto.ManagerRequest;
import nedioit.dione.ms_manager.dto.ManagerResponse;
import nedioit.dione.ms_manager.entities.Manager;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ManagerMapper {

    public ManagerResponse fromManager(Manager manager){
        ManagerResponse managerResponse = new ManagerResponse();
        BeanUtils.copyProperties(manager, managerResponse);
        return managerResponse;
    }

    public Manager fromManagerRequest(ManagerRequest managerRequest){
        Manager manager = new Manager();
        BeanUtils.copyProperties(managerRequest, manager);
        return manager;
    }
}
