package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDoctorDao;
import com.app.pojos.Doctor;
import com.app.pojos.Patient;


@Service
@Transactional

public class DoctorServiceImpl implements IDoctorService  {

	@Autowired
	private IDoctorDao doctorDao ;
	
	
	@Override
	public List<Doctor> getAllDoctors() {
		
		return doctorDao.findAll();
	}


	@Override
	public Optional<Doctor> getDoctorDetails(String doctorName) {
	
		return  doctorDao.findByFirstName( doctorName);
	}


	@Override
	public Doctor getEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Doctor AddDoctor(Doctor doctor) {
		
		return doctorDao.save(doctor);
	}

}
