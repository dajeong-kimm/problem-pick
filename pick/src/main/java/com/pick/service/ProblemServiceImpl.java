package com.pick.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pick.dto.UserProblemStatus;
import com.pick.repository.HandleFetcher;
import com.pick.repository.UserRepository;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HandleFetcher handleFetcher;

    @Override
    public List<UserProblemStatus> getUserProblemStatuses(int problemId) {
        List<UserProblemStatus> statuses = new ArrayList<>();
        List<String> users = userRepository.getAllUsers();

        for (String user : users) {
            Set<Integer> solvedProblems = handleFetcher.fetchSolvedProblems(user);

            boolean isSolved = solvedProblems.contains(problemId); // 정확한 비교
            statuses.add(new UserProblemStatus(user, isSolved));
        }

        return statuses;
    }

    @Override
    public List<String> getSolvedUsers(int problemId) {
        List<String> allUsers = userRepository.getAllUsers();

        return allUsers.stream()
                .filter(username -> {
                    Set<Integer> solvedProblems = handleFetcher.fetchSolvedProblems(username);
                    return solvedProblems.contains(problemId);
                })
                .collect(Collectors.toList());
    }

}
