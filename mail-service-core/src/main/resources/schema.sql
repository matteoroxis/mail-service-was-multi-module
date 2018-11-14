create table if not exists email
(
   id integer not null,
   subject varchar(255) not null,
   to varchar(255) not null,
   body varchar(255) not null,
   primary key(id)
);