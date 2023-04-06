package com.example.demo.repository;

import com.example.demo.domain.Receipt;
import com.example.demo.domain.ReceiptKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, ReceiptKey> {
}
