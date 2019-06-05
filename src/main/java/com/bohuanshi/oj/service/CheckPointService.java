package com.bohuanshi.oj.service;


import com.bohuanshi.oj.dao.CheckPointDAO;
import com.bohuanshi.oj.model.Checkpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckPointService {
    public List<Checkpoint>getCheckpointsByProblemId(long problemId){
        return checkPointDAO.getCheckpointsByProblemId(problemId);
    }
    @Autowired
    CheckPointDAO checkPointDAO;
}
