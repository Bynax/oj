package com.bohuanshi.oj.dao;

import ch.qos.logback.classic.db.names.TableName;
import com.bohuanshi.oj.model.JudgeResult;
import org.apache.ibatis.annotations.*;

import java.util.List;

/***
 * 对judge_results表进行CRUD操作
 */

public interface JudgeResultDAO {
    String TABLE_NAME="judge_result";
    /**
     * 通过评测结果的唯一标识符获取评测结果对象.
     * @return 预期的评测结果对象或空引用
     */
    @Select({"SELECT * FROM", TABLE_NAME})
    @Results({
            @Result(property = "judgeResultId", column = "judge_result_id"),
            @Result(property = "judgeResultSlug", column = "judge_result_slug"),
            @Result(property = "judgeResultName", column = "judge_result_name")
    })
    List<JudgeResult> getAllJudgeResults();

    /**
     * 通过评测结果的唯一英文缩写获取评测结果对象.
     * @param judgeResultSlug - 评测结果的唯一英文缩写
     * @return 预期的评测结果对象或空引用
     */
    @Select({"SELECT * FROM", TABLE_NAME, "WHERE judge_result_slug = #{judgeResultSlug}"})
    @Results({
            @Result(property = "judgeResultId", column = "judge_result_id"),
            @Result(property = "judgeResultSlug", column = "judge_result_slug"),
            @Result(property = "judgeResultName", column = "judge_result_name")
    })
    JudgeResult getJudgeResultBySlug(@Param("judgeResultSlug") String judgeResultSlug);

}
