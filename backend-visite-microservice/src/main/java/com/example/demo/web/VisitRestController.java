package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Visit;
import com.example.demo.service.VisitService;

@RestController
@RequestMapping(path="/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class VisitRestController {
	
	@Autowired
	private VisitService visitService;
	
	@GetMapping(path="/visits")
	  public List<Visit> visits(){
		  return visitService.getVisits();
	}
	
	@GetMapping(path="/visits/{id}")
	public Visit visitById(@PathVariable String id) {
		return visitService.getVisit(id);
	}
	
	@PostMapping(path="/visits",consumes = {"application/json;charset=UTF-8"}, produces={"application/json;charset=UTF-8"})
	public Visit save(@RequestBody Visit visit) {
		
		return visitService.save(visit);
	}
	
	@PutMapping(path="/visits/{id}")
	  public Visit update(@RequestBody Visit visit,@PathVariable String id) {
		  visit.setVisitId(id);
		  return visitService.save(visit);}
	
	  @DeleteMapping(path="/visits/{id}")
	  public void delete(@PathVariable String id) {
		  visitService.deleteVisit(id);}
	  
	  @GetMapping(path="/visits/date/{date}")
	  public List<Visit> visitsByDate(@PathVariable String date){
		  return visitService.findByDate(date);
	  }
	  
	  @PostMapping(path="/add")
	  public Visit add(@RequestBody String date) {
		  Visit v = new Visit();
		  v.setDate(date);
		  return visitService.save(v);
	  }
	  
	  @GetMapping(path="/visits/dates")
	  public List<String> findDates() {
		return visitService.findDates();
	  }
	  
	  @GetMapping(path="/visits/month/{month}")
	  public List<String> findDatesByMonth(@PathVariable String month){
		  return visitService.findByMonth(month);
	  }
	  
	  @GetMapping(path="/visits/lastNdays/{n}")
	  public List<String> findLast7daysDates(@PathVariable int n) {
		  return visitService.findLastNdaysDates(n);
	  }
}
