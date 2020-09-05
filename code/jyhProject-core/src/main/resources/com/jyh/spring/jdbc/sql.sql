create table student
(
  studentId       int primary key auto_increment not null,
  studentName     varchar(10) not null,
  studentAge      int,
  studentPhone    varchar(15)
)

insert into student(studentName,studentAge,studentPhone) values('Betty', '20', '00000000');
insert into student(studentName,studentAge,studentPhone) values('Jerry', '18', '11111111');
insert into student(studentName,studentAge,studentPhone) values('Betty', '21', '22222222');
insert into student(studentName,studentAge,studentPhone) values('Steve', '27', '33333333');
insert into student(studentName,studentAge,studentPhone) values('James', '22', '44444444');
commit;