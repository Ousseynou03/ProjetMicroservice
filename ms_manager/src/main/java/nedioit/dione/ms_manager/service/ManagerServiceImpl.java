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
import java.util.Optional;

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
        return managementRepository.findAll();
    }

    @Override
    public ManagerResponse updateManager(Long id, ManagerRequest managerRequest) {
        Optional<Manager> optionalManager = managementRepository.findById(id);

        if (optionalManager.isPresent()) {
            Manager manager = optionalManager.get();
            // Mettez à jour les propriétés du manager avec les nouvelles valeurs de managerRequest
            manager.setNom(managerRequest.getNom());
            manager.setPrenom(managerRequest.getPrenom());
            manager.setDepartement(managerRequest.getDepartement());
            manager.setEmployes(managerRequest.getEmployes());

            // Enregistrez les modifications dans la base de données
            managementRepository.save(manager);

            return managerMapper.fromManager(manager);
        } else {
            // Gérez le cas où le manager avec l'ID spécifié n'est pas trouvé
            // Vous pouvez lancer une exception ou retourner null selon vos besoins
            return null;
        }
    }

    @Override
    public void deleteManager(Long id) {
        managementRepository.deleteById(id);
    }

    @Override
    public ManagerResponse getManagerById(Long id) {
        Optional<Manager> optionalManager = managementRepository.findById(id);

        if (optionalManager.isPresent()) {
            Manager manager = optionalManager.get();
            return managerMapper.fromManager(manager);
        } else {
            // Gérez le cas où le manager avec l'ID spécifié n'est pas trouvé
            // Vous pouvez lancer une exception ou retourner null selon vos besoins
            return null;
        }
    }
}
