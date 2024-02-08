package com.test.firstproject.repository;

import com.test.firstproject.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    public Address findByCityAndStateAndType(String city, String state, String type);
}
