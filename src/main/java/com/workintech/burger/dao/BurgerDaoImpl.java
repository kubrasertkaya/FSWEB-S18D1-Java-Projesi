package com.workintech.burger.dao;

import com.workintech.burger.entity.BreadType;
import com.workintech.burger.entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BurgerDaoImpl implements BurgerDao {

    private EntityManager entityManager;

    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query=entityManager.createQuery("SELECT b FROM Burger b",Burger.class);
        return query.getResultList();
    }

    @Override
    public Burger findById(int id) {
         return  entityManager.find(Burger.class,id);

    }

    @Override
    public List<Burger> findByPrice(double price) {
        TypedQuery<Burger> query=entityManager
                .createQuery("SELECT b FROM Burger b WHERE b.PRİCE>=:price ORDER BY b.price desc ",Burger.class);
           query.setParameter("price",price);
        return  query.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query=entityManager.
                createQuery("SELECT b FROM Burger b WHERE b.breadType=:type ORDER BY name asc", Burger.class);
        query.setParameter("type",breadType.name());
        return query.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query=entityManager.
                createQuery("SELECT b FROM Burger b WHERE b.contents ilike '%:content%'", Burger.class);
        query.setParameter("content",content);
        return query.getResultList();
    }

    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);
    }

    @Override
    public Burger delete(Burger burger) {
        Burger foundBurger=findById(burger.getId());
        entityManager.remove(burger);
        return foundBurger;
    }
}
