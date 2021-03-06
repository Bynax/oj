package com.bohuanshi.oj.dao;

import com.bohuanshi.oj.model.Problem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface ProblemDAO {
    String TABLE_NAME = "problems";
    String INSERT_FIELD = "problem_is_public, problem_name,total_submission,problem_time_limit,problem_memory_limit,problem_description," +
            "problem_input_format,problem_output_format,problem_sample_input,problem_sample_output";
    String SELECTED_FIELD = "problem_id, " + INSERT_FIELD;


    @Select({"SELECT", SELECTED_FIELD, "FROM", TABLE_NAME, "WHERE problem_id = #{problemId}"})
    @Results({
            @Result(property = "problemId", column = "problem_id"),
            @Result(property = "isPublic", column = "problem_is_public"),
            @Result(property = "problemName", column = "problem_name"),
            @Result(property = "totalSubmission", column = "total_submission"),
            @Result(property = "acceptedSubmission", column = "accepted_submission"),
            @Result(property = "timeLimit", column = "problem_time_limit"),
            @Result(property = "memoryLimit", column = "problem_memory_limit"),
            @Result(property = "description", column = "problem_description"),
            @Result(property = "inputFormat", column = "problem_input_format"),
            @Result(property = "outputFormat", column = "problem_output_format"),
            @Result(property = "sampleInput", column = "problem_sample_input"),
            @Result(property = "sampleOutput", column = "problem_sample_output"),
            @Result(property = "hint", column = "problem_hint")
    })
    Problem getProblemById(@Param("problemId") long problemId);
}
