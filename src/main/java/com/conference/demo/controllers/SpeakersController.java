package com.conference.demo.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conference.demo.models.Speaker;
import com.conference.demo.repositories.SpeakerRepository;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

	@Autowired
	private SpeakerRepository speakerRepository;

	@GetMapping
	public List<Speaker> getAll() {
		return speakerRepository.findAll();
	}

	@GetMapping
	@RequestMapping("{id}")
	public Speaker getSpeaker(@PathVariable Long id) {
		return speakerRepository.getById(id);
	}

	@PostMapping
	public Speaker create(@RequestBody final Speaker speaker) {
		return speakerRepository.saveAndFlush(speaker);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		// Also need to check for children records before deleting. Need to configure
		// cascading in hibernate entities.
		speakerRepository.deleteById(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
		
		/*
		 * because this is a PUT, we expect all attributes to be passed in. Otherwise
		 * the attributes that are not passed in will be updated to NULL. A PATCH would
		 * only need what needs to be updated. So you might want to use a PATCH instead
		 * of PUT if all attributes are not going to be passed in.
		 */
		
		// TODO: Add validation that all attributes are passed in, otherwise return a
		// 400 bad payload.
		Speaker existingSpeaker = speakerRepository.getById(id);
		BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
		return speakerRepository.saveAndFlush(existingSpeaker);
	}
}
