package com.example.gym5b.models.users;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<Users, String > {
    @Query("[{ '$project': { 'id_user': 1, 'name': 1, 'last_name': 1, 'age': 1, 'email': 1, 'password': 1 }}, { '$sort': { 'name': 1 } }]")
    List<Users> findAllUsers();

    @Query("{'name': ?0}")
    List<Users> findUserByName(String name);

    @Query("{ 'email' : ?0 }")
    List<Users> findUserByEmail(String email);

    List<Users> findByAgeGreaterThan(int age);

    Users findByEmail(String email);

    @Query(value = "{}", sort = "{ 'name' : 1 }")
    List<Users> findUsersByAsc();

    @Query(value = "{}", sort = "{ 'name' : -1 }")
    List<Users> findUsersByDesc();

    @Query(value = "[{ '$sort': { 'age': -1 } }]")
    List<Users> findUsersByAgeDesc();

    @Query(value = "[{ '$sort': { 'age': 1 } }]")
    List<Users> findUsersByAgeAsc();

    @Query(value="{'email' : ?0}", delete = true)
    public void deleteByEmail(String id);

    //DELETE ALL USERS
    @Query(value="{}", delete = true)
    void deleteAllUsers();

}
