package com.example.demo.service;

import com.example.demo.domain.Manager;
import com.example.demo.domain.Store;
import com.example.demo.domain.StoreDTO;
import com.example.demo.repository.StoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Long> getStores() {
        List<Store> stores = storeRepository.findAll();
        return stores.stream().map(Store::getId).collect(Collectors.toList());
    }

    public void addStore(Store store) {
        storeRepository.save(store);
    }

    public void deleteStore(Long id) {
        boolean exists = storeRepository.existsById(id);
        if (!exists)
            throw new IllegalStateException(
                    "Store with id" + id + "does not exist");
        storeRepository.deleteById(id);
    }

    @Transactional
    public void updateStore(Long id, String name, String address, LocalTime openingHour, LocalTime closingHour) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Store with id" + id + "does not exist"));
        if(name != null)
            store.setName(name);
        if(address != null)
            store.setAddress(address);
        if(openingHour != null)
            store.setOpeningHour(openingHour);
        if(closingHour != null)
            store.setClosingHour(closingHour);
    }

    public Store findById(Long id) {
        return storeRepository.findById(id).get();
    }

    public StoreDTO convertEntityToDto(Store store){
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setStoreName(store.getName());
        storeDTO.setAddress(store.getAddress());
        storeDTO.setOpeningHour(store.getOpeningHour().format(DateTimeFormatter.ISO_DATE));
        storeDTO.setClosingHour(store.getClosingHour().format(DateTimeFormatter.ISO_DATE));
        return storeDTO;
    }

    public void getManagersAverageAged(Store store) {
        List<Manager> managers = store.getManagers();
        if(managers == null)
            System.out.println("null");;
        int totalAgeInDays = 0;
        for (Manager manager : managers) {
            totalAgeInDays += Duration.between(manager.getDob(), LocalDate.now()).toDays();
        }
        int averageAgeInYears = Math.toIntExact(totalAgeInDays / (managers.size() * 365L));
        System.out.println(averageAgeInYears);
        /*return new StoreDTO(
                averageAgeInYears,
                "",
                store.getName(),
                store.getAddress(),
                store.getOpeningHour().format(DateTimeFormatter.ISO_DATE),
                store.getClosingHour().format(DateTimeFormatter.ISO_DATE)
        );*/
    }

    public List<StoreDTO> orderStoresByManagerAge() {
        List<Store> stores = storeRepository.findAll();
        List<StoreDTO> orderedStoreDTO = new ArrayList<>();
        for (Store store : stores) {
            //orderedStoreDTO.add(getManagersAverageAged(store));
            getManagersAverageAged(store);
        }
        return orderedStoreDTO.stream()
                .sorted(Comparator.comparingInt(StoreDTO::getAge))
                .collect(Collectors.toList());
    }


/*    public StoreDTO getOldestStoreByManagers(){
        List<Store> stores = storeRepository.findAll();
        List<StoreDTO> orderedStoreDTO = new ArrayList<>();
        for (Store store : stores){
            orderedStoreDTO.add(getManagersAverageAged(store));
        }
        return orderedStoreDTO.stream()
                .sorted(Comparator.comparingInt(StoreDTO::getAge)).toList().get(orderedStoreDTO.size());
    }*/
}
