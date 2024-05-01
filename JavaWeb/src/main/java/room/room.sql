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

-- 計算每個房間的預訂次數，對於沒有預訂的房間顯示 0
SELECT r.room_id, 
       r.room_name,
       COALESCE(COUNT(b.booking_id), 0) AS booking_count
FROM room r
LEFT JOIN booking_room b ON r.room_id = b.room_id
GROUP BY r.room_id, r.room_name;

這個查詢的工作原理如下：
從 room 表中選取所有房間。
使用 LEFT JOIN 語句將 room 表和 booking_room 表連接起來，連接條件是它們的 room_id。這確保了即使某些房間沒有預訂記錄，也會被包括在內。
使用 GROUP BY 語句按房間 ID 和房間名稱分組。
使用 COUNT(b.booking_id) 計算每組的預訂數量。COALESCE 函數確保了即使某個房間沒有任何預訂，也會顯示為 0 而不是 null。
這個查詢將為您提供每個房間的預訂次數的清單，並且對於沒有預訂的房間也會包含在內，預訂次數顯示為 0。這樣您就能完整地看到所有房間的預訂情況。


