CREATE DATABASE University;
USE University;

CREATE TABLE lectors(
    id INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    salary DOUBLE,
    degree VARCHAR(50) NOT NULL,
    CHECK ( salary>=0 ),
    PRIMARY KEY (id)
);

CREATE TABLE departments(
    id INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    head_of_department INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (head_of_department) REFERENCES lectors(id)
);

CREATE TABLE department_lectors(
    department_id INTEGER NOT NULL,
    lector_id INTEGER NOT NULL,
    PRIMARY KEY (department_id, lector_id),
    FOREIGN KEY (department_id) REFERENCES departments (id),
    FOREIGN KEY (lector_id) REFERENCES lectors (id)
);

INSERT INTO lectors (name, surname, salary, degree) VALUES ('Andrii', 'Shevchenko', 1500,'Professor');
INSERT INTO lectors (name, surname, salary, degree) VALUES ('Roman', 'Kotyk', 2000,'Professor');
INSERT INTO lectors (name, surname, salary, degree) VALUES ('Yaroslav', 'Yaremchuk', 1350,'Assistant');
INSERT INTO lectors (name, surname, salary, degree) VALUES ('Andrii', 'Savchenko', 750,'Assistant');
INSERT INTO lectors (name, surname, salary, degree) VALUES ('Oleksandr', 'Koval', 3500,'Assistant');
INSERT INTO lectors (name, surname, salary, degree) VALUES ('Anastasia', 'Shalko', 6000,'Associate_professor');
INSERT INTO lectors (name, surname, salary, degree) VALUES ('Oleksandra', 'Popovych', 1500,'Professor');
INSERT INTO lectors (name, surname, salary, degree) VALUES ('Maria', 'Kotyk', 3700,'Professor');
INSERT INTO lectors (name, surname, salary, degree) VALUES ('Yurii', 'Makar', 5000,'Professor');
INSERT INTO lectors (name, surname, salary, degree) VALUES ('Ostap', 'Kotsuba', 4500,'Assistant');
INSERT INTO lectors (name, surname, salary, degree) VALUES ('Rostyslav', 'Koval', 2305,'Associate_professor');
INSERT INTO lectors (name, surname, salary, degree) VALUES ('Yaroslava', 'Shalko', 3400,'Associate_professor');

INSERT INTO departments(name,head_of_department) VALUES ('Applied Math',2);
INSERT INTO departments(name, head_of_department) VALUES ('Computer Science',10);

INSERT INTO department_lectors(department_id, lector_id) VALUES (1,2);
INSERT INTO department_lectors(department_id, lector_id) VALUES (2,10);
INSERT INTO department_lectors(department_id, lector_id) VALUES (1,5);
INSERT INTO department_lectors(department_id, lector_id) VALUES (1,6);
INSERT INTO department_lectors(department_id, lector_id) VALUES (1,7);
INSERT INTO department_lectors(department_id, lector_id) VALUES (1,12);
INSERT INTO department_lectors(department_id, lector_id) VALUES (1,4);
INSERT INTO department_lectors(department_id, lector_id) VALUES (1,8);
INSERT INTO department_lectors(department_id, lector_id) VALUES (2,1);
INSERT INTO department_lectors(department_id, lector_id) VALUES (2,3);
INSERT INTO department_lectors(department_id, lector_id) VALUES (2,2);
INSERT INTO department_lectors(department_id, lector_id) VALUES (2,4);
INSERT INTO department_lectors(department_id, lector_id) VALUES (2,5);
INSERT INTO department_lectors(department_id, lector_id) VALUES (2,6);
INSERT INTO department_lectors(department_id, lector_id) VALUES (2,7);
INSERT INTO department_lectors(department_id, lector_id) VALUES (2,8);
INSERT INTO department_lectors(department_id, lector_id) VALUES (2,11);
INSERT INTO department_lectors(department_id, lector_id) VALUES (2,12);
INSERT INTO department_lectors(department_id, lector_id) VALUES (1,11);
INSERT INTO department_lectors(department_id, lector_id) VALUES (1,10);

