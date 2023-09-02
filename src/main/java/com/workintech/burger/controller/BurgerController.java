package com.workintech.burger.controller;

import com.workintech.burger.dao.BurgerDao;
import com.workintech.burger.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {

    private BurgerDao burgerDao;
    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @PostMapping("/")
    public Burger save (@RequestBody Burger burger){
        return burgerDao.save(burger);
    }

    @GetMapping("/")
    public List<Burger> get(){
        return burgerDao.findAll();
    }


}
