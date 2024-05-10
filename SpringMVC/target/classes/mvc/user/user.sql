drop table if exists user_interest;
drop table if exists user;
drop table if exists base_data;

create table if not exists base_data(
	id int auto_increment primary key,
	group_name varchar(50),
    item_id int,
    item_name varchar(50)
);

create table if not exists user(
	id int auto_increment primary key,
    name varchar(50),
    age int,
    birth timestamp,
    resume varchar(50),
    education_id int,
    gender_id int
);

create table if not exists user_interest(
	user_id int,
    interest_id int,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

insert into base_data(group_name, item_id, item_name) values('Education', 1, '小學');
insert into base_data(group_name, item_id, item_name) values('Education', 2, '國中');
insert into base_data(group_name, item_id, item_name) values('Education', 3, '高中');
insert into base_data(group_name, item_id, item_name) values('Education', 4, '大學');
insert into base_data(group_name, item_id, item_name) values('Education', 5, '研究所');
insert into base_data(group_name, item_id, item_name) values('Gender', 1, '男');
insert into base_data(group_name, item_id, item_name) values('Gender', 2, '女');
insert into base_data(group_name, item_id, item_name) values('Interest', 1, '爬山 🏕');
insert into base_data(group_name, item_id, item_name) values('Interest', 2, '音樂 🎶');
insert into base_data(group_name, item_id, item_name) values('Interest', 3, '看書');
insert into base_data(group_name, item_id, item_name) values('Interest', 4, '刺繡');
insert into base_data(group_name, item_id, item_name) values('Interest', 5, '國畫');
insert into base_data(group_name, item_id, item_name) values('Interest', 6, 'FPV ✈');

insert into user(name, age, birth, resume, education_id, gender_id) values('John', 20, '2004-05-10', 'Test1', 4, 1);
insert into user(name, age, birth, resume, education_id, gender_id) values('Mary', 21, '2003-05-10', 'Test2', 5, 2);

insert into user_interest(user_id, interest_id) values(1, 1);
insert into user_interest(user_id, interest_id) values(1, 2);
insert into user_interest(user_id, interest_id) values(1, 3);
insert into user_interest(user_id, interest_id) values(1, 6);
insert into user_interest(user_id, interest_id) values(2, 2);
insert into user_interest(user_id, interest_id) values(2, 3);
insert into user_interest(user_id, interest_id) values(2, 4);



