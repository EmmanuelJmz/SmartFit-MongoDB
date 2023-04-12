package com.example.gym5b.services.instructors;

import com.example.gym5b.models.instructors.Instructors;
import com.example.gym5b.models.instructors.InstructorsRepository;
import com.example.gym5b.models.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InstructorsService {

    @Autowired
    private InstructorsRepository instructorsRepository;

    //CRUD OPERATIONS FOR INSTRUCTORS <3 <3 <3

    //CREATE
    public Instructors addInstructor(Instructors instructors) {
        // Verificar si el correo electrónico ya está registrado
        Instructors existingInstructor = instructorsRepository.findByEmail(instructors.getEmail());
        if (existingInstructor != null) {
            throw new RuntimeException("El correo electrónico ya está en uso");
        }

        // Generar un ID único para el instructor
        instructors.set_id(UUID.randomUUID().toString().split("-")[0]);

        // Guardar el instructor en la base de datos
        return instructorsRepository.save(instructors);
    }

    //READ
    public List<Instructors> findInstructorByName(String name){
        return instructorsRepository.findInstructorByName(name);
    }

    public Instructors findInstructorByEmail(String email){
        return instructorsRepository.findInstructorByEmail(email);
    }

    public List<Instructors> findAllInstructors(){
        return instructorsRepository.findAllInstructors();
    }

    public List<Instructors> findInstructorsByAsc(){
        return instructorsRepository.findInstructorsByAsc();
    }

    public List<Instructors> findInstructorsByDesc(){
        return instructorsRepository.findInstructorsByDesc();
    }

    public List<Instructors> findInstructorsByAgeAsc(){
        return instructorsRepository.findInstructorsByAgeAsc();
    }

    public List<Instructors> findInstructorsByAgeDesc(){
        return instructorsRepository.findInstructorsByAgeDesc();
    }

    public Instructors updateInstructorByEmail(String email, Instructors instructors){
        Instructors existingInstructor = instructorsRepository.findByEmail(email);
        if (existingInstructor == null) {
            throw new RuntimeException("El isntructor no existe");
        }
        existingInstructor.setName(instructors.getName());
        existingInstructor.setLast_name(instructors.getLast_name());
        existingInstructor.setAge(instructors.getAge());
        existingInstructor.setEmail(instructors.getEmail());
        existingInstructor.setPassword(instructors.getPassword());

        return instructorsRepository.save(existingInstructor);
    }

    //DELETE
    public void deleteByEmail(String email){
        instructorsRepository.deleteByEmail(email);
    }

    public void deleteAllInstructors(){
        instructorsRepository.deleteAllInstructors();
    }
}
