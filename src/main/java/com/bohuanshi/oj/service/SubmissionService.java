package com.bohuanshi.oj.service;


import com.bohuanshi.oj.dao.SubmissionDAO;
import com.bohuanshi.oj.model.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {
    public Submission getSubmissionById(long submissionId) {
        return submissionDAO.getSubmission(submissionId);

    }

    public void updateSubmission(Submission submission) {
        submissionDAO.updateSubmission(submission);
    }

    @Autowired
    private SubmissionDAO submissionDAO;
}
