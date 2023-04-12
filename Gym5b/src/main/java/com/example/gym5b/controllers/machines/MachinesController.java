package com.example.gym5b.controllers.machines;

import com.example.gym5b.models.machines.Machines;
import com.example.gym5b.services.machines.MachinesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gym")
public class MachinesController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MachinesService machinesService;

    @PostMapping("/addMachine")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createMachine(@RequestBody Machines machines){
        logger.info("Creando la máquina: {}...", machines.getName());
        Machines newMachine = machinesService.addMachine(machines);
        return ResponseEntity.ok(newMachine);
    }

    @GetMapping("/machines")
    public List<Machines> getAllMachines(){
        logger.info("Obteniendo todas las máquinas...");
        return machinesService.findAllMachines();
    }

    @GetMapping("/machines/{name}")
    public List<Machines> findMachineByName(@PathVariable String name){
        logger.info("Obteniendo la máquina: {}...", name);
        return machinesService.findMachineByName(name);
    }

    @GetMapping("/machinesDesc/")
    public List<Machines> findMachinesByDesc(){
        logger.info("Obteniendo las máquinas ordenadas por nombre descendente...");
        return machinesService.findMachinesByDesc();
    }

    @GetMapping("/machinesAsc/")
    public List<Machines> findMachinesByAsc(){
        logger.info("Obteniendo las máquinas ordenadas por nombre ascendente...");
        return machinesService.findMachinesByAsc();
    }

    @GetMapping("/machinesQuantityDesc/")
    public List<Machines> findMachinesByQuantityDesc(){
        logger.info("Obteniendo las máquinas ordenadas por cantidad descendente...");
        return machinesService.findMachinesByQuantityDesc();
    }

    @GetMapping("/machinesQuantityAsc/")
    public List<Machines> findMachinesByQuantityAsc(){
        logger.info("Obteniendo las máquinas ordenadas por cantidad ascendente...");
        return machinesService.findMachinesByQuantityAsc();
    }

    @PutMapping("/updateMachine/{id}")
    public ResponseEntity<?> updateMachine(@PathVariable int id, @RequestBody Machines machines){
        logger.info("Actualizando la máquina: {}...", machines.getName());
        Machines updatedMachine = machinesService.updateMachine(id, machines);
        return ResponseEntity.ok(updatedMachine);
    }
    
    @DeleteMapping("/deleteMachine/{id}")
    public ResponseEntity<?> deleteMachine(@PathVariable int id){
        logger.info("Eliminando la máquina con id: {}...", id);
        machinesService.deleteMachineById(String.valueOf(id));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAllMachines")
    public ResponseEntity<?> deleteAllMachines(){
        logger.info("Eliminando todas las máquinas...");
        machinesService.deleteAllMachines();
        return ResponseEntity.ok().build();
    }
}
