--  DROP TABLE --
drop table if exists Employee cascade;
drop table if exists Coach cascade;
drop table if exists Payment cascade;
drop table if exists Workout_type cascade;
drop table if exists Card_category cascade;
drop table if exists Workout cascade;
drop table if exists Member cascade;
drop table if exists Gym_card cascade;

-- DROP SEQUENCE --
drop sequence if exists Employee_seq;
drop sequence if exists Coach_seq;
drop sequence if exists Payment_seq;
drop sequence if exists Workout_type_seq;
drop sequence if exists Card_category_seq;
drop sequence if exists Workout_seq;
drop sequence if exists Member_seq;
drop sequence if exists Gym_card_seq;

-- CREATE TABLE --

create table Employee (
	id integer not null,
	username varchar(50) not null,
	password varchar(50) not null,
	name varchar(50) not null,
	surname varchar(50) not null,
	contact varchar(50)
);

create table Coach (
	id integer not null,
	name varchar(50) not null,
	surname varchar(50) not null,
	JMBG varchar(50) not null,
	adress varchar(50) not null,
	contact varchar(50) not null
);

create table Payment (
	id integer not null,
	amount varchar(50) not null,
	paymentDate varchar(50) not null
);

create table Workout_type (
	id integer not null,
	title varchar(50) not null
);

create table Card_category (
	id integer not null,
	name varchar(50) not null,
	description varchar(100) not null,
	mark varchar(100) 
);


create table Workout (
	id integer not null,
	duration varchar(50) not null,
	date varchar(100) not null ,
	workoutType int not null,
	coach int not null,
	member int not null
);


create table Member (
	id integer not null,
	name varchar(50) not null,
	surname varchar(50) not null,
	JMBG varchar(50) not null,
	adress varchar(50) not null,
	contact varchar(50) not null,
	status varchar(50) not null,
	cardCategory int not null,
	payment int not null
);

create table Gym_card (
	id integer not null,
	cardDuration varchar(70) not null,
	employee int not null,
	member int not null
);

--  ADD PRIMARY KEY --
alter table employee add constraint
pk_employee primary key(id);
alter table coach add constraint
pk_coach primary key(id);
alter table payment add constraint
pk_payment primary key(id);
alter table workout_type add constraint
pk_workout_type primary key(id);
alter table card_category add constraint
pk_card_category primary key(id);
alter table workout add constraint
pk_workout primary key(id);
alter table member add constraint
pk_member primary key(id);
alter table gym_card add constraint
pk_gym_card primary key(id);


--  ADD FOREGIN KEY --
alter table Workout add constraint
fk_workout_workout_type foreign key (workoutType) references Workout_type(id);
alter table Workout add constraint
fk_workout_coach foreign key (coach) references Coach(id);
alter table Workout add constraint
fk_workout_member foreign key (member) references Member(id);
alter table Gym_card add constraint
fk_gym_card_employee foreign key (employee) references Employee(id);
alter table Gym_card add constraint
fk_gym_card_member foreign key (member) references Member(id);
alter table Member add constraint
fk_Member_card_category foreign key (cardCategory) references Card_category(id);
alter table Member add constraint
fk_Member_payment foreign key (payment) references Payment(id);


-- CREATE INDEX --
create index idxfk_workout_workout_type
on workout(workoutType);
create index idxfk_workout_coach
on workout(coach);
create index idxfk_workout_member
on workout(member);
create index idxfk_gym_card_employee
on Gym_card(employee);
create index idxfk_gym_card_member
on Gym_card(member);
create index idxfk_Member_card_category
on Member(cardCategory);
create index idxfk_Member_payment
on Member(payment);


-- CREATE SEQUENCE --
create sequence Employee_seq
increment 1;
create sequence Coach_seq
increment 1;
create sequence Payment_seq
increment 1;
create sequence Workout_type_seq
increment 1;
create sequence Card_category_seq
increment 1;
create sequence Workout_seq
increment 1;
create sequence Member_seq
increment 1;
create sequence Gym_card_seq
increment 1;


--ROLE 

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE users_seq;

drop table users cascade;

CREATE TABLE users (
  user_id int NOT NULL DEFAULT NEXTVAL ('users_seq'),
  username varchar(45) NOT NULL,
  full_name varchar(45) NOT NULL,
  password varchar(64) NOT NULL,
  enabled smallint DEFAULT NULL,
  PRIMARY KEY (user_id),
  CONSTRAINT username_UNIQUE UNIQUE (username)
);
 
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE roles_seq;

CREATE TABLE roles (
  role_id int NOT NULL DEFAULT NEXTVAL ('roles_seq'),
  name varchar(45) NOT NULL,
  PRIMARY KEY (role_id)
);
 
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE users_roles (
  user_id int NOT NULL,
  role_id int NOT NULL
 ,
  CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES roles (role_id),
  CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE INDEX user_fk_idx ON users_roles (user_id);
CREATE INDEX role_fk_idx ON users_roles (role_id);


