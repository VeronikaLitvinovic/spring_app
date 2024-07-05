# CREATE TABLE customer(
#                          id          bigint       PRIMARY KEY,
#                          fio         varchar(20)            NOT NULL,
#                          phone       varchar(20),
#                          address     varchar(20),
#                          created     timestamp       DEFAULT now()
# )
#
# drop table users
# CREATE TABLE users (
#                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
#                        username VARCHAR(255) NOT NULL,
#                        lastname VARCHAR(255) NOT NULL,
#                        firstname VARCHAR(255) NOT NULL,
#                        email VARCHAR(255) NOT NULL,
#                        password VARCHAR(255) NOT NULL,
#                        role VARCHAR(255) NOT NULL
# );
DELETE FROM users WHERE username = 'john_doe';
DELETE FROM users WHERE username = 'jane_smith';