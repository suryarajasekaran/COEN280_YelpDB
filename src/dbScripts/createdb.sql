SET ESCAPE ON;

CREATE TABLE BUSINESS_MAIN_CATEGORIES (
    MAIN_CATEGORY VARCHAR(30)
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
    REV_COUNT   NUMBER(5),
    USER_NAME   VARCHAR(50),
    USERID      VARCHAR(25) PRIMARY KEY,
    AVG_STARS   FLOAT(5)
);

CREATE TABLE REVIEWS (
BID             VARCHAR(25),
VOTES_COOL      NUMBER(5),
VOTES_FUNNY     NUMBER(5),
VOTES_USEFUL    NUMBER(5),
USERID          VARCHAR(25),
RID             VARCHAR(25) PRIMARY KEY,
STARS           NUMBER(5),
REVIEW_DATE     DATE,
TEXT            CLOB,
FOREIGN KEY (BID) REFERENCES BUSINESS (BID) ON DELETE CASCADE,
FOREIGN KEY (USERID) REFERENCES USERS (USERID) ON DELETE CASCADE
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

CREATE TABLE ATTRIB (
    BID     VARCHAR(25),
    ATTR    VARCHAR(50),
    FOREIGN KEY (BID) REFERENCES BUSINESS (BID) ON DELETE CASCADE
);

CREATE TABLE LOCATON (
    BID     VARCHAR(25),
    LOC    VARCHAR(50),
    FOREIGN KEY (BID) REFERENCES BUSINESS (BID) ON DELETE CASCADE
);

CREATE TABLE HOURS (
    BID            VARCHAR(25),
    OPENHRS        NUMBER,
    CLOSEHRS       NUMBER,
    WORKDAY        VARCHAR(10),
    FOREIGN KEY (BID) REFERENCES BUSINESS (BID) ON DELETE CASCADE
);

CREATE TABLE CHECKIN (
    BID            VARCHAR(25),
    CHKINCOUNT     NUMBER,
    FOREIGN KEY (BID) REFERENCES BUSINESS (BID) ON DELETE CASCADE
);

CREATE INDEX SUB_CATEGORIES_BID ON SUB_CATEGORIES (BID);
CREATE INDEX MAIN_CATEGORIES_BID ON MAIN_CATEGORIES (BID);
CREATE INDEX ATTRIB_BID ON ATTRIB (BID);
CREATE INDEX LOCATION_BID ON LOCATON (BID);
CREATE INDEX HOURS_BID ON HOURS (BID);
CREATE INDEX HOURS_OPEN ON HOURS (OPENHRS);
CREATE INDEX HOURS_CLOSE ON HOURS (CLOSEHRS);
CREATE INDEX CHECKIN_BID ON CHECKIN (BID);
