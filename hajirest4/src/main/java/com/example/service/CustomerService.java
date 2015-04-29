package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Customer;
import com.example.domain.User;
import com.example.repository.CustomerRepository;
/**
 * カスタマのサービスクラス
 * @author nagase
 *
 */
@Service //サービスクラスであることを示す。Componentと意味は変わらない
@Transactional
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	/*
	 * すべてを返す
	 */
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	public Page<Customer> findAll(Pageable pageable){
		return customerRepository.findAllOrderByName2(pageable);
	}
	
	public Customer findOne(Integer id){
		return customerRepository.findOne(id);
	}
	public Customer create(Customer customer, User user){
		customer.setUser(user);
		return customerRepository.save(customer);
	}
	public Customer save(Customer customer){
		return customerRepository.save(customer);
	}
	public void delete(Integer id){
		 customerRepository.delete(id);
	}

	public Customer update(Customer customer,User user) {
		customer.setUser(user);
		return customerRepository.save(customer);
	}

	

}
