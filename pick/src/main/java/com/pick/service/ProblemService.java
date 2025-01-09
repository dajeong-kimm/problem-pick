package com.pick.service;

import java.util.List;

import com.pick.dto.UserProblemStatus;

public interface ProblemService {
    List<UserProblemStatus> getUserProblemStatuses(int problemId);
    List<String> getSolvedUsers(int problemId);
}
