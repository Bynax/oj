package com.bohuanshi.oj.service;


import com.bohuanshi.oj.dao.JudgeResultDAO;
import com.bohuanshi.oj.model.JudgeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudgeResultService {
    public JudgeResult getJudgeResultBySlug(String judgeResultSlug) {
        return judgeResultDAO.getJudgeResultBySlug(judgeResultSlug);
    }

    public List<JudgeResult> getAllJudgeResults() {
        return judgeResultDAO.getAllJudgeResults();

    }


    @Autowired
    JudgeResultDAO judgeResultDAO;
}
