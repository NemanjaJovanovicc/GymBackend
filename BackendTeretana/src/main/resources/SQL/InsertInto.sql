--EMPLOYEE
insert into "employee"("id","username","password","name","surname","contact")
values (nextval('Employee_seq'),'markoperovic00','markopet','Marko','Petrovic','065-8765429');
insert into "employee"("id","username","password","name","surname","contact")
values (nextval('Employee_seq'),'ana98jov','anajov','Ana','Jovanovic','062-870820');
insert into "employee"("id","username","password","name","surname","contact")
values (nextval('Employee_seq'),'dare.mitrovic','darecare','Darko','Mitorvic','064-8743294');
insert into "employee"("id","username","password","name","surname","contact")
values (nextval('Employee_seq'),'dunja77lukic','dunja123','Dunja','Lukic','065-9874322');
insert into "employee"("id","username","password","name","surname","contact")
values (nextval('Employee_seq'),'ogjnen.82la','ognjen87','Ognjen','Lazic','064-1239762');

--EMPLOYEE TEST
insert into "employee"("id","username","password","name","surname","contact")
values (-100,'username TEST','password TEST','name TEST','surname TEST','contact TEST');

select * from employee;

--COACH
insert into "coach"("id","name","surname","jmbg","adress","contact")
values (nextval('Coach_seq'),'Luka','Mitrovic','8777321070211','Bulevar Oslobodjenja 89','063-213761');
insert into "coach"("id","name","surname","jmbg","adress","contact")
values (nextval('Coach_seq'),'Mitar','Petrovic','9326498372125','Brace Ribnikar 71','064-8632873');
insert into "coach"("id","name","surname","jmbg","adress","contact")
values (nextval('Coach_seq'),'Djordje','Gacic','1230283213434','Futoska 56','062-6786876');
insert into "coach"("id","name","surname","jmbg","adress","contact")
values (nextval('Coach_seq'),'Andjela','Gajic','9879387498327','Kornelija Stankovic 14a','062-9632123');
insert into "coach"("id","name","surname","jmbg","adress","contact")
values (nextval('Coach_seq'),'Nemanja','Matic','8961273902131','Zitni trg 12','064-8768736');

--COACH TEST
insert into "coach"("id","name","surname","jmbg","adress","contact")
values (-100,'name TEST','surname TEST','TEST','TEST','TEST');


select * from coach;

--PAYMENT
insert into "payment"("id","amount","paymentdate")
values (nextval('Payment_seq'),'2500 dinara','12.02.2021');
insert into "payment"("id","amount","paymentdate")
values (nextval('Payment_seq'),'2000 dinara','10.02.2021');
insert into "payment"("id","amount","paymentdate")
values (nextval('Payment_seq'),'1800 dinara','01.02.2021');
insert into "payment"("id","amount","paymentdate")
values (nextval('Payment_seq'),'3000 dinara','07.02.2021');
insert into "payment"("id","amount","paymentdate")
values (nextval('Payment_seq'),'2200 dinara','18.02.2021');

--PAYMENT TEST
insert into "payment"("id","amount","paymentdate")
values (-100,'Test dinara','datum test');

select * from payment;


--WORKOUT_TYPE
insert into "workout_type"("id","title")
values (nextval('Workout_type_seq'),'fitness');
insert into "workout_type"("id","title")
values (nextval('Workout_type_seq'),'aerobik');
insert into "workout_type"("id","title")
values (nextval('Workout_type_seq'),'dzudo');
insert into "workout_type"("id","title")
values (nextval('Workout_type_seq'),'gym trening');
insert into "workout_type"("id","title")
values (nextval('Workout_type_seq'),'dziu dzica');

--WORKOUT_TYPE TEST
insert into "workout_type"("id","title") 
values (-100,'dziu dzica TEST');

select * from workout_type;

--CARD_CATEGORY
insert into "card_category"("id","name","description","mark")
values (nextval('Card_category_seq'),'basic','12 termina mesecno','B');
insert into "card_category"("id","name","description","mark")
values (nextval('Card_category_seq'),'classic','16 termina mesecno','C');
insert into "card_category"("id","name","description","mark")
values (nextval('Card_category_seq'),'premium','31 termin mesecno','P');
insert into "card_category"("id","name","description","mark")
values (nextval('Card_category_seq'),'gold','50 termina mesecno','G');
insert into "card_category"("id","name","description","mark")
values (nextval('Card_category_seq'),'classic XL','25 termina mesecno','XL');

--CARD_CATEGORY TEST
insert into "card_category"("id","name","description","mark")
values (-100,'name TEST','description TEST','mark TEST');

select * from card_category;


--MEMBER
insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Katarina','Mitrovic','1273523182343','Branka Bajica 23','063-3962312','student',1,1);
insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Marko','Gavric','2381736219873','Cara Lazara 3','067-339842','student',1,51);
insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Valentina','Brankovic','3218763912873','Bulevar Cara Lazara 82','063-394873','zaposlen',1,101);

insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Milorad','Sekulic','3219632131232','Karadjordjeva 232','062-32143212','penzioner',51,1);
insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Danilo','Mitic','3213343212131','Kneza Milosa 312','062-3123123','student',51,201);
insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Stefan','Radic','3219832897309','Bulevar Oslobodnjenja 2','065-22341412','zaposlen',51,151);
insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Dusan','Djaic','1274325523343','Jevrejska 32','063-423546','student',51,1);

insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Djurdja','Markovic','3276321893691','Kralja Petra 17','0632-2323234','nezaposlen',101,51);
insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Dragana','Eric','3291863981234','Kosovska 23','063-1231232','penzioner',101,51);
insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Katarina','Zujovic','3918237982734','BDunavska 42','065-5345345','student',101,101);
insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Dejan','Jevtic','3198239817311','Veternik','063-987493','nezaposlen',101,51);


insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Olivera','Selakovic','9837189273902','Branka Bajica 74','064-3123123','student',151,201);
insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Filip','Markovic','3982163986121','Jevrejska 72','063-5436345','zaposlen',151,151);
insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Milos','Nikolic','1983679187309','Toplice Milana 32','065-5456542','zaposlen',151,1);

insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Milica','Stefanovic','9987384979287','Bulevar Cara Lazara 4','063-7625313','student',201,1);
insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Nadja','Jokic','8937109470938','Mise Dimitrijevic 32','063-8712638','student',201,201);
insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (nextval('Member_seq'),'Darko','Marijanovic','9847932874982','DUnavska 3','063-3387126','nezaposlen',201,101);

--MEMBER TEST
insert into "member"("id","name","surname","jmbg","adress","contact","status","cardcategory","payment")
values (-100,'name TEST','surname TEST','jmbg TEST','addres TEST','contact TEST','status TEST',201,101);

select * from member;


--GYM_CARD
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','1','101');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','51','301');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','101','351');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','151','401');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','201','451');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','251','501');

insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','301','551');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesecna','351','601');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','401','651');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','451','701');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','1','751');

insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','51','801');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','101','851');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','151','901');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','201','951');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','251','1001');


insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','301','1051');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','351','101');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','401','301');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','451','351');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','1','401');

insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','51','451');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','101','501');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','151','551');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','201','601');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','251','651');
insert into "gym_card"("id","cardduration","employee","member")
values (nextval('Gym_card_seq'),'mesečna','301','701');


--GYM_CARD TEST
insert into "gym_card"("id","cardduration","employee","member")
values (-100,'card TEST','1','101');


select * from gym_card;

--WORKOUT
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','1','1','101');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','51','51','301');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','101','101','351');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','151','151','401');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','201','201','451');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','201','251','501');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','151','301','551');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','101','351','601');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','51','401','651');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','1','451','701');


insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','1','1','751');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','51','51','801');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','101','101','851');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','151','151','901');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','201','201','951');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','151','251','1001');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','101','301','1051');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','51','351','101');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','1','401','301');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','1','451','351');

insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','51','1','401');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','101','51','451');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','151','101','501');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','201','151','551');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','151','201','601');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','101','251','651');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','51','301','701');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','1','351','751');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','101','401','801');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','15.02.2021','151','451','851');

insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','13.02.2021','201','1','901');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','11.02.2021','1','51','951');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','19.02.2021','51','101','1001');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','19.02.2021','101','151','1051');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','21.02.2021','151','201','101');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','18.02.2021','201','251','301');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','24.02.2021','151','301','351');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','25.02.2021','201','351','401');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','24.02.2021','101','401','451');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','09.02.2021','51','451','501');

insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','19.02.2021','1','1','551');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','11.02.2021','51','51','601');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','12.02.2021','151','101','651');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','13.02.2021','101','151','701');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','14.02.2021','201','201','751');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','18.02.2021','51','251','801');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','18.02.2021','151','301','851');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','21.02.2021','1','351','901');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','25.02.2021','201','401','951');
insert into "workout"("id","duration","date","workouttype","coach","member")
values (nextval('Workout_seq'),'1h','18.02.2021','51','451','1001');


--WORKOUT TEST
insert into "workout"("id","duration","date","workouttype","coach","member")
values (-100,'duration TEST','date TEST','51','451','1001');

select * from workout;

--ROLE

DELETE FROM roles
WHERE id=4;

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

SELECT * FROM roles;

select * from users;
INSERT INTO users (id, email, password,username) VALUES  (1,'mod@gmail.com','12345678','mod');
INSERT INTO users (id, email, password,username) VALUES  (2,'admin@gmail.com','12345678','admin');
INSERT INTO users (id, email, password,username) VALUES  (3,'user@gmail.com','12345678','user');

INSERT INTO users (id, email, password,username) VALUES  (5,'luka@gmail.com','12345678','luka');

select * from user_roles;
INSERT INTO user_roles (user_id,role_id) VALUES  (1,1); 
INSERT INTO user_roles (user_id,role_id) VALUES  (1,2); 
INSERT INTO user_roles (user_id,role_id) VALUES  (2,3); 
INSERT INTO user_roles (user_id,role_id) VALUES  (3,1); 
INSERT INTO user_roles (user_id,role_id) VALUES  (4,3); 

INSERT INTO user_roles (user_id,role_id) VALUES  (7,2); 




