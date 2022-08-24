package com.pluralsight.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;

@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {
	
	private SpeakerRepository repository;
	
	public SpeakerServiceImpl() {
		System.out.println("SpeakerServiceImpl no args constructor");
	}
	
	@Autowired
	public SpeakerServiceImpl (SpeakerRepository speakerRepository) {
		System.out.println("SpeakerServiceImpl repository constructor");
		repository = speakerRepository;
	}
	
	@PostConstruct
	private void initialize() {
		System.out.println("We're called after the constructors.");
	}

	public List<Speaker> findAll(){
		return repository.findAll();
	}

	
	public void setRepository(SpeakerRepository repository) {
		System.out.println("SpeakerServiceImpl setter");
		this.repository = repository;
	}
	
	
	
}
