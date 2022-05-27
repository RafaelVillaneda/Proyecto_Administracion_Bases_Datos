CREATE DATABASE Empresa
GO
USE Empresa
GO

CREATE TABLE Empleado(Nombre VARCHAR(20) NOT NULL, Apellido1 VARCHAR(20) NOT NULL, Apellido2 VARCHAR(20), Dni VARCHAR(20) PRIMARY KEY NOT NULL, FechaNac DATE NOT NULL, Direccion VARCHAR(20), Sexo VARCHAR(1), Sueldo INT, SuperDni VARCHAR(20), Dno INT)
GO

ALTER TABLE Empleado
   ADD CONSTRAINT fk_Emp_SuperDni
    FOREIGN KEY (SuperDni)
    REFERENCES Empleado (Dni)
    ON DELETE NO ACTION
GO


SELECT TABLE_NAME 
FROM [Empresa].INFORMATION_SCHEMA.TABLES 
WHERE TABLE_TYPE = 'BASE TABLE'
GO 

CREATE TABLE Departamento(NombreDpto VARCHAR(20), NumeroDpto INT PRIMARY KEY NOT NULL, DniDirector VARCHAR(20), FechaIngresoDirector DATE NOT NULL)
GO

ALTER TABLE Departamento
   ADD CONSTRAINT fk_Dpt_DniDirector
    FOREIGN KEY (DniDirector)
    REFERENCES Empleado (Dni)
    ON DELETE NO ACTION
GO

SELECT TABLE_NAME 
FROM [Empresa].INFORMATION_SCHEMA.TABLES 
WHERE TABLE_TYPE = 'BASE TABLE'
GO

ALTER TABLE Empleado
   ADD CONSTRAINT fk_Emp_Dno
    FOREIGN KEY (Dno)
    REFERENCES Departamento (NumeroDpto)
    ON DELETE NO ACTION
GO

CREATE TABLE localizaciones_dpto(NumeroDpto INT, UbicacionDpto VARCHAR(20), PRIMARY KEY(NumeroDpto,UbicacionDpto))
GO

ALTER TABLE localizaciones_dpto
   ADD CONSTRAINT fk_ldp_NumeroDpto
    FOREIGN KEY (NumeroDpto)
    REFERENCES Departamento (NumeroDpto)
    ON DELETE NO ACTION
GO

SELECT TABLE_NAME 
FROM [Empresa].INFORMATION_SCHEMA.TABLES 
WHERE TABLE_TYPE = 'BASE TABLE'
GO

CREATE TABLE Proyecto(NombreProyecto VARCHAR(20), NumProyecto INT PRIMARY KEY, UbicacionProyecto VARCHAR(20), NumDptoProyecto INT)
GO

ALTER TABLE Proyecto
   ADD CONSTRAINT fk_Pyt_NumYLoc
    FOREIGN KEY (NumDptoProyecto,UbicacionProyecto)
    REFERENCES localizaciones_dpto (NumeroDpto,UbicacionDpto)
    ON DELETE NO ACTION
GO

SELECT TABLE_NAME 
FROM [Empresa].INFORMATION_SCHEMA.TABLES 
WHERE TABLE_TYPE = 'BASE TABLE'
GO

CREATE TABLE trabaja_en(DniEmpleado VARCHAR(20) NOT NULL, NumProyecto INT, Horas DECIMAL(5,2))
GO

ALTER TABLE trabaja_en
   ADD CONSTRAINT fk_Tre_Dni
    FOREIGN KEY (DniEmpleado)
    REFERENCES Empleado (Dni)
    ON DELETE CASCADE
GO

CREATE TABLE Subordinado(DniEmpleado VARCHAR(20), NombSubordinado VARCHAR(20), Sexo CHAR, FechaNac DATE, Relacion VARCHAR(20), PRIMARY KEY(DniEmpleado,NombSubordinado))
GO

ALTER TABLE Subordinado
   ADD CONSTRAINT fk_Sbd_DniEmpleado
    FOREIGN KEY (DniEmpleado)
    REFERENCES Empleado (Dni)
    ON DELETE CASCADE
GO

INSERT INTO Empleado(Nombre, Apellido1, Apellido2, Dni, FechaNac, Direccion, Sexo, Sueldo) VALUES
('Jose','Perez','Perez',123456789,'1965-09-01','Eloy I, 98','H',30000),
('Alberto','Campos','Sastre',333445555,'1955-12-08','Avda. Rios, 9','H',40000),
('Aurora','Oliva','Avezuela',453453453,'1972-07-31','Anton,6','M',25000),
('Fernando','Ojeda','Ordoñez',666884444,'1962-09-15','Portillo, s/n','H',38000),
('Eduardo','Ochoa','Paredes',888665555,'1937-11-10','Las peñas, 1','H',55000),
('Juana','Sainz','Oreja',987654321,'1941-06-20','Cerquillas, 67','M',43000),
('Luis','Pajares','Morena',987987987,'1969-03-29','Enebros,90','H',25000),
('Alicia','Jimenez','Celaya',999887777,'1968-05-12','Gran Via, 38','M',25000)
GO

UPDATE Empleado SET SuperDni=333445555 WHERE Dni=123456789 OR Dni=666884444 OR Dni=453453453
GO
UPDATE Empleado SET SuperDni=888665555 WHERE Dni=333445555 OR Dni=987654321
GO
UPDATE Empleado SET SuperDni=987654321 WHERE Dni=999887777 OR Dni=987987987
GO

INSERT INTO Departamento(NombreDpto, NumeroDpto, DniDirector, FechaIngresoDirector) VALUES
('Sede Central',1,'888665555','1981-06-19'),
('Administracion',4,'987654321','1981-06-19'),
('Investigacion',5,'333445555','1988-05-22'),
('N/A',-1,123456789,'1981-06-19')
GO


INSERT INTO localizaciones_dpto VALUES
(1,'Madrid'),
(4,'Gijón'),
(5,'Madrid'),
(5,'Sevilla'),
(5,'Valencia')
GO

UPDATE Empleado SET Dno=1 WHERE Dni=888665555
GO
UPDATE Empleado SET Dno=4 WHERE Dni=999887777 OR Dni=987654321 OR Dni=987987987
GO
UPDATE Empleado SET Dno=5 WHERE Dni=123456789 OR Dni=333445555 OR Dni=666884444 OR Dni=453453453
GO

INSERT INTO Proyecto VALUES
('ProductoX',1,'Valencia',5),
('ProductoY',2,'Sevilla',5),
('ProductoZ',3,'Madrid',5),
('Computación',10,'Gijón',4),
('Reorganización',20,'Madrid',1),
('Comunicaciones',30,'Gijón',4)
GO

INSERT INTO trabaja_en VALUES
('123456789',1,32.5),
('123456789',2,7.5),
('333445555',2,10),
('333445555',3,10),
('333445555',10,10),
('333445555',20,10),
('453453453',1,20),
('453453453',2,20),
('666884444',3,40),
('888665555',20,NULL),
('987654321',20,15),
('987654321',30,20),
('987987987',10,35),
('987987987',30,5),
('999887777',10,10),
('999887777',30,30)
GO

INSERT INTO Subordinado VALUES
('123456789','Alicia','M','1988-12-30','Hija'),
('123456789','Elisa','M','1967-05-05','Esposa'),
('123456789','Miguel','H','1988-01-04','Hijo'),
('333445555','Alicia','M','1986-04-05','Hija'),
('333445555','Luisa','M','1958-05-03','Esposa'),
('333445555','Teodoro','H','1983-10-25','Hijo'),
('987654321','Alfonso','H','1942-02-28','Esposo')
GO

SELECT Nombre, Apellido1, Apellido2, Sueldo, Horas FROM Empleado E JOIN trabaja_en T ON E.Dni=T.DniEmpleado;
GO
SELECT Nombre, Apellido1, Apellido2, NombSubordinado FROM Empleado E JOIN Subordinado S ON E.Dni=S.DniEmpleado WHERE Relacion!='';
GO
SELECT NombreProyecto, UbicacionProyecto FROM Proyecto;
GO
SELECT Nombre, NumProyecto FROM Empleado E JOIN trabaja_en T ON E.Dni=T.DniEmpleado;
GO
SELECT E.Nombre AS Empleado, P.Nombre AS Patron FROM Empleado E JOIN Empleado P ON E.SuperDni=P.Dni;
GO


CREATE TABLE Usuarios(
	usuario varchar(255),
	password varchar(255) NOT NULL
)
GO

ALTER TABLE Usuarios
ADD CONSTRAINT PK_Usuario PRIMARY KEY (usuario);

INSERT INTO usuarios (usuario,password) VALUES ('Admin','admin')







