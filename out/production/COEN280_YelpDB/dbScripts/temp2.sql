﻿SET ESCAPE ON;

CREATE OR REPLACE TYPE VOTES AS OBJECT (
    COOL       NUMBER(5),
    FUNNY      NUMBER(5),
    USEFUL     NUMBER(5)
);

CREATE TABLE BUSINESS_MAIN_CATEGORIES (
    MAIN_CATEGORY VARCHAR(30)
);

CREATE TABLE BUSINESS (
    BID             VARCHAR(25)       PRIMARY KEY,
    ADDRESS         VARCHAR(250),
    OP_CL           VARCHAR(5),
    CITY            VARCHAR(25),
    STATE           VARCHAR(5),
    latitude        FLOAT(10),
    longitude       FLOAT(10),
    REV_COUNT       NUMBER(5),
    BNAME           VARCHAR(100),
    STARS           FLOAT(5),
    BTYPE           VARCHAR(10)
);

CREATE TABLE USERS (
    VOTES       VOTES,
    REV_COUNT   NUMBER(5),
    USER_NAME   VARCHAR(50),
    USERID      VARCHAR(25) PRIMARY KEY,
    AVG_STARS   FLOAT(5)
);

SELECT * FROM REVIEWS

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

DELETE FROM HOURS;

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





select H.BID from HOURS H, HOURS W where trunc(H.OPENHRS) = to_date(H.OPENHRS,'HH24:MI');

trunc(field1) = to_date('2012-01-01', 'YYYY-MM-DD')

DELETE FROM TABLE HOURS;

DROP TABLE LOCATON CASCADE CONSTRAINTS;

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

CREATE TABLE LOCATON (
    BID     VARCHAR(25),
    LOC    VARCHAR(50),
    FOREIGN KEY (BID) REFERENCES BUSINESS (BID) ON DELETE CASCADE
);

INSERT INTO LOCATON (BID, LOC) VALUES ('vcNAWiLM4dR7D2nwwJ7nCA','Pheonix,AZ');


SELECT * FROM BUSINESS_MAIN_CATEGORIES;





-------------




﻿SET ESCAPE ON;

CREATE OR REPLACE TYPE VOTES AS OBJECT (
    COOL       NUMBER(5),
    FUNNY      NUMBER(5),
    USEFUL     NUMBER(5)
);

CREATE TABLE BUSINESS_MAIN_CATEGORIES (
    MAIN_CATEGORY VARCHAR(30)
);

CREATE TABLE BUSINESS (
    BID             VARCHAR(25)       PRIMARY KEY,
    ADDRESS         VARCHAR(250),
    OP_CL           VARCHAR(5),
    CITY            VARCHAR(25),
    STATE           VARCHAR(5),
    latitude        FLOAT(10),
    longitude       FLOAT(10),
    REV_COUNT       NUMBER(5),
    BNAME           VARCHAR(100),
    STARS           FLOAT(5),
    BTYPE           VARCHAR(10)
);

CREATE TABLE USERS (
    VOTES       VOTES,
    REV_COUNT   NUMBER(5),
    USER_NAME   VARCHAR(50),
    USERID      VARCHAR(25) PRIMARY KEY,
    AVG_STARS   FLOAT(5)
);

SELECT * FROM REVIEWS

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

DELETE FROM HOURS;

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





select H.BID from HOURS H, HOURS W where trunc(H.OPENHRS) = to_date(H.OPENHRS,'HH24:MI');

trunc(field1) = to_date('2012-01-01', 'YYYY-MM-DD')

DELETE FROM TABLE HOURS;

DROP TABLE LOCATON CASCADE CONSTRAINTS;

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

CREATE TABLE LOCATON (
    BID     VARCHAR(25),
    LOC    VARCHAR(50),
    FOREIGN KEY (BID) REFERENCES BUSINESS (BID) ON DELETE CASCADE
);

INSERT INTO LOCATON (BID, LOC) VALUES ('vcNAWiLM4dR7D2nwwJ7nCA','Pheonix,AZ');


SELECT * FROM BUSINESS_MAIN_CATEGORIES;




---------------





﻿CREATE TABLE BUSINESS (
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

CREATE OR REPLACE TYPE VOTES AS OBJECT
( COOL       NUMBER(5),
  FUNNY      NUMBER(5),
  USEFUL     NUMBER(5)
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
SA_C            DATE
);

CREATE TABLE ATTRIB (
BID     VARCHAR(25),
ATTR    VARCHAR(50),
ATTR_VALUE  VARCHAR(50),
FOREIGN KEY (BID) REFERENCES BUSINESS (BID) ON DELETE CASCADE
);

Insertion :

Insert into BUSINESS (BID , ADDRESS , OP_CL , CITY, STATE , latitude , longitude, REV_COUNT , BNAME, STARS, BTYPE) VALUES
 ('vcNAWiLM4dR7D2nwwJ7nCA', '4840 E Indian School Rd\nSte 101\nPhoenix, AZ 85018','true', 'Phoenix', 'AZ', 33.499313000000001, -111.98375799999999, 7,'Eric Goldberg, MD', 3.5, 'business');

Insert into BUSINESS (BID , ADDRESS , OP_CL , CITY, STATE , latitude , longitude, REV_COUNT , BNAME, STARS, BTYPE) VALUES
 ('JwUE5GmEO-sH1FuwJgKBlQ', '6162 US Highway 51\nDe Forest, WI 53532','true', 'De Forest', 'WI', 43.238892999999997, -89.335843999999994, 26,'Pine Cone Restaurant', 4.0, 'business');

Insert into BUSINESS (BID , ADDRESS , OP_CL , CITY, STATE , latitude , longitude, REV_COUNT , BNAME, STARS, BTYPE) VALUES
 ('m9haUi2_1lHR2eAKBhKwDg', '5210 N Central Ave\nPhoenix, AZ 85012','true', 'Phoenix', 'AZ', 33.513539000000002,  -112.074195, 371,'Federal Pizza', 4.0, 'business');

select b.BID, c.BID from BUSINESS b, ATTRIB c;
select * FROM USERS;
select * from REVIEWS;
SELECT * FROM MAIN_CATEGORIES
SELECT * FROM SUB_CATEGORIES
SELECT * FROM ATTRIB
select * from BUSINESS

Insert into USERS (YELP_SINCE , REV_COUNT , USER_NAME, USERID , FAN , AVG_STARS, UTYPE) VALUES
 (to_date('2012-02','yyyy/mm'), 6,'Lee', 'qtrmBGNqCvupHMHL_bKFgQ', 0, 3.8300000000000001, 'user');

 Insert into USERS (YELP_SINCE , REV_COUNT , USER_NAME, USERID , FAN , AVG_STARS, UTYPE) VALUES
 (to_date('2010-09','yyyy/mm'), 22,'Jasmine', '0vscrHoajVRa1Yk19XWdwA', 1, 5.0, 'user');

Insert into USERS (YELP_SINCE , REV_COUNT , USER_NAME, USERID , FAN , AVG_STARS, UTYPE) VALUES
 (to_date('2006-12','yyyy/mm'), 267,'Lily', 'Xqd0DzHaiyRqVH3WRG7hzg', 21, 3.71, 'user');

Insert into USERS (YELP_SINCE , REV_COUNT , USER_NAME, USERID , FAN , AVG_STARS, UTYPE) VALUES
 (to_date('2009-04','yyyy/mm'), 13,'Daniel', 'H1kH6QZV7Le4zqTRNxoZow', 0, 1.9099999999999999, 'user');

Insert into USERS (REV_COUNT , USER_NAME, USERID , FAN , AVG_STARS, UTYPE) VALUES
 ( 6,'Lee', 'qtrmBGNqCvupHMHL_bKFgQ', 0, 3.8300000000000001, 'user');

 Insert into USERS ( VOTES, REV_COUNT , USER_NAME, USERID , FAN , AVG_STARS, UTYPE) VALUES
 (VOTES(11, 5, 20), 22,'Jasmine', '0vscrHoajVRa1Yk19XWdw5', 1, 5.0, 'user');

Insert into REVIEWS (BID , VOTES , USERID , RID, STARS , REVIEW_DATE , TEXT, RTYPE) VALUES
 ('vcNAWiLM4dR7D2nwwJ7nCA',VOTES(1,0,2),'Xqd0DzHaiyRqVH3WRG7hzg', '15SdjuK7DmYqUAj6rjGowg',5, TO_DATE('2007/05/17', 'yyyy/mm/dd'), 'dr. goldberg offers everything i look for in a general practitioner.  hes nice and easy to talk to without being patronizing; hes always on time in seeing his patients hes affiliated with a top-notch hospital (nyu) which my parents have explained to me is very important in case something happens and you need surgery; and you can get referrals to see specialists without having to see him first.  really, what more do you need?  im sitting here trying to think of any complaints i have about him, but im really drawing a blank.','review');

 Insert into REVIEWS (BID , VOTES , USERID , RID, STARS , REVIEW_DATE , TEXT, RTYPE) VALUES
 ('vcNAWiLM4dR7D2nwwJ7nCA',VOTES(0,0,2),'H1kH6QZV7Le4zqTRNxoZow', 'RF6UnRTtG7tWMcrO2GEoAg',2, TO_DATE('2010/03/22 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), 'Unfortunately, the frustration of being Dr. Goldbergs patient is a repeat of the experience Ive had with so many other doctors in NYC -- good doctor, terrible staff.  It seems that his staff simply never answers the phone.  It usually takes 2 hours of repeated calling to get an answer.  Who has time for that or wants to deal with it?  I have run into this problem with many other doctors and I just dont get it.  You have office workers, you have patients with medical needs, why isnt anyone answering the phone?  Its incomprehensible and not work the aggravation.  Its with regret that I feel that I have to give Dr. Goldberg 2 stars','review');

insert after business inserts
Insert into REVIEWS (BID , VOTES , USERID , RID, STARS , REVIEW_DATE , TEXT, RTYPE) VALUES
 ('m9haUi2_1lHR2eAKBhKwDg',VOTES(0,0,0),'0vscrHoajVRa1Yk19XWdwA', 'yuU08vL1jbsnQcRx43wCjg',5, to_DATE('2014-06-30','yyyy/mm/dd') ,'Mondays and Tuesdays are super radical.  $20 for two pitchers of beer (or a bottle of wine) and a pizza.  Too good to pass up','review');

INSERT INTO MAIN_CATEGORIES VALUES ('m9haUi2_1lHR2eAKBhKwDg','Restaurants');
INSERT INTO MAIN_CATEGORIES VALUES ('vcNAWiLM4dR7D2nwwJ7nCA','Doctors');
INSERT INTO MAIN_CATEGORIES VALUES ('vcNAWiLM4dR7D2nwwJ7nCA','Hospitals');
INSERT INTO MAIN_CATEGORIES VALUES ('JwUE5GmEO-sH1FuwJgKBlQ','Restaurants');

INSERT INTO SUB_CATEGORIES VALUES ('vcNAWiLM4dR7D2nwwJ7nCA','Health & Medical');
INSERT INTO SUB_CATEGORIES VALUES ('m9haUi2_1lHR2eAKBhKwDg','Pizza');
INSERT INTO SUB_CATEGORIES VALUES ('m9haUi2_1lHR2eAKBhKwDg','Italian');
INSERT INTO SUB_CATEGORIES VALUES ('JwUE5GmEO-sH1FuwJgKBlQ','Mexican');

DROP TABLE ATTRIB;

INSERT INTO ATTRIB VALUES ('vcNAWiLM4dR7D2nwwJ7nCA','By Appointment Only','true');
INSERT INTO ATTRIB VALUES ('JwUE5GmEO-sH1FuwJgKBlQ','Take-out','true');
INSERT INTO ATTRIB VALUES ('m9haUi2_1lHR2eAKBhKwDg','Take-out','true');
INSERT INTO ATTRIB VALUES ('vcNAWiLM4dR7D2nwwJ7nCA','Wi-Fi','free');

SELECT COUNT (BID)
from business  20544
SELECT COUNT (userID)
from users   211002
SELECT COUNT (BID)
from reviews 826190
SELECT COUNT (BID)
from checkin 16896

selections :
main category :
SELECT distinct(MCAT) FROM MAIN_CATEGORIES;

sub : OR
select distinct(SCAT)
FROM SUB_CATEGORIES S, MAIN_CATEGORIES M
WHERE M.MCAT IN ( 'Doctors' ,'Dentists')
and M.BID = S.BID;

sub : AND
SELECT S.SCAT from SUB_CATEGORIES S
where S.Bid in (select DISTINCT(M.BID)
FROM SUB_CATEGORIES S, MAIN_CATEGORIES M
WHERE M.MCAT = 'Doctors'
Intersect
select DISTINCT( M.BID)
FROM SUB_CATEGORIES S, MAIN_CATEGORIES M
WHERE M.MCAT = 'Dentists');

4 only.

union
select distinct(SCAT)
FROM SUB_CATEGORIES S, MAIN_CATEGORIES M
WHERE M.MCAT = 'Real Estate'
and M.BID = S.BID;




SELECT * FROM ATTRIB WHERE BID='m9haUi2_1lHR2eAKBhKwDg';

attrib : AND
select distinct(ATTR)
FROM SUB_CATEGORIES S, MAIN_CATEGORIES M
WHERE M.MCAT IN ('Doctors','Restaurants')
and M.BID = S.BID;

attrib : OR

Location :
select * from business_main_Categories

DROP TABLE ATTRIB CASCADE CONSTRAINTS;
DROP TABLE REVIEWS CASCADE CONSTRAINTS;
DROP TABLE SUB_CATEGORIES  CASCADE CONSTRAINTS;
DROP TABLE MAIN_CATEGORIES CASCADE CONSTRAINTS;
DROP TABLE USERS CASCADE CONSTRAINTS;
DROP TABLE BUSINESS CASCADE CONSTRAINTS;
DROP TABLE BUSINESS_MAIN_CATEGORIES CASCADE CONSTRAINTS;
DROP TABLE HOURS CASCADE CONSTRAINTS;

SELECT COUNT(BID) from BUSINESS; WHERE BID='BRaQrgYVR17bd_zr-wNSlQ';
DELETE FROM SUB_CATEGORIES;

select a.value, s.username, s.sid, s.serial# from v$sesstat a, v$statname b, v$session s where a.statistic# = b.statistic#  and s.sid=a.sid and b.name = 'opened cursors current' and s.username is not null;
select  sid ,sql_text, count(*) as "OPEN CURSORS", USER_NAME from v$open_cursor where sid in ($SID);
show parameter cursor

ALTER SYSTEM SET open_cursors = 800 SCOPE=BOTH;

LOCATION FROM MAIN OR:
SELECT DISTINCT(l.loc)
FROM LOCATON L, MAIN_CATEGORIES M
WHERE M.MCAT IN ( 'Doctors' ,'Dentists')
and M.BID = L.BID;

LOCATION FROM MAIN AND :
SELECT DISTINCT(l.LOC) from LOCATON L
where L.Bid in (select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M
WHERE M.MCAT = 'Dentists'
Intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M
WHERE M.MCAT = 'Doctors');

LOCATION FROM MC, SUB OR :
SELECT DISTINCT(l.LOC) FROM LOCATON L
WHERE L.LOC = 'Pheonix,AZ'
AND L.LOC IN (
SELECT DISTINCT(l.LOC) from LOCATON L
where L.Bid in (select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M
WHERE M.MCAT = 'Dentists'
Intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M
WHERE M.MCAT = 'Doctors')
);




where LOC like '%Vegas%';


select * from business;
from locaton ;

SELECT DISTINCT(l.LOC) from LOCATON L
where L.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Doctors' AND S.SCAT = 'Cosmetic Surgeons'
AND  M.BID = S.BID
UNION
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Doctors' AND S.SCAT = 'Family Practice'
AND M.BID = S.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Dentists' AND S.SCAT = 'Cosmetic Surgeons'
AND M.BID = S.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Dentists' AND S.SCAT = 'Family Practice'
AND M.BID=S.BID
);

LOCATON FROM SUB  : AND (2 MC, 2 SC)
SELECT DISTINCT(L.LOC) from LOCATON L
where L.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Doctors' AND S.SCAT = 'Cosmetic Surgeons'
AND  M.BID = S.BID
INTERSECT
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Doctors' AND S.SCAT = 'Family Practice'
AND M.BID = S.BID
Intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Dentists' AND S.SCAT = 'Cosmetic Surgeons'
AND M.BID = S.BID
Intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Dentists' AND S.SCAT = 'Family Practice'
AND M.BID=S.BID
);

LOCATION FROM ATTRIB :


main category :
SELECT distinct(l.loc)
FROM MAIN_CATEGORIES M, locaton l
where M.MCAT = 'Dentists'
and m.bid = l.bid;

attrib : AND (2 MC, one SC)
SELECT DISTINCT(A.ATTR) from attrib A
where A.Bid in (select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Doctors' AND S.SCAT = 'Cosmetic Surgeons'
Intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Dentists' AND S.SCAT = 'Cosmetic Surgeons' );




------------------





﻿
========================
LOCATION IN STARTING :
select distinct(LOC) from locaton

TO GET location with main : OR
select distinct(l.loc)
from locaton L, main_Categories M
where m.mcat in ('Restaurants','Food')
and l.bid = m.bid;

TO GET location with main : AND
SELECT DISTINCT(l.loc) from locaton L
where l.Bid in (select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M
WHERE M.MCAT = 'Doctors'
Intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M
WHERE M.MCAT = 'Dentists');

TO GET Location WITH  MAIN AND SC selected with : OR
SELECT DISTINCT(L.loc) from locaton l
where l.bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian'
AND  M.BID = S.BID
UNION
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Food' AND S.SCAT = 'American (Traditional)'
AND M.BID = S.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'Vegetarian'
AND M.BID = S.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'American (Traditional)'
AND M.BID=S.BID
);

Location : MAIN AND SC selected with AND
SELECT DISTINCT(l.loc) from locaton l
where l.bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Cafes' AND S.SCAT = 'Fondue'
AND  M.BID = S.BID
intersect
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Cafes' AND S.SCAT = 'American (Traditional)'
AND M.BID = S.BID
intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'Fondue'
AND M.BID = S.BID
intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'American (Traditional)'
AND M.BID=S.BID
);

TO GET LOcation WITH MAIN,SC,ATTRIB with OR
select distinct (l.loc)
from BUSINESS B, LOCATON L
WHERE B.BID = L.BID
AND B.BID IN (
SELECT DISTINCT(B.BID) from BUSINESS B
where B.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND  M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID=S.BID
AND M.BID = A.BID
));

location  : OR (2 MC, 2 SC, 1 attrib)
select distinct (l.loc)
from BUSINESS B, LOCATON L
WHERE B.BID = L.BID
AND B.BID IN (
SELECT DISTINCT(B.BID) from BUSINESS B
where B.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND  M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID=S.BID
AND M.BID = A.BID
));

===================================

DAY HOURS:
WHERE H.BID = '4DDbIvNtzfhLRwz-EOLFDA' OR H.BID = 'AjE4uM-VaGP3QPCjSjIEaw' OR H.BID ='AX56yxldIb7TPBHMaPqOmg' OR H.BID ='X7lGjrkrAkwtMOQbN-S3tA';
CREATE INDEX HOURS_BID ON HOURS (BID);
CREATE INDEX HOURS_OPEN ON HOURS (OPENHRS);
CREATE INDEX HOURS_CLOSE ON HOURS (CLOSEHRS);
oKuvHNucsBVMAkmNdSASSw OPEN 8 , CLOSE 17, 4
ve79IOyqrV98sV1kQhMygg OPEN 8   CLOSE 17

=======================

starting :
SELECT DISTINCT(H.WORKDAY)
FROM HOURS H

SELECT DISTINCT(H.OPENHRS)
FROM HOURS H
order by H.OPENHRS

SELECT DISTINCT(H.CLOSEHRS)
FROM HOURS H
order by H.closehrs

main OR :
SELECT DISTINCT(H.WORKDAY)
FROM HOURS H, main_Categories m
where M.MCAT in ('Doctors','Dentists')
and h.bid = m.bid;

SELECT DISTINCT(H.OPENHRS)
FROM HOURS H, main_Categories m
where M.MCAT in ('Doctors','Dentists')
and h.bid = m.bid
order by H.OPENHRS;

SELECT DISTINCT(h.closehrs)
FROM HOURS H, main_Categories m
where M.MCAT in ('Doctors','Dentists')
and h.bid = m.bid
order by H.closehrs;

main AND :
SELECT DISTINCT(H.WORKDAY) from HOURS H
where H.Bid in (select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M
WHERE M.MCAT = 'Doctors'
Intersect
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M
WHERE M.MCAT = 'Dentists');

SELECT DISTINCT(H.OPENHRS) from HOURS H
where H.Bid in (select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M
WHERE M.MCAT = 'Doctors'
Intersect
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M
WHERE M.MCAT = 'Dentists');

SELECT DISTINCT(H.CLOSEHRS) from HOURS H
where H.Bid in (select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M
WHERE M.MCAT = 'Doctors'
Intersect
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M
WHERE M.MCAT = 'Dentists');

to get days// hours when MC and SC given with OR :
sELECT DISTINCT(H.WORKDAY) from HOURS H
where H.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian'
AND  M.BID = S.BID
UNION
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Food' AND S.SCAT = 'American (Traditional)'
AND M.BID = S.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'Vegetarian'
AND M.BID = S.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'American (Traditional)'
AND M.BID=S.BID
);

SAME FOR CLOSE AND OPEN

MC SC AND :
sELECT DISTINCT(H.WORKDAY) from HOURS H
where H.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian'
AND  M.BID = S.BID
INTERSECT
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Food' AND S.SCAT = 'American (Traditional)'
AND M.BID = S.BID
INTERSECT
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'Vegetarian'
AND M.BID = S.BID
INTERSECT
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'American (Traditional)'
AND M.BID=S.BID
);

SAME FOR CLOSE AND OPEN

to get days date when MC SC ATTR with AND :

select distinct (H.WORKDAY)
from HOURS H
WHERE H.BID IN (
SELECT DISTINCT(B.BID) from BUSINESS B
where B.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND  M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID=S.BID
AND M.BID = A.BID
));

MC SC ATTR OR : to get days date when MC SC ATTR with OR :

select distinct (H.WORKDAY)
from HOURS H
WHERE H.BID IN (
SELECT DISTINCT(B.BID) from BUSINESS B
where B.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND  M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID=S.BID
AND M.BID = A.BID
));


MC SC ATTR LOC OR :

select distinct (H.WORKDAY)
from HOURS H
WHERE H.BID IN (
SELECT DISTINCT(L.BID) FROM LOCATON L , business b
WHERE b.city = 'Pheonix'
and b.bid = l.bid
and L.BID IN (
SELECT DISTINCT(B.BID) from BUSINESS B
where B.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND  M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID=S.BID
AND M.BID = A.BID
)));

MC SC ATTR LOC AND :
select distinct (H.WORKDAY)
from HOURS H
WHERE H.BID IN (
SELECT DISTINCT(L.BID) FROM LOCATON L , business b
WHERE b.city = 'Pheonix'
and b.bid = l.bid
and L.BID IN (
SELECT DISTINCT(B.BID) from BUSINESS B
where B.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND  M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID=S.BID
AND M.BID = A.BID
)));








------------------




﻿BUSINESS :

GET BUSINESS WHEN main GIVEN  FOR OR :
SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT
FROM BUSINESS B, MAIN_cATEGORIES M
WHERE M.MCAT in ('Doctors','Dentists')
AND B.BID = M.BID;

GET BUSINESS WHEN main GIVEN  FOR AND :
SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT
FROM BUSINESS B
where B.Bid in (select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M
WHERE M.MCAT = 'Doctors'
Intersect
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M
WHERE M.MCAT = 'Dentists');

to get BUSINESS when MC and SC given with OR :
sELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT
FROM BUSINESS B
where B.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian'
AND  M.BID = S.BID
UNION
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Food' AND S.SCAT = 'American (Traditional)'
AND M.BID = S.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'Vegetarian'
AND M.BID = S.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'American (Traditional)'
AND M.BID=S.BID
);


to get BUSINESS when MC and SC given with AND :
SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT
FROM BUSINESS B
where B.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian'
AND  M.BID = S.BID
INTERSECT
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Food' AND S.SCAT = 'American (Traditional)'
AND M.BID = S.BID
INTERSECT
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'Vegetarian'
AND M.BID = S.BID
INTERSECT
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'American (Traditional)'
AND M.BID=S.BID
);


to get BUSINESS when MC SC ATTR with AND :
SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT
FROM BUSINESS B
where B.Bid IN (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND  M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID=S.BID
AND M.BID = A.BID
);

TO GET BUSINESS WHEN MC SC ATTR WITH OR :
SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT
FROM BUSINESS B
where B.Bid IN (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND  M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID=S.BID
AND M.BID = A.BID
);



GET BUSINESS WHEN MC SC ATTR LOC WITH OR :

SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT
FROM BUSINESS B
where B.Bid IN (
SELECT DISTINCT(L.BID) FROM LOCATON L , business b
WHERE b.city = 'Pheonix'
and b.bid = l.bid
and L.BID IN (
SELECT DISTINCT(B.BID) from BUSINESS B
where B.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND  M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID=S.BID
AND M.BID = A.BID
)));

GET BUSINESS WHEN MC SC ATTR LOC AND :
SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT
FROM BUSINESS B
where B.Bid IN (
SELECT DISTINCT(L.BID) FROM LOCATON L , business b
WHERE b.city = 'Pheonix'
and b.bid = l.bid
and L.BID IN (
SELECT DISTINCT(B.BID) from BUSINESS B
where B.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND  M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'Vegetarian' AND A.ATTR = 'Caters_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restarants' AND S.SCAT = 'American(Traditional)' AND A.ATTR = 'Caters_TRUE'
AND M.BID=S.BID
AND M.BID = A.BID
)));


to get business when MC SC ATTR LOC DAYS HOURS when OR
SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT
FROM BUSINESS B
where B.Bid IN (
select distinct (H.BID)
from HOURS H
WHERE h.workday = 'Monday' AND H.OPENHRS = '1100' AND H.CLOSEHRS = '2000'
and H.BID IN (
SELECT DISTINCT(L.BID) FROM LOCATON L , business b
WHERE b.city = 'Madison'
and b.bid = l.bid
and L.BID IN (
SELECT DISTINCT(B.BID) from BUSINESS B
where B.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'Fondue' AND A.ATTR = 'Waiter_Service_TRUE'
AND  M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'American (New)' AND A.ATTR = 'Waiter_Service_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'Fondue' AND A.ATTR = 'Waiter_Service_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
UNION
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'American (New)' AND A.ATTR = 'Waiter_Service_TRUE'
AND M.BID=S.BID
AND M.BID = A.BID
))));


to get business when MC SC ATTR LOC DAYS HOURS when AND
SELECT DISTINCT(B.BID) ,B.BNAME, B.ADDRESS, B.CITY, B.STATE,B.STARS, B.REV_COUNT
FROM BUSINESS B
where B.Bid IN (
select distinct (H.BID)
from HOURS H
WHERE h.workday = 'Monday' AND H.OPENHRS = '0' AND H.CLOSEHRS = '2000'
and H.BID IN (
SELECT DISTINCT(L.BID) FROM LOCATON L , business b
WHERE b.city = 'Madison'
and b.bid = l.bid
and L.BID IN (
SELECT DISTINCT(B.BID) from BUSINESS B
where B.Bid in (
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'Fondue' AND A.ATTR = 'Waiter_Service_TRUE'
AND  M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT(M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Food' AND S.SCAT = 'American (New)' AND A.ATTR = 'Waiter_Service_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'Fondue' AND A.ATTR = 'Waiter_Service_TRUE'
AND M.BID = S.BID
AND M.BID = A.BID
intersect
select DISTINCT( M.BID)
FROM MAIN_CATEGORIES M, sub_categories S,attrib A
WHERE M.MCAT = 'Restaurants' AND S.SCAT = 'American (New)' AND A.ATTR = 'Waiter_Service_TRUE'
AND M.BID=S.BID
AND M.BID = A.BID
))));


Review popup : for final B

select R.review_Date, r.stars, r.text, r.userid, u.user_name
from business b, reviews r, users u
where r.userid = u.userid
and b.bid = r.bid
