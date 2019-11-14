package com.rgkCloud.vo;

/**
 * 统一响应结果 格式
 */
public class ReturnObject {
	private int code = 1; // 编码
	private String message = "success"; // 提示消息
	private Object result; // 数据

	public ReturnObject() {
		super();
	}

	
	public ReturnObject(int code, Object result) {
		super();
		this.code = code;
		this.result = result;
		this.message = code == 1 ? "success" : "fail";
	}


	public ReturnObject(int code, Object result, String message) {
		super();
		this.code = code;
		this.message = message;
		this.result = result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
