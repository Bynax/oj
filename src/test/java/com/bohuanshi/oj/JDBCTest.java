package com.bohuanshi.oj;

import com.bohuanshi.oj.model.JudgeResult;
import com.bohuanshi.oj.service.JudgeResultService;
import com.bohuanshi.oj.service.SubmissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 *数据库连接测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.bohuanshi.oj.application.ApplicationBootstrap.class)
public class JDBCTest {

    @Autowired
    JudgeResultService judgeResultService;

    @Test
    public void SubmissionServiceTest(){
        List<JudgeResult>a = judgeResultService.getAllJudgeResults();
        for(JudgeResult aa:a){
            System.out.println(aa.toString());
        }

    }
}
