package com.workintech.burger.controller;

import com.workintech.burger.dao.BurgerDao;
import com.workintech.burger.entity.Burger;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/burger")
public class BurgerController {

    private BurgerDao burgerDao;
    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @Transactional
    @PostMapping("/")
    public Burger save (@Validated @RequestBody Burger burger){
        return burgerDao.save(burger);
    }

    @GetMapping("/")
    public List<Burger> get(){
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger find(@PathVariable @Positive int id){
        return  burgerDao.findById(id);
    }
    @GetMapping("/findByPrice{price}")
    public List<Burger> findByPrice(@PathVariable int price){
        return burgerDao.findByPrice(price);

    }

    @GetMapping("/findByBreadType{price}")
    public List<Burger> findByBreadType(@PathVariable String breadType){
        return burgerDao.findByBreadType(breadType);

    }

    @GetMapping("/findByContent{content}")
    public List<Burger> findByContent(@PathVariable String content){
        return burgerDao.findByContent(content);

    }
    @Transactional
    @PutMapping("/")
    public Burger update(@RequestBody Burger burger){
         return burgerDao.update(burger);
    }

    @Transactional
    public  Burger delete(@PathVariable int id){
        Burger burger=find(id);
         burgerDao.delete(burger);
         return  burger;
    }



}
