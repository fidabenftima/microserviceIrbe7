package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.SignalMapper;
import com.example.demo.model.Signal;
import com.example.demo.model.SignalRequestDTO;
import com.example.demo.model.SignalResponseDTO;
import com.example.demo.repository.SignalRepository;

@Service
@Transactional
public class SignalServiceImp implements SignalService {

	private SignalRepository signalRepository;
	private SignalMapper signalMapper;

	public SignalServiceImp(SignalRepository signalRepository, SignalMapper signalMapper) {
		this.signalRepository = signalRepository;
		this.signalMapper = signalMapper;
	}

	@Override
	public SignalResponseDTO getSignal(String id) {
		Signal signal = signalRepository.findById(id).get();
		return signalMapper.signalToSignalDTO(signal);
	}

	@Override
	public List<SignalResponseDTO> getSignal() {
		List<Signal> signals = signalRepository.findAll();
		return signals.stream().map((signal) -> signalMapper.signalToSignalDTO(signal)).collect(Collectors.toList());
	}

	@Override
	public SignalResponseDTO save(SignalRequestDTO signalRequestDTO) {
		Signal signal = signalMapper.signalRequestDTOToSignal(signalRequestDTO);
		Signal saveSignal = signalRepository.save(signal);
		return signalMapper.signalToSignalDTO(saveSignal);
	}

	@Override
	public void deleteSignal(String id) {
		signalRepository.deleteById(id);

	}

}
