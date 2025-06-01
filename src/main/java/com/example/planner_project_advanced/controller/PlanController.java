package com.example.planner_project_advanced.controller;


import com.example.planner_project_advanced.dto.CreatePlanDTO;
import com.example.planner_project_advanced.service.PlanService;
import com.example.planner_project_advanced.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PlanController {

    private final PlanService planService;
    private final UserService userService;

    public PlanController(PlanService planService, UserService userService) {
        this.planService = planService;
        this.userService = userService;
    }

    @PostMapping("/plan/{userId}")
    public ResponseEntity<CreatePlanDTO> createPlan(
            @PathVariable Long userId,
            @RequestBody CreatePlanDTO createPlanDTO
    ) {
        return new ResponseEntity<>(planService.createPlan(userId, createPlanDTO), HttpStatus.OK);
    }

}
