package nedioit.dione.ms_employe.mapper;


import nedioit.dione.ms_employe.dto.EmployeRequest;
import nedioit.dione.ms_employe.dto.EmployeResponse;
import nedioit.dione.ms_employe.entities.Employe;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeMapper {

    public EmployeResponse fromEmploye(Employe employe){
        EmployeResponse employeResponse = new EmployeResponse();
        BeanUtils.copyProperties(employe, employeResponse);
        return employeResponse;
    }

    public Employe fromEmployeRequest(EmployeRequest employeRequest){
        Employe employe = new Employe();
        BeanUtils.copyProperties(employeRequest, employe);
        return employe;
    }
}
