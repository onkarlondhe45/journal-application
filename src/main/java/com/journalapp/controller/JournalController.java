package com.journalapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journalapp.entity.Journal;
import com.journalapp.entity.User;
import com.journalapp.service.JournalService;
import com.journalapp.service.UserService;

@RestController
@RequestMapping("/journal")
public class JournalController {

	@Autowired
	private JournalService journalService;

	@Autowired
	private UserService userService;

	@PostMapping("/create/{id}")
	public ResponseEntity<Journal> createJournal(@RequestBody Journal journal, @PathVariable int id) {
		Journal createJournal = journalService.createJournal(journal, id);
		if (createJournal != null) {
			return new ResponseEntity<Journal>(createJournal, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Journal>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getAll/{id}")
	public ResponseEntity<List<Journal>> getAllJournalOfUser(@PathVariable int id) {
		User user = userService.findById(id);
		List<Journal> findAllJournal = user.getJournals();
		if (findAllJournal != null) {
			return new ResponseEntity<List<Journal>>(findAllJournal, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Journal>>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Journal> getById(@PathVariable int id) {
		Journal findJournalById = journalService.findJournalById(id);
		if (findJournalById != null) {
			return new ResponseEntity<Journal>(findJournalById, HttpStatus.OK);
		} else {
			return new ResponseEntity<Journal>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Journal> updateJournal(@RequestBody Journal journal, @PathVariable int id) {
		Journal updateJournal = journalService.updateJournal(id, journal);
		if (updateJournal != null) {
			return new ResponseEntity<Journal>(updateJournal, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Journal>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteJournal(@PathVariable int id) {
		journalService.deleteJournal(id);
		return new ResponseEntity<String>("journal deleted...!", HttpStatus.OK);
	}
}
