package com.conference.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conference.demo.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{

}
