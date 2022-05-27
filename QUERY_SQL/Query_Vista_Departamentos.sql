
DROP VIEW IF EXISTS dept_vista
GO
CREATE VIEW dept_vista 
as
SELECT D.NombreDpto,D.NumeroDpto,D.DniDirector,D.FechaIngresoDirector,L.UbicacionDpto FROM Departamento D,localizaciones_dpto L WHERE D.NumeroDpto=L.NumeroDpto 

GO
