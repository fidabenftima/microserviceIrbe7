package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.model.Signal;
import com.example.demo.model.SignalRequestDTO;
import com.example.demo.model.SignalResponseDTO;

@Component
public class SignalMapperImpl implements SignalMapper {

	@Override
	public SignalResponseDTO signalToSignalDTO(Signal signal) {
		if (signal == null) {
			return null;
		}

		SignalResponseDTO signalResponseDTO = new SignalResponseDTO();

		signalResponseDTO.setPublicationId(signal.getPublicationId());
		signalResponseDTO.setUserSignaleId(signal.getUserSignaleId());
		signalResponseDTO.setEtat(signal.isEtat());
		signalResponseDTO.setMessage(signal.getMessage());
		signalResponseDTO.setType(signal.getType());
		signalResponseDTO.setDateAjout(signal.getDateAjout());
		signalResponseDTO.setCommentaireId(signal.getCommentaireId());
		signalResponseDTO.setTypeSignal(signal.getTypeSignal());
		signalResponseDTO.setId(signal.getId());
		signalResponseDTO.setReportedUserId(signal.getReportedUserId());
		
		return signalResponseDTO;
	}

	@Override
	public Signal signalRequestDTOToSignal(SignalRequestDTO signalRequestDTO) {
		if (signalRequestDTO == null) {
			return null;
		}

		Signal signal = new Signal();

		signal.setId(signalRequestDTO.getId());
		signal.setPublicationId(signalRequestDTO.getPublicationId());
		signal.setUserSignaleId(signalRequestDTO.getUserSignaleId());
		signal.setEtat(signalRequestDTO.isEtat());
		signal.setMessage(signalRequestDTO.getMessage());
		signal.setType(signalRequestDTO.getType());
		signal.setDateAjout(signalRequestDTO.getDateAjout());
		signal.setCommentaireId(signalRequestDTO.getCommentaireId());
		signal.setTypeSignal(signalRequestDTO.getTypeSignal());
		signal.setReportedUserId(signalRequestDTO.getReportedUserId());

		return signal;
	}

}
