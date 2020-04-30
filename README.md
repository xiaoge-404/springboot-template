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

![dbinfo](https://opsbible.oss-cn-hongkong.aliyuncs.com/images/dbinfo.png)

去除ping表(额外添加的),其他根据名称大概可以看出主要用功能

employees (雇员信息):

| 列         | 类型          | 注释 |
| :--------- | ------------- | :--: |
| emp_no     | int           |      |
| birth_date | date          |      |
| first_name | varchar(14)   |      |
| last_name  | varchar(16)   |      |
| gender     | enum('M','F') |      |
| hire_date  | date          |      |

titles(职位名称):

| 列        | 类型        | 注释 |
| :-------- | ----------- | ---- |
| emp_no    | int         |      |
| title     | varchar(50) |      |
| from_date | date        |      |
| to_date   | date *NULL* |      |

salaries(薪资收入):

| 列        | 类型 | 注释 |
| :-------- | ---- | ---- |
| emp_no    | int  |      |
| salary    | int  |      |
| from_date | date |      |
| to_date   | date |      |

departments(部门):

| 列        | 类型        | 注释 |
| :-------- | ----------- | ---- |
| dept_no   | char(4)     |      |
| dept_name | varchar(40) |      |

depat_emp(员工部门对应关系):

| 列        | 类型    | 注释 |
| :-------- | ------- | ---- |
| emp_no    | int     |      |
| dept_no   | char(4) |      |
| from_date | date    |      |
| to_date   | date    |      |

dept_manager(部门管理人):

| 列        | 类型    | 注释 |
| :-------- | ------- | ---- |
| emp_no    | int     |      |
| dept_no   | char(4) |      |
| from_date | date    |      |
| to_date   | date    |      |

剩余两个视图暂不用理会!

### 相关`Sql`语句

查询员工:

1. 查询指定员工详细信息

```mysql
select e.birth_date,e.first_name,e.last_name,e.gender,e.hire_date,t.title,dp.dept_name from employees as e
left join titles as t
on t.emp_no = e.emp_no
left join dept_emp as d
on d.emp_no = e.emp_no
left join departments as dp
on dp.dept_no = d.dept_no
 where first_name="Mary" and last_name="Swift" # 此次开发时换成emp_id
```

| birth_date | first_name | last_name | gender | hire_date  |    title     |    dept_name    |
| :-------- | -------- | ------- | ---- | -------- | ---------- | ------------- : |
| 1957-05-29 |    Mary    |   Swift   |   M    | 1994-05-17 | Senior Staff | Human Resources |



添加员工: 

1. 添加员工到对应部门,定当年薪资

查询当前最后一个id:

```mysql
select emp_no from employees order by emp_no desc limit 1;
```

插入员工当前的id加1:

```mysql
INSERT INTO `employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`)
VALUES ('500000', '1992-11-13', 'song', 'xiao', 1, '2020-05-01');
INSERT INTO `titles` (`emp_no`, `title`, `from_date`, `to_date`)
VALUES ('500000', 'Senior Engineer', '2020-05-01', '9999-01-01');
INSERT INTO `dept_emp` (`emp_no`, `dept_no`, `from_date`, `to_date`)
VALUES ('500000', 'd005', '2020-05-01', '9999-01-01');
INSERT INTO `salaries` (`emp_no`, `salary`, `from_date`, `to_date`)
VALUES ('500000', '68888', '2020-05-01', '9999-01-01');
```

删除员工:
1. 删除当前在职员工信息

```mysql
DELETE FROM `employees`
WHERE `emp_no` = '500000';
```

```mysql
DELETE FROM `salaries`
WHERE `emp_no` = '500000';
```

```mysql
DELETE FROM `dept_emp`
WHERE `emp_no` = '500000';
```

```mysql
DELETE FROM `titles`
WHERE `emp_no` = '500000';
```

更改员工:
1. 更改员工薪资

```mysql
UPDATE `salaries` SET
`salary` = '78888',
`from_date` = '2020-07-01'
WHERE `emp_no` = '500000' ;
```



### 测试API

添加员工(员工编号自增):

请求接口:http://127.0.0.1:8080/api/employee/add

请求数据:

```json
{
  "birthDate": "2019-11-11",
  "deptNo": "d005",
  "firstName": "Lou",
  "fromDate": "2019-11-12",
  "gender": "M",
  "hireDate": "2019-11-12",
  "lastName": "Xiaohei",
  "salary": 88888,
  "title": "Senior Engineer",
  "toDate": "9999-11-11"
}
```

根据员工基本信息查详细:

接口: http://127.0.0.1:8080/api/employee

```json
{
  "birthDate": "2019-11-11",
  "firstName": "Lou",
  "gender": "M",
  "lastName": "Xiaohei"
}
```

