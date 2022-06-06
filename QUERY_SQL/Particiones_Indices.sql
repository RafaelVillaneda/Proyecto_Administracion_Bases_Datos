
ALTER DATABASE Empresa
ADD FILEGROUP gruporespaldo1

ALTER DATABASE Empresa
ADD FILEGROUP gruporespaldo2

ALTER DATABASE Empresa
ADD FILEGROUP gruporespaldo3

go


ALTER DATABASE Empresa
ADD FILE
(
  NAME = respaldo1,
  FILENAME = 'C:\ParticionesSQLServer\respaldo1.ndf',
    SIZE = 1 MB,
    MAXSIZE = UNLIMITED, 
    FILEGROWTH = 3 MB
) TO FILEGROUP gruporespaldo1

go

ALTER DATABASE Empresa
ADD FILE
(
  NAME = respaldo2,
  FILENAME = 'C:\ParticionesSQLServer\respaldo2.ndf',
    SIZE = 1 MB,
    MAXSIZE = UNLIMITED, 
    FILEGROWTH = 3 MB
) TO FILEGROUP gruporespaldo2

go

ALTER DATABASE Empresa
ADD FILE
(
  NAME = respaldo3,
  FILENAME = 'C:\ParticionesSQLServer\respaldo3.ndf',
    SIZE = 1 MB,
    MAXSIZE = UNLIMITED, 
    FILEGROWTH = 3 MB
) TO FILEGROUP gruporespaldo3

GO




CREATE PARTITION FUNCTION ParticionPorSueldo (int)
AS RANGE LEFT FOR VALUES (1, 999)

go




CREATE PARTITION SCHEME SC_Particion
AS PARTITION ParticionPorSueldo
TO 
( 
  'gruporespaldo1', 'gruporespaldo2', 'gruporespaldo3'
);

go

/*
ALTER TABLE dbo.Empleado
DROP CONSTRAINT PK__Empleado__C03085747E17FBC7
go


CREATE CLUSTERED INDEX ix_gr ON dbo.Empleado(sueldo) ON SC_Particion(sueldo)

go
*/