package org.example;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static String MySqlDriver = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/school";
    public static String USER_NAME  = "root";
    public static String PASSWORD = "1qaz!QAZ";

    public static void main( String[] args ) throws SQLException, ClassNotFoundException {

       Connection connection = getConnection();
//        createTable(connection);
        List<ClassRoom> allClassRooms = getAllClassRoom(connection);
        System.out.println(allClassRooms);
    connection.close();

    }
    public static void createClassRoomIndb( Long student_number, Long roomNumber, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("inser into class_room( student_number, room_number) values (?,?)");
        preparedStatement.setInt(1,student_number.intValue());
        preparedStatement.setInt(2,roomNumber.intValue());


    }
    public static void updateClassRoomById (Connection connection, Long id,Long newClassRoom, Long newStudentNumber) throws SQLException{}


    public static ClassRoom getClassRommByIdWithPrepared (Connection connection, Long classRoom) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("select * from class_room where id = ?");
        preparedStatement.setInt(1,classRoom.intValue());
        ResultSet resultSet = preparedStatement.executeQuery();
        ClassRoom classRooms = new ClassRoom();
        while (resultSet.next()){
            Long id = resultSet.getLong("id");
            Long studentNumber  = resultSet.getLong("student_number");
            Long roomNumber = resultSet.getLong("room_number");
            classRooms =  new ClassRoom(id, studentNumber, roomNumber);

        }
        return classRooms;
    }

    public static List<ClassRoom> getAllClassRoom(Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from class_room");
        List<ClassRoom> classRooms = new ArrayList<>();
        while (resultSet.next()){
            Long id = resultSet.getLong("id");
            Long studentNumber  = resultSet.getLong("student_number");
            Long roomNumber = resultSet.getLong("room_number");
            classRooms.add(new ClassRoom(id, studentNumber, roomNumber)) ;

    }
        statement.close();
        return classRooms;
//    public static void createTable(Connection connection) throws SQLException{
//       Statement statement = connection.createStatement();
//       statement.execute("create table class_room(id int primary key auto_increment,student_number int not null,room_number int not null)");
//       statement.close();
   }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(MySqlDriver);
        return DriverManager.getConnection(URL,USER_NAME,PASSWORD);
    }
}
