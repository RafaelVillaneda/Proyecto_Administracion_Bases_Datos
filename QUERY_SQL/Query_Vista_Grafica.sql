DROP VIEW IF EXISTS grafica_view
GO

CREATE VIEW grafica_view 
as
SELECT UbicacionDpto as Ubicacion,count(*) as Total_Empleados_Trabajando FROM Empleado,localizaciones_dpto where dno=NumeroDpto
GROUP BY UbicacionDpto
HAVING COUNT(*)>1