package nedioit.dione.ms_employe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nedioit.dione.ms_employe.entities.Employe;

@Data
@NoArgsConstructor
@Builder
public class EmployeResponse {

    private Long id;
    private String nom;
    private String prenom;
    private String poste;
    private double salaire;

    public EmployeResponse(Long id, String nom, String prenom, String poste, double salaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.salaire = salaire;
    }
}
