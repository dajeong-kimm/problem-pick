package com.pick.repository;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Repository;

@Repository
public class HandleFetcher {
	public Set<Integer> fetchSolvedProblems(String username) {
	    Set<Integer> solvedProblems = new HashSet<>();
	    String url = "https://www.acmicpc.net/user/" + username;

	    try {
	        Document doc = Jsoup.connect(url).get();
	        // Find the element containing "맞은 문제"
	        Element solvedProblemElement = doc.selectFirst("div:contains(맞은 문제)");

	        if (solvedProblemElement != null) {
	            // Extract problem numbers from the element
	            String problemsText = solvedProblemElement.text();

	            // Extract numbers using regex
	            Pattern pattern = Pattern.compile("\\b\\d+\\b");
	            Matcher matcher = pattern.matcher(problemsText);

	            while (matcher.find()) {
	                solvedProblems.add(Integer.parseInt(matcher.group()));
	            }
	        } else {
	            System.err.println("Could not find '맞은 문제' section for user: " + username);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (NumberFormatException e) {
	        System.err.println("Failed to parse problem number.");
	    }

	    return solvedProblems;
	}


}
