package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class ReceiptKey implements Serializable {

    @Column(name = "store_id")
    Long store_id;

    @Column(name = "client_id")
    Long client_id;

    public ReceiptKey(Long store_id, Long client_id) {
        this.store_id = store_id;
        this.client_id = client_id;
    }

}
