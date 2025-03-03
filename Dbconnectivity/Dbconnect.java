    package Dbconnectivity;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.util.*;

    public  class Dbconnect {
            private static Dbconnect instance;
            private  Connection con;
            private Dbconnect()  throws SQLException {
                    String url = "jdbc:mysql://localhost:3306/doctorappointment";
                    String user = "root";
                    String password = "";
                    con = DriverManager.getConnection(url, user, password);
            }
            public static Dbconnect getInstance () throws SQLException
            {
                if(instance==null) {
                    instance=new Dbconnect();
                }
                return instance;
            }
        public  Connection getConnection() {

            return con;
        }
    }
