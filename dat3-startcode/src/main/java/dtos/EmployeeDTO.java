/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class EmployeeDTO {
    private long id;
    private String Name;
    private String Address;

    public EmployeeDTO(String Name, String Address) {
        this.Name = Name;
        this.Address = Address;
    }
    
    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.Name  = employee.getName();
        this.Address = employee.getAddress();
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" + "id=" + id + ", Name=" + Name + ", Address=" + Address + '}';
    }

    public EmployeeDTO() {
    }


  

   
    
    
    
    
    
    
}
