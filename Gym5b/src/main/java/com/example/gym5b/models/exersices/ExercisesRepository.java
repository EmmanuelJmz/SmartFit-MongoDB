package com.example.gym5b.models.exersices;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ExercisesRepository extends MongoRepository<Exercises, String > {
    @Query("[{ '$project': { 'id_exercise': 1, 'name': 1, 'description': 1, 'type': 1 }}, { '$sort': { 'name': 1 } }]")
    Exercises findAllExercises();

    @Query("{'name': ?0}")
    Exercises findExerciseByName(String name);

    Exercises findByName(String name);

    @Query(value = "[{ '$sort': { 'name': 1 } }]")
    Exercises findExercisesByAsc();

    @Query(value = "[{ '$sort': { 'name': -1 } }]")
    Exercises findExercisesByDesc();

    @Query(value = "[{ '$sort': { 'type': -1 } }]")
    Exercises findExercisesByTypeDesc();

    @Query(value = "[{ '$sort': { 'type': 1 } }]")
    Exercises findExercisesByTypeAsc();

    @Query("{'name': ?0}")
    Exercises deleteExerciseByName(String name);

    @Query(value="{}", delete = true)
    void deleteAllExercises();
}
