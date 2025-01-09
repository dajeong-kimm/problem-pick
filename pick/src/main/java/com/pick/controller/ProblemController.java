package com.pick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pick.dto.UserProblemStatus;
import com.pick.service.ProblemService;

@RestController
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    @GetMapping("/problem-status")
    public Object getProblemStatus(@RequestParam int problemId) {
        List<String> solvedUsers = problemService.getSolvedUsers(problemId);

        if (solvedUsers.isEmpty()) {
            return "아무도 풀지 않았습니다.";
        } else {
            return "문제 푼 사람: " + String.join(", ", solvedUsers);
        }
    }
}
