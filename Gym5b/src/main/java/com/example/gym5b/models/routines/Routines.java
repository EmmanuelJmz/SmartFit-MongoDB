package com.example.gym5b.models.routines;

import com.example.gym5b.models.users.Users;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "routines")
@Data
@CompoundIndex(def = "{'name': 1}", name = "name", unique = true)
@NoArgsConstructor
@AllArgsConstructor
public class Routines {
    @Id
    private String id_routine;
    private String name;
    private String description;
    private String type;
}