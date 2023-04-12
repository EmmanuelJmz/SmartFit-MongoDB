package com.example.gym5b.models.machines;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MachinesRepository extends MongoRepository<Machines, String > {
    @Query("[{ '$project': { 'id_machine': 1, 'name': 1, 'description': 1, 'quantity': 1 }}, { '$sort': { 'name': 1 } }]")
    List<Machines> findAllMachines();

    @Query("{'name': ?0}")
    List<Machines> findMachineByName(String name);

    @Query("{'id_machine': ?0}")
    Machines findMachineById(String id);

    Optional<Machines> findById(String id);

    @Query(value = "[{ '$sort': { 'name': 1 } }]")
    List<Machines> findMachinesByAsc();

    @Query(value = "[{ '$sort': { 'name': -1 } }]")
    List<Machines> findMachinesByDesc();

    @Query(value = "[{ '$sort': { 'quantity': -1 } }]")
    List<Machines> findMachinesByQuantityDesc();

    @Query(value = "[{ '$sort': { 'quantity': 1 } }]")
    List<Machines> findMachinesByQuantityAsc();

    @Query(value="{'id_machine' : ?0}", delete = true)
    public void deleteById(String id);

    //DELETE ALL MACHINES
    @Query(value="{}", delete = true)
    void deleteAllMachines();
}
