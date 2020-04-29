## JAVA 性能测试项目

本项目主要用于java项目优化测试案例,项目涉及:

Springboot作为Java项目框架,后端数据为开源数据,[雇员信息](https://github.com/datacharmer/test_db)

项目中除了`pom.xml`再无其他xml配置(xml方式配置,在我这个非开发人士看来,超级恶心!)

### 相关依赖库说明

mybatis: 完全采用注解方式

```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.1.2</version>
</dependency>
```

druid: 可以自由开启,通过开启和不开启来测试对性能的影响

```xml
<!--		<dependency>-->
<!--			<groupId>com.alibaba</groupId>-->
<!--			<artifactId>druid</artifactId>-->
<!--			<version>1.1.22</version>-->
<!--		</dependency>-->
```

lombok: 懒人必备,使用`@Data` 和`@Builder`注解,感觉java写起代码感觉不要太爽

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
```

mysql: 使用的是mysql 8 ,所以,采用的是`com.mysql.cj.jdbc.Driver`驱动

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: "root"
    password: "Opsbible123."
    url:  jdbc:mysql://10.0.0.40:3306/employees?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true
```

thymeleaf: 添加thymeleaf引擎,简单写一个界面

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
    <version>2.2.6.RELEASE</version>
</dependency>
```

```yaml
thymeleaf:
    prefix: classpath:/templates/
    check-template-location: true
    suffix: .html
    encoding: UTF-8
    servlet:
      content-type: text/html
    mode: HTML5
    cache: false
```

### 数据库数据介绍

![dbinfo](C:\Users\sun\Desktop\app\app\others\images\dbinfo.png)

去除ping表(额外添加的),其他根据名称大概可以看出主要用功能

employees 为雇员基本信息,包含以下字段:



### 相关`Sql`语句


1. 查询员工是否在职
2. 查询员工在职期间总收益
3. 查询员工是否是管理
4. 查询公司一共有那些部门
5. 查询各个部门当前在职人数
6. 查询各个部门平均薪资水平
7. 查询男女比例
8. 查询男女薪资比例
9. 查询出薪资最高的人的基本信息

添加员工: 
1. 添加员工到对应部门,定当年薪资

删除员工:
1. 删除当前在职员工信息

更改员工:
1. 更改员工薪资


接口测试要求:
1. 纯查询接口一个
2. 纯修改接口一个
3. 纯删除接口一个
4. 多表联查接口一个
5. 多表增加接口一个


api: 

涉及sql:

```mysql

```

