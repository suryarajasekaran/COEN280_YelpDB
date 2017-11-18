DROP INDEX SUB_CATEGORIES_BID;
DROP INDEX MAIN_CATEGORIES_BID;
DROP INDEX ATTRIB_BID;
DROP INDEX LOCATION_BID;
DROP INDEX HOURS_BID;
DROP INDEX HOURS_OPEN;
DROP INDEX HOURS_CLOSE;
DROP INDEX CHECKIN_BID;
DROP INDEX USER_BID;
DROP INDEX BUSINESS_BID;
DROP INDEX BUSINESS_OP_CL;
DROP INDEX REVIEWS_USERID;
DROP INDEX REVIEWS_RID;

DELETE FROM HOURS;
DELETE FROM LOCATON;
DELETE FROM ATTRIB;
DELETE FROM REVIEWS;
DELETE FROM SUB_CATEGORIES;
DELETE FROM MAIN_CATEGORIES;
DELETE FROM USERS;
DELETE FROM CHECKIN;
DELETE FROM BUSINESS;
DELETE FROM BUSINESS_MAIN_CATEGORIES;

DROP TABLE HOURS CASCADE CONSTRAINTS;
DROP TABLE LOCATON CASCADE CONSTRAINTS;
DROP TABLE ATTRIB CASCADE CONSTRAINTS;
DROP TABLE REVIEWS CASCADE CONSTRAINTS;
DROP TABLE CHECKIN CASCADE CONSTRAINTS;
DROP TABLE SUB_CATEGORIES  CASCADE CONSTRAINTS;
DROP TABLE MAIN_CATEGORIES CASCADE CONSTRAINTS;
DROP TABLE USERS CASCADE CONSTRAINTS;
DROP TABLE BUSINESS CASCADE CONSTRAINTS;
DROP TABLE BUSINESS_MAIN_CATEGORIES CASCADE CONSTRAINTS;