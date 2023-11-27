/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system;
import java.sql.*;
import java.util.Map;
import misclases.*;
import java.security.SecureRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class DataBase {
    Connection conexion;
     private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
     Empleado employee = null;
     Empleado me = null;
     Cliente client = null;
     Servicio service = null;
     Descuento discount = null;
     Mascota pet = null;
     
    public Connection getConnected(){
        String url = "jdbc:mysql://localhost:3306/veterinaria";
        String user = "root";
        String pass = "";
        
        try {
            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado con la db correctamente.");
            return conexion;
        } catch (SQLException err){
            System.out.println("Hubo un error al conectar con la db:\n" + err.toString());
            return null;
            
        }
    }
    
    public Empleado getLogin(String username){
        String consulta = "select * from empleado_user where user=?";
        try {
        PreparedStatement ps = conexion.prepareStatement(consulta);
        ps.setString(1, username);
        ResultSet res = ps.executeQuery();
        if (!res.next()) return null;
        int employeeId = res.getInt("empleadoId");
        
        String query = "select * from empleado where empleadoId=?";
        PreparedStatement ps_e = conexion.prepareStatement(query);
        ps_e.setInt(1, employeeId);
        ResultSet res_e = ps_e.executeQuery();
        while(res_e.next()){
             me = new Empleado(
                res_e.getString("email"),
                res_e.getString("telefono"),
                res_e.getString("direccion"), 
               res_e.getString("colonia"), 
                Integer.parseInt(res_e.getString("zp")), 
                  res_e.getString("nombre"), 
                  res_e.getString("apellidoP"), 
                 res_e.getString("apellidoM"), 
                 res.getString("user"), 
                 res.getString("password"), 
                  res_e.getInt("empleadoId"), 
                  res_e.getString("puesto"));
        }
        return me;
        
        } catch(SQLException err) {
            System.out.println(err);
            return null;
        }
    }
    
    public void insertClientData(Map<String, String> lista){
        String sql = "INSERT INTO cliente (nombre, apellidoP, apellidoM, direccion, colonia, zp, email, tel_casa, tel_cel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                   
           try {
            PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int index = 1;
            for (String key : lista.keySet()) {
                statement.setString(index, lista.get(key));
                index++;
            }

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
//                    System.out.println("El ID generado es: " + id);
                    client = new Cliente(
                   lista.get("Correo"), 
                   lista.get("Telefono Cel"), 
                   lista.get("Direccion"), 
                   lista.get("Colonia"), 
                   Integer.parseInt(lista.get("Codigo Postal")), 
                   lista.get("Nombre"), 
                   lista.get("Apellido Paterno"), 
                   lista.get("Apellido Materno"), 
                       id,
                   lista.get("Telefono Casa"));
//           
           JOptionPane.showMessageDialog(null, "¡Registro exitoso!\n\n" + client.showData());
                }
//                System.out.println("Los datos fueron insertados exitosamente!");
            }
           } catch(SQLException err){
               System.out.println("Hubo un error al insertar datos en la tabla cliente: \n" + err.toString());
           }
           
    }
    
    public void insertServiceData(Map<String, String> lista){
              String sql = "INSERT INTO servicio (tipo, precio) VALUES (?, ?)";
              float precio = Float.parseFloat(lista.get("Precio"));
              String Servicio = lista.get("Servicio");
           try {
            PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1,Servicio);
            statement.setFloat(2,precio);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    service = new Servicio();
                    service.setServiceId(id);
                    service.setPrecio(precio);
                    service.setTipo(Servicio);
     
           JOptionPane.showMessageDialog(null, "¡Registro exitoso!\n\n" + service.showData());
                }
            }
           } catch(SQLException err){
               System.out.println("Hubo un error al insertar datos en la tabla cliente: \n" + err.toString());
           }
    }
    
    public void insertEmployeeData(Map<String, String> lista){
        String sql = "INSERT INTO empleado (nombre, apellidoP, apellidoM, direccion, colonia, zp, email, puesto, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                   
           try {
            PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int index = 1;
            for (String key : lista.keySet()) {
                statement.setString(index, lista.get(key));
                index++;
            }

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
//                    System.out.println("El ID generado es: " + id);
                    insertUserData(lista, id);
                }
//                System.out.println("Los datos fueron insertados exitosamente!");
            }
           } catch(SQLException err){
               System.out.println("Hubo un error al insertar datos en la tabla empleado: \n" + err.toString());
           }
           
    }
    
    public void insertUserData(Map<String, String> lista, int employeeId){
        String sql = "INSERT INTO empleado_user (empleadoId, password, user) VALUES (?, ?, ?)";
        
        String username = generateUsername(lista.get("Nombre"), lista.get("Apellido Paterno"));
        String pass_generated = getRandomPassword();
           try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, employeeId);
            statement.setString(2, pass_generated);
            statement.setString(3, username);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
            employee = new Empleado(
                   lista.get("Correo"), 
                   lista.get("Telefono"), 
                   lista.get("Direccion"), 
                   lista.get("Colonia"), 
                   Integer.parseInt(lista.get("Codigo Postal")), 
                   lista.get("Nombre"), 
                   lista.get("Apellido Paterno"), 
                   lista.get("Apellido Materno"), 
                   username, 
                   pass_generated, 
                   employeeId,
                   lista.get("Puesto"));
//           
           JOptionPane.showMessageDialog(null, "¡Registro exitoso!\n\n" + employee.showData());
            }
           } catch(SQLException err){
               System.out.println("Hubo un error al insertar datos en la tabla empleado_user: \n" + err.toString());
           }
           
           
           
        
    }
    
    public void insertDiscountData(Map<String, String> lista){
          String sql = "INSERT INTO descuento (porcentaje, cantidad) VALUES (?, ?)";
       
          int por = Integer.parseInt(lista.get("Descuento").replace("%", ""));
          
          int cant = Integer.parseInt(lista.get("Cantidad"));
           try {
            PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, por);
            statement.setInt(2, cant);
          

            int rowsInserted = statement.executeUpdate();
              if (rowsInserted > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
           discount = new Descuento();
           discount.setCantidad(cant);
           discount.setPorcentaje(por);
           discount.setDiscountId(id);
     
           JOptionPane.showMessageDialog(null, "¡Registro exitoso!\n\n" + discount.showData());
                }
              }  
           } catch(SQLException err){
               System.out.println("Hubo un error al insertar datos en la tabla descuento: \n" + err.toString());
           }
           
    }
    
    public void insertPetData(Map<String, String> lista){
              String sql = "INSERT INTO mascota (nombre, especie, raza, edad, peso, sexo, estatus) VALUES (?, ?, ?, ?, ?, ?, ?)";
             
           try {
            PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1,lista.get("Nombre"));
            statement.setString(2,lista.get("Especie"));
            statement.setString(3,lista.get("Raza"));
            statement.setInt(4, Integer.parseInt(lista.get("Edad")));
            statement.setFloat(5,Float.parseFloat(lista.get("Peso")));
            statement.setString(6,lista.get("Sexo"));
            statement.setString(7,lista.get("Estatus"));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    pet = new Mascota();
                    pet.setPetId(id);
                    pet.setNombre(lista.get("Nombre"));
                    pet.setEspecie(lista.get("Especie"));
                    pet.setRaza(lista.get("Raza"));
                    pet.setEdad(Integer.parseInt(lista.get("Edad")));
                    pet.setPeso(Float.parseFloat(lista.get("Peso")));
                    pet.setSexo(lista.get("Sexo"));
                    pet.setEstatus("Ninguno");
                    
                    
                    insertPetAndOnwer(lista.get("Owner"), id);
         
                }
            }
           } catch(SQLException err){
               System.out.println("Hubo un error al insertar datos en insertPetData: \n" + err.toString());
           }
    }
    
    public void insertPetAndOnwer(String nombre,int petId){
        String[] partes = nombre.split(" ");
        String sql = "SELECT * FROM cliente WHERE nombre = ? AND apellidoP = ? AND apellidoM = ?";
        
        try{
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, partes[0]);  // Nombre
            pstmt.setString(2, partes[1]);  // Apellido paterno
            pstmt.setString(3, partes[2]);  // Apellido materno

            ResultSet rs = pstmt.executeQuery();
            int ownerId;

            while (rs.next()) {
                ownerId = rs.getInt("clienteId");
                pet.setOwner(new Cliente(
                 rs.getString("email"),
                rs.getString("tel_cel"),
              rs.getString("direccion"), 
                   rs.getString("colonia"), 
                   Integer.parseInt(rs.getString("zp")), 
                  rs.getString("nombre"), 
                  rs.getString("apellidoP"), 
                  rs.getString("apellidoM"), 
                      ownerId, 
              rs.getString("tel_casa")
                 ));
                // ... obtén los demás campos ...

                // Ahora tienes los datos del cliente y puedes usarlos como necesites
            }
            
        }catch (SQLException e){
             System.out.println("Hubo un error al consultar datos en inserPetAndOwner: \n" + e.toString());
        }
        
          String script = "INSERT INTO pet_and_owner (pet, owner) VALUES (?, ?)";
             
           try {
            PreparedStatement statement = conexion.prepareStatement(script);
            
            statement.setInt(1,petId);
            statement.setInt(2,pet.getOwner().getClienteId());
           

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "¡Registro exitoso!\n\n" + pet.showData());
            }
           } catch(SQLException err){
               System.out.println("Hubo un error al insertar datos en insertPetData: \n" + err.toString());
           }
        
         
    }
    
    public void editEmployeeData(Map<String, String> lista, int empleadoId){
           String sql = "update empleado set nombre=?, apellidoP=?, apellidoM=?, direccion=?, colonia=?, zp=?, email=?, puesto=?, telefono=? where empleadoId=?";
                   
           try {
            PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int index = 1;
            for (String key : lista.keySet()) {
                statement.setString(index, lista.get(key));
                index++;
            }
            
            statement.setInt(10, empleadoId);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                  JOptionPane.showMessageDialog(null, "¡Se actualizaron correctamente los datos!");
//                System.out.println("Los datos fueron insertados exitosamente!");
            }
           } catch(SQLException err){
               System.out.println("Hubo un error al insertar datos en la tabla empleado: \n" + err.toString());
           }
           
    }
    
    public void editClientData(Map<String, String> lista, int clienteId){
          String sql = "update cliente set nombre=?, apellidoP=?, apellidoM=?, direccion=?, colonia=?, zp=?, email=?, tel_casa=?, tel_cel=? where clienteId=?";
                   
           try {
            PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int index = 1;
            for (String key : lista.keySet()) {
                statement.setString(index, lista.get(key));
                index++;
            }
            
            statement.setInt(10, clienteId);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                  JOptionPane.showMessageDialog(null, "¡Se actualizaron correctamente los datos!");
//                System.out.println("Los datos fueron insertados exitosamente!");
            }
           } catch(SQLException err){
               System.out.println("Hubo un error al actualizar datos en la tabla cliente: \n" + err.toString());
           }
           
    }
    
    public void editServiceData(Map<String, String> lista, int servicioId){
        String sql = "update servicio set tipo=?, precio=? where servicioId=?";
        float precio = Float.parseFloat(lista.get("Precio"));
        String Servicio = lista.get("Servicio");           
           try {
            PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, Servicio);
            statement.setFloat(2, precio);
            statement.setInt(3, servicioId);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                  JOptionPane.showMessageDialog(null, "¡Se actualizaron correctamente los datos!");
//                System.out.println("Los datos fueron insertados exitosamente!");
            }
           } catch(SQLException err){
               System.out.println("Hubo un error al actualizar datos en la tabla cliente: \n" + err.toString());
           }
           
    }
    
    public void editDiscountData(Map<String, String> lista, int servicioId){
         String sql = "update servicio set tipo=?, precio=? where servicioId=?";
        float precio = Float.parseFloat(lista.get("Precio"));
        String Servicio = lista.get("Servicio");           
           try {
            PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, Servicio);
            statement.setFloat(2, precio);
           

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                  JOptionPane.showMessageDialog(null, "¡Se actualizaron correctamente los datos!");
//                System.out.println("Los datos fueron insertados exitosamente!");
            }
           } catch(SQLException err){
               System.out.println("Hubo un error al actualizar datos en la tabla cliente: \n" + err.toString());
           }
    }
    
    public void editPetData(Map<String, String> lista, int mascotaId){
         String sql = "update mascota set nombre=?, especie=?, raza=?, edad=?, peso=?, sexo=?, estatus=? where mascotaId=?";        
           try {
            PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,lista.get("Nombre"));
            statement.setString(2,lista.get("Especie"));
            statement.setString(3,lista.get("Raza"));
            statement.setInt(4, Integer.parseInt(lista.get("Edad")));
            statement.setFloat(5,Float.parseFloat(lista.get("Peso")));
            statement.setString(6,lista.get("Sexo"));
            statement.setString(7,lista.get("Estatus"));
            statement.setInt(8, mascotaId);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                editPetAndOwner(lista.get("Owner"), mascotaId);  
            }
           } catch(SQLException err){
               System.out.println("Hubo un error al actualizar datos en la tabla cliente: \n" + err.toString());
           }
    }
    
    public void editPetAndOwner(String nombre, int petId){
        String[] partes = nombre.split(" ");
        String sql = "SELECT * FROM cliente WHERE nombre = ? AND apellidoP = ? AND apellidoM = ?";
        int ownerId;
        try{
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, partes[0]);  // Nombre
            pstmt.setString(2, partes[1]);  // Apellido paterno
            pstmt.setString(3, partes[2]);  // Apellido materno

            ResultSet rs = pstmt.executeQuery();
            

            while (rs.next()) {
                ownerId = rs.getInt("clienteId");
             String script = "update pet_and_owner set owner=? where pet=?";
             
           try {
            PreparedStatement statement = conexion.prepareStatement(script);
            
            statement.setInt(1,ownerId);
            statement.setInt(2,petId);
           

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
               JOptionPane.showMessageDialog(null, "¡Se actualizaron correctamente los datos!");
            }
           } catch(SQLException err){
               System.out.println("Hubo un error al insertar datos en editPetAndOwner: \n" + err.toString());
           }
            }
            
        }catch (SQLException e){
             System.out.println("Hubo un error al consultar datos en editPetAndOwner: \n" + e.toString());
        }
        
         
        
         
    }
    
    
    public static String getRandomPassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        int length = random.nextInt(6) + 10;

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }

        return password.toString();
    }
       
    public static String generateUsername(String firstName, String lastName) {
        SecureRandom random = new SecureRandom();
        int number = random.nextInt(10000);

        String username = (firstName.toLowerCase() + "." + lastName.toLowerCase() + number).replaceAll("\\s", "");

        return username;
    }

}
