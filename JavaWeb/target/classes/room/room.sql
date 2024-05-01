-- 訂房系統

drop table if exists booking_room;
drop table if exists room;

-- 建立 room
create table if not exists room(
	room_id int primary key,
    room_name varchar(50) not null unique
);

-- 建立 booking_room
create table if not exists booking_room(
	booking_id int auto_increment primary key,
    room_id int not null,
    user_id int not null,
    checkin_date timestamp not null,
    create_time timestamp default current_timestamp,
    foreign key (room_id) references room(room_id),
    CONSTRAINT unique_room_id_and_checkin_date UNIQUE(room_id, checkin_date)
);

-- 建立預設資料
insert into room (room_id, room_name) values (101, '101室');
insert into room (room_id, room_name) values (202, '202室');
insert into room (room_id, room_name) values (303, '303室');
insert into room (room_id, room_name) values (404, '404室');

insert into booking_room(room_id, user_id, checkin_date) values(101, 1, '2024-05-01 00:00:00');
insert into booking_room(room_id, user_id, checkin_date) values(101, 2, '2024-05-02 00:00:00');
insert into booking_room(room_id, user_id, checkin_date) values(202, 1, '2024-05-05 00:00:00');


