INSERT INTO roles (name) VALUES ('ROLE_USER'), ('ROLE_ADMIN');

INSERT INTO users (id, username, password, active)
VALUES
--     password: user
    (1, 'user', '$2a$12$8z1d/mVoYfxRtBDb/Pms3.3gveu5sZyPZoJoAmM/FDF6dUutAQyj.', TRUE),
--     password: admin
    (2, 'admin', '$2a$12$lU4p3z5rZZzJ/ml8RH/FXu2W5cd6Up6PnbVVrbUJcVgH4dE32a2.O', TRUE);

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1), (2, 2);
