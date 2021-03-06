--------------------ADMININFO--------------------
DELETE FROM ADMININFO;
INSERT INTO ADMININFO VALUES(1,'admin','111111','lily','13688997766','shiyl@sin.com',TO_DATE('2013-05-22','yyyy-mm-dd'));
INSERT INTO ADMININFO VALUES(2,'lily','lily123','lily','13688997766','shiyl@sin.com',TO_DATE('2013-05-22','yyyy-mm-dd'));
SELECT * FROM ADMININFO;
--------------------ADMININFO--------------------

--------------------COST----------------------
DELETE FROM COST;
INSERT INTO COST VALUES (1,'5.9元套餐',20,5.9,0.4,0,'5.9元20小时/月,超出部分0.4元/时',DEFAULT,NULL,2);
INSERT INTO COST VALUES (2,'6.9元套餐',40,6.9,0.3,0,'6.9元40小时/月,超出部分0.3元/时',DEFAULT,NULL,2);
INSERT INTO COST VALUES (3,'8.5元套餐',100,8.5,0.2,0,'8.5元100小时/月,超出部分0.2元/时',DEFAULT,NULL,2);
INSERT INTO COST VALUES (4,'10.5元套餐',200,10.5,0.1,0,'10.5元200小时/月,超出部分0.1元/时',DEFAULT,NULL,2);
INSERT INTO COST VALUES (5,'计时收费',0,0,0.5,0,'0.5元/时,不使用不收费',DEFAULT,NULL,3);
INSERT INTO COST VALUES (6,'包月',0,20,0,0,'每月20元,不限制使用时间',DEFAULT,NULL,1);
SELECT * FROM COST;
--------------------COST----------------------

--------------------ACCOUNT----------------------
DELETE FROM ACCOUNT;
ALTER SESSION SET NLS_DATE_FORMAT = 'yyyy-mm-dd';
INSERT INTO ACCOUNT (ID, RECOMMENDERID, LOGINNAME, LOGINPASSWORD, STATUS, CREATEDATE, REALNAME, IDCARDNO, TELEPHONE, GENDER) VALUES(1005, NULL, 'taiji001', '256528', 1, '2008-03-15', 'zhangsanfeng', '410381194302256528', '13669351234', 0);
INSERT INTO ACCOUNT (ID, RECOMMENDERID, LOGINNAME, LOGINPASSWORD, STATUS, CREATEDATE, REALNAME, IDCARDNO, TELEPHONE, GENDER) VALUES(1010, NULL, 'xl18z60', '190613', 1, '2009-06-10', 'guojing', '330682196903190613', '13338924567', 0);
INSERT INTO ACCOUNT (ID, RECOMMENDERID, LOGINNAME, LOGINPASSWORD, STATUS, CREATEDATE, REALNAME, IDCARDNO, TELEPHONE, GENDER) VALUES(1011,1010, 'dgbf70', '270429', 1, '2009-03-01', 'huangrong', '330902197108270429', '13637811357',1);
INSERT INTO ACCOUNT (ID, RECOMMENDERID, LOGINNAME, LOGINPASSWORD, STATUS, CREATEDATE, REALNAME, IDCARDNO, TELEPHONE, GENDER) VALUES(1015,1005, 'mjjzh64', '041115', 1, '2010-03-12', 'zhangwuji', '610121198906041115', '13572952468', 0);
INSERT INTO ACCOUNT (ID, RECOMMENDERID, LOGINNAME, LOGINPASSWORD, STATUS, CREATEDATE, REALNAME, IDCARDNO, TELEPHONE, GENDER) VALUES(1018,1011, 'jmdxj00', '010322', 1, '2011-06-01', 'guofurong', '350581200201010322', '18617832562' , 1);
INSERT INTO ACCOUNT (ID, RECOMMENDERID, LOGINNAME, LOGINPASSWORD, STATUS, CREATEDATE, REALNAME, IDCARDNO, TELEPHONE, GENDER) VALUES(1019,1011, 'ljxj90', '310346', 1, '2012-02-01', 'luwushuang', '320211199307310346', '13186454984',1 );
INSERT INTO ACCOUNT (ID, RECOMMENDERID, LOGINNAME, LOGINPASSWORD, STATUS, CREATEDATE, REALNAME, IDCARDNO, TELEPHONE, GENDER) VALUES(1020, NULL, 'kxhxd20', '121155', 1, '2012-02-20', 'weixiaobao', '321022200010012115', '13953410078', 0);
SELECT * FROM ACCOUNT;
--------------------ACCOUNT----------------------

--------------------HOST----------------------
DELETE FROM HOST;
INSERT INTO HOST VALUES ('192.168.0.26','sunv210','beijing');
INSERT INTO HOST VALUES('192.168.0.20','sun-server','beijing');
INSERT INTO HOST VALUES ('192.168.0.23','sun280','beijing');
INSERT INTO HOST VALUES ('192.168.0.200','ultra10','beijing');
SELECT * FROM HOST;
--------------------HOST----------------------

--------------------SERVICE----------------------
DELETE FROM SERVICE;
ALTER SESSION SET NLS_DATE_FORMAT = 'yyyy mm dd hh24:mi:ss';
INSERT INTO SERVICE VALUES (2001,1010,'192.168.0.26','guojing','guo1234',0,'2009 03 10 10:00:00',NULL,NULL,1);
INSERT INTO SERVICE VALUES (2002,1011,'192.168.0.26','huangr','huang234',0,'2009 03 01 15:30:05',NULL,NULL,1);
INSERT INTO SERVICE VALUES (2003,1011,'192.168.0.20','huangr','huang234',0,'2009 03 01 15:30:10',NULL,NULL,3);
INSERT INTO SERVICE VALUES (2004,1011,'192.168.0.23','huangr','huang234',0,'2009 03 01 15:30:15',NULL,NULL,6);
INSERT INTO SERVICE VALUES (2005,1019,'192.168.0.26','luwsh','luwu2345',0,'2012 02 10 23 :50:55',NULL,NULL,4);
INSERT INTO SERVICE VALUES (2006,1019,'192.168.0.20','luwsh','luwu2345',0,'2012 02 10 00 :00:00',NULL,NULL,5);
INSERT INTO SERVICE VALUES (2007,1020,'192.168.0.20','weixb','wei12345',0,'2012 02 10 11:05:20',NULL,NULL,6);
INSERT INTO SERVICE VALUES (2008,1010,'192.168.0.20','guojing','guo09876',0,'2012 02 11 12:05:21',NULL,NULL,6);
SELECT * FROM SERVICE;
--------------------SERVICE----------------------

--------------------SERVICE_UPDATE_BAK----------------------
DELETE FROM SERVICE_UPDATE_BAK;
--------------------SERVICE_UPDATE_BAK----------------------

--------------------ROLEINFO----------------------
DELETE FROM ROLEINFO;
INSERT INTO ROLEINFO VALUES (1,'超级管理员');
INSERT INTO ROLEINFO VALUES (2,'资费管理员');
--------------------ROLEINFO----------------------

--------------------ADMIN_ROLE----------------------
DELETE FROM ADMIN_ROLE;
INSERT INTO ADMIN_ROLE VALUES (1,1);
INSERT INTO ADMIN_ROLE VALUES (2,2);
--------------------ADMIN_ROLE----------------------

----------------------ROLEINFO_PRIVILEGE---------------------------
DELETE FROM ROLEINFO_PRIVILEGE;
INSERT INTO ROLEINFO_PRIVILEGE VALUES (1,1);
INSERT INTO ROLEINFO_PRIVILEGE VALUES (1,2);
INSERT INTO ROLEINFO_PRIVILEGE VALUES (1,3);
INSERT INTO ROLEINFO_PRIVILEGE VALUES (1,4);
INSERT INTO ROLEINFO_PRIVILEGE VALUES (1,5);
INSERT INTO ROLEINFO_PRIVILEGE VALUES (1,6);
INSERT INTO ROLEINFO_PRIVILEGE VALUES (1,7);
INSERT INTO ROLEINFO_PRIVILEGE VALUES (2,3);
----------------------ROLEINFO_PRIVILEGE---------------------------

----------------------PRIVILEGE---------------------------
DELETE FROM PRIVILEGE;
INSERT INTO PRIVILEGE(ID,MODULENAME,URL) VALUES(1,'角色管理','');
INSERT INTO PRIVILEGE(ID,MODULENAME,URL) VALUES(2,'人员管理','');
INSERT INTO PRIVILEGE(ID,MODULENAME,URL) VALUES(3,'资费管理','');
INSERT INTO PRIVILEGE(ID,MODULENAME,URL) VALUES(4,'账务账号','');
INSERT INTO PRIVILEGE(ID,MODULENAME,URL) VALUES(5,'业务账号','');
INSERT INTO PRIVILEGE(ID,MODULENAME,URL) VALUES(6,'账单管理','');
INSERT INTO PRIVILEGE(ID,MODULENAME,URL) VALUES(7,'报表管理','');
INSERT INTO PRIVILEGE(ID,MODULENAME,URL) VALUES(8,'实习生A','');
----------------------PRIVILEGE---------------------------

----------------------SERVICE_DETAIL---------------------------
ALTER SESSION SET NLS_DATE_FORMAT = 'yyyy-mm-dd hh24:mi:ss';
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2001,'192.168.0.1','guojing',123,TO_DATE('2014-03-05 20:20:00'),TO_DATE('2014-03-05 21:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2001,'192.168.0.1','guojing',123,TO_DATE('2014-03-06 10:20:00'),TO_DATE('2014-03-06 20:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2001,'192.168.0.1','guojing',123,TO_DATE('2014-03-07 10:20:00'),TO_DATE('2014-03-07 20:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2001,'192.168.0.1','guojing',123,TO_DATE('2014-03-08 10:20:00'),TO_DATE('2014-03-08 12:55:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2001,'192.168.0.1','guojing',123,TO_DATE('2014-03-08 18:20:00'),TO_DATE('2014-03-08 22:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2001,'192.168.0.1','guojing',123,TO_DATE('2014-03-09 10:20:00'),TO_DATE('2014-03-09 14:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2001,'192.168.0.1','guojing',123,TO_DATE('2014-03-09 11:20:00'),TO_DATE('2014-03-09 13:22:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2001,'192.168.0.1','guojing',123,TO_DATE('2014-03-10 16:20:00'),TO_DATE('2014-03-10 18:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2001,'192.168.0.1','guojing',123,TO_DATE('2014-03-10 20:20:00'),TO_DATE('2014-03-10 22:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2001,'192.168.0.1','guojing',123,TO_DATE('2014-03-11 18:20:00'),TO_DATE('2014-03-11 22:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-05 20:20:00'),TO_DATE('2014-03-05 21:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-06 10:20:00'),TO_DATE('2014-03-06 20:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-07 10:20:00'),TO_DATE('2014-03-07 20:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-08 10:20:00'),TO_DATE('2014-03-08 12:55:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-08 18:20:00'),TO_DATE('2014-03-08 22:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-09 10:20:00'),TO_DATE('2014-03-09 14:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-09 11:20:00'),TO_DATE('2014-03-09 13:22:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-10 16:20:00'),TO_DATE('2014-03-10 18:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-10 20:20:00'),TO_DATE('2014-03-10 22:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-11 18:20:00'),TO_DATE('2014-03-11 22:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2002,'192.168.0.1','huangr',123,TO_DATE('2014-03-05 20:20:00'),TO_DATE('2014-03-05 21:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2002,'192.168.0.1','huangr',123,TO_DATE('2014-03-06 10:20:00'),TO_DATE('2014-03-06 20:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2002,'192.168.0.1','huangr',123,TO_DATE('2014-03-07 10:20:00'),TO_DATE('2014-03-07 20:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2002,'192.168.0.1','huangr',123,TO_DATE('2014-03-08 10:20:00'),TO_DATE('2014-03-08 12:55:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2002,'192.168.0.1','huangr',123,TO_DATE('2014-03-08 18:20:00'),TO_DATE('2014-03-08 22:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2002,'192.168.0.1','huangr',123,TO_DATE('2014-03-09 10:20:00'),TO_DATE('2014-03-09 14:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2002,'192.168.0.1','huangr',123,TO_DATE('2014-03-09 11:20:00'),TO_DATE('2014-03-09 13:22:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2002,'192.168.0.1','huangr',123,TO_DATE('2014-03-10 16:20:00'),TO_DATE('2014-03-10 18:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2002,'192.168.0.1','huangr',123,TO_DATE('2014-03-10 20:20:00'),TO_DATE('2014-03-10 22:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2002,'192.168.0.1','huangr',123,TO_DATE('2014-03-11 18:20:00'),TO_DATE('2014-03-11 22:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-05 20:20:00'),TO_DATE('2014-03-05 21:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-06 10:20:00'),TO_DATE('2014-03-06 20:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-07 10:20:00'),TO_DATE('2014-03-07 20:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-08 10:20:00'),TO_DATE('2014-03-08 12:55:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-08 18:20:00'),TO_DATE('2014-03-08 22:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-09 10:20:00'),TO_DATE('2014-03-09 14:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-09 11:20:00'),TO_DATE('2014-03-09 13:22:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-10 16:20:00'),TO_DATE('2014-03-10 18:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-10 20:20:00'),TO_DATE('2014-03-10 22:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2008,'192.168.0.1','guojing',123,TO_DATE('2014-03-11 18:20:00'),TO_DATE('2014-03-11 22:52:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2004,'192.168.0.1','huangr',123,TO_DATE('2014-03-05 20:20:00'),TO_DATE('2014-03-05 21:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2005,'192.168.0.1','luwsh',123,TO_DATE('2014-03-05 20:20:00'),TO_DATE('2014-03-05 21:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2006,'192.168.0.1','luwsh',123,TO_DATE('2014-03-05 20:20:00'),TO_DATE('2014-03-05 21:20:00'));
INSERT INTO SERVICE_DETAIL(SERVICE_ID,CLIENTHOST,OSUSERNAME,PID,LOGINTIME,LOGOUTTIME) VALUES (2007,'192.168.0.1','weixb',123,TO_DATE('2014-03-05 20:20:00'),TO_DATE('2014-03-05 21:20:00'));
----------------------SERVICE_DETAIL---------------------------