package app.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private PreparedStatement createSt;
    private PreparedStatement getByIdSt;
    private PreparedStatement setNameSt;
    private PreparedStatement deleteByIdSt;
    private PreparedStatement listAllSt;
    private PreparedStatement selectMaxIdSt;
    private PreparedStatement clearSt;
    private static int MIN_NAME_LENGTH = 2;
    private static int MAX_NAME_LENGTH = 30;


    public ClientService (Connection connection)  {
        try {
            createSt = connection.prepareStatement("INSERT INTO client (name) VALUES(?)");
            getByIdSt = connection.prepareStatement("SELECT name FROM client WHERE id = ?");
            setNameSt = connection.prepareStatement("UPDATE client SET name = ? WHERE id = ?");
            deleteByIdSt = connection.prepareStatement("DELETE FROM client WHERE id = ?");
            listAllSt = connection.prepareStatement("SELECT * FROM client");
            selectMaxIdSt = connection.prepareStatement("SELECT max(id) AS maxId FROM client");
            clearSt = connection.prepareStatement("DELETE FROM client");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public long create(String name) throws SQLException {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new SQLException("Invalid name length");
        }
        createSt.setString(1, name);
        createSt.executeUpdate();
        long id;
        try (ResultSet rs = selectMaxIdSt.executeQuery()) {
            rs.next();
             id = rs.getLong("maxId");
        }
        return id;

    }
    public String getById(long id) throws SQLException {
        getByIdSt.setLong(1, id);

        try (ResultSet rs = getByIdSt.executeQuery()) {
            if (!rs.next()) {
                return "Client not found";
            }
            return rs.getString("name");
        }
    }

    public void setName(long id, String name) throws SQLException {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new SQLException("Invalid name length");
        }
        setNameSt.setLong(2, id);
        setNameSt.setString(1, name);
        setNameSt.executeUpdate();

    }
    public void clear() throws SQLException {
        clearSt.executeUpdate();
    }
    public void deleteById(long id) throws SQLException {
        deleteByIdSt.setLong(1,id);
        int deleteClient;
        try {
            deleteClient = deleteByIdSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (deleteClient == 0) {
            throw new SQLException("Client not deleted");
        }


    }
    public List<Client> listAll() {
        List<Client> clients = new ArrayList<>();
        try (ResultSet rs = listAllSt.executeQuery()) {
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                Client client = new Client(id, name);
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;

    }
}
