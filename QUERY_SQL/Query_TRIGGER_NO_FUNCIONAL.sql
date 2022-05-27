CREATE TRIGGER TR_Eliminacion_SuperDni
ON [dbo].[Empleado] for delete
AS
BEGIN
SET NOCOUNT ON;
DECLARE @Dni_borrar AS Varchar(20)
SET @Dni_borrar=(Select deleted.Dni FROM deleted )
EXEC [dbo].[sp_actualizarSuperDni] @Dni_borrar
END
GO

UPDATE Empresa.dbo.Empleado SET Empleado.SuperDni= null WHERE Empleado.SuperDni =147
DELETE FROM Empleado WHERE dni = 147


CREATE TRIGGER TR_Eliminacion_SuperDni
ON [dbo].[Empleado] FOR DELETE
AS
BEGIN
SET NOCOUNT ON;
UPDATE Empresa.dbo.Empleado SET Empleado.SuperDni= null WHERE Empleado.SuperDni=(Select TOP(1) deleted.Dni FROM deleted)
END
GO