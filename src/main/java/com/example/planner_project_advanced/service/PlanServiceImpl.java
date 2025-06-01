package com.example.planner_project_advanced.service;


import com.example.planner_project_advanced.dto.CreatePlanDTO;
import com.example.planner_project_advanced.entity.Plan;
import com.example.planner_project_advanced.entity.User;
import com.example.planner_project_advanced.repository.PlanRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;
    private final UserService userService;

    public PlanServiceImpl(PlanRepository planRepository, UserService userService) {
        this.planRepository = planRepository;
        this.userService = userService;
    }

    @Override
    public CreatePlanDTO createPlan(Long userId, CreatePlanDTO createPlanDTO) {
        User user = userService.findUserById(userId);
        /***
         * todo: user == null일때 예외 처리 추가
         */
        Plan plan = new Plan(userId,createPlanDTO);
        planRepository.createPlan(plan);
        return new CreatePlanDTO(plan);
    }

}
