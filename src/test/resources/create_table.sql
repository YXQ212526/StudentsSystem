use student;

drop table if exists student_basic_info;
/*学生信息表*/
create table `student_basic_info`
(
    `id`    int auto_increment,
    `sex`   varchar(10),
    `age`   int,
    `phone` varchar(11),
    primary key (`id`)
);

drop table if exists course;

/*课程信息表*/
create table course
(
    `course_id` int         not null auto_increment,
    `name`      varchar(10) not null,
    primary key (`course_id`)
);

drop table if exists student_course;

/*学生选课表*/
create table student_course
(
    `course_id`  int not null,
    `student_id` int not null
);

drop table if exists teacher_course;

/*教师授课表*/
create table teacher_course
(
    `course_id`    int         not null,
    `teacher_name` varchar(10) not null
);

drop table if exists live_die;

/*学生-教师表*/
create table live_die
(
    `s_id`   int         not null,
    `t_name` varchar(10) not null
);

