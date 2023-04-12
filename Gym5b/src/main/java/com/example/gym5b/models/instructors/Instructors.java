package com.example.gym5b.models.instructors;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "instructors")
@Data
@CompoundIndex(def = "{'last_name': 1}", name = "last_name_index", unique = true)
@NoArgsConstructor
@AllArgsConstructor
public class Instructors {
    @Id
    private String _id;
    private String name;
    private String last_name;
    private int age;
    private String email;
    private String password;
}


