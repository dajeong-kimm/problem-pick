package com.pick;


import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import com.pick.repository.HandleFetcher;

@SpringBootApplication
public class PickApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PickApplication.class, args);

	}
	
	private final HandleFetcher handleFetcher;
	
	public PickApplication(HandleFetcher handleFetcher) {
        this.handleFetcher = handleFetcher;
    }
	
	@Override
    public void run(String... args) throws Exception {
        // Replace "username" with the BOJ handle of a test user
        String testUsername = "rlaekwjd6545";
        Set<Integer> solvedProblems = handleFetcher.fetchSolvedProblems(testUsername);
        for (int solved : solvedProblems) {
        	System.out.println(solved);
        }
        System.out.println("Solved Problems for " + testUsername + ": " + solvedProblems);
    }

}
