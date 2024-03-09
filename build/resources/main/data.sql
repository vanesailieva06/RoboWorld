INSERT INTO users(id, email, full_name, password, username)
VALUES
    (1, '111@12.bg', 'Admin Adminov', '6cf1643832d3199650e5b751fd97473490bc6dd4aa9343d9bfa23ba9ceb2e24d71360d42d571a2cabdbcec584bbda490', 'admin'),
    (2, '12@11.bg', 'User Userov', '6cf1643832d3199650e5b751fd97473490bc6dd4aa9343d9bfa23ba9ceb2e24d71360d42d571a2cabdbcec584bbda490', 'user'),
    (3, '11@111', 'Teacher Teacher', '6cf1643832d3199650e5b751fd97473490bc6dd4aa9343d9bfa23ba9ceb2e24d71360d42d571a2cabdbcec584bbda490', 'teacher'),
    (4, '11@111', 'Teacher Teacher', '6cf1643832d3199650e5b751fd97473490bc6dd4aa9343d9bfa23ba9ceb2e24d71360d42d571a2cabdbcec584bbda490', 'teacher1'),
    (5, '11@111', 'Teacher Teacher', '6cf1643832d3199650e5b751fd97473490bc6dd4aa9343d9bfa23ba9ceb2e24d71360d42d571a2cabdbcec584bbda490', 'teacher2'),
    (6, '11@111', 'Teacher Teacher', '6cf1643832d3199650e5b751fd97473490bc6dd4aa9343d9bfa23ba9ceb2e24d71360d42d571a2cabdbcec584bbda490', 'teacher3');

INSERT INTO roles(id, role_type)
VALUES
    (1, 'User'),
    (2, 'Admin'),
    (3, 'Lecturer');


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

INSERT INTO courses(id, age_limit, description, end, start, title, lecturer_id)
VALUES
    (1, 'SixToEight', 'This course is for the kids in first and second grade. In this course they learn how to make simple robots.', '2024-03-22','2024-02-01', 'Introduction', 3),
    (2, 'SixToEight', 'Students build on what they have learned.In this course they make robots as animals and learn more difficult mechanisms', '2024-04-24', '2024-03-03', 'More difficult mechanisms', 3),
    (3, 'NineToTwelve', 'The kids in the course construct their robots with MONO(program designed for children aged 9 to 12). They learn interesting facts about the nature.','2024-05-01','2024-03-18', 'Robots with MONO', 4),
    (4, 'NineToTwelve', 'This course is about constructing robots-helpers. The students should make a robot, which help with different chores as cleaning, vacuuming and helping with the homework', '2024-05-16', '2024-03-18', 'Robots-Helpers', 5),
    (5, 'ThirteenToFifteen', 'This course is designed for students who have never worked with robotics.Here they already learn more complex functions. Here they learn basic steps in the programming with Python.', '2024-06-22', '2024-04-10', 'First steps with Python and more complex robots', 6),
    (6, 'ThirteenToFifteen', 'The course builds on what has been learned and students make robots in which Artificial Intelligence is implemented. The robots can talk and "think"', '2024-06-12', '2024-04-02', 'Robots with the AI', 6),
    (7, 'SixteenToEighteen', 'The students here learn way more difficult programs and making robots who looks like a human. The Robots can do anything a human can do such as walking, speaking, going to work etc.', '2024-05-29', '2024-03-09', 'Robots as a people', 5),
    (8, 'SixteenToEighteen', 'The robots which students make are more complex. Here they learn how to make robots to fly and going to space. Also in a few lectures NASA show how rockets are made.', '2024-05-29', '2024-03-09', 'Robots in the space', 5);
INSERT INTO reviews(id,name, description, user_id)
VALUES
    (1,'Monika A.','РобоСвят е най-доброто попадение днес!Научих много за роботика и се забавлявах! Препоръчвам!', 1),
    (2, 'David D.', 'От както се регистрирах виждането ми към Роботиката се промени коренно. Не се чудете, регистрирайте се!', 2),
    (3, 'ELena O.', 'Най-доброто приложение, което съм срещал! Най-много ми хареса форумите, където всеки може да си каже мнението.', 3),
    (4, 'Polly I.', 'Курсовете в РобоСвят са направени по лесен и разбираем начин за децата! Вкючете се и вие!', 4);

INSERT INTO lectures(id,ended, started, title, course_id)
VALUES
    (1, '2024-02-03 12:00', '2024-02-02 10:00', 'Introduction', 1),
    (2, '2024-02-09 12:00', '2024-02-09 10:00', 'Let play with Robo', 1),
    (3, '2024-02-15 12:00', '2024-02-15 10:00', 'LEGO robot', 1),
    (4, '2024-02-22 12:00', '2024-02-22 10:00', 'First and second grade Math', 1),
    (5, '2024-02-28 12:00', '2024-02-28 10:00', 'Eco robot', 1),
    (6, '2024-03-05 12:00', '2024-03-05 10:00', 'Meet Lila The Robot', 1),
    (7, '2024-03-11 12:00', '2024-03-11 10:00', 'E-Drawing', 1),
    (8, '2024-03-05 14:00', '2024-03-05 12:00', 'More difficult LEGO robots', 2),
    (9, '2024-03-12 14:00', '2024-03-12 12:00', 'Complex Math for the kids', 2),
    (10, '2024-03-20 14:00', '2024-03-20 12:00', 'Robo-Animal', 2),
    (11, '2024-03-25 14:00', '2024-03-25 12:00', 'Robo-Animal 2.0', 2),
    (12, '2024-04-02 12:00', '2024-04-02 10:00', 'Say Hi to Tommy', 2),
    (13, '2024-04-10 13:00', '2024-04-010 11:00', 'Educational movie', 2),
    (14, '2024-04-20 12:00', '2024-04-20 10:00', 'Show your Robo-Animals', 2),
    (15, '2024-03-20 15:00', '2024-03-20 13:00', 'Introduction the MONO', 3),
    (16, '2024-03-25 15:00', '2024-03-25 13:00', 'Walking in the nature', 3),
    (17, '2024-04-01 15:00', '2024-04-01 13:00', 'Math in the Nature', 3),
    (18, '2024-04-07 15:00', '2024-04-07 13:00', 'More difficult mechanism', 3),
    (19, '2024-04-15 15:00', '2024-04-15 13:00', 'The MONO project', 3),
    (20, '2024-04-20 15:00', '2024-04-20 13:00', 'The MONO project 2.0', 3),
    (21, '2024-04-27 15:00', '2024-04-27 13:00', 'Final MONO project', 3),
    (22, '2024-03-20 13:00', '2024-03-20 10:30', 'Do your chores easily', 4),
    (23, '2024-03-27 13:00', '2024-03-27 10:30', 'Garry-your biggest helper', 4),
    (24, '2024-04-04 13:00', '2024-04-04 10:30', 'Educational movie', 4),
    (25, '2024-04-11 13:00', '2024-04-11 10:30', 'How to make your robo-helper', 4),
    (26, '2024-04-17 13:00', '2024-04-17 10:30', 'How to make your robo-helper 2.0', 4),
    (27, '2024-04-25 13:00', '2024-04-25 10:30', 'Practice', 4),
    (28, '2024-05-05 13:00', '2024-05-05 10:30', 'Show your robot', 4),
    (29, '2024-04-11 14:00', '2024-04-11 11:00', 'What is programming', 5),
    (30, '2024-04-17 14:00', '2024-04-17 11:00', 'Introduction to Python', 5),
    (31, '2024-04-24 14:00', '2024-04-24 11:00', 'Basic algorithms', 5),
    (32, '2024-04-30 14:00', '2024-04-30 11:00', 'Why do we need to program', 5),
    (33, '2024-05-06 14:00', '2024-05-06 11:00', 'Python and Robotics', 5),
    (34, '2024-05-12 14:00', '2024-05-12 11:00', 'Practice', 5),
    (35, '2024-05-18 14:00', '2024-05-18 11:00', 'Teen Math', 5),
    (36, '2024-05-28 14:00', '2024-05-28 11:00', 'Practical Exam', 5),
    (37, '2024-04-05 16:00', '2024-04-05 13:00', 'Meet Darcy-the AI robot', 6),
    (38, '2024-04-12 16:00', '2024-04-12 13:00', 'What is AI', 6),
    (39, '2024-04-20 16:00', '2024-04-20 13:00', 'AI and the robots', 6),
    (40, '2024-04-25 16:00', '2024-04-25 13:00', 'Basic AI algorithms', 6),
    (41, '2024-05-02 16:00', '2024-05-02 13:00', 'AI algorithms 2.0', 6),
    (42, '2024-05-08 16:00', '2024-05-08 13:00', 'Practice', 6),
    (43, '2024-05-17 16:00', '2024-04-17 13:00', 'AI in the world', 6),
    (44, '2024-05-28 16:00', '2024-05-28 13:00', 'Exam', 6),
    (45, '2024-03-11 17:00', '2024-03-11 14:00', 'What is H-Robo', 7),
    (46, '2024-03-18 17:00', '2024-03-18 14:00', 'High-School Math', 7),
    (47, '2024-03-25 17:00', '2024-03-25 14:00', 'Practice Math', 7),
    (48, '2024-04-01 17:00', '2024-04-01 14:00', 'H-Robo Project', 7),
    (49, '2024-04-08 17:00', '2024-04-08 14:00', 'More difficult AI mechanism', 7),
    (50, '2024-04-16 17:00', '2024-04-16 14:00', 'AI in H-Robo', 7),
    (51, '2024-04-23 17:00', '2024-04-23 14:00', 'Practice 2.0', 7),
    (52, '2024-05-01 17:00', '2024-05-01 14:00', 'Meet George-the founder of H-Robo', 7),
    (53, '2024-05-08 17:00', '2024-05-08 14:00', 'Exam', 7),
    (54, '2024-03-10 13:00', '2024-03-10 10:00', 'THE ROBOT', 8),
    (55, '2024-03-16 13:00', '2024-03-16 10:00', 'Flying robot? How to do it', 8),
    (56, '2024-03-22 13:00', '2024-03-22 10:00', 'Meeting with the NASA', 8),
    (57, '2024-03-29 13:00', '2024-03-29 10:00', 'NASA robot project', 8),
    (58, '2024-04-05 13:00', '2024-04-05 10:00', 'Practice', 8),
    (59, '2024-04-13 13:00', '2024-04-13 10:00', 'Robot in the Space. Mechanisms', 8),
    (60, '2024-04-20 13:00', '2024-04-20 10:00', 'Practice', 8),
    (61, '2024-04-28 13:00', '2024-04-28 10:00', 'NASA robot project 2.0', 8),
    (62, '2024-05-10 14:00', '2024-05-10 10:00', 'FINAL EXAM', 8);





































































