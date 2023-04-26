CREATE TABLE IF NOT EXISTS server.user
(
    ID SERIAL,
    USER_ID varchar (20),
    FIO varchar (100),
    GENDER_TYPE varchar (10),
    DESCRIPTION varchar (250),
    SEARCH_GENDER varchar (10),
    STAGE_OF_QUESTIONNAIRE varchar (1)
);

CREATE TABLE IF NOT EXISTS server.liked_user
(
    ID SERIAL,
    USER_ID varchar (20),
    LIKED_USER_ID varchar (20)
);