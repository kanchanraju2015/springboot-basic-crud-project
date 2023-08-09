package com.briz.bioneone;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController 
{
@Autowired
CustomerRepository crepo;
@Autowired
AddressRepository arepo;  // must be autowired for all repositories 

@RequestMapping("/allcustomer")
public List<Customer> allcust()
{
	return crepo.findAll();  // customer repository used here  bidirectional
}

@RequestMapping("/alladdress")
public List<Address> alladd()
{
	return arepo.findAll();  // address repository used here bidirectional
}

@RequestMapping("/by/{id}")
public Optional<Customer> byid(@PathVariable int id)
{
return crepo.findById(id);	// all data of both tables can be accessed bcoz customerrepo
}// IF DELEYEBYID IS USED THEN BOTH TABLE DATA WILL BE DELETED 
@RequestMapping("/find/{city}")
public List<Address> getbycity(@PathVariable String city)
{
	return  arepo.findByAddressCity(city);//  THIS METHOD IS DEFINED IN ADDREPO NOTE BIDIRECT
}
}
