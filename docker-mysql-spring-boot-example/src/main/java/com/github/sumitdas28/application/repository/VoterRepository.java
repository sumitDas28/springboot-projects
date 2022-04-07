package com.github.sumitdas28.application.repository;

import com.github.sumitdas28.application.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter, Integer> {
}
