package org.example.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "from_planet_id")
    private String fromPlanetId;

    @Column(name = "to_planet_id")
    private String toPlanetId;

    public Ticket() {
    }

    public Ticket(Timestamp createdAt, Long clientId, String fromPlanetId, String toPlanetId) {
        this.createdAt = createdAt;
        this.clientId = clientId;
        this.fromPlanetId = fromPlanetId;
        this.toPlanetId = toPlanetId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFromPlanetId() {
        return fromPlanetId;
    }

    public void setFromPlanetId(String fromPlanetId) {
        this.fromPlanetId = fromPlanetId;
    }

    public String getToPlanetId() {
        return toPlanetId;
    }

    public void setToPlanetId(String toPlanetId) {
        this.toPlanetId = toPlanetId;
    }
}

