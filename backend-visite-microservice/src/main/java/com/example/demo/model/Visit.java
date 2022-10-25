package com.example.demo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.Visit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "visits")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Visit {
	@Id
	private String visitId;
	private String date;
	
}
