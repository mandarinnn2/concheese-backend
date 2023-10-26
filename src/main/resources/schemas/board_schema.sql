CREATE TABLE BOARD
(
    POST_ID   BINARY(16) PRIMARY KEY,
    TITLE      TINYTEXT    NOT NULL,
    CATEGORY   VARCHAR(20) NOT NULL,
    CONTENT    TEXT        NOT NULL,
    CREATED_AT DATETIME(6) NOT NULL,
    UPDATED_AT DATETIME(6) NOT NULL
)