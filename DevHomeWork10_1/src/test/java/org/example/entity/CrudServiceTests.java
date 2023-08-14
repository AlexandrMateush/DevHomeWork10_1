package org.example.entity;

import org.example.ClientCrudService;
import org.example.PlanetCrudService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CrudServiceTests {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private ClientCrudService clientCrudService;
    private PlanetCrudService planetCrudService;

    @BeforeEach
    public void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence.xml");
        entityManager = entityManagerFactory.createEntityManager();
        clientCrudService = new ClientCrudService(entityManager);
        planetCrudService = new PlanetCrudService(entityManager);
    }

    @Test
    public void testClientCrudOperations() {
        Client client = new Client();
        client.setName("John Doe");
        clientCrudService.createClient(client);

        Client retrievedClient = clientCrudService.getClientById(client.getId());
        assertEquals("John Doe", retrievedClient.getName());

        retrievedClient.setName("Jane Doe");
        clientCrudService.updateClient(retrievedClient);
        Client updatedClient = clientCrudService.getClientById(client.getId());
        assertEquals("Jane Doe", updatedClient.getName());

        List<Client> allClients = clientCrudService.getAllClients();
        assertEquals(1, allClients.size());

        clientCrudService.deleteClient(client.getId());
        Client deletedClient = clientCrudService.getClientById(client.getId());
        assertNull(deletedClient);
    }

    @Test
    public void testPlanetCrudOperations() {

        Planet planet = new Planet();
        planet.setId("EARTH6");
        planet.setName("Earth");
        planetCrudService.createPlanet(planet);

        Planet retrievedPlanet = planetCrudService.getPlanetById(planet.getId());
        assertNotNull(retrievedPlanet);
        assertEquals("Earth", retrievedPlanet.getName());

        retrievedPlanet.setId("EARTH6");
        retrievedPlanet.setName("Earth");
        planetCrudService.updatePlanet(retrievedPlanet);
        Planet updatedPlanet = planetCrudService.getPlanetById((planet.getId()));
        assertEquals("Earth", updatedPlanet.getName());

        List<Planet> allPlanets = planetCrudService.getAllPlanets();
        assertEquals(1, allPlanets.size());

        planetCrudService.deletePlanet((planet.getId()));
        Planet deletedPlanet = planetCrudService.getPlanetById((planet.getId()));
        assertNull(deletedPlanet);
    }

}
