CREATE PROCEDURE [dbo].[sp_actualizarDno]  @Dno int
AS
UPDATE dbo.Empleado SET Empleado.Dno= -1 WHERE Empleado.Dno=@Dno
GO

