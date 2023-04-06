package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
    @EmbeddedId
    ReceiptKey receiptId;

    @ManyToOne
    @JsonBackReference
    @MapsId("store_id")
    @JoinColumn(name = "store_id", nullable = false)
    Store store;

    @ManyToOne
    @JsonBackReference
    @MapsId("client_id")
    @JoinColumn(name = "client_id", nullable = false)
    Client client;

    @Column(name = "purchase_date")
    LocalDate purchase_date;

    @Column(name = "value")
    Double value;

}
