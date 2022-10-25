package com.example.demo.service;

import java.util.List;

import com.example.demo.model.SignalRequestDTO;
import com.example.demo.model.SignalResponseDTO;

public interface SignalService {
	SignalResponseDTO getSignal(String id);

	List<SignalResponseDTO> getSignal();

	SignalResponseDTO save(SignalRequestDTO signalRequestDTO);

	void deleteSignal(String id);
}
