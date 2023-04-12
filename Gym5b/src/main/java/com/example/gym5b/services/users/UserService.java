package com.example.gym5b.services.users;

import com.example.gym5b.models.users.UserRepository;
import com.example.gym5b.models.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    //CRUD OPERATIONS FOR USERS <3 <3 <3

    //CREATE
    public Users addUser(Users users) {
        // Verificar si el correo electrónico ya está registrado
        Users existingUser = userRepository.findByEmail(users.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("El correo electrónico ya está en uso");
        }

        // Generar un ID único para el usuario
        users.set_id(UUID.randomUUID().toString().split("-")[0]);

        // Indexar el campo "email"
        IndexOperations indexOps = mongoTemplate.indexOps(Users.class);
        indexOps.ensureIndex(new Index().on("age", Sort.Direction.ASC).unique());


        // Guardar el usuario en la base de datos
        return userRepository.save(users);
    }

    //READ
    public List<Users> findAllUsers(){
        return userRepository.findAllUsers();
    }

    public List<Users> findUserByName(String name){
        return userRepository.findUserByName(name);
    }

    public List<Users> findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public List<Users> findUsersByAsc(){
        return userRepository.findUsersByAsc();
    }

    public List<Users> findUsersByDesc(){
        return userRepository.findUsersByDesc();
    }

    public List<Users> findUsersByAgeAsc(){
        return userRepository.findUsersByAgeAsc();
    }

    public List<Users> findUsersByAgeDesc(){
        return userRepository.findUsersByAgeDesc();
    }

    //update user by email
    public Users updateUserByEmail(String email, Users users) {
        Users existingUser = userRepository.findByEmail(email);
        if (existingUser == null) {
            throw new RuntimeException("El usuario no existe");
        }

        // Actualizar los datos del usuario
        existingUser.setName(users.getName());
        existingUser.setLast_name(users.getLast_name());
        existingUser.setAge(users.getAge());
        existingUser.setEmail(users.getEmail());
        existingUser.setPassword(users.getPassword());

        // Guardar el usuario en la base de datos
        return userRepository.save(existingUser);
    }

    //DELETE
    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    public void deleteAllUsers() {
        userRepository.deleteAllUsers();
    }

    public List<Users> getUsersOverAge(int age) {
        return userRepository.findByAgeGreaterThan(age);
    }

}
