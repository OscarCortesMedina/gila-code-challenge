INSERT INTO users (name, email, phone) VALUES
                                           ('Alice', 'alice@example.com', '1234567890'),
                                           ('Bob', 'bob@example.com', '0987654321'),
                                           ('Charlie', 'charlie@example.com', '1122334455');

INSERT INTO user_categories (user_id, category) VALUES
                                                    (1, 'SPORTS'),
                                                    (1, 'FINANCE');

INSERT INTO user_channels (user_id, channel) VALUES
                                                 (1, 'SMS'),
                                                 (1, 'EMAIL');

-- Bob subscribes to all categories, and prefers Email and Push notifications
INSERT INTO user_categories (user_id, category) VALUES
                                                    (2, 'SPORTS'),
                                                    (2, 'FINANCE'),
                                                    (2, 'FILMS');

INSERT INTO user_channels (user_id, channel) VALUES
                                                 (2, 'EMAIL'),
                                                 (2, 'PUSH_NOTIFICATION');

-- Charlie subscribes to Sports category only, and prefers Push notifications only
INSERT INTO user_categories (user_id, category) VALUES
    (3, 'SPORTS');

INSERT INTO user_channels (user_id, channel) VALUES
    (3, 'PUSH_NOTIFICATION');
