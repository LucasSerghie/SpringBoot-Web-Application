package com.example.demo.service;

import com.example.demo.domain.Manager;
import com.example.demo.domain.Store;
import com.example.demo.repository.ManagerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }
    
    public List<Long> getAll(){
        List<Manager> manager = managerRepository.findAll();
        return manager.stream()
                .map(Manager::getId)
                .collect(Collectors.toList());
    }

    public void addNewManager(Manager manager) {
        managerRepository.save(manager);
    }

    @Transactional
    public void updateManager(Long managerId, String name, String address, LocalDate employmentDate, Store store) {
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(() -> new IllegalStateException("manager with id " + managerId + "does not exist"));
        if(name != null)
            manager.setName(name);
        if(address != null)
            manager.setAddress(address);
        if(!Objects.equals(employmentDate, LocalDate.now()))
            manager.setAddress(address);
        if(store != null)
            manager.setStore(store);
    }
    public void deleteManager(Long managerId) {
        boolean exists = managerRepository.existsById(managerId);
        if(!exists)
            throw new IllegalStateException(
                    "manager with id " + managerId + "does not exist");
        managerRepository.deleteById(managerId);
    }

    public Manager findById(Long id){
        return managerRepository.findById(id).get();
    }
}
