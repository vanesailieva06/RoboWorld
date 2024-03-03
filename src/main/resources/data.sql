INSERT INTO users(id, email, full_name, password, username)
VALUES
    (1, '111@12.bg', 'Admin Adminov', '6cf1643832d3199650e5b751fd97473490bc6dd4aa9343d9bfa23ba9ceb2e24d71360d42d571a2cabdbcec584bbda490', 'admin'),
    (2, '12@11.bg', 'User Userov', '6cf1643832d3199650e5b751fd97473490bc6dd4aa9343d9bfa23ba9ceb2e24d71360d42d571a2cabdbcec584bbda490', 'user');

INSERT INTO roles(id, role_type)
VALUES
    (1, 'USER'),
    (2, 'ADMIN');

INSERT INTO users_roles(user_id, roles_id)
VALUES
    (2, 1),
    (1, 2);


INSERT INTO forums(id, created, description, title)
VALUES
    (1, NOW(), 'This forum is about AI and do you think that it will change the world? Write your comments bellow!', 'AI-The Future'),
    (2, NOW(), 'This forum is about programming languages. Which language is the most popular? Write your comments bellow!', 'Programming languages-the popular once'),
    (3, NOW(), 'This forum is about self-study. Do you think that a person can learn without any help? Write your comments bellow!', 'Self-study-useful or not?'),
    (4, NOW(), 'This forum is about the robots. Will they control us in the future? Write your comments bellow!', 'The unpredictable future');

INSERT INTO comments(id, created, description, forum_id, user_id)
VALUES
    (1, NOW(), 'Well I think that it will change the world but we should be carefull with the AI because it can cause more harm than help', 1, 1),
    (2, NOW(), 'The most popular languages are Java, JavaScript and Python. Although C++ and TypeScript are very interesting languages but they are not in TOP 5 :)', 2, 2),
    (3, NOW(), 'It depends on the person. Someone cannot study on themselves but some can. Personally i cannot study on my own.', 3, 1),
    (4, NOW(), 'Robots are very unpredictable. Most of them are helpful but everything can get wrong so we must be careful with them.', 4, 2);