package com.github.sumitdas28.application.controller;

import com.github.sumitdas28.application.entity.Voter;
import com.github.sumitdas28.application.repository.VoterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VotingAppController {
    private final VoterRepository voterRepository;

    public VotingAppController(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    @PostMapping("/submitVote")
    public ResponseEntity<Voter> submitVote(@RequestBody Voter voter) {
        try {
            Voter submittedVoter = voterRepository.save(voter);
            return new ResponseEntity<>(submittedVoter, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllVoteDetails")
    public ResponseEntity<List<Voter>> getAllVotes() {
        try {
            List<Voter> votesList = voterRepository.findAll();
            if (votesList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(votesList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
