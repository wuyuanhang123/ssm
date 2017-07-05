# 人事管理系统
基于Spring+Springmvc+mybatis框架开发的管理系统
## 1.系统描述：
本系统分为6大模块：用户管理，部门管理，职位管理，员工管理，公告管理，文件下载，主要业务逻辑通过HrmService业务逻辑组件实现，可以使用这个逻辑组件封装DAO组件
## 2.开发工具及版本说明：
开发工具：<br/> 1.Eclipse<br/> 2.tomcat 8.5.11<br/> 3.使用maven管理项目<br/> 4.spring版本 4.1.6<br/> 5.mybatis版本 3.3.1<br/> 6.数据库：mysql
## 3.系统结构
* 表现层：使用jsp作为表现层，并使用bootstrap前端框架美化传统html页面，使页面更加符合审美，结合EL表达式和JSTL标签库简化jsp开发做到无脚本jsp页面。<br/>
* MVC层：使用springmvc作为MVC框架，对比struts2开发效率和性能更高且更符合面向对象的设计思想<br/>
* 业务逻辑层:由Spring IOC容器管理的业务逻辑组件组成<br/>
* DAO层：由6个DAO组件组成<br/>
* 领域对象层：由6个domain Object对象组成<br/>
* 数据库服务层：使用MySQL数据库储存持久化数据，使用c3p0连接池，优化数据库连接<br/>
* 使用junit整合spring进行单元测试，结合MockMvc进行服务端的单元测试<br/>
* 利用页面标签实现分页功能
## 4.数据库设计

## 5.后序更新
下一步更新打算研究下sql语句的优化，优化系统查询效率
