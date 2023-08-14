package org.example;

import org.example.entity.Planet;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class PlanetCrudService {
    @PersistenceContext
    private EntityManager entityManager;

    public PlanetCrudService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createPlanet(Planet planet) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(planet);
        transaction.commit();
    }


    public Planet getPlanetById(String id) {
        return entityManager.find(Planet.class, id);
    }

    public void updatePlanet(Planet planet) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(planet);
        transaction.commit();
    }

    public List<Planet> getAllPlanets() {
        TypedQuery<Planet> query = entityManager.createQuery("SELECT p FROM Planet p", Planet.class);
        return query.getResultList();
    }
    @Transactional
    public void deletePlanet(String id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Planet planet = entityManager.find(Planet.class, id);
        if (planet != null) {
            entityManager.remove(planet);
        }
        transaction.commit();
    }

    public void deletePlanetById(String id) {
        Planet planetToDelete = entityManager.find(Planet.class, id);
        if (planetToDelete != null) {
            entityManager.remove(planetToDelete);
        }
    }
}
