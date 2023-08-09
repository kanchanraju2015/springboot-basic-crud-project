package com.briz.bioneone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>
{
	List<Address> findByAddressCity(String city);
}
