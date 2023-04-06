package com.example.demo.controller;

import com.example.demo.domain.Manager;
import com.example.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/manager")
public class ManagerController {
    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/getManagers")
    public List<Long> getManagers(){
        return managerService.getAll();
    }

    @PostMapping("/addManager")
    public void addManager(@RequestBody Manager manager){
        managerService.addNewManager(manager);
    }

    @PutMapping("updateManager/{managerId}")
    public void updateManager(@PathVariable("managerId") Long managerId,
                              @RequestBody(required = false) Manager newManager){
        managerService.updateManager(managerId, newManager.getName(), newManager.getAddress(), newManager.getEmploymentDate(), newManager.getStore());}
 
    @DeleteMapping("deleteManager/{managerId}")
    public void deleteManager(@PathVariable("managerId") Long id){
        managerService.deleteManager(id);
    }

    @GetMapping("/getManager/{id}")
    public Manager getManagerById(@PathVariable("id") Long id){
        return managerService.findById(id);
    }

    @PostMapping("/addManagers/{store_id}")
    public void addMultipleManagers(@PathVariable("store_id") Long store_id,
                                    @RequestBody List<Manager> managers){
        for(Manager manager : managers)
            managerService.addNewManager(manager);
    }
}
