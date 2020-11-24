package com.example.rebealService.service;

import com.example.rebealService.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeasantService {

    private final PeasantRepo repos;
    private final com.example.rebealService.service.KingdomService kservice;



    @Autowired
    PeasantService(PeasantRepo reposit, com.example.rebealService.service.KingdomService kservice)
    {
        this.repos = reposit;
        this.kservice = kservice;

    }

    public Peasant addPeasant(String name, String position, String kingdom, boolean status){
        if(getPeasantByName(name) != null)
        {
            return null;
        }
        else if(kservice.getKingdomByName(kingdom) != null){
            Peasant new_p = new Peasant(name, position, kingdom, status);
            repos.save(new_p);
            return new_p;
        }
        else{
            return null;
        }
    }

    public List<Peasant> allPeasant(){
        return (List<Peasant>) repos.findAll();
    }

    public Peasant getPeasantByName(String name){
        return repos.getPeasantByName(name);
    }

    public boolean deletePeasantByName(String name){
        Peasant p = getPeasantByName(name);
        repos.delete(p);
        if(getPeasantByName(name) == null)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public Peasant updatePeasant(String name, String position, String kingdom, boolean status){
        if(getPeasantByName(name) != null){

                Peasant p = getPeasantByName(name);
                if(!status){
                    Kingdom k = kservice.getKingdomByName(kingdom);
                    kservice.updateKingdom( k.getName(), k.getSqare(),k.getPopulation() - 1, k.getAmountOfBuildings());
                }
                p.setName(name);
                p.setStatus(status);
                p.setPosition(position);
                repos.save(p);

                return p;
        }
        else{
            System.out.println("ERROR: No such peasant!");
            return null;
        }

    }

    public boolean deleteOperation(List<Peasant> list){
        if (list.size() == 0) return false;
        int iterator = 0;
        int iterationSize = list.size();

        for (iterator = 0; iterator < iterationSize; iterator++) {
            repos.delete(list.get(iterator));
        }
        return true;
    }

    public boolean deleteAllPeasant(){
        List<Peasant> list = (List<Peasant>) repos.findAll();
        return deleteOperation(list);
    }
}
