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
    public List<UserProblemStatus> getProblemStatus(@RequestParam int problemId) {
        return problemService.getUserProblemStatuses(problemId);
    }
}
