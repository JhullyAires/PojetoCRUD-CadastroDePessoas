---
--- drop tables
---

DROP TABLE IF EXISTS pessoa;
DROP TABLE IF EXISTS endereco;

---
--- create tables
---

CREATE TABLE pessoa (
    id SERIAL PRIMARY KEY,
    nome character varying(150) NOT NULL,
    idade date,
    sexo character varying(2)
);

CREATE TABLE endereco (
    id SERIAL PRIMARY KEY,
    estado character varying(2),
    cidade character varying(100),
    logradouro character varying(100),
	numero int,
    cep character varying(8),
	id_pessoa int,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
);

-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: -

INSERT INTO pessoa (nome, idade, sexo) VALUES
('Nancy Davolio', '1948-12-08', 'F'),
('Andrew Fuller', '1952-02-19', 'M'),
('Janet Leverling', '1963-08-30', 'F'),
('Margaret Peacock', '1937-09-19', 'F'),
('Steven Buchanan', '1955-03-04', 'M'),
('Michael Suyama', '1963-07-02', 'M'),
('Robert King', '1960-05-29', 'M'),
('Laura Callahan', '1958-01-09', 'F'),
('Anne Dodsworth', '1966-01-27', 'F');

-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: -

INSERT INTO endereco (estado, cidade, logradouro, numero, cep, id_pessoa) VALUES
('WA', 'Seattle', '507 - 20th Ave. E. Apt. 2A', 102, '98122', 1),
('WA', 'Tacoma', '908 W. Capital Way', 100, '98401', 2),
('WA', 'Kirkland', '722 Moss Bay Blvd.', 562, '98033', 3),
('WA', 'Redmond', '4110 Old Redmond Rd.', 789, '98052', 4),
('UK', 'London', '14 Garrett Hill', 457, 'SW1 8JR', 5),
('UK', 'London', 'Coventry House Miner Rd.', 963, 'EC2 7JR', 6),
('UK', 'London', 'Edgeham Hollow Winchester Way', 852, 'RG1 9SP', 7),
('WA', 'Seattle', '4726 - 11th Ave. N.E.', 753, '98105', 8),
('UK', 'London', '7 Houndstooth Rd.', 267, 'WG2 7LT', 9);
