CREATE TABLE worker (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK(length(name) >= 2 AND length(name) <= 100),
    birthday DATE CHECK(EXTRACT(YEAR FROM birthday) > 1900),
    level VARCHAR(50) NOT NULL CHECK(level IN('Trainee', 'Junior', 'Middle',  'Senior')),
    salary INT NOT NULL CHECK(salary>= 100 AND salary <=100000)
);
CREATE TABLE client (
   id IDENTITY PRIMARY KEY,
   name VARCHAR(1000) NOT NULL CHECK(length(name) >= 2 AND length(name) <= 100)
);

CREATE TABLE project (
   id IDENTITY PRIMARY KEY,
   client_id BIGINT,
   start_date DATE,
   finish_date DATE,
   FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE project_worker (
   project_id INT,
   worker_id BIGINT,
   PRIMARY KEY (project_id, worker_id),
   FOREIGN KEY (project_id) REFERENCES project(id),
   FOREIGN KEY (worker_id) REFERENCES worker(id)
);