package com.example.thymeleafminibankapp.Controller;

import com.example.thymeleafminibankapp.Entity.SogebankEntity;
import com.example.thymeleafminibankapp.Repository.SogebankRepository;
import com.example.thymeleafminibankapp.Service.SogebankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class sogebankcontroller {
    SogebankRepository sogebankRepository;
    SogebankService sogebankService;

    public sogebankcontroller(SogebankRepository sogebankRepository, SogebankService sogebankService) {
        this.sogebankRepository = sogebankRepository;
        this.sogebankService = sogebankService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
//lister
    @GetMapping("/list")
    public String listall(Model model){
        List<SogebankEntity> listall=sogebankService.listallinfo();
        model.addAttribute("listall",listall);
        return "list";
    }
//lister by id
    @GetMapping("/list/{id}")
    public String listbyid(@PathVariable int id, Model model){
        SogebankEntity listbyid=sogebankService.listbyid(id);
        model.addAttribute("listbyid",listbyid);
        return "listbyid";
    }
    //create
    @GetMapping("/create/new")
    public String savedata(Model model){
        model.addAttribute("savedata",new SogebankEntity());
                return "create";
    }
    //save data
    @PostMapping("/save")
    public String save(SogebankEntity savedata){
//        sogebankService.savedata(savedata);
        sogebankRepository.save(savedata);
        return "create";
    }

    @GetMapping("/depot/create")
    public String depotcreate(Model model){
        model.addAttribute("depot",new SogebankEntity());
        return "depot";
    }

    @PostMapping("/depot/{id}")
    public String depot(int id, double montant){
       sogebankService.depot(montant, id);
        return "depot";
    }

    @GetMapping("/virement")
    public String virement(Model model){
        model.addAttribute("virement", new SogebankEntity());
        return "virement";
    }

    @PostMapping("/virement/{id}")
    public String myvirement(int idunibank,int idsogebank,double montant){
        sogebankService.virement(idunibank,idsogebank,montant);
        return "virement";
    }
}
