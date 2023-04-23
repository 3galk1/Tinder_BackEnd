CREATE TABLE IF NOT EXISTS homework.customers
(
    ID SERIAL,
    USER_ID char varying (20),
    FIO char varying (100),
    GENDER_TYPE char (10),
    DESCRIPTION char (250),
    SEARCH_GENDER char (10)
);