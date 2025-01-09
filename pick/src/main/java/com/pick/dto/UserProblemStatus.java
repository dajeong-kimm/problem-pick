package com.pick.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProblemStatus {
    private String username;
    private boolean solved;
}
