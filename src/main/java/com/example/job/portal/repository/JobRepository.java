package com.example.job.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.job.portal.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}
