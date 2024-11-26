create table notas (
    id int not null primary key auto_increment,
    matricula_id int not null,
    disciplina_id int not null,
    nota DECIMAL(5,2) not null,
    data_lancamento date not null,
    foreign key (matricula_id) references matriculas(id),
    foreign key (disciplina_id) references disciplinas(id)
);