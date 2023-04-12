package com.example.gym5b.controllers.instructors;

import com.example.gym5b.models.instructors.Instructors;
import com.example.gym5b.models.instructors.InstructorsRepository;
import com.example.gym5b.models.users.UserRepository;
import com.example.gym5b.models.users.Users;
import com.example.gym5b.services.instructors.InstructorsService;
import com.example.gym5b.services.users.UserService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gym")
public class InstructorsController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private InstructorsService instructorsService;

    @Autowired
    private InstructorsRepository instructorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/addInstructor")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createInstructor(@RequestBody Instructors instructors){
        logger.info("Creando al instructor: {}...", instructors.getName());
        Instructors newInstructor = instructorsService.addInstructor(instructors);
        return ResponseEntity.ok(newInstructor);
    }

    @GetMapping("/instructors")
    public List<Instructors> getAllInstructors(){
        logger.info("Obteniendo todos los instructores...");
        return instructorsService.findAllInstructors();
    }

    @GetMapping("/instructors/{name}")
    public List<Instructors> findInstructorByName(@PathVariable String name){
        logger.info("Obteniendo el instructor: {}...", name);
        return instructorsService.findInstructorByName(name);
    }

    @GetMapping("/instructorsEmail/{email}")
    public Instructors getInstructorByEmail(@PathVariable String email){
        logger.info("Obteniendo el instructor: {}...", email);
        return instructorsService.findInstructorByEmail(email);
    }

    @GetMapping("/instructorsDesc/")
    public List<Instructors> findInstructorsByDesc(){
        logger.info("Obteniendo los instructores ordenados por nombre descendente...");
        return instructorsService.findInstructorsByDesc();
    }

    @GetMapping("/instructorsAsc/")
    public List<Instructors> findInstructorsByAsc(){
        logger.info("Obteniendo los instructores ordenados por nombre ascendente...");
        return instructorsService.findInstructorsByAsc();
    }

    @GetMapping("/findInstructorsByAgeAsc/")
    public List<Instructors> findInstructorsByAgeAsc(){
        logger.info("Obteniendo los instructores ordenados por edad ascendente...");
        return instructorsService.findInstructorsByAgeAsc();
    }

    @GetMapping("/findInstructorsByAgeDesc/")
    public List<Instructors> findInstructorsByAgeDesc(){
        logger.info("Obteniendo los instructores ordenados por edad descendente...");
        return instructorsService.findInstructorsByAgeDesc();
    }

    @PutMapping("/updateInstructor/{email}")
    public ResponseEntity<?> updateInstructor(@PathVariable String email, @RequestBody Instructors instructors){

        logger.info("Actualizando al instructor: {}...", email);
        Instructors updateInstructor = instructorsService.updateInstructorByEmail(email, instructors);
        return ResponseEntity.ok(updateInstructor);
    }

    @DeleteMapping("/deleteInstructor/{email}")
    public ResponseEntity<?> deleteInstructor(@PathVariable String email){
        logger.info("Eliminando al instructor: {}...", email);
        instructorsService.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAllInstructors/")
    public ResponseEntity<?> deleteAllInstructors(){
        logger.info("Eliminando todos los instructores...");
        instructorsService.deleteAllInstructors();
        return ResponseEntity.ok().build();
    }

}
