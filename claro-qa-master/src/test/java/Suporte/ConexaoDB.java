package Suporte;



import java.sql.*;

public class ConexaoDB {
    public String url;
    public String usuario;
    public String senha;
    public Connection con;
    public String aux;

    public ConexaoDB() {
        url = "jdbc:sqlserver://172.16.140.167";
        usuario = "MARCELO_PARREIRA";
        senha = "Mfmti*09";

        try {

            Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
            con = DriverManager.getConnection( url , usuario, senha );



            PreparedStatement comando ;

            String sql = "SELECT TOP 1  DEV_CPF FROM TAB_DEVEDOR ";
            comando = con.prepareStatement(sql);

        Login login = new Login(  );
            ResultSet rs = comando.executeQuery();
            while(rs.next())
                    aux = login.setCpf(rs.getString(1));

            System.out.println(login.getCpf());


        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public static void main(String[] args){
        ConexaoDB con = new ConexaoDB();
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("USE INTERSIC_NET_HOMOLOGACAO\n" +
                "SELECT TOP 1  DEV_CPF FROM TAB_DEVEDOR ");

        return stmt;
    }





     class Login{
        private String cpf;

         public Login() {
         }

         public Login(String cpf) {
             this.cpf = cpf;
         }

         public String getCpf() {
             return cpf;
         }

         public String setCpf(String cpf) {
             this.cpf = cpf;
             return cpf;
         }

         @Override
         public String toString() {
             return "Login{" +
                     "cpf='" + cpf + '\'' +
                     '}';
         }
     }
}
