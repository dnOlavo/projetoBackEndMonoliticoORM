create database db_Usuario;
create user 'root'@'%' identified by '';
grant all on db_Usuario.* to 'root'@'%';