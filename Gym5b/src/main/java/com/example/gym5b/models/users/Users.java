package com.example.gym5b.models.users;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@CompoundIndex(def = "{'age': 1}", name = "age_index", unique = true)
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    private String _id;
    private String name;
    private String last_name;
    private int age;
    private String email;
    private String password;
}
