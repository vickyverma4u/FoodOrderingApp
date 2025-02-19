package com.upgrad.FoodOrderingApp.service.dao;


import com.upgrad.FoodOrderingApp.service.entity.AddressEntity;
import com.upgrad.FoodOrderingApp.service.entity.StateEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AddressDao {

    @PersistenceContext
    private EntityManager entityManager;

    public StateEntity getStateByUuid(String uuid) {

        try {
            return entityManager.createNamedQuery("StateUuid", StateEntity.class).
                    setParameter("uuid", uuid).getSingleResult();
        }
        catch (NoResultException exception) {
            return null;
        }

    }

    public List<StateEntity> getAllStates() {
        try {
            return entityManager.createNamedQuery("getAllStates", StateEntity.class).getResultList();
        }
        catch (NoResultException exception) {
            return null;
        }
    }

    public AddressEntity saveAddress(AddressEntity addressEntity){
        entityManager.persist(addressEntity);
        return addressEntity;
    }

    public AddressEntity getAddressByUuid(String uuid) {
        try {
            return entityManager.createNamedQuery("AddressUuid", AddressEntity.class).
                    setParameter("uuid", uuid).getSingleResult();
        }
        catch (NoResultException exception) {
            return null;
        }
    }

    public AddressEntity deleteAddress(AddressEntity addressEntity) {
        entityManager.remove(addressEntity);
        return addressEntity;
    }

    public List<AddressEntity> getAllSavedAddresses() {
        try {
            return entityManager.createNamedQuery("getAllSavedAddresses", AddressEntity.class).getResultList();
        }
        catch (NoResultException exception) {
            return null;
        }
    }
}
