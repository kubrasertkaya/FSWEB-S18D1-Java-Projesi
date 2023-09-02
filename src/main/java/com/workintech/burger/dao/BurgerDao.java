package com.workintech.burger.dao;

import com.workintech.burger.entity.BreadType;
import com.workintech.burger.entity.Burger;

import java.util.List;

public interface BurgerDao {
    Burger save(Burger burger);
    List<Burger> findAll();
    Burger findById(int id);
    List<Burger> findByPrice(double price);
    List<Burger> findByBreadType(String breadType);
    List<Burger> findByContent(String contents);
    Burger update(Burger burger);
    Burger delete(Burger burger);

}
