package teste;

import java.sql.SQLException;

public class connectDB {
    /*Lembrando que, para funcionar, precisa adicionar este trecho dentro do aquivo pom.xml do maven
     <dependencies>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.3</version>
        </dependency>
    </dependencies>

    também precisa rodar um CTRL+SHIFT+A, pesquisar por "reload" e selecionar a opção "reload All maven projects"
    para que a dependencia seja baixada e adicionada, de maneira que o java entenda onde buscar
    --Claro, isso após criar o banco de dados no postgres, tabela, iaraiara
    */
    /* Cria os dados de conexão com o banco de dados */
    public static final String url = "jdbc:postgresql://localhost/consultorio";
    public static final String user = "postgres";
    public static final String password = "masterkey";

    /*
    * Dentro da classe que vai executar o comando SQL vai funcionar como [Classe] [Variavel] = DriverManager.getConnection(url, user, password)
    * Connection conexaoComBanco = DriverManager.getConnection(connectDB.url, connectDB.user, connectDB.password);
    */


    public static void printSQLException(SQLException ex){
        for (Throwable e:ex){
            if (e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
            }
        }
    }
}
