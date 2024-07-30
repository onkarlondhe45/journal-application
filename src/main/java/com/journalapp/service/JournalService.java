package com.journalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.journalapp.entity.Journal;
import com.journalapp.entity.User;
import com.journalapp.exception.ResourceNotFoundException;
import com.journalapp.repository.JournalRepository;

@Service
public class JournalService {

	@Autowired
	private JournalRepository journalRepository;

	@Autowired
	private UserService userService;

	public Journal createJournal(Journal journal, int id) {
		User user = userService.findById(id);
		journal.setUser(user);
		Journal save = journalRepository.save(journal);
		user.getJournals().add(save);
		userService.createUser(user);
		return save;
	}

	public List<Journal> findAllJournal() {
		List<Journal> findAll = journalRepository.findAll();
		return findAll;
	}

	public Journal findJournalById(int id) {
		Journal journal = journalRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Journal", "id", id));

		return journal;
	}

	public Journal updateJournal(int id, Journal journal) {
		Journal journalDetail = journalRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("journal", "id", id));
		journalDetail.setTitle(journal.getTitle());
		journalDetail.setContent(journal.getContent());

		Journal update = journalRepository.save(journalDetail);
		return update;
	}

	public void deleteJournal(int id) {
		Journal journalDetail = journalRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("journal", "id", id));
		journalRepository.delete(journalDetail);
	}

}
