package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table
@Data
@NoArgsConstructor
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private LocalDate dob;
    private LocalDate employmentDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "store_id")
    @JsonBackReference
    private Store store;

    public Manager(String name, String address, LocalDate dob, LocalDate employmentDate, Store store) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.employmentDate = employmentDate;
        this.store = store;
    }

}
