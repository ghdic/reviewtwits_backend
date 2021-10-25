package com.reviewtwits.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.reviewtwits.entity.Project;
import com.reviewtwits.message.request.ProjectReq;
import com.reviewtwits.service.ProjectService;
import com.reviewtwits.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    FirebaseAuth firebaseAuth;
    @Autowired
    ProjectService projectService;

    @GetMapping("")
    private ArrayList<Project> getProjectFromUser(@RequestHeader("Authorization") String authorization) {
        return projectService.displayProjectByUser(TokenUtil.parseUid(firebaseAuth, authorization));
    }

    @PostMapping("")
    private Project submitProject(@RequestBody Project project) {
        return projectService.submitProjectToDatabase(project);
    }

    @PostMapping("/{projectId}")
    private Project updateProject(@PathVariable("projectId")String projectId, @RequestHeader("Authorization") String authorization,
                                  @RequestBody ProjectReq projectReq) {
        return projectService.updateProjectToDatabase(projectId, TokenUtil.parseUid(firebaseAuth, authorization),
                projectReq.getSummary(), projectReq.getCategory(), projectReq.getReviewStyle(),
                projectReq.getCustomCss(), projectReq.getAiPositiveNegative());
    }

    @DeleteMapping("/{projectId}")
    private int deleteProject(@PathVariable("projectId")String projectId, @RequestHeader("Authorization") String authorization) {
        return projectService.deleteProjectToDatabase(projectId, TokenUtil.parseUid(firebaseAuth, authorization));
    }
}
