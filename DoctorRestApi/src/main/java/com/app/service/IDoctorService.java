package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.app.pojos.Doctor;


public interface IDoctorService {

	List<Doctor> getAllDoctors();
	Optional<Doctor> getDoctorDetails(String doctorName);
	Doctor getEmailAndPassword(String email,String  password);
	Doctor AddDoctor( Doctor doctor);
}
