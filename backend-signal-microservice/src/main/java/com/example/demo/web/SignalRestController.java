package com.example.demo.web;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SignalRequestDTO;
import com.example.demo.model.SignalResponseDTO;
import com.example.demo.service.SignalService;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin("*")

public class SignalRestController {
	@Autowired
	private SignalService signalService;

	@GetMapping(path = "/signals")
	public List<SignalResponseDTO> signals() {
		return signalService.getSignal();
	}

	@GetMapping(path = "/signals/{id}")
	public SignalResponseDTO signalById(@PathVariable String id) {

		return signalService.getSignal(id);
	}

	@PostMapping(path = "/signals")
	public SignalResponseDTO save(@RequestBody SignalRequestDTO signalRequestDTO) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd--HH:mm:ss").format(new java.util.Date());
		signalRequestDTO.setDateAjout(timeStamp);
		return signalService.save(signalRequestDTO);
	}

	@DeleteMapping(path = "/signals/{id}")
	public void delete(@PathVariable String id) {
		signalService.deleteSignal(id);
	}

}