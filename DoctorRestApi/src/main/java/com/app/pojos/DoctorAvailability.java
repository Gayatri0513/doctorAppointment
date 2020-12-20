package com.app.pojos;


import java.time.LocalTime;

import javax.persistence.*;



@Entity
@Table(name="Doctor_availability")

public class DoctorAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctor_availability_id; 
    
    @Enumerated(EnumType.STRING) //col type varchar (enum constant name)
	@Column(name="day_in_week",length = 20)
    private DayInWeek day;
    private LocalTime starting_time ;
    private LocalTime end_time ;
	private int minute_per_patient;
	
	
	public DoctorAvailability() {
		   System.out.println("in DoctorAvailability constructor "+getClass().getName());
	}

	
	

	public DoctorAvailability(DayInWeek day, LocalTime starting_time, LocalTime end_time, int minute_per_patient) {
		super();
		this.day = day;
		this.starting_time = starting_time;
		this.end_time = end_time;
		this.minute_per_patient = minute_per_patient;
	}




	public Integer getDoctor_availability_id() {
		return doctor_availability_id;
	}




	public void setDoctor_availability_id(Integer doctor_availability_id) {
		this.doctor_availability_id = doctor_availability_id;
	}







	public DayInWeek getDay() {
		return day;
	}




	public void setDay(DayInWeek day) {
		this.day = day;
	}




	public LocalTime getStarting_time() {
		return starting_time;
	}




	public void setStarting_time(LocalTime starting_time) {
		this.starting_time = starting_time;
	}




	public LocalTime getEnd_time() {
		return end_time;
	}




	public void setEnd_time(LocalTime end_time) {
		this.end_time = end_time;
	}




	public int getMinute_per_patient() {
		return minute_per_patient;
	}




	public void setMinute_per_patient(int minute_per_patient) {
		this.minute_per_patient = minute_per_patient;
	}




	@Override
	public String toString() {
		return "DoctorAvailability [doctor_availability_id=" + doctor_availability_id + ", day=" + day
				+ ", starting_time=" + starting_time + ", end_time=" + end_time + ", minute_per_patient="
				+ minute_per_patient + "]";
	}

	
	
	
	
	
	
}


