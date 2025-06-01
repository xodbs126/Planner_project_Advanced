package com.example.planner_project_advanced.controller;


import com.example.planner_project_advanced.dto.CreatePlanDTO;
import com.example.planner_project_advanced.dto.PlanResponseDTO;
import com.example.planner_project_advanced.dto.PlanUpdateDTO;
import com.example.planner_project_advanced.service.PlanService;
import com.example.planner_project_advanced.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/plans/view")
    public ResponseEntity<Page<PlanResponseDTO>> findAll(
            @RequestParam(required = false) String updatedDate,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) Long userId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<PlanResponseDTO> result = planService.findAll(updatedDate, userName, userId, page - 1, size);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/plans/{planId}/{userId}")
    public ResponseEntity<PlanResponseDTO> updatePlan(
            @PathVariable Long planId,
            @PathVariable Long userId,
            @Valid @RequestBody PlanUpdateDTO planUpdateDTO
    ){
        return ResponseEntity.ok(planService.updatePlan(planId,userId, planUpdateDTO));
    }
}
