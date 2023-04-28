CREATE TABLE IF NOT EXISTS tinder.user
(
    ID SERIAL,
    TELEGRAM_ID varchar (20),
    NAME varchar (100),
    GENDER_TYPE varchar (10),
    SEARCH_GENDER varchar (10),
    DESCRIPTION varchar (1000),
    STAGE_OF_QUESTIONNAIRE varchar (1)
);

CREATE TABLE IF NOT EXISTS tinder.liked_user
(
    ID SERIAL,
    USER_ID varchar (2),
    LIKED_USER_ID varchar (2)
);