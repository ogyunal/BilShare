package com.bilshare.backend.entity;

import javax.persistence.*;

/**
 * The Abstract Entity Class which provides the equals and hashcode methods for the entities.
 * @author BilShare
 * @version 1.0
 */
@MappedSuperclass
public abstract class AbstractEntity {

    // properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    /**
     * This method gets the id of an AbstractEntity
     * @return the id of the AbstractEntity
     */
    public Long getId() {
        return id;
    }

    /**
     * This method checks if an entity is persisted to the database
     * @return whether or not the entity is persisted
     */
    public boolean isPersisted() {
        return id != null;
    }

    /**
     * This method creates a hashCode representation for the entity
     * @return the hashcode representation
     */
    @Override
    public int hashCode() {
        if (getId() != null) {
            return getId().hashCode();
        }
        return super.hashCode();
    }

    /**
     * This method checks if two entities are equal
     * @return whether or not the entities are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AbstractEntity other = (AbstractEntity) obj;
        if (getId() == null || other.getId() == null) {
            return false;
        }
        return getId().equals(other.getId());
    }
}
