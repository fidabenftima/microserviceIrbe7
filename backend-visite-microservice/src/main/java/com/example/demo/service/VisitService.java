package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Visit;


@Service
public interface VisitService {
	Visit getVisit(String id);
	 List<Visit> getVisits();
	 Visit save(Visit visit);
	 Visit update(Visit visit);
	 void deleteVisit( String id);
	 List<Visit> findByDate(String date);
	 List<String> findDates();
	 List <String> findByMonth(String month); 
	 List<String> findLastNdaysDates(int n);
}
