package com.github.timurnabiyev.postgresql_course.dao.impl;

import com.github.timurnabiyev.postgresql_course.dao.EmployeeTerritoriesDao;
import com.github.timurnabiyev.postgresql_course.dao.impl.query.EmployeeTerritoriesQuery;
import com.github.timurnabiyev.postgresql_course.initdb.InitToDB;
import com.github.timurnabiyev.postgresql_course.models.EmployeeTerritories;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.*;

@NoArgsConstructor
public class EmployeeTerritoriesDaoImpl implements EmployeeTerritoriesDao {

    @Override
    public EmployeeTerritories findEmployeeTerritoryByID(Long id) {
        EmployeeTerritories employeeTerritories = null;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(EmployeeTerritoriesQuery.FIND_EMPLOYEE_TERRITORIES_BY_ID)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            employeeTerritories = new EmployeeTerritories();

            while (rs.next()) {
                employeeTerritories.setEmployeeId(rs.getLong("employee_id"));
                employeeTerritories.setTerritoryId(rs.getString("territory_id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return employeeTerritories;
    }

    @Override
    public long insertEmployeeTerritories(EmployeeTerritories employeeTerritory) {
        long id = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(EmployeeTerritoriesQuery.INSERT_EMPLOYEE_TERRITORY,
                     Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setLong(1, employeeTerritory.getEmployeeId());
            pstmt.setString(2, employeeTerritory.getTerritoryId());

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
    public int getEmployeeTerritoriesCount() {
        int count = 0;

        try (Connection conn = InitToDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(EmployeeTerritoriesQuery.GET_EMPLOYEE_TERRITORIES_COUNT)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public void getEmployeeTerritories() {
        try (Connection conn = InitToDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(EmployeeTerritoriesQuery.GET_EMPLOYEE_TERRITORIES)) {
            displayEmployeeTerritories(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int updateEmployeeTerritories(Long id, EmployeeTerritories employeeTerritory) {
        int affectedRows = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(EmployeeTerritoriesQuery.UPDATE_EMPLOYEE_TERRITORIES_BY_ID)) {
            pstmt.setString(1, employeeTerritory.getTerritoryId());
            pstmt.setLong(2, id);
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    @Override
    public int deleteEmployeeTerritory(Long id) {
        int affectedRows = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(EmployeeTerritoriesQuery.DELETE_EMPLOYEE_TERRITORY_BY_ID)) {
            pstmt.setLong(1, id);
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    private void displayEmployeeTerritories(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.printf("%-3s%-7s%n", rs.getLong("employee_id"), rs.getString("territory_id"));
        }
    }
}
