package com.reviewtwits.service;

import com.reviewtwits.entity.Project;
import com.reviewtwits.repository.ProjectRepo;
import com.reviewtwits.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class ProjectService {
    ProjectRepo projectRepo;
    UserService userService;

    public ProjectService(ProjectRepo projectRepo, UserService userService) {
        this.projectRepo = projectRepo;
        this.userService = userService;
    }

    public Project displayProejctMetaData(String projectId) {
        return projectRepo.findProjectByProjectId(projectId);
    }

    public Project submitProjectToDatabase(Project project) {
        project.setUser(userService.loadUserByUsername(project.getUid()));
        String projectId = RandomUtil.getRandomName(20);
        while(displayProejctMetaData(projectId) != null)
            projectId = RandomUtil.getRandomName(20);
        project.setProjectId(projectId);
        return projectRepo.save(project);
    }

    public Project updateProjectToDatabase(String projectId, String uid, String summary, String category, int reviewStyle, String customCss, int aiPositiveNegative) {
        Project project = projectRepo.findProjectByProjectId(projectId);
        if(project == null || !project.getUser().getUid().equals(uid))
            return null;
        project.setSummary(summary);
        project.setCategory(category);
        project.setReviewStyle(reviewStyle);
        project.setCustomCss(customCss);
        project.setAiPositiveNegative(aiPositiveNegative);
        return projectRepo.save(project);
    }

    @Transactional
    public int deleteProjectToDatabase(String projectId, String uid) {
        Project project = projectRepo.findProjectByProjectId(projectId);
        if(project == null || !project.getUser().getUid().equals(uid))
            return -1;
        projectRepo.deleteByProjectId(projectId);
        return 0;
    }

    public ArrayList<Project> displayProjectByUser(String uid) {
        return projectRepo.findProjectByUser_Uid(uid);
    }
}
