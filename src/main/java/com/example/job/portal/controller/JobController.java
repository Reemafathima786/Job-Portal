package com.example.job.portal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job.portal.entity.Job;
import com.example.job.portal.repository.JobRepository;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

	private final JobRepository jobRepository;

	public JobController(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@PostMapping
	public Job createJob(@RequestBody Job job) {
		return jobRepository.save(job);
	}

	@GetMapping
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	@GetMapping("/{id}")
	public Job getJobById(@PathVariable Long id) {
		return jobRepository.findById(id).orElse(null);
	}

	@DeleteMapping("/{id}")
	public void deleteJob(@PathVariable Long id) {
		jobRepository.deleteById(id);
	}

}
