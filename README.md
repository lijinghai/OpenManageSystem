<h1 align="center"> 东软开发平台 | Dorian </h1>

<p align="center">
 	<a href="https://github.com/Dorian1015/OpenManageSystem">
		<img src="https://img.shields.io/github/issues/Dorian1015/OpenManageSystem"
			 alt="Version">
	</a>
 	<a href="https://github.com/Dorian1015/OpenManageSystem">
		<img src="https://img.shields.io/github/forks/Dorian1015/OpenManageSystem"
			 alt="Status">
	</a>
    <a href="https://github.com/Dorian1015/OpenManageSystem">
		<img src="https://img.shields.io/github/stars/Dorian1015/OpenManageSystem"
			 alt="Status">
	</a>
</p>


<p align="center">
     <a href="https://github.com/Dorian1015/WarmSearch">
		<img src="https://img.shields.io/badge/Dorian-%E6%B5%B7-blue"
			 alt="Status">
	</a>
</p>

### 项目介绍 :book:

👉 这是我的大二(2021.6.3)全栈班的后端业务领域课的实训===>东软开放平台

### 项目要求：

（1）使用SpringBoot+Mybaits+Druid+Mysql5.7实现项目搭建，SpringBoot版本号无具体要求

（2）使用PowerDesigner实现项目pdm的输出

（3）使用Git服务器实现代码管理

（4）使用FastDfs实现文件上传

（5）集成Swagger2实现简化调试

（6）使用redis实现登陆共享与登陆拦截

（7）使用AspectJ实现日志的自动添加


### 项目技术栈 :star:


- 后台管理系统(WarmSearch-Web)：
- 后端(WarmSearch)：Springboot 2.4.2 + Java Web Token +MybatisPlus + Swagger
- 数据库：MySql 5.7
### 项目地址 :link:

项目采用前后端分离开发模式，PC端使用:Vue + Element-ui开发，后端数据API采用Java、Spring-Boot开发.

后端code地址：https://github.com/Dorian1015/OpenManageSystem

web管理端code地址:  https://github.com/Dorian1015/OpenManageSystem-web

## 前言：

##### 这是我的邮箱lijinghailjh@163.com,欢迎大家来指正

##### 最新代码将在[GitHub](https://github.com/Dorian1015)上持续更新

##### 在读大二学生（2021年5月8日）





## 说明


> #### 如果您觉得这项目还不错，可以在右上角`Star`支持一下，万分感谢！！！

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/0E503FDA.gif)

## 项目简介

- 本项目前后端分离，前端基于`Vue`+`Vue-router`+`Vuex`+`Element-ui`+`Axios`，参考锤子商城实现。后端基于SpringBoot(框架) + JSON WEB TOKEN(令牌机制) + MybatisPlus + Mysql实现。

- 总体架构![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/2021611实训/图片1.png)

  系统设计秉承“前后端分离/SOA”的总体思想，前端使用Vue/ElementUI作为主要框架技术、Nginx作为HTTP服务器，用来提供静态页面访问服务和反向代理作用；后端则以Springboot主流框架技术为主、采用MySQL开源数据库，前后端使用Restful规范交换数据。

  系统采用JWT令牌鉴权方式，降低服务器运行消耗，提升系统的伸缩性和扩展性。

- 总体架构

  总体设计按“前后端分离”方式，当浏览器请求页面或静态资源时，HTTP Server直接响应；当浏览器请求数据时，该请求仍然先发给HTTP Server，经由该Server转发至Web APP Server。Web APP Server业务处理后将结果数据返回给HTTP Server，最终返回浏览器。在此过程中，Web APP Server返回的仅仅是数据（json格式），没有任何与显示（视图）相关的信息，做到了完全的前后端分离，前端负责页面与展示，后端负责业务处理与数据。

## 技术栈

- 前台页面展示系统（WarmSearch-PC)：`Vue`+`Vue-router`+`Vuex`+`Element-ui`+`Axios`
- 后台管理系统：基于Vue-admin-ui脚手架
- 微信小程序：uni-app + Vue.js
- 后端：Springboot + Java Web Token +MybatisPlus + Swagger 框架
- 数据库：MySql

## 功能模块

#### 后端部分(Springboot + mybatis + Java web token)

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/2021611实训/后端页面1.png)



![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/2021611实训/后端页面2.png)

#### Swagger2页面

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/2021611实训/swagger1.png)



![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/2021611实训/swagger21.png)

#### 前端代码结构（vue)

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/2021611实训/前端1.png)



![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/2021611实训/前端2.png)

- #### 登录页面展示

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/2021611实训/登录1.png)

- #### 首页页面展示

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/2021611实训/首页.png)
- #### 部分功能页面展示

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/2021611实训/层次管理.png)
- #### 添加
![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/2021611实训/添加.png)
- #### 编辑功能
![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/2021611实训/编辑.png)



## 后期打算

### 如果你觉得我的项目，还不错，可以给我一下赞赏，本人现是一名大二学生，打算不断完善这个项目，所以我打算购买服务器，并部署上去；开源不易，如果你喜欢我的项目，可以给我投资一下我的服务器基金，苦逼大学生，万分感谢您！！！！






### 如果你能看到这里说明你肯定对我的项目感兴趣，那么请访问我的博客吧，里面会更新更详细的关于我这个项目的信息 [博客](https://dorian1015.github.io/)

### 或者你也可以通过我的[Github](https://github.com/Dorian1015) 首页的邮箱来联系我 lijinghailjh@163.com







