INSERT INTO worker (name, birthday, level, salary)
VALUES
('Ivan', '2000-01-01', 'Trainee', 300),
('Oleg', '1995-02-20', 'Junior', 500),
('Ruslan', '1980-02-20', 'Senior', 6000),
('Oleksandr', '2003-12-26', 'Trainee', 350),
('Olena', '1991-10-10', 'Middle', 1000),
('Sveta', '1983-10-16', 'Senior', 6500),
('Anton', '1997-05-01', 'Middle', 1100),
('Oleksiy', '2003-12-12', 'Junior', 600),
('Anna', '2002-04-05', 'Trainee', 380),
('Roman', '1999-03-08', 'Middle', 1200);

INSERT INTO client (name)
VALUES
('Starcompany'),
('Superenterprise'),
('Global comunication'),
('NBC'),
('Smile');

INSERT INTO project (client_id, start_date, finish_date)
VALUES
(1, '2022-01-01','2023-01-01'),
(2, '2020-01-01','2020-10-10'),
(3, '2022-02-01','2022-03-01'),
(4, '2021-10-01','2021-12-01'),
(5, '2023-03-01','2023-08-01'),
(5, '2023-02-01','2023-06-01'),
(5, '2022-05-01','2022-10-01'),
(2, '2020-04-01','2020-08-01'),
(3, '2020-01-01','2023-01-01'),
(1, '2018-01-01','2023-01-01');

INSERT INTO project_worker (project_id, worker_id)
VALUES
(1, 2 ),
(1, 5 ),
(1, 6 ),
(1, 7 ),
(1, 10 ),
(2, 1 ),
(2, 3 ),
(2, 4 ),
(3, 8 ),
(3, 7 ),
(4, 6 ),
(5, 9 ),
(5, 8 ),
(6, 1 ),
(6, 3 ),
(7, 9 ),
(7, 10),
(8, 4 ),
(9, 6 ),
(10, 1 ),
(10, 2 ),
(10, 3 );
