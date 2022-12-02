package com.github.timurnabiyev.postgresql_course.dao.impl;

import com.github.timurnabiyev.postgresql_course.dao.EmployeesDao;
import com.github.timurnabiyev.postgresql_course.dao.impl.query.EmployeesQuery;
import com.github.timurnabiyev.postgresql_course.initdb.InitToDB;
import com.github.timurnabiyev.postgresql_course.models.Employees;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.time.LocalDate;

@NoArgsConstructor
public class EmployeesDaoImpl implements EmployeesDao {

    @Override
    public Employees findEmployeeById(Long id) {
        Employees employee = null;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(EmployeesQuery.FIND_EMPLOYEE_BY_ID)) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            employee = new Employees();

            while (rs.next()) {
                employee.setEmployeeId(rs.getLong("employee_id"));
                employee.setLastName(rs.getString("last_name"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setTitle(rs.getString("title"));
                employee.setTitleOfCourtesy("title_of_courtesy");
                employee.setBirthDate(rs.getDate("birth_date").toLocalDate());
                employee.setHireDate(rs.getDate("hire_date").toLocalDate());
                employee.setAddress(rs.getString("address"));
                employee.setCity(rs.getString("city"));
                employee.setRegion(rs.getString("region"));
                employee.setPostalCode(rs.getString("postal_code"));
                employee.setCountry(rs.getString("country"));
                employee.setHomePhone(rs.getString("home_phone"));
                employee.setExtension(rs.getString("extension"));
                employee.setPhoto(rs.getString("photo"));
                employee.setNotes(rs.getString("notes"));
                employee.setReportsTo(rs.getInt("reports_to"));
                employee.setPhotoPath(rs.getURL("photo_path"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return employee;
    }

    @Override
    public long insertEmployee(Employees employee) {
        long id = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(EmployeesQuery.INSERT_EMPLOYEE,
                     Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setLong(1, employee.getEmployeeId());
            pstmt.setString(2, employee.getLastName());
            pstmt.setString(3, employee.getFirstName());
            pstmt.setString(4, employee.getTitle());
            pstmt.setString(5, employee.getTitleOfCourtesy());
            pstmt.setDate(6, Date.valueOf(employee.getBirthDate()));
            pstmt.setDate(7, Date.valueOf(employee.getHireDate()));
            pstmt.setString(8, employee.getAddress());
            pstmt.setString(9, employee.getCity());
            pstmt.setString(10, employee.getRegion());
            pstmt.setString(11, employee.getPostalCode());
            pstmt.setString(12, employee.getCountry());
            pstmt.setString(13, employee.getHomePhone());
            pstmt.setString(14, employee.getExtension());
            pstmt.setByte(15, Byte.valueOf(employee.getPhoto()));
            pstmt.setString(16, employee.getNotes());
            pstmt.setInt(17, employee.getReportsTo());
            pstmt.setURL(18, employee.getPhotoPath());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    @Override
    public int getEmployeeCount() {
        int count = 0;

        try (Connection conn = InitToDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(EmployeesQuery.GET_EMPLOYEES_COUNT)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    @Override
    public void getEmployees() {
        try (Connection conn = InitToDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(EmployeesQuery.GET_EMPLOYEES)) {
            displayEmployees(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int updateEmployee(Long id, Employees employee) {
        int affectedRows = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(EmployeesQuery.UPDATE_EMPLOYEE_BY_ID)) {
            pstmt.setString(1, employee.getLastName());
            pstmt.setString(2, employee.getFirstName());
            pstmt.setString(3, employee.getTitle());
            pstmt.setString(4, employee.getTitleOfCourtesy());
            pstmt.setDate(5, Date.valueOf(employee.getBirthDate()));
            pstmt.setDate(6, Date.valueOf(employee.getHireDate()));
            pstmt.setString(7, employee.getAddress());
            pstmt.setString(8, employee.getCity());
            pstmt.setString(9, employee.getRegion());
            pstmt.setString(10, employee.getPostalCode());
            pstmt.setString(11, employee.getCountry());
            pstmt.setString(12, employee.getHomePhone());
            pstmt.setString(13, employee.getExtension());
            pstmt.setByte(14, Byte.valueOf(employee.getPhoto()));
            pstmt.setString(15, employee.getNotes());
            pstmt.setInt(16, employee.getReportsTo());
            pstmt.setURL(17, employee.getPhotoPath());
            pstmt.setLong(18, id);
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    @Override
    public int deleteEmployee(Long id) {
        int affectedRows = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(EmployeesQuery.DELETE_EMPLOYEE_BY_ID)) {
           pstmt.setLong(1, id);
           affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    private void displayEmployees(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.printf("%-3d%-11s%-10s%-26s%-6s%-12s%-12s%-32s%-9s%-8s%-9s%-5s%-16s%-6s%-10s%-450s%-3s%-40s%n",
                    rs.getLong("employee_id"), rs.getString("last_name"), rs.getString("first_name"),
                    rs.getString("title"), rs.getString("title_of_courtesy"), rs.getDate("birth_date"),
                    rs.getDate("hire_date"), rs.getString("address"), rs.getString("city"),
                    rs.getString("region"), rs.getString("postal_code"), rs.getString("country"),
                    rs.getString("home_phone"), rs.getString("extension"), rs.getString("photo"),
                    rs.getString("notes"), rs.getInt("reports_to"), rs.getString("photo_path"));
        }
        System.out.println();
    }
}
