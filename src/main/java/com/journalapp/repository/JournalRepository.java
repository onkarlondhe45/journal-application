package com.journalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.journalapp.entity.Journal;

public interface JournalRepository extends JpaRepository<Journal, Integer>{

}
