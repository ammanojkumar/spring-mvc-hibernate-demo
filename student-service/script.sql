<!-- Student table will create when start application. username and password are same a,a / b,b / c,c -->

create table Login_User(username VARCHAR(255) primary key , password VARCHAR(255), enabled INTEGER, role VARCHAR(255));

insert into Login_User values('a','$2a$10$0C8o1V9DKUmbqv/CGcDozeJErvT.sM7wtfWHVCR3kleWuKVfykTA6',1,'ROLE_ADMIN');
insert into Login_User values('b','$2a$10$0muOkZuwPyubkgAwTbMPE.EPSUWms9vTBeiIMNfoDYEIUHEMQtLAC',1,'ROLE_USER');
insert into Login_User values('c','$2a$10$QZoomPf1Jr2.PBsnIXQvT.OL2PjI/HpU6dzyANtFAJ3Urt8mhgyMO',1,'ROLE_USER');
insert into Login_User values('d','$2a$10$rPs869uKj60N1JG7AoufceObFcePBK8wedo/13cF3hMCmuHx2AqmO',1,'ROLE_ADMIN');