SET ESCAPE ON;

CREATE OR REPLACE TYPE VOTES AS OBJECT (
    COOL       NUMBER(5),
    FUNNY      NUMBER(5),
    USEFUL     NUMBER(5)
);

CREATE TABLE BUSINESS_MAIN_CATEGORIES (
    MAIN_CATEGORTY VARCHAR(30)
);

CREATE TABLE BUSINESS (
    BID             VARCHAR(25)       PRIMARY KEY,
    ADDRESS         VARCHAR(250),
    OP_CL           VARCHAR(5),
    CITY            VARCHAR(25),
    STATE           VARCHAR(2),
    latitude        FLOAT(10),
    longitude       FLOAT(10),
    REV_COUNT       NUMBER(5),
    BNAME           VARCHAR(100),
    STARS           NUMBER(5),
    BTYPE           VARCHAR(10)
);

CREATE TABLE USERS (
    YELP_SINCE  DATE,
    VOTES       VOTES,
    REV_COUNT   NUMBER(5),
    USER_NAME   VARCHAR(50),
    USERID      VARCHAR(25) PRIMARY KEY,
    FAN         NUMBER(5),
    AVG_STARS   FLOAT(5),
    UTYPE       VARCHAR(10)
);

CREATE TABLE MAIN_CATEGORIES (
    BID          VARCHAR(25),
    MCAT         VARCHAR(50),
    FOREIGN KEY (BID) REFERENCES BUSINESS (BID) ON DELETE CASCADE
);

CREATE TABLE SUB_CATEGORIES (
    BID          VARCHAR(25),
    SCAT         VARCHAR(50),
    FOREIGN KEY (BID) REFERENCES BUSINESS (BID) ON DELETE CASCADE
);

CREATE TABLE REVIEWS (
    BID         VARCHAR(25),
    VOTES       VOTES,
    USERID      VARCHAR(25),
    RID         VARCHAR(25) PRIMARY KEY,
    STARS       NUMBER(5),
    REVIEW_DATE DATE,
    TEXT        CLOB,
    RTYPE       VARCHAR(10),
    FOREIGN KEY (BID) REFERENCES BUSINESS (BID) ON DELETE CASCADE,
    FOREIGN KEY (USERID) REFERENCES USERS (USERID) ON DELETE CASCADE
);






CREATE TABLE ATTRIB (
    BID     VARCHAR(25),
    ATTR    VARCHAR(50),
    ATTR_VALUE  VARCHAR(50),
    FOREIGN KEY (BID) REFERENCES BUSINESS (BID) ON DELETE CASCADE
);




CREATE TABLE HOURS (
    BID             VARCHAR(25),
    SU_O            DATE,
    SU_C            DATE,
    MO_O            DATE,
    MO_C            DATE,
    TU_O            DATE,
    TU_C            DATE,
    WE_O            DATE,
    WE_C            DATE,
    TH_O            DATE,
    TH_C            DATE,
    FR_O            DATE,
    FR_C            DATE,
    SA_O            DATE,
    SA_C            DATE,
    FOREIGN KEY (BID) REFERENCES BUSINESS (BID) ON DELETE CASCADE
);


