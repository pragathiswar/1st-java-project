package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, String>{

}
