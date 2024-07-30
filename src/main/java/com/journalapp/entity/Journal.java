package com.journalapp.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Journal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String title;
	private String content;
	private LocalDateTime dateTime;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference // avoid cyclic JSON response
	private User user;

	public Journal() {
		this.dateTime = LocalDateTime.now();
	}
}
