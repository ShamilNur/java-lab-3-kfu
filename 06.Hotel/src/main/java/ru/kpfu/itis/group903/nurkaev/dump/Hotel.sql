CREATE TABLE user_hotel
(
    id            BIGSERIAL PRIMARY KEY,
    first_name    VARCHAR(30),
    last_name     VARCHAR(30),
    email         VARCHAR(30),
    hash_password VARCHAR(100),
    rooms_id      VARCHAR
);

SELECT *
FROM user_hotel;

SELECT *
FROM room_hotel;

CREATE TABLE room_hotel
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(30),
    photo         VARCHAR(500),
    date_from     BIGINT,
    date_to       BIGINT,
    rooms_number  INTEGER,
    adults_number INTEGER,
    child_number  INTEGER,
    price         INTEGER
);

INSERT INTO room_hotel (name, photo, date_from, date_to, rooms_number, adults_number, child_number, price)
VALUES ('room1', '/static/img/room/rooms-1.jpg', 12345, 123456, 3, 3, 3, 5000);
INSERT INTO room_hotel (name, photo, date_from, date_to, rooms_number, adults_number, child_number, price)
VALUES ('room1', '/static/img/room/rooms-2.jpg', 12345, 123456, 1, 1, 1, 9990);
INSERT INTO room_hotel (name, photo, date_from, date_to, rooms_number, adults_number, child_number, price)
VALUES ('room1', '/static/img/room/rooms-3.jpg', 12345, 123456, 3, 3, 3, 19990);
INSERT INTO room_hotel (name, photo, date_from, date_to, rooms_number, adults_number, child_number, price)
VALUES ('room1', '/static/img/room/rooms-4.jpg', 12345, 123456, 3, 3, 3, 4500);

CREATE TABLE news_hotel
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(100),
    description VARCHAR(500),
    photo       VARCHAR(500)
);
SELECT *
FROM news_hotel;

INSERT INTO news_hotel
VALUES (1, 'Вот что Вам нужно знать при поездке на отдых.', 'Lorem ipsum ...', '/static/img/blog/blog-1.jpg'),
       (2, 'Скоро у нас открытие кофейни.', 'Lorem ipsum ...', '/static/img/blog/blog-2.jpg'),
       (3, 'Новый класс комнат в нашем отеле.', 'Lorem ipsum ...', '/static/img/blog/blog-3.jpg');

CREATE TABLE tag_hotel
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(30)
);
SELECT *
FROM tag_hotel;

INSERT INTO tag_hotel
VALUES (1, 'Жильё'),
       (2, 'Отель'),
       (3, 'События'),
       (4, 'Бронирование'),
       (5, 'Праздники'),
       (6, 'Новости'),
       (7, 'Без рубрики');

CREATE TABLE news_tag
(
    news_id BIGINT REFERENCES news_hotel (id),
    tag_id  BIGINT REFERENCES tag_hotel (id),
    CONSTRAINT news_tag_pkey PRIMARY KEY (news_id, tag_id)
);

INSERT INTO news_tag
VALUES (1, 3),
       (1, 4),
       (2, 2),
       (2, 3),
       (2, 6),
       (3, 1),
       (3, 2),
       (3, 6);

WITH _title_tag_id AS (
    SELECT nh.id, nh.title, nh.description, nh.photo, nt.tag_id
    FROM news_hotel nh
             LEFT JOIN news_tag nt on nh.id = nt.news_id)
SELECT _title_tag_id.id, _title_tag_id.title, _title_tag_id.description, _title_tag_id.photo
FROM _title_tag_id
         INNER JOIN tag_hotel th ON th.id = _title_tag_id.tag_id
WHERE name = 'События';