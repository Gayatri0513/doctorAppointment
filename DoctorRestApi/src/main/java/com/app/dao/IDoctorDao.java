package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Doctor;
import com.app.pojos.Patient;


public interface IDoctorDao  extends JpaRepository<Doctor,Integer> {
 
	List<Doctor> findAll();
	
	//search by patient name
	Optional<Doctor>  findByFirstName(String doctorName);
	Doctor findByEmailAndPassword(String email,String password ); 
	
}
