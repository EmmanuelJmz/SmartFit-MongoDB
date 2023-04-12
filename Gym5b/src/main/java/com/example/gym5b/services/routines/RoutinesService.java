package com.example.gym5b.services.routines;

import com.example.gym5b.models.routines.Routines;
import com.example.gym5b.models.routines.RoutinesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoutinesService {

    @Autowired
    private RoutinesRespository routinesRespository;

    //CRUD OPERATIONS FOR ROUTINES <3 <3 <3

    //CREATE
    public Routines addRoutine(Routines routines){
        //Verificar si la rutina ya existe
        Routines existingRoutine = routinesRespository.findByName(routines.getName());
        if(existingRoutine != null){
            throw new RuntimeException("La rutina ya existe");
        }

        //Generar un ID único para la rutina
        routines.setId_routine(UUID.randomUUID().toString().split("-")[0]);

        //Guardar la rutina en la base de datos
        return routinesRespository.save(routines);
    }

    //READ
    public Routines findRoutineByName(String name){
        return routinesRespository.findRoutineByName(name);
    }

    public Routines findAllRoutines(){
        return routinesRespository.findAllRoutines();
    }

    public Routines findRoutinesByAsc(){
        return routinesRespository.findRoutinesByAsc();
    }

    public Routines findRoutinesByDesc(){
        return routinesRespository.findRoutinesByDesc();
    }

    public Routines findRoutinesByTypeAsc(){
        return routinesRespository.findRoutinesByTypeAsc();
    }

    public Routines findRoutinesByTypeDesc(){
        return routinesRespository.findRoutinesByTypeDesc();
    }

    //UPDATE
    public Routines updateRoutineByName(String name, Routines routines){
        Routines existingRoutine = routinesRespository.findRoutineByName(name);
        if(existingRoutine == null){
            throw new RuntimeException("La rutina no existe");
        }
        existingRoutine.setName(routines.getName());
        existingRoutine.setDescription(routines.getDescription());
        existingRoutine.setType(routines.getType());
        return routinesRespository.save(existingRoutine);
    }

    //DELETE
    public void deleteRoutineByName(String name){
        routinesRespository.deleteByName(name);
    }

    public void deleteAllRoutines(){
        routinesRespository.deleteAllRoutines();
    }

    public List<Routines> getRoutinesByType(String type) {
        return routinesRespository.findByType(type);
    }

}
