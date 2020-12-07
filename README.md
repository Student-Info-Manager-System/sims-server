# Student Info Manager System

# 学生信息管理系统后台服务（sims-server）

> 特别说明：该系统自动生成表，只需创建一个空数据库即可！（为防止有人以为没有数据库）

## 系统介绍
### 业务模块

1. 学生模块
2. 管理员（教师）模块
3. 班级模块
4. 课程模块
5. 专业模块
6. 成绩模块
7. 课表模块

### 系统模块
1. 用户模块
2. 日志模块

### 系统说明

1. 该项目为学生信息管理系统的后端服务简称sims-server
2. 前端代码请移步sims-vue
3. 项目基于SprinBoot 2.4.0
4. 数据库开发时基于Mysql57
>（项目ORM拥有JPA + MybatisPlus双buff加持，理论使用其他数据库也可）

### 技术支持

1. 切面拦截配置中心
2. Shiro权限管理
3. Mybatis-Plus配置中心
4. 异常拦截器
5. Redis缓存中心
6. Jwt拦截器
7. Swagger配置
8. JPA + MybatisPlus
9. PIO

### 公共配置
1. base通配架构
2. config配置中心
3. 其他工具



## 使用手册
### 开发环境
1. 电脑环境：Windows / Linux
2. 开发工具：IDEA社区版 / 专业版 （需安装Lombok插件）
2. 依赖管理： Maven3
3. 开发语言：Java 8
4. 数据库：MySql5.7
5. 缓存工具：Redis
6. API手册：Swagger 

### 运行方式
1. 拉取：从仓库clone项目或下载至本地
2. 导入：IDEA导入sims-server（导入后会自动下载jar包，此时可继续下一步）
3. 建库：新建数据库{sims}，格式utf8（注意：只需要新建库即可，表会在项目启动时自动创建）
4. 配置：等待maven加载完毕后，修改application配置文件为你的配置，如数据库用户名密码，redis用户名密码
5. 启动：直接运行RunApp.java启动类
6. 运行：控制台出现API接口url访问即可


### 其它文档
> 前端文档参见sims-vue
> API接口文档参见目录doc
> API部分截图见doc/img
