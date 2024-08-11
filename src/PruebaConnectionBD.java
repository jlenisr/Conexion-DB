
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PruebaConnectionBD{
    public static void main(String[] args) throws Exception {

        // Parametros de conexion a la base de datos //
        String usuario = "root"; // Usuario de la base de datos //
        String password = ""; // Contraseña del usuario //
        String url = "jdbc:mysql://localhost:3306/petparadiseprueba"; // URL de la base de datos //
        Connection connection; // Objeto para manejar la conexion //
        Statement statement; // Objeto para ejecutar consultas SQL //
        ResultSet rs; // Objeto para almacenar el resultado de una consulta SQL //

        try{

            // Cargar el driver JDBC para MySQL //
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("----Conexion exitosa a la base de datos Pet Paradise----");
        }catch (ClassNotFoundException ex){

            // Manejar el error por si el driver no se encuentra //
            Logger.getLogger(PruebaConnectionBD.class.getName()).log(Level.SEVERE,null,ex);
        }

        try{

            // Establecer la conexion a la base de datos //
            connection =  DriverManager.getConnection(url,usuario, password);

            // Crear un objeto Statement para ejecutar consultas SQL //
            statement = connection.createStatement();

            // Ejecutar una consulta SQL para insertar todos los registros de la tabla 'usuarios' //
            /*statement.executeUpdate("insert into usuarios(codigo_user,nombres,apellidos,fecha_nacimiento,identificacion,sexo,ciudad,email,contraseña,fecha_registro,compras,adopciones) values('','','','','','','','','','','','')");*/

              //---Ejemplo de uso---// 
            /*statement.executeUpdate("insert into usuarios(codigo_user,nombres,apellidos,fecha_nacimiento,identificacion,sexo,ciudad,email,contraseña,fecha_registro,compras,adopciones) values('2222','Jesus David','Lenis Rodriguez','2002-07-26','0000000','masculino','Barranquilla','jes@gmail.com','jlenis0000','2024-08-10','2','2')");*/
            
            /* 
            // Actualizar registros //
            String updateQuery = "UPDATE usuarios SET nombres = 'Juan David', apellidos = 'Gómez', email = 'juan@misena.edu.co' WHERE codigo_user = '2222'";
            statement.executeUpdate(updateQuery);
            */

            /* 
            // Eliminar registros //
            String deleteQuery = "DELETE FROM usuarios WHERE codigo_user = '2222'";
            statement.executeUpdate(deleteQuery);
            */

            // Ejecutar una consulta SQL para obtener todos los registros de la tabla 'usuarios' // 
            rs = statement.executeQuery("select * from usuarios");

            // Iterar sobre los resultados y mostrarlos en consola //
            rs.next(); // Avanzar hacia el primer registro //
            do{

                // Imprimir los datos de cada registro //
                System.out.println(rs.getInt("codigo_user")+" : "+rs.getString("nombres")+" : "+rs.getString("apellidos")+" : "+rs.getDate("fecha_nacimiento")+" : "+rs.getInt("identificacion")+" : "+rs.getString("sexo")+" : "+rs.getString("ciudad")+" : "+rs.getString("email")+" : "+rs.getString("contraseña")+" : "+rs.getDate("fecha_registro")+" : "+rs.getInt("compras")+" : "+rs.getInt("adopciones"));
            }while(rs.next()); // Continua mientras haya mas registros //
        }catch (SQLException ex) {
            // Manejar errores de SQL, como problemas con la conexion o la consulta //
            Logger.getLogger(PruebaConnectionBD.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}


