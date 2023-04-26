INSERT INTO server.user
    (ID, USER_ID, FIO, GENDER_TYPE, DESCRIPTION, SEARCH_GENDER, STAGE_OF_QUESTIONNAIRE)
values (1, '1-qwerty', 'Васильев Игорь Геннадьевич', 'MALE', 'Все ок', 'FEMALE', '1'),
       (2, '2-qwerty', 'Васильев Роман Сергеевич', 'MALE', 'Все по кайфу', 'FEMALE', '1'),
       (3, '3-qwerty', 'Толмачев Никита Сергеевич', 'MALE', 'Сюда нахуй', 'FEMALE', '1');


INSERT INTO server.liked_user
    (ID, USER_ID, LIKED_USER_ID)
VALUES (1, '1-qwerty', '2-qwerty');
