package com.example.gym5b.models.instructors;

import com.example.gym5b.models.users.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface InstructorsRepository extends MongoRepository<Instructors, String > {
    @Query("[{ '$project': { 'id_instructor': 1, 'name': 1, 'last_name': 1, 'age': 1, 'email': 1, 'password': 1 }}, { '$sort': { 'name': 1 } }]")
    List<Instructors> findAllInstructors();

    @Query("{'name': ?0}")
    List<Instructors> findInstructorByName(String name);

    @Query("{ 'email' : ?0 }")
    Instructors findInstructorByEmail(String email);

    Instructors findByEmail(String email);

    @Query(value = "[{ '$sort': { 'name': 1 } }]")
    List<Instructors> findInstructorsByAsc();

    @Query(value = "[{ '$sort': { 'name': -1 } }]")
    List<Instructors> findInstructorsByDesc();

    @Query(value = "[{ '$sort': { 'age': -1 } }]")
    List<Instructors> findInstructorsByAgeDesc();

    @Query(value = "[{ '$sort': { 'age': 1 } }]")
    List<Instructors> findInstructorsByAgeAsc();

    @Query(value="{'email' : ?0}", delete = true)
    public void deleteByEmail(String id);

    //DELETE ALL INSTRUCTORS
    @Query(value="{}", delete = true)
    void deleteAllInstructors();
}
