
package com.bohuanshi.oj.model;
import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 程序评测结果的Model.
 * 对应数据库中的voj_judge_results数据表.
 * 
 */
@Entity
@Data
public class JudgeResult implements Serializable {
	/**
	 * 评测结果类的默认构造函数.
	 */
	public JudgeResult() { }
	
	/**
	 * 评测结果类的构造函数.
	 * @param judgeResultId - 评测结果的唯一标识符
	 * @param judgeResultSlug - 评测结果的唯一英文缩写
	 * @param judgeResultName - 评测结果的名称
	 */
	public JudgeResult(int judgeResultId, String judgeResultSlug, String judgeResultName) {
		this.judgeResultId = judgeResultId;
		this.judgeResultSlug = judgeResultSlug;
		this.judgeResultName = judgeResultName;
	}
	

	@Override
	public String toString() {
		return String.format("JudgeResult [Id=%d, Slug=%s, Name=%s]",
				new Object[] { judgeResultId, judgeResultSlug, judgeResultName });
	}

	/**
	 * 评测结果的唯一标识符.
	 */
	@Id
	@NotNull
	@Column(length = 4)
	private int judgeResultId;
	
	/**
	 * 评测结果的英文唯一缩写.
	 */
	@Column(length = 4,unique = true)
	@NotNull
	private String judgeResultSlug;
	
	/**
	 * 评测结果的名称.
	 */
	@Column(length = 32)
	@NotNull
	private String judgeResultName;
	
	/**
	 * 唯一的序列化标识符.
	 */
	private static final long serialVersionUID = -1572920076997918781L;
}
