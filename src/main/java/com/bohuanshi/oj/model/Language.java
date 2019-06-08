package com.bohuanshi.oj.model;


import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * 编程语言的Model.
 * 对应数据库中的voj_languages数据表.
 * 
 */
@Entity
@Data
public class Language implements Serializable {
	/**
	 * 编程语言的默认构造函数.
	 */
	public Language() { }
	
	/**
	 * 编程语言的构造函数.
	 * @param languageSlug - 编程语言的英文缩写
	 * @param languageName - 编程语言的名称
	 * @param compileCommand - 编程语言的编译命令
	 * @param runCommand - 编程语言对应程序执行命令
	 */
	public Language(String languageSlug, String languageName, String compileCommand, String runCommand) {
		this.languageSlug = languageSlug;
		this.languageName = languageName;
		this.compileCommand = compileCommand;
		this.runCommand = runCommand;
	}
	

	@Override
	public String toString() {
		return String.format("Language [ID=%d, Slug=%s, Name=%s, CompileCommand=%s, runCommand=%s]",
				new Object[] { languageId, languageSlug, languageName, compileCommand, runCommand });
	}
	
	/**
	 * 编程语言的唯一标识符. 
	 */
	private int languageId;
	
	/**
	 * 编程语言的唯一英文简称.
	 */
	private String languageSlug;
	
	/**
	 * 编程语言的名称.
	 */
	private String languageName;
	
	/**
	 * 编程语言的编译命令.
	 */
	private String compileCommand;
	
	/**
	 * 编程语言的运行命令.
	 */
	private String runCommand;
	
	/**
	 * 唯一的序列化标识符
	 */
	private static final long serialVersionUID = 9065824880175832696L;
}
