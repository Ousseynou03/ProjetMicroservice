package nedioit.dione.ms_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerRequest {

    private String nom;
    private List<Long> employes;
    private String prenom;
    private String departement;

}
