create table alunos (
    id int not null primary key auto_increment,
    nome varchar(100) not null,
    email varchar(100) unique not null,
    matricula varchar(20) unique not null,
    data_nascimento date not null
);