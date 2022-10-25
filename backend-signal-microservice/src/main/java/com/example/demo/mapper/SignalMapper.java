package com.example.demo.mapper;

import com.example.demo.model.Signal;
import com.example.demo.model.SignalRequestDTO;
import com.example.demo.model.SignalResponseDTO;

public interface SignalMapper {
	SignalResponseDTO signalToSignalDTO(Signal signal);

	Signal signalRequestDTOToSignal(SignalRequestDTO signalRequestDTO);
}
