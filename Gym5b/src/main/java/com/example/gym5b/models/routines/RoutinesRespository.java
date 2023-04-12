package com.example.gym5b.models.routines;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RoutinesRespository extends MongoRepository<Routines, String > {

    @Query("[{ '$project': { 'id_routine': 1, 'name': 1, 'description': 1, 'type': 1 }}, { '$sort': { 'name': 1 } }]")
    Routines findAllRoutines();

    @Query("{'name': ?0}")
    Routines findRoutineByName(String name);

    Routines findByName(String name);

    @Query(value = "[{ '$sort': { 'name': 1 } }]")
    Routines findRoutinesByAsc();

    @Query(value = "[{ '$sort': { 'name': -1 } }]")
    Routines findRoutinesByDesc();

    @Query(value = "[{ '$sort': { 'type': -1 } }]")
    Routines findRoutinesByTypeDesc();

    @Query(value = "[{ '$sort': { 'type': 1 } }]")
    Routines findRoutinesByTypeAsc();

    @Query(value="{'name' : ?0}", delete = true)
    public void deleteByName(String name);

    //DELETE ALL ROUTINES
    @Query(value="{}", delete = true)
    void deleteAllRoutines();

    List<Routines> findByType(String type);

}
