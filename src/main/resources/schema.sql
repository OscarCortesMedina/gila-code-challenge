CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                     name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL
    );

CREATE TABLE IF NOT EXISTS user_categories (
                                               user_id BIGINT,
                                               category VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

CREATE TABLE IF NOT EXISTS user_channels (
                                             user_id BIGINT,
                                             channel VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

CREATE TABLE IF NOT EXISTS notifications (
                                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                             user_id BIGINT,
                                             message VARCHAR(500) NOT NULL,
    channel VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL,
    time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
    );