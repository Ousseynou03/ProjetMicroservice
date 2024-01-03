package nedioit.dione.ms_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ManagerResponse {

    private Long id;
    private String nom;
    private List<Long> employes;
    private String prenom;
    private String departement;

    public ManagerResponse(Long id, String nom, List<Long> employes, String prenom, String departement) {
        this.id = id;
        this.nom = nom;
        this.employes = employes;
        this.prenom = prenom;
        this.departement = departement;
    }
}

