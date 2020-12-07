# 学生信息管理系统 API 接口文档


**简介**:学生信息管理系统 API 接口文档


**HOST**:localhost:8888


**联系人**:江浒一只猫


**Version**:V1.0


**接口路径**:/v2/api-docs?group=Main


[TOC]






# 专业模块


## 新增专业


**接口地址**:`/sims/major/v1/add`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "code": "",
  "name": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|from|from|body|true|MajorFrom|MajorFrom|
|&emsp;&emsp;code|||false|string||
|&emsp;&emsp;name|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除(逻辑删)


**接口地址**:`/sims/major/v1/super-delete`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|false|array|string|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #新增-更新


**接口地址**:`/sims/major/v1/super-edit`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|code||query|false|string||
|createTime||query|false|string(date-time)||
|id||query|false|string||
|isDelete||query|false|boolean||
|name||query|false|string||
|updateTime||query|false|string(date-time)||
|version||query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据导出链接


**接口地址**:`/sims/major/v1/super-export-data-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据模板下载链接


**接口地址**:`/sims/major/v1/super-export-templat-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取


**接口地址**:`/sims/major/v1/super-get-no-filter/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取(过滤内容)


**接口地址**:`/sims/major/v1/super-get/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #Excel批量导入


**接口地址**:`/sims/major/v1/super-import-excel`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|file|file|body|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #全部列表


**接口地址**:`/sims/major/v1/super-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #分页列表


**接口地址**:`/sims/major/v1/super-page-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|current||query|false|integer(int64)||
|orders[0].asc||query|false|boolean||
|orders[0].column||query|false|string||
|records||query|false|array|object|
|searchCount||query|false|boolean||
|size||query|false|integer(int64)||
|total||query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除


**接口地址**:`/sims/major/v1/super-remove/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


# 学生模块


## 新增学生


**接口地址**:`/sims/student/v1/add`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "gradeId": "",
  "name": "",
  "number": "",
  "position": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|from|from|body|true|AddStudentFrom|AddStudentFrom|
|&emsp;&emsp;gradeId|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;number|||false|string||
|&emsp;&emsp;position|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 删除用户


**接口地址**:`/sims/student/v1/del/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 修改个人信息


**接口地址**:`/sims/student/v1/edit`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "address": "",
  "avatar": "",
  "birthDay": "",
  "email": "",
  "phone": "",
  "sex": "",
  "username": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|from|from|body|true|EditUserFrom|EditUserFrom|
|&emsp;&emsp;address|||true|string||
|&emsp;&emsp;avatar|||false|string||
|&emsp;&emsp;birthDay|||false|string||
|&emsp;&emsp;email|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;sex|||true|string||
|&emsp;&emsp;username|||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 修改学生信息


**接口地址**:`/sims/student/v1/editStudent`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "gradeId": "",
  "id": "",
  "name": "",
  "number": "",
  "position": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|from|from|body|true|EditStudentFrom|EditStudentFrom|
|&emsp;&emsp;gradeId|||false|string||
|&emsp;&emsp;id|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;number|||false|string||
|&emsp;&emsp;position|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 根据学号获取学生信息


**接口地址**:`/sims/student/v1/findByNumber/{number}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|number|number|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 获取当前登录学生信息


**接口地址**:`/sims/student/v1/findLogin`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 根据系统用户ID获取


**接口地址**:`/sims/student/v1/getSysUserId/{sysUserId}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|sysUserId|sysUserId|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 学生登录


**接口地址**:`/sims/student/v1/login`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "account": "",
  "password": "",
  "type": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|from|from|body|true|LoginFrom|LoginFrom|
|&emsp;&emsp;account|||true|string||
|&emsp;&emsp;password|||true|string||
|&emsp;&emsp;type|||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 搜索(学号-姓名)


**接口地址**:`/sims/student/v1/search/{search}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|search|search|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除(逻辑删)


**接口地址**:`/sims/student/v1/super-delete`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|false|array|string|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #新增-更新


**接口地址**:`/sims/student/v1/super-edit`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|createTime||query|false|string(date-time)||
|gradeId||query|false|string||
|id||query|false|string||
|isDelete||query|false|boolean||
|number||query|false|string||
|position||query|false|string||
|sysUserId||query|false|string||
|updateTime||query|false|string(date-time)||
|version||query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据导出链接


**接口地址**:`/sims/student/v1/super-export-data-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据模板下载链接


**接口地址**:`/sims/student/v1/super-export-templat-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取


**接口地址**:`/sims/student/v1/super-get-no-filter/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取(过滤内容)


**接口地址**:`/sims/student/v1/super-get/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #Excel批量导入


**接口地址**:`/sims/student/v1/super-import-excel`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|file|file|body|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #全部列表


**接口地址**:`/sims/student/v1/super-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #分页列表


**接口地址**:`/sims/student/v1/super-page-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|current||query|false|integer(int64)||
|orders[0].asc||query|false|boolean||
|orders[0].column||query|false|string||
|records||query|false|array|object|
|searchCount||query|false|boolean||
|size||query|false|integer(int64)||
|total||query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除


**接口地址**:`/sims/student/v1/super-remove/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


# 成绩模块


## 获取学生成绩表


**接口地址**:`/sims/achievement/v1/findStudentAchievement/{studentId}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|studentId|studentId|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 课程名模糊查询学生成绩


**接口地址**:`/sims/achievement/v1/findStudentAchievement/{studentId}/{courseName}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|courseName|courseName|path|true|string||
|studentId|studentId|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 学生成绩


**接口地址**:`/sims/achievement/v1/getStudentScore/{gradeId}/{courseId}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|courseId|courseId|path|true|string||
|gradeId|gradeId|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 修改成绩


**接口地址**:`/sims/achievement/v1/putScore/{courseId}/{studentId}/{score}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|courseId|courseId|path|true|string||
|score|score|path|true|string||
|studentId|studentId|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除(逻辑删)


**接口地址**:`/sims/achievement/v1/super-delete`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|false|array|string|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #新增-更新


**接口地址**:`/sims/achievement/v1/super-edit`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|courseId||query|false|string||
|createTime||query|false|string(date-time)||
|id||query|false|string||
|isDelete||query|false|boolean||
|score||query|false|string||
|studentId||query|false|string||
|updateTime||query|false|string(date-time)||
|version||query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据导出链接


**接口地址**:`/sims/achievement/v1/super-export-data-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据模板下载链接


**接口地址**:`/sims/achievement/v1/super-export-templat-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取


**接口地址**:`/sims/achievement/v1/super-get-no-filter/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取(过滤内容)


**接口地址**:`/sims/achievement/v1/super-get/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #Excel批量导入


**接口地址**:`/sims/achievement/v1/super-import-excel`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|file|file|body|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #全部列表


**接口地址**:`/sims/achievement/v1/super-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #分页列表


**接口地址**:`/sims/achievement/v1/super-page-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|current||query|false|integer(int64)||
|orders[0].asc||query|false|boolean||
|orders[0].column||query|false|string||
|records||query|false|array|object|
|searchCount||query|false|boolean||
|size||query|false|integer(int64)||
|total||query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除


**接口地址**:`/sims/achievement/v1/super-remove/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


# 日志模块


## #根据ID删除(逻辑删)


**接口地址**:`/sims/log/v1/super-delete`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|false|array|string|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #新增-更新


**接口地址**:`/sims/log/v1/super-edit`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|code||query|false|integer(int32)||
|content||query|false|string||
|createTime||query|false|string(date-time)||
|device||query|false|string||
|id||query|false|string||
|ip||query|false|string||
|isDelete||query|false|boolean||
|logType||query|false|integer(int32)||
|message||query|false|string||
|method||query|false|string||
|model||query|false|string||
|operateType||query|false|integer(int32)||
|success||query|false|boolean||
|updateTime||query|false|string(date-time)||
|url||query|false|string||
|userId||query|false|string||
|version||query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据导出链接


**接口地址**:`/sims/log/v1/super-export-data-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据模板下载链接


**接口地址**:`/sims/log/v1/super-export-templat-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取


**接口地址**:`/sims/log/v1/super-get-no-filter/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取(过滤内容)


**接口地址**:`/sims/log/v1/super-get/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #Excel批量导入


**接口地址**:`/sims/log/v1/super-import-excel`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|file|file|body|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #全部列表


**接口地址**:`/sims/log/v1/super-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #分页列表


**接口地址**:`/sims/log/v1/super-page-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|current||query|false|integer(int64)||
|orders[0].asc||query|false|boolean||
|orders[0].column||query|false|string||
|records||query|false|array|object|
|searchCount||query|false|boolean||
|size||query|false|integer(int64)||
|total||query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除


**接口地址**:`/sims/log/v1/super-remove/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


# 班级模块


## 新增班级


**接口地址**:`/sims/grade/v1/add`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "leaderId": "",
  "majorId": "",
  "name": "",
  "number": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|from|from|body|true|GradeFrom|GradeFrom|
|&emsp;&emsp;leaderId|||false|string||
|&emsp;&emsp;majorId|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;number|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 修改班级名称


**接口地址**:`/sims/grade/v1/edit`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "gradeId": "",
  "name": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|from|from|body|true|EditFrom|EditFrom|
|&emsp;&emsp;gradeId|||false|string||
|&emsp;&emsp;name|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 根据班级ID获取班级课程信息


**接口地址**:`/sims/grade/v1/findCourseInfoById/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 根据班级ID获取班级信息


**接口地址**:`/sims/grade/v1/findInfoById/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 获取用户的班级列表


**接口地址**:`/sims/grade/v1/findInfoByUserId/{type}/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||
|type|type|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 根据班级ID获取班级学生信息


**接口地址**:`/sims/grade/v1/findStudentInfoById/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 发布公告


**接口地址**:`/sims/grade/v1/notice`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "gradeId": "",
  "notice": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|from|from|body|true|NoticeFrom|NoticeFrom|
|&emsp;&emsp;gradeId|||false|string||
|&emsp;&emsp;notice|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除(逻辑删)


**接口地址**:`/sims/grade/v1/super-delete`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|false|array|string|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #新增-更新


**接口地址**:`/sims/grade/v1/super-edit`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|createTime||query|false|string(date-time)||
|id||query|false|string||
|isDelete||query|false|boolean||
|leaderId||query|false|string||
|majorId||query|false|string||
|name||query|false|string||
|notice||query|false|string||
|number||query|false|string||
|updateTime||query|false|string(date-time)||
|version||query|false|integer(int32)||
|year||query|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据导出链接


**接口地址**:`/sims/grade/v1/super-export-data-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据模板下载链接


**接口地址**:`/sims/grade/v1/super-export-templat-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取


**接口地址**:`/sims/grade/v1/super-get-no-filter/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取(过滤内容)


**接口地址**:`/sims/grade/v1/super-get/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #Excel批量导入


**接口地址**:`/sims/grade/v1/super-import-excel`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|file|file|body|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #全部列表


**接口地址**:`/sims/grade/v1/super-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #分页列表


**接口地址**:`/sims/grade/v1/super-page-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|current||query|false|integer(int64)||
|orders[0].asc||query|false|boolean||
|orders[0].column||query|false|string||
|records||query|false|array|object|
|searchCount||query|false|boolean||
|size||query|false|integer(int64)||
|total||query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除


**接口地址**:`/sims/grade/v1/super-remove/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


# 用户模块


## 修改个人信息


**接口地址**:`/sims/user/v1/edit`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "address": "",
  "avatar": "",
  "birthDay": "",
  "email": "",
  "phone": "",
  "sex": "",
  "username": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|from|from|body|true|EditUserFrom|EditUserFrom|
|&emsp;&emsp;address|||true|string||
|&emsp;&emsp;avatar|||false|string||
|&emsp;&emsp;birthDay|||false|string||
|&emsp;&emsp;email|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;sex|||true|string||
|&emsp;&emsp;username|||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 修改密码


**接口地址**:`/sims/user/v1/editPwd`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "id": "",
  "newPwd": "",
  "newTwoPwd": "",
  "oldPwd": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|from|from|body|true|EditPwdFrom|EditPwdFrom|
|&emsp;&emsp;id|||false|string||
|&emsp;&emsp;newPwd|||false|string||
|&emsp;&emsp;newTwoPwd|||false|string||
|&emsp;&emsp;oldPwd|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 获取当前登录用户信息


**接口地址**:`/sims/user/v1/findUserInfo`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 注销登录


**接口地址**:`/sims/user/v1/logout`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除(逻辑删)


**接口地址**:`/sims/user/v1/super-delete`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|false|array|string|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #新增-更新


**接口地址**:`/sims/user/v1/super-edit`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|address||query|false|string||
|avatar||query|false|string||
|birth||query|false|string(date-time)||
|createTime||query|false|string(date-time)||
|email||query|false|string||
|id||query|false|string||
|isDelete||query|false|boolean||
|name||query|false|string||
|password||query|false|string||
|phone||query|false|string||
|sex||query|false|string||
|status||query|false|string||
|type||query|false|string||
|updateTime||query|false|string(date-time)||
|username||query|false|string||
|version||query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据导出链接


**接口地址**:`/sims/user/v1/super-export-data-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据模板下载链接


**接口地址**:`/sims/user/v1/super-export-templat-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取


**接口地址**:`/sims/user/v1/super-get-no-filter/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取(过滤内容)


**接口地址**:`/sims/user/v1/super-get/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #Excel批量导入


**接口地址**:`/sims/user/v1/super-import-excel`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|file|file|body|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #全部列表


**接口地址**:`/sims/user/v1/super-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #分页列表


**接口地址**:`/sims/user/v1/super-page-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|current||query|false|integer(int64)||
|orders[0].asc||query|false|boolean||
|orders[0].column||query|false|string||
|records||query|false|array|object|
|searchCount||query|false|boolean||
|size||query|false|integer(int64)||
|total||query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除


**接口地址**:`/sims/user/v1/super-remove/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


# 管理员模块


## 根据工号获取教师信息


**接口地址**:`/sims/leader/v1/findByNumber/{number}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|number|number|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 获取当前登录教师信息


**接口地址**:`/sims/leader/v1/findLogin`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 获取当前登录教师的班级ID


**接口地址**:`/sims/leader/v1/getGradeId`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 教师登录


**接口地址**:`/sims/leader/v1/login`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "account": "",
  "password": "",
  "type": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|from|from|body|true|LoginFrom|LoginFrom|
|&emsp;&emsp;account|||true|string||
|&emsp;&emsp;password|||true|string||
|&emsp;&emsp;type|||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除(逻辑删)


**接口地址**:`/sims/leader/v1/super-delete`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|false|array|string|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #新增-更新


**接口地址**:`/sims/leader/v1/super-edit`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|createTime||query|false|string(date-time)||
|id||query|false|string||
|isDelete||query|false|boolean||
|leaderType||query|false|string||
|number||query|false|string||
|sysUserId||query|false|string||
|updateTime||query|false|string(date-time)||
|version||query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据导出链接


**接口地址**:`/sims/leader/v1/super-export-data-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据模板下载链接


**接口地址**:`/sims/leader/v1/super-export-templat-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取


**接口地址**:`/sims/leader/v1/super-get-no-filter/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取(过滤内容)


**接口地址**:`/sims/leader/v1/super-get/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #Excel批量导入


**接口地址**:`/sims/leader/v1/super-import-excel`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|file|file|body|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #全部列表


**接口地址**:`/sims/leader/v1/super-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #分页列表


**接口地址**:`/sims/leader/v1/super-page-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|current||query|false|integer(int64)||
|orders[0].asc||query|false|boolean||
|orders[0].column||query|false|string||
|records||query|false|array|object|
|searchCount||query|false|boolean||
|size||query|false|integer(int64)||
|total||query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除


**接口地址**:`/sims/leader/v1/super-remove/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


# 课程模块


## 新增课程


**接口地址**:`/sims/course/v1/add`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "credit": "",
  "learnTime": "",
  "name": "",
  "number": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|from|from|body|true|CourseFrom|CourseFrom|
|&emsp;&emsp;credit|||false|string||
|&emsp;&emsp;learnTime|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;number|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 修改课程信息


**接口地址**:`/sims/course/v1/edit`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "gradeId": "",
  "name": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|from|from|body|true|EditFrom|EditFrom|
|&emsp;&emsp;gradeId|||false|string||
|&emsp;&emsp;name|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 获取班级课程列表


**接口地址**:`/sims/course/v1/getByGradeId/{gradeId}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|gradeId|gradeId|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除(逻辑删)


**接口地址**:`/sims/course/v1/super-delete`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|false|array|string|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #新增-更新


**接口地址**:`/sims/course/v1/super-edit`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|createTime||query|false|string(date-time)||
|credit||query|false|string||
|id||query|false|string||
|isDelete||query|false|boolean||
|learnTime||query|false|string||
|majorId||query|false|string||
|name||query|false|string||
|number||query|false|string||
|updateTime||query|false|string(date-time)||
|version||query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据导出链接


**接口地址**:`/sims/course/v1/super-export-data-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据模板下载链接


**接口地址**:`/sims/course/v1/super-export-templat-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取


**接口地址**:`/sims/course/v1/super-get-no-filter/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取(过滤内容)


**接口地址**:`/sims/course/v1/super-get/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #Excel批量导入


**接口地址**:`/sims/course/v1/super-import-excel`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|file|file|body|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #全部列表


**接口地址**:`/sims/course/v1/super-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #分页列表


**接口地址**:`/sims/course/v1/super-page-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|current||query|false|integer(int64)||
|orders[0].asc||query|false|boolean||
|orders[0].column||query|false|string||
|records||query|false|array|object|
|searchCount||query|false|boolean||
|size||query|false|integer(int64)||
|total||query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除


**接口地址**:`/sims/course/v1/super-remove/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


# 课表模块


## 新增课表


**接口地址**:`/sims/timetable/v1/add`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "courseId": "",
  "gradeId": "",
  "teachPosition": "",
  "teachTime": "",
  "teacher": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|from|from|body|true|TimetableFrom|TimetableFrom|
|&emsp;&emsp;courseId|||false|string||
|&emsp;&emsp;gradeId|||false|string||
|&emsp;&emsp;teachPosition|||false|string||
|&emsp;&emsp;teachTime|||false|string||
|&emsp;&emsp;teacher|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除(逻辑删)


**接口地址**:`/sims/timetable/v1/super-delete`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|false|array|string|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #新增-更新


**接口地址**:`/sims/timetable/v1/super-edit`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|courseId||query|false|string||
|createTime||query|false|string(date-time)||
|gradeId||query|false|string||
|id||query|false|string||
|isDelete||query|false|boolean||
|teacher||query|false|string||
|teachPosition||query|false|string||
|teachTime||query|false|string||
|updateTime||query|false|string(date-time)||
|version||query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据导出链接


**接口地址**:`/sims/timetable/v1/super-export-data-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #获取数据模板下载链接


**接口地址**:`/sims/timetable/v1/super-export-templat-url`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取


**接口地址**:`/sims/timetable/v1/super-get-no-filter/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID获取(过滤内容)


**接口地址**:`/sims/timetable/v1/super-get/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #Excel批量导入


**接口地址**:`/sims/timetable/v1/super-import-excel`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|file|file|body|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #全部列表


**接口地址**:`/sims/timetable/v1/super-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #分页列表


**接口地址**:`/sims/timetable/v1/super-page-list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|current||query|false|integer(int64)||
|orders[0].asc||query|false|boolean||
|orders[0].column||query|false|string||
|records||query|false|array|object|
|searchCount||query|false|boolean||
|size||query|false|integer(int64)||
|total||query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## #根据ID删除


**接口地址**:`/sims/timetable/v1/super-remove/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 课表查询


**接口地址**:`/sims/timetable/v1/table/{gradeId}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|gradeId|gradeId|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```


## 课表搜索


**接口地址**:`/sims/timetable/v1/table/{gradeId}/{search}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|gradeId|gradeId|path|true|string||
|search|search|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|状态码|integer(int32)|integer(int32)|
|data|数据对象|object||
|message|处理消息|string||
|success|成功标志|boolean||
|timestamp|时间戳|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"message": "",
	"success": true,
	"timestamp": ""
}
```