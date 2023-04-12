package com.example.gym5b.services.machines;

import com.example.gym5b.models.machines.Machines;
import com.example.gym5b.models.machines.MachinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MachinesService {
    
    @Autowired
    private MachinesRepository machinesRepository;
    
    //CRUD OPERATIONS FOR MACHINES <3 <3 <3
    
    //CREATE
    public Machines addMachine(Machines machines) {
        // Verificar si el nombre de la maquina ya está registrado
        Machines existingMachine = machinesRepository.findById(machines.getId_machine()).orElse(null);
        if (existingMachine != null) {
            throw new RuntimeException("El nombre de la maquina ya está en uso");
        }

        // Generar un ID único para la maquina
        machines.setId_machine(UUID.randomUUID().toString().split("-")[0]);

        // Guardar la maquina en la base de datos
        return machinesRepository.save(machines);
    }
    
    //READ
    public List<Machines> findMachineByName(String name){
        return machinesRepository.findMachineByName(name);
    }

    public Machines findMachineById(String id){
        return machinesRepository.findMachineById(id);
    }

    public List<Machines> findAllMachines(){
        return machinesRepository.findAllMachines();
    }

    public List<Machines> findMachinesByAsc(){
        return machinesRepository.findMachinesByAsc();
    }

    public List<Machines> findMachinesByDesc(){
        return machinesRepository.findMachinesByDesc();
    }

    public List<Machines> findMachinesByQuantityAsc(){
        return machinesRepository.findMachinesByQuantityAsc();
    }

    public List<Machines> findMachinesByQuantityDesc(){
        return machinesRepository.findMachinesByQuantityDesc();
    }

    //UPDATE
    public Machines updateMachine(int id, Machines machines){
        Machines existingMachine = machinesRepository.findById(machines.getId_machine()).orElse(null);
        if (existingMachine == null) {
            throw new RuntimeException("La maquina no existe");
        }
        existingMachine.setName(machines.getName());
        existingMachine.setDescription(machines.getDescription());
        existingMachine.setQuantity(machines.getQuantity());
        return machinesRepository.save(existingMachine);
    }

    //DELETE
    public void deleteMachineById(String id){
        machinesRepository.deleteById(id);
    }

    public void deleteAllMachines(){
        machinesRepository.deleteAllMachines();
    }
}
