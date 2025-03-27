package teste;

import java.sql.*;

public class CadMedicos {
    public static final String query = "select * from cad_medicos";
    public static void getMedicos(){
        try{
            /*Connection é uma interface que permite abrir uma conexão com o banco */
            Connection connection = DriverManager.getConnection(connectDB.url, connectDB.user, connectDB.password);

            /*Prepara um statement SQL para ser executado
            * PreparedStatement também é uma insterface
            * o valor de connection.prepareStatement() pode ser um text, como abaixo, ou uma variável que contenha o statement*/
            PreparedStatement statement = connection.prepareStatement("select * from cad_medicos");

            /*Armazena os resultados em uma variável que implementa a interface ResultSet */
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String crm = rs.getString("crm");
                String nome = rs.getString("nome");


                System.out.println(codigo +"          "+nome+"       "+crm);
            }
        }catch (SQLException e){
            connectDB.printSQLException(e);
        }

    }

}
