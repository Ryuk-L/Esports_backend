package esports.espots.service;

import esports.espots.Entity.Store;
import esports.espots.Exception.StoreNotFoundException;
import esports.espots.respository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Optional<Store> getStoreById(Integer id) {
        return storeRepository.findById(id);
    }

    public Store addStore(Store store) {
        return storeRepository.save(store);
    }

    public Store updateStore(Integer id, Store store) {
        if (storeRepository.existsById(id)) {
            store.setIdStore(id);
            return storeRepository.save(store);
        } else {
            throw new StoreNotFoundException("Store with ID " + id + " not found");
        }
    }

    public void deleteStore(Integer id) {
        storeRepository.deleteById(id);
    }
}
