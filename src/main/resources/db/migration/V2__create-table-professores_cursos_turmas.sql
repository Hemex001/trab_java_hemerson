create table professores (
    id int not null primary key auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(15),
    especialidade varchar(100)
);

create table cursos (
    id int not null primary key auto_increment,
    nome varchar(100) not null,
    codigo varchar(20) not null unique,
    carga_horaria int not null
);

create table turmas (
    id int not null primary key auto_increment,
    ano int not null,
    semestre int not null,
    curso_id int not null,
    foreign key (curso_id) references cursos(id)
);