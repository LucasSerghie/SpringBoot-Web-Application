package com.example.demo.controller;

import com.example.demo.domain.Store;
import com.example.demo.domain.StoreDTO;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/store")
public class StoreController {
    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/getStores")
    public List<Long> stores(){
        return storeService.getStores();
    }

    @PostMapping("/addStore")
    public void addStore(@RequestBody Store store){
        storeService.addStore(store);
    }

    @PutMapping("/updateStore/{storeId}")
    public void updateStore(@PathVariable("storeId") Long storeId,
                            @RequestBody(required = false) Store store){
        storeService.updateStore(storeId, store.getName(), store.getAddress(), store.getOpeningHour(), store.getClosingHour());
    }

    @DeleteMapping("/deleteStore/{id}")
    public void deleteStore(@PathVariable("id") Long storeId){
        storeService.deleteStore(storeId);
    }

    @GetMapping("/getStore/{id}")
    public Store getStoreById(@PathVariable("id") Long id){
        return storeService.findById(id);
    }

    @GetMapping("/getStoresWithManagersOld")
    public List<StoreDTO> getStoresWithManagersOld(){
        return storeService.orderStoresByManagerAge();
    }

/*    @GetMapping("/getOldestStoreByManagers")
    public StoreDTO getOldestStoreByManagers(){
        return storeService.getOldestStoreByManagers();
    }*/
}
