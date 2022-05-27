CREATE PROCEDURE [dbo].[sp_actualizarSuperDni]  @SuperDni VARCHAR(20)
AS
UPDATE Empresa.dbo.Empleado SET Empleado.SuperDni= null WHERE Empleado.SuperDni =@SuperDni
GO
