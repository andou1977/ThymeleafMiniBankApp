package com.example.thymeleafminibankapp.Service;

import com.example.thymeleafminibankapp.Entity.SogebankEntity;
import com.example.thymeleafminibankapp.Entity.UnibankEntity;
import com.example.thymeleafminibankapp.Repository.SogebankInterface;
import com.example.thymeleafminibankapp.Repository.SogebankRepository;
import com.example.thymeleafminibankapp.Repository.UnibankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SogebankService implements SogebankInterface  {

    SogebankRepository sogebankRepository;
    UnibankRepository unibankRepository;

    public SogebankService(SogebankRepository sogebankRepository, UnibankRepository unibankRepository) {
        this.sogebankRepository = sogebankRepository;
        this.unibankRepository = unibankRepository;
    }

    @Override
    public List<SogebankEntity> listallinfo() {
       return sogebankRepository.findAll();
    }

    @Override
    public SogebankEntity listbyid(int id) {
        return sogebankRepository.findById(id).orElse(null);
    }

    @Override
    public SogebankEntity savedata(SogebankEntity savedata) {
        return sogebankRepository.save(savedata);
    }

    @Override
    public void depot(double montant, int id) {
        SogebankEntity depot=sogebankRepository.findById(id).orElse(null);
        depot.setCompte(depot.getCompte()+montant);
        sogebankRepository.save(depot);
    }

    @Override
    public void virement(int idunibank, int idsogebank, double montant) {
        SogebankEntity idsogebank1=sogebankRepository.findById(idsogebank).orElse(null);
        UnibankEntity idunibank1=unibankRepository.findById(idunibank).orElse(null);
        idunibank1.setCompte(idunibank1.getCompte()-montant);
        idsogebank1.setCompte(idsogebank1.getCompte()+montant);
        unibankRepository.save(idunibank1);
        sogebankRepository.save(idsogebank1);

    }


}
