package com.example.demo.service;

   
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.model.Visit;
import com.example.demo.repository.VisitRepository;

@Service
public class VisitServiceImpl implements VisitService {
	private VisitRepository visitRepository;

	public VisitServiceImpl (VisitRepository visitRepository) {
		this.visitRepository= visitRepository;
		}
	
	@Override
	public Visit getVisit(String id) {
		Visit visit = visitRepository.findById(id).get();
		return visit;
	}
	
	@Override
	public List<Visit> getVisits(){
		List<Visit> visits = visitRepository.findAll();
		return visits.stream().collect(Collectors.toList());
	}
	
	@Override
	public Visit save (Visit visit) {
		Visit saveVisit = visitRepository.save(visit);
		return saveVisit;
	}
	
	@Override
	public Visit update(Visit visit) {
		Visit saveVisit= visitRepository.save(visit);
		return saveVisit;
	}

	@Override
	public void deleteVisit(String id) {
		visitRepository.deleteById(id);
		
	}

	@Override
	public List<Visit> findByDate(String date) {
		return visitRepository.findByDate(date).stream().collect(Collectors.toList());
	}
	
	@Override
	public List<String> findDates(){
	List <Visit> visits = visitRepository.findAll();
	List<String> dates = new ArrayList<String>();
	for(int i=0;i<visits.size();i++) {
		dates.add(visits.get(i).getDate());
	}
	return dates;}
	
	@Override
	public List<String> findByMonth(String month){
		List <Visit> visits = visitRepository.findAll();
		List<String> dates = new ArrayList<String>();
		for(int i=0;i<visits.size();i++) {
			

			if(month.equals(visits.get(i).getDate().substring(5, 7))) {
				dates.add(visits.get(i).getDate());
			}
		}
	
		return dates;
		}
	
	@Override
	public List<String> findLastNdaysDates(int n){
		List <Visit> visits = visitRepository.findAll();
		List<String> dates = new ArrayList<String>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String[] days = new String[n];
        days[0] = dateFormat.format(date);
        for(int i = 1; i < n; i++){
            cal.add(Calendar.DAY_OF_MONTH, -1);
            date = cal.getTime();
            days[i] = dateFormat.format(date);
        }
		for(int i=0;i<visits.size();i++) {
			if(Arrays.asList(days).contains(visits.get(i).getDate())) {
				dates.add(visits.get(i).getDate());
			}
		}
		return dates;
	}


}