package com.wipro.jcb.livelink.app.commonUtils.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wipro.jcb.livelink.app.commonUtils.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>{

	@Query(nativeQuery = true,value="Select customer_name from common_util.customer_details where id=:id")
	String findCustomerNameById(int id);

}
