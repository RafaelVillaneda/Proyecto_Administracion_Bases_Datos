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


SELECT TABLE_NAME 
FROM [Empresa].INFORMATION_SCHEMA.TABLES 
WHERE TABLE_TYPE = 'BASE TABLE'
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



CREATE TABLE Usuarios(
	usuario varchar(255),
	password varchar(255) NOT NULL
)
GO

ALTER TABLE Usuarios
ADD CONSTRAINT PK_Usuario PRIMARY KEY (usuario);
GO
INSERT INTO usuarios (usuario,password) VALUES ('Admin','admin')
go





