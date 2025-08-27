-- ===== Professors (fixed IDs) =====
insert into professor (id, name) values (1, 'Dr. Alice Johnson');
insert into professor (id, name) values (2, 'Dr. Bob Smith');
insert into professor (id, name) values (3, 'Dr. Carol Lee');
insert into professor (id, name) values (4, 'Dr. David Brown');

-- ===== Students (fixed IDs, no professor assigned) =====
insert into student (id, name) values (1, 'Dean von Schoultz');
insert into student (id, name) values (2, 'Alex Carter');
insert into student (id, name) values (3, 'Maria Lopez');
insert into student (id, name) values (4, 'James Wilson');
insert into student (id, name) values (5, 'Sophia Patel');
insert into student (id, name) values (6, 'Liam O''Connor');
insert into student (id, name) values (7, 'Emma Zhang');
insert into student (id, name) values (8, 'Noah Müller');
insert into student (id, name) values (9, 'Olivia Rossi');
insert into student (id, name, professor_id) values (10, 'Ethan Kim',1);


