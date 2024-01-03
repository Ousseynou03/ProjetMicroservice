package nedioit.dione.ms_employe.service;


import nedioit.dione.ms_employe.dto.EmployeRequest;
import nedioit.dione.ms_employe.dto.EmployeResponse;

import java.util.List;

public interface IEmployeService {

    EmployeResponse add(EmployeRequest employeRequest);

    public EmployeResponse getEmployeById(Long id);

    List<EmployeResponse> getAllEmployes();

    //update
    EmployeResponse updateEmploye(Long id, EmployeRequest employeRequest);

    //delete
    void deleteEmploye(Long id);







}
