package com.example.thymeleafminibankapp.Repository;

import com.example.thymeleafminibankapp.Entity.SogebankEntity;

import java.util.List;

public interface SogebankInterface {

    public List<SogebankEntity> listallinfo();
    SogebankEntity listbyid(int id);
    SogebankEntity savedata(SogebankEntity savedata);
    void depot(double montant,int id);

    void virement(int idunibank,int idsogebank,double montant);
}
