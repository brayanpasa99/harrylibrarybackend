package com.harrylibrarybackend.harrylibrarybackend.repositories;

import com.harrylibrarybackend.harrylibrarybackend.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    Optional<Purchase> findPurchaseById(Long id);

    void deletePurchaseById(Long id);

}
