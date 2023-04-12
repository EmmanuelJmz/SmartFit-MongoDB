package com.example.gym5b.models.exersices;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "exercises")
@Data
@CompoundIndex(def = "{'type': 1}", name = "type_index", unique = true)
@NoArgsConstructor
@AllArgsConstructor
public class Exercises {
    @Id
    private String id_exercise;
    private String name;
    private String description;
    private String type;
}
