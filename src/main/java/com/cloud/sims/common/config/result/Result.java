package com.cloud.sims.common.config.result;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *   接口返回数据格式
 * @author longxin
 * @email 1753047507@qq.com
 * @date  2020年6月19日
 */

@Getter
@Setter
@ApiModel(description="统一返回对象")
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 成功标志
	 */
	@ApiModelProperty(value = "成功标志")
	private boolean success = false;

	/**
	 * 返回处理消息
	 */
	@ApiModelProperty(value = "处理消息")
	private String message = "操作失败！";

	/**
	 * 返回代码
	 */
	@ApiModelProperty(value = "状态码", example = "0")
	private Integer code = 0;

	/**
	 * 返回数据对象 data
	 */
	@ApiModelProperty(value = "数据对象")
	private T data;

	/**
	 * 时间戳
	 */
	@ApiModelProperty(value = "时间戳")
	private String timestamp = DateUtil.now();


	public static <T> Result<T> ok(){
		return new Result<T>().success();
	}

	public static <T> Result<T> ok(T data){
		return new Result<T>().success(data);
	}

	public static <T> Result<T> ok(String msg, T data){
		return new Result<T>().success(msg, data);
	}

	public static <T> Result<T> okStr(String msg){
		return new Result<T>().success(msg);
	}

	public static <T> Result<T> error(String msg){
		return new Result<T>().filed(msg);
	}

	public static <T> Result<T> error(Integer code, String msg){
		return new Result<T>().filed(msg, code);
	}

	private Result<T> success(){
		return success(200, null);
	}

	private Result<T> success(T data){
		return success(200, data);
	}

	private Result<T> filed(T data){
		return filed(0, data);
	}

	private Result<T> success(String msg){
		return success(msg, 200);
	}

	private Result<T> filed(String msg){
		return filed(msg, 0);
	}

	private  Result<T> success(Integer code){
		return success(code, null);
	}

	private  Result<T> filed(Integer code){
		return filed(code, null);
	}

	private  Result<T> success(String msg, Integer code){
		return success(msg, code, null);
	}

	private  Result<T> filed(String msg, Integer code){
		return filed(msg, code, null);
	}

	private  Result<T> success(String msg, T data){
		return success(msg, 200, data);
	}

	private  Result<T> filed(String msg, T data){
		return filed(msg, 0, data);
	}

	private  Result<T> success(Integer code, T data){
		return success("操作成功!", code, data);
	}

	private  Result<T> filed(Integer code, T data){
		return filed("操作失败!", code, data);
	}

	private  Result<T> success(String msg, Integer code, T data){
		return rest(true, msg, code, data);
	}

	private  Result<T> filed(String msg, Integer code, T data){
		return rest(false, msg, code, data);
	}

	private Result<T> rest(boolean success, String message, Integer code, T data) {
		this.success = success;
		this.message = message;
		this.code = code;
		this.data = data;
		return this;
	}



	@Override
	public String toString() {
		return (String) JSON.toJSON(this);
	}
}