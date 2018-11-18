create table if not exists email
(
   id serial primary key ,
   subject varchar(255) not null,
   toEmail varchar(255) not null,
   body varchar(255) not null
);

create table if not exists attachment
(
   id serial primary key ,
	emailId integer not null,
   fileName varchar(255) not null,
   fileType varchar(255) not null,
   content BYTEA not null
);