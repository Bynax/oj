package com.bohuanshi.oj.dao;

import com.bohuanshi.oj.model.Checkpoint;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/***
 * 对checkpoint表进行CRUD操作
 */
public interface CheckPointDAO {
    String TABLE_NAME = "checkpoint";

    /**
     * 获取某个试题的全部测试点.
     *
     * @param problemId - 试题的唯一标识符
     * @return 某个试题的全部测试点
     */
    @Select({"SELECT * FROM", TABLE_NAME, "WHERE problem_id = #{problemId}"})
    @Results({
            @Result(property = "problemId", column = "problem_id"),
            @Result(property = "checkpointId", column = "checkpoint_id"),
            @Result(property = "isExactlyMatch", column = "checkpoint_exactly_match"),
            @Result(property = "score", column = "checkpoint_score"),
            @Result(property = "input", column = "checkpoint_input"),
            @Result(property = "output", column = "checkpoint_output"),
    })
    List<Checkpoint> getCheckpointsByProblemId(@Param("problemId") long problemId);
}
