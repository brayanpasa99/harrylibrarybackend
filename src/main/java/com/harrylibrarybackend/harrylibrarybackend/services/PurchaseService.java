package com.harrylibrarybackend.harrylibrarybackend.services;
import com.harrylibrarybackend.harrylibrarybackend.exceptions.PurchaseNotFoundException;
import com.harrylibrarybackend.harrylibrarybackend.models.Purchase;
import com.harrylibrarybackend.harrylibrarybackend.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public Purchase addPurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> findAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase updatePurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Purchase findPurchaseById(Long id) {
        return purchaseRepository.findPurchaseById(id)
                .orElseThrow(() -> new PurchaseNotFoundException("Purchase by id " + id + " was not found"));
    }

    public void deletePurchase(Long id) {
        purchaseRepository.deletePurchaseById(id);
    }
}
