package com.conference.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conference.demo.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
