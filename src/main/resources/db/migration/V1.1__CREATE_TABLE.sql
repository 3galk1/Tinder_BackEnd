CREATE TABLE IF NOT EXISTS server.customer
(
    ID SERIAL,
    USER_ID varchar (20),
    FIO varchar (100),
    GENDER_TYPE varchar (10),
    DESCRIPTION varchar (250),
    SEARCH_GENDER varchar (10),
    STATE varchar (1)
);