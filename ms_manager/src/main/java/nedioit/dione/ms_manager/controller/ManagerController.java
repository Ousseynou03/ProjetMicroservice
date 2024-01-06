package nedioit.dione.ms_manager.controller;

import nedioit.dione.ms_manager.dto.ManagerRequest;
import nedioit.dione.ms_manager.dto.ManagerResponse;
import nedioit.dione.ms_manager.entities.Manager;
import nedioit.dione.ms_manager.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/add")
    public ManagerResponse addManager(@RequestBody(required = true) ManagerRequest managerRequest){
        return managerService.addManager(managerRequest);
    }

    @GetMapping("/")
    public List<Manager> getAllManager(){
        return managerService.getAllManager();
    }

    @PutMapping("/update/{id}")
    public ManagerResponse updateManager(@PathVariable Long id, @RequestBody ManagerRequest managerRequest){
        return managerService.updateManager(id, managerRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteManager(@PathVariable Long id){
        managerService.deleteManager(id);
    }

    @GetMapping("/{id}")
    public ManagerResponse getManagerById(@PathVariable Long id){
        return managerService.getManagerById(id);
    }
}
