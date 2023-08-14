package org.example;


import org.example.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


public class ClientCrudService {
    @PersistenceContext
    private EntityManager entityManager;

    public ClientCrudService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createClient(Client client) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(client);
        transaction.commit();
    }

    public Client getClientById(long id) {
        return entityManager.find(Client.class, id);
    }

    public void updateClient(Client client) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(client);
        transaction.commit();
    }

    public List<Client> getAllClients() {
        TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }

    public void deleteClient(long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Client client = entityManager.find(Client.class, id);
        if (client != null) {
            entityManager.remove(client);
        }
        transaction.commit();
    }
}
