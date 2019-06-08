package com.bohuanshi.oj.model;


import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * 试题的Model.
 * 对应数据库中的voj_problems数据表.
 * 
 */
@Data
@Entity
public class Problem implements Serializable {
	/**
	 * Problem的默认构造函数.
	 */
	public Problem() { }
	
	/**
	 * Problem的构造函数.
	 * @param isPublic - 试题是否公开
	 * @param problemName - 试题的名称
	 * @param timeLimit - 最大运行时间
	 * @param memoryLimit - 最大运行内存
	 * @param description - 试题描述
	 * @param inputFormat - 试题输入格式描述
	 * @param outputFormat - 试题输出描述
	 * @param sampleInput - 试题样例输入
	 * @param sampleOutput - 试题样例输出
	 * @param hint - 试题提示
	 */
	public Problem(boolean isPublic, String problemName, int timeLimit, int memoryLimit,  
					String description, String inputFormat, String outputFormat, 
					String sampleInput, String sampleOutput, String hint) { 
		this.isPublic = isPublic;
		this.problemName = problemName;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.description = description;
		this.inputFormat = inputFormat;
		this.outputFormat = outputFormat;
		this.sampleInput = sampleInput;
		this.sampleOutput = sampleOutput;
		this.hint = hint;
	}
	
	/**
	 * Problem类的构造函数.
	 * @param problemId - 试题唯一标识符
	 * @param isPublic - 试题是否公开
	 * @param problemName - 试题的名称
	 * @param timeLimit - 最大运行时间
	 * @param memoryLimit - 最大运行内存
	 * @param description - 试题描述
	 * @param inputFormat - 试题输入描述
	 * @param outputFormat - 试题输出描述
	 * @param sampleInput - 试题样例输入
	 * @param sampleOutput - 试题样例输出
	 * @param hint - 试题提示
	 */
	public Problem(long problemId, boolean isPublic, String problemName, int timeLimit, 
					int memoryLimit, String description, String inputFormat, String outputFormat, 
					String sampleInput, String sampleOutput, String hint) { 
		this(isPublic, problemName, timeLimit, memoryLimit, description, inputFormat, outputFormat, sampleInput, sampleOutput, hint);
		this.problemId = problemId;
	}
	

	@Override
	public String toString() {
		return String.format("Problem: [ProblemID=%s, isPublic=%s, ProblemName=%s, TimeLimit=%s, "
							+ "MemoryLimit=%s, Description=%s, InputFormat=%s, OutputFormat=%s, " 
							+ "SampleInput=%s, SampleOutput=%s, Hint=%s]", 
				new Object[] { problemId, isPublic, problemName, timeLimit, memoryLimit, 
								description, inputFormat, outputFormat, sampleInput, sampleOutput, hint});
	}

	/**
	 * 试题的唯一标识符.
	 */
	private long problemId;
	
	/**
	 * 试题是否公开.
	 */
	private boolean isPublic;
	
	/**
	 * 试题名称. 
	 */
	private String problemName;
	
	/**
	 * 最大运行时间.
	 */
	private int timeLimit;
	
	/**
	 * 最大运行内存.
	 */
	private int memoryLimit;
	
	/**
	 * 试题描述.
	 */
	private String description;
	
	/**
	 * 输入格式.
	 */
	private String inputFormat;
	
	/**
	 * 输出格式.
	 */
	private String outputFormat;
	
	/**
	 * 样例输入.
	 */
	private String sampleInput;
	
	/**
	 * 样例输出.
	 */
	private String sampleOutput;
	
	/**
	 * 试题提示.
	 */
	private String hint;
	
	/**
	 * 唯一的序列化标识符.
	 */
	private static final long serialVersionUID = 4703482016721365341L;
}
