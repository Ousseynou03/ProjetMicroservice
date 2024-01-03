package nedioit.dione.ms_manager.controller;


import nedioit.dione.ms_manager.dto.ManagerRequest;
import nedioit.dione.ms_manager.dto.ManagerResponse;
import nedioit.dione.ms_manager.entities.Manager;
import nedioit.dione.ms_manager.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/achat")
public class AchatController {

    private ManagerService achatService;

    public AchatController(ManagerService achatService) {
        this.achatService = achatService;
    }


    @PostMapping("/add")
    public ManagerResponse addAchat(@RequestBody(required = true) ManagerRequest achatRequest){
        return achatService.addManager(achatRequest);
    }


    @GetMapping("/")
    public List<Manager> getAllAchat(){
        return achatService.getAllManager();
    }


}
