package com.example.gym5b.models.machines;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "machines")
@Data
@NoArgsConstructor
@CompoundIndex(def = "{'quantity': 1}", name = "quantity_index", unique = true)
@AllArgsConstructor
public class Machines {
    @Id
    private String id_machine;
    private String name;
    private String description;
    private int quantity;
}
