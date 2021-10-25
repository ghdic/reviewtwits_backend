package com.reviewtwits.repository;

import com.reviewtwits.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface ProjectRepo extends JpaRepository<Project, String> {
    Project save(Project project);
    Project findProjectByProjectId(String projectId);
    ArrayList<Project> findProjectByUser_Uid(String user_uid);
    @Transactional
    void deleteByProjectId(String projectId);
}
