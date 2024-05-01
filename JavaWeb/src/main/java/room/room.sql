-- 訂房系統

drop table if exists BookingRoom;
drop table if exists Room;

-- 建立 Room
create table if not exists Room(
	room_id int primary key,
    room_name varchar(50) not null unique
);

-- 建立 BookingRoom
create table if not exists BookingRoom(
	booking_id int auto_increment primary key,
    room_id int not null,
    user_id int not null,
    checkin_date date not null,
    create_time timestamp default current_timestamp,
    foreign key (room_id) references Room(room_id),
    CONSTRAINT unique_room_id_and_checkin_date UNIQUE(room_id, checkin_date)
);
