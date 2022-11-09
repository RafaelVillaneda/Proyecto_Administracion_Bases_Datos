<!DOCTYPE html>


<html>


<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <title>Pacientes</title>
</head>


<body>
    <?php
    require_once('header.php');
    ?>
    <div class="container">
        <table class="table table-striped mt-4 my-4">
            <thead>
                <h2 class="text-center">Pacientes</h2>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Apellido paterno</th>
                    <th>Apellido materno</th>
                    <th>Número telefonico</th>
                    <th>Edad</th>
                    <th>Sexo</th>
                    <th>Dirección</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <?php
                    $parametro = $_POST['parametro'];
                    //
                    if ($parametro == '') {
                        include("tabla.php");
                    } else {
                        //var_dump($parametro);
                        include('../controlador/paciente_dao.php');
                        $paciente = new Paciente(
                            $_POST['parametro'],
                            $_POST['parametro'],
                            $_POST['parametro'],
                            $_POST['parametro'],
                            $_POST['parametro'],
                            $_POST['parametro'],
                            $_POST['parametro'],
                            $_POST['parametro']
                        );
                        //var_dump($paciente);
                        
                        $aDAO = new PacienteDAO();
                        Singleton::obtenerConexion();
                        $paciente2 = new Paciente(15,"Jose","Villaneda","Sandoval","4945137436",67,"M","18 de julio #36 col. centro");
                        $resultado = $aDAO->mostrarPacienteFiltro($paciente2);
                        //var_dump($resultado);

                        if ($resultado->rowCount()) {
                            //echo("Hay registros");
                            while ($result = $resultado->fetch(PDO::FETCH_ASSOC)) {
                                printf("<tr>");
                                printf("<td>" . $result["id_paciente"] . "</td>");
                                printf("<td>" . $result["nombre"] . "</td>");
                                printf("<td>" . $result["apellido_paterno"] . "</td>");
                                printf("<td>" . $result["apellido_materno"] . "</td>");
                                printf("<td>" . $result["num_telefono"] . "</td>");
                                printf("<td>" . $result["edad"] . "</td>");
                                printf("<td>" . $result["sexo"] . "</td>");
                                printf("<td>" . $result["direccion"] . "</td>");
                                printf(
                                    "<td><a  href='../controlador/procesar_cambios.php?id_paciente=%s&nombre=%s&primerAp=%s&SegundoAp=%s&no_tel=%s&edad=%s&sexo=%s&dire=%s'
                class='btn btn-outline-success'>Modificar</a>",
                                    $result["id_paciente"],
                                    $result["nombre"],
                                    $result["apellido_paterno"],
                                    $result["apellido_materno"],
                                    $result["num_telefono"],
                                    $result["edad"],
                                    $result["sexo"],
                                    $result["direccion"]
                                );
                                printf("<a href='../controlador/procesar_bajas.php?id_paciente=%s'class='btn btn-outline-danger'>Eliminar</a></td>", $result["id_paciente"]);
                                printf("</tr>");
                            }
                        } else {
                            echo ("No hay registros");
                        }
                    }
                    ?>

                </tr>
            </tbody>
        </table>
    </div>

    </div>


</body>


</html>