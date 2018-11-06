
/**
  COMENTARIO MODEL
*/
create table comentario_model
(
  id                bigint                      not null   primary key,
  contenido         varchar(255) default 'NULL' null,
  fecha_publicacion datetime default 'NULL'     null,
  usuario_id        bigint default 'NULL'       null,
  recurso_id        bigint default 'NULL'       null
) engine = MyISAM;

create index FK1ac1ngc5bsse7c5r4lwm02pm4
  on comentario_model (recurso_id);

create index FKp62iyjv9vbqd6eqf1dj7xe5ua
  on comentario_model (usuario_id);


/**
  ETIQUETA MODEL
*/
create table etiqueta_model
(
  id     int                         not null     primary key,
  nombre varchar(255) default 'NULL' null,        
  constraint UK_8lf3ynttj3jp7c8m3rw0pv9wg         unique (nombre)
) engine = MyISAM;


/**
  RECURSO MODEL
*/
create table recurso_model
(
  id            bigint                      not null    primary key,
  autor         varchar(255) default 'NULL' null,
  categoria     varchar(255) default 'NULL' null,
  descripcion   varchar(255) default 'NULL' null,
  edicion       varchar(255) default 'NULL' null,
  etiquetas     varchar(255) default 'NULL' null,
  formato       varchar(255) default 'NULL' null,
  nombre        varchar(255) default 'NULL' null,
  num_consultas int                         not null,
  num_likes     int                         not null
) engine = MyISAM;


/*
  USUARIO MODEL
*/
create table usuario_model
(
  id         bigint                      not null     primary key,
  carrera    varchar(255) default 'NULL' null,
  contrasena varchar(255) default 'NULL' null,
  correo     varchar(255) default 'NULL' null,
  cuenta     bigint                      not null,
  nombre     varchar(255) default 'NULL' null,
  tipo       varchar(255) default 'NULL' null,
  usuario    varchar(255) default 'NULL' null
) engine = MyISAM;

