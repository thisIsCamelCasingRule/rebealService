package com.example.rebealService.service;

import com.example.rebealService.model.King;
import com.example.rebealService.service.KingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KingService {
    private final KingRepo repos;
    private final com.example.rebealService.service.KingdomService kingdomService;

    @Autowired
    KingService(KingRepo repos, com.example.rebealService.service.KingdomService kingdomService)
    {
        this.repos = repos;
        this.kingdomService = kingdomService;
    }

    public King addKing(String name,String kingdom){
        if(getKingByName(name) != null)
        {
            return null;
        }
        else if (kingdomService.getKingdomByName(kingdom) != null){
            King new_k = new King(name, kingdom);
            repos.save(new_k);
            return new_k;
        }
        else{
            return null;
        }

    }

    public List<King> allKing(){
        return (List<King>) repos.findAll();
    }

    public King getKingByName(String name){
        return repos.getKingByName(name);
    }

    public boolean deleteKingByName(String name){
        King k = getKingByName(name);
        repos.delete(k);
        if(getKingByName(name) == null)
        {
            return true;
        }
        else{
            return false;
        }

    }

    public King updateKing(String name, String kingdom){
        if(getKingByName(name) != null){
            if(kingdomService.getKingdomByName(kingdom) != null){
                King k = getKingByName(name);

                k.setKingdom(kingdom);
                repos.save(k);

                return k;
            }
            else{
                System.out.println("ERROR: No such kingdom!");
                return null;
            }

        }
        else{
            System.out.println("ERROR: No such king!");
            return null;
        }

    }

    public boolean deleteOperation(List<King> list){
        if (list.size() == 0) return false;
        int iterator = 0;
        int iterationSize = list.size();

        for (iterator = 0; iterator < iterationSize; iterator++) {
            repos.delete(list.get(iterator));
        }
        return true;
    }

    public boolean deleteAllKing(){
        List<King> list = (List<King>) repos.findAll();
        return deleteOperation(list);
    }

}
