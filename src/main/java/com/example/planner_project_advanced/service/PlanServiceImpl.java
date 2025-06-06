package com.example.planner_project_advanced.service;


import com.example.planner_project_advanced.dto.CreatePlanDTO;
import com.example.planner_project_advanced.dto.DeletePlanDTO;
import com.example.planner_project_advanced.dto.PlanResponseDTO;
import com.example.planner_project_advanced.dto.PlanUpdateDTO;
import com.example.planner_project_advanced.entity.Plan;
import com.example.planner_project_advanced.entity.User;
import com.example.planner_project_advanced.repository.PlanRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Page<PlanResponseDTO> findAll(String updatedDate, String userName, Long userId, int page, int size) {
        Page<Plan> planPage = planRepository.findAll(updatedDate, userName, userId, page, size);

        List<PlanResponseDTO> dtoList = new ArrayList<>();
        for (Plan plan : planPage.getContent()) {
            String user = userService.findUserById(plan.getUserId()).getName();
            PlanResponseDTO dto = new PlanResponseDTO(plan.getContent(),user);
            dtoList.add(dto);
        }

        return new PageImpl<>(dtoList, planPage.getPageable(), planPage.getTotalElements());
    }

    @Override
    public PlanResponseDTO updatePlan(Long planId,Long userId, PlanUpdateDTO planUpdateDTO) {
        User user = userService.findUserById(userId);
        if (!user.getPassword().equals(planUpdateDTO.getPassword())) {
            return null;
            /**
             * todo : 비밀번호 다를때 예외처리
             */
        }
        user.setName(planUpdateDTO.getUserName());
        userService.updateUserName(user.getId(), user.getName());
        String content = planUpdateDTO.getContent();
        Plan plan = planRepository.updatePlan(planId, user.getId(), content);


        return new PlanResponseDTO(plan,user.getName());
    }

    @Override
    public void delete(DeletePlanDTO deletePlanDTO) {
        User user = userService.findUserByName(deletePlanDTO.getUserName());

        if (!user.getPassword().equals(deletePlanDTO.getPassword())) {
            return;
        }
        planRepository.deletePlan(user.getId(), deletePlanDTO.getId());
    }

}
