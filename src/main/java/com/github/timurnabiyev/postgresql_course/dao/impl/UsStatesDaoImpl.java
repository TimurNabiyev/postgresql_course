package com.github.timurnabiyev.postgresql_course.dao.impl;

import com.github.timurnabiyev.postgresql_course.dao.UsStatesDao;
import com.github.timurnabiyev.postgresql_course.dao.impl.query.UsStatesQuery;
import com.github.timurnabiyev.postgresql_course.initdb.InitToDB;
import com.github.timurnabiyev.postgresql_course.models.UsStates;
import lombok.NoArgsConstructor;

import java.sql.*;
@NoArgsConstructor
public class UsStatesDaoImpl implements UsStatesDao {
    @Override
    public UsStates findUsStatesByID(Long usStatesId) {
        UsStates usStates = null;
        try (Connection connection = InitToDB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(UsStatesQuery.FIND_US_STATE_BY_ID)) {

            preparedStatement.setLong(1, usStatesId);
            ResultSet resultSet = preparedStatement.executeQuery();

            usStates = new UsStates();
            while (resultSet.next()) {
                usStates.setStateId(resultSet.getInt("state_id"));
                usStates.setStateName(resultSet.getString("state_name"));
                usStates.setStateAbbr(resultSet.getString("state_abbr"));
                usStates.setStateRegion(resultSet.getString("state_region"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return usStates;
    }

    @Override
    public Long insertUsStates(UsStates usStates) {
        long id = 0;

        try (Connection connection = InitToDB.connect();
             PreparedStatement pstmt = connection.prepareStatement(UsStatesQuery.INSERT_US_STATE,
                     Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setLong(1, usStates.getStateId());
            pstmt.setString(2, usStates.getStateName());
            pstmt.setString(3, usStates.getStateAbbr());
            pstmt.setString(4, usStates.getStateRegion());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    @Override
    public int getUsStatesCount() {
        int count = 0;

        try (Connection conn = InitToDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(UsStatesQuery.GET_US_STATES_COUNT)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    @Override
    public void getUsStates() {
        try (Connection conn = InitToDB.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(UsStatesQuery.GET_US_STATES)) {
            displayUsState(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int updateUsState( Long id, UsStates usState) {
        int affectedRows = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(UsStatesQuery.UPDATE_US_STATE_BY_ID)) {

            pstmt.setString(1, usState.getStateName());
            pstmt.setString(2, usState.getStateAbbr());
            pstmt.setString(3, usState.getStateRegion());
            pstmt.setLong(4, id);

            affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    @Override
    public int deleteUsState(Long id) {
        int affectedRows = 0;

        try (Connection conn = InitToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(UsStatesQuery.DELETE_US_STATES_BY_ID)) {

            pstmt.setLong(1, id);

            affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;
    }

    private void displayUsState(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.printf("%-3s%-21s%-3s%-8s%n", rs.getString("state_id"), rs.getString("state_name"),
                    rs.getString("state_abbr"), rs.getString("state_region"));
        }
        System.out.println();
    }
}
