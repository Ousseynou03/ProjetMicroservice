package nedioit.dione.ms_manager.service;

import nedioit.dione.ms_manager.dto.ManagerRequest;
import nedioit.dione.ms_manager.dto.ManagerResponse;
import nedioit.dione.ms_manager.dto.EmployeResponse;
import nedioit.dione.ms_manager.entities.Manager;
import nedioit.dione.ms_manager.mapper.ManagerMapper;
import nedioit.dione.ms_manager.repository.ManagementRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagementRepository managementRepository;
    private final ManagerMapper managerMapper;
    private final WebClient webClient;

    public ManagerServiceImpl(ManagementRepository managementRepository, ManagerMapper managerMapper, WebClient webClient) {
        this.managementRepository = managementRepository;
        this.managerMapper = managerMapper;
        this.webClient = webClient;
    }

    @Override
    public ManagerResponse addManager(ManagerRequest managerRequest) {
        Manager manager = managerMapper.fromManagerRequest(managerRequest);
        for(Long p: manager.getEmployes()){
            EmployeResponse employeResponse = webClient.get()
                    .uri("http://localhost:1015/api/employe/" +p)
                    .retrieve()
                    .bodyToMono(EmployeResponse.class)
                    .block();
            employeResponse.getPrenom();
            employeResponse.getNom();
        }
        manager.setDepartement(manager.getDepartement());
        manager.setNom(manager.getNom());
        manager.setPrenom(manager.getPrenom());
        managementRepository.save(manager);
        return managerMapper.fromManager(manager);
    }

    @Override
    public List<Manager> getAllManager() {
        List<Manager> managerList = managementRepository.findAll();
        return managerList;
    }
}
