package com.example.gym5b.services.exercises;

import com.example.gym5b.models.exersices.Exercises;
import com.example.gym5b.models.exersices.ExercisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExercisesService {

    @Autowired
    private ExercisesRepository exercisesRepository;

    //CRUD OPERATIONS FOR EXERCISES <3 <3 <3

    //CREATE
    public Exercises addExercise(Exercises exercises) {
        // Verificar si el ejercicio ya está registrado
        Exercises existingExercise = exercisesRepository.findExerciseByName(exercises.getName());
        if (existingExercise != null) {
            throw new RuntimeException("El ejercicio ya está registrado");
        }

        // Generar un ID único para el ejercicio
        exercises.setId_exercise(UUID.randomUUID().toString().split("-")[0]);

        // Guardar el ejercicio en la base de datos
        return exercisesRepository.save(exercises);
    }

    //READ
    public Exercises findExerciseByName(String name){
        return exercisesRepository.findExerciseByName(name);
    }

    public Exercises findAllExercises(){
        return exercisesRepository.findAllExercises();
    }

    public Exercises findExercisesByAsc(){
        return exercisesRepository.findExercisesByAsc();
    }

    public Exercises findExercisesByDesc(){
        return exercisesRepository.findExercisesByDesc();
    }

    public Exercises findExercisesByTypeAsc(){
        return exercisesRepository.findExercisesByTypeAsc();
    }

    public Exercises findExercisesByTypeDesc(){
        return exercisesRepository.findExercisesByTypeDesc();
    }

    //UPDATE
    public Exercises updateExercise(String name, Exercises exercises){
        Exercises existingExercise = exercisesRepository.findByName(exercises.getName());
        if (existingExercise != null) {
            throw new RuntimeException("El ejercicio ya está registrado");
        }
        existingExercise.setName(exercises.getName());
        existingExercise.setDescription(exercises.getDescription());
        existingExercise.setType(exercises.getType());
        return exercisesRepository.save(existingExercise);
    }

    //DELETE
    public Exercises deleteExerciseByName(String name){
        return exercisesRepository.deleteExerciseByName(name);
    }

    public void deleteAllExercises(){
        exercisesRepository.deleteAllExercises();
    }
}
