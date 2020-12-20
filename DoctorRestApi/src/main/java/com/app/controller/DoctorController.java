
package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.pojos.Doctor;
import com.app.pojos.Patient;
import com.app.service.IDoctorService;
import com.app.service.IPatientService;



@RestController //@Controller =>at class level + @Responsebody added on  the return type of all req handling method
@RequestMapping ("/doctors")
public class DoctorController {

	@Autowired
	private IDoctorService doctorService ;
	
	
	public	DoctorController() {
		System.out.println("in constructor of"+getClass().getName());
	}
	
	
	
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> doctorLogin(@RequestBody Doctor doctor){
		String email=doctor.getEmail();
        String password =doctor.getPassword();	
       
		if(email != null &&  !" ".equals(email)) 
			doctor = doctorService.getEmailAndPassword(email, password);
	     
	     if(doctor != null)
		return new  ResponseEntity<>(doctor,HttpStatus.OK);
		
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	
	//ResponseEntity=>entire Response packet represented by ResponseEntity
	@GetMapping
	public ResponseEntity<?> getAllDoctors(){
		
		System.out.println("in  getAllDoctors method  of"+getClass().getName());
		//empty patient list:set status code 204(no content)
		
		List<Doctor> doctors=doctorService.getAllDoctors();
		if(doctors.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
     return new  ResponseEntity<>(doctors,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{doctorName}")
	public ResponseEntity<?> getDoctorDetails(@PathVariable String doctorName ){
		
		   Optional<Doctor> doctortDetails= doctorService.getDoctorDetails(doctorName);
		    if(doctortDetails.isPresent()) 
		    	return new  ResponseEntity<>(doctortDetails,HttpStatus.OK);
		    
		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	//dispatcher servlet do un-marshalling/de serialization(json-->java obj)
	@PostMapping()
	public  ResponseEntity<?> AddDoctor(@RequestBody Doctor doctor) {
		System.out.println("in add doctor");
			try {
				Doctor savedDoctor=	doctorService.AddDoctor(doctor);
			return new ResponseEntity<>(savedDoctor,HttpStatus.OK);
			}
			catch(RuntimeException ex) {
				ex.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}
	
	
}
