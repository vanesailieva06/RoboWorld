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
    (5, 'ThirteenToFifteen', 'This course is designed for students who have never worked with robotics.Here they already learn more complex functions. Here they basic steps in the programming with Python.', '2024-06-22', '2024-04-10', 'First steps with Python and more complex robots', 6),
    (6, 'ThirteenToFifteen', 'The course builds on what has been learned and students make robots in which Artificial Intelligence is implemented. The robots can talk and "think"', '2024-06-12', '2024-04-02', 'Robots with the AI', 6),
    (7, 'SixteenToEighteen', 'The students here learn way more difficult programs and making robots who looks like a human. The Robots can do anything a human can do such as walking, speaking, going to work etc.', '2024-05-29', '2024-03-09', 'Robots as a people', 5),
    (8, 'SixteenToEighteen', 'The robots which students make are more complex. Here they learn how to make robots to fly and going to space. Also in a few lectures NASA show how rockets are made.', '2024-05-29', '2024-03-09', 'Robots in the space', 5),
    (9, 'SixteenToEighteen', 'Here the students shows everything that they learnt. The task is to make robot which looks like a human but can do more things than a human. The lecturers are here to help :)', '2024-06-29','2024-03-09', 'The final exam', 6);

INSERT INTO reviews(id,name, description, user_id)
VALUES
    (1,'Monika A.','РобоСвят е най-доброто попадение днес!Научих много за роботика и се забавлявах! Препоръчвам!', 1),
    (2, 'David D.', 'От както се регистрирах виждането ми към Роботиката се промени коренно. Не се чудете, регистрирайте се!', 2),
    (3, 'ELena O.', 'Най-доброто приложение, което съм срещал! Най-много ми хареса форумите, където всеки може да си каже мнението.', 3),
    (4, 'Polly I.', 'Курсовете в РобоСвят са направени по лесен и разбираем начин за децата! Вкючете се и вие!', 4);







