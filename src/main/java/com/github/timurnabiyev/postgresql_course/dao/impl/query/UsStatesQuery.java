package com.github.timurnabiyev.postgresql_course.dao.impl.query;

public final class UsStatesQuery {
    private UsStatesQuery() {
    }

    public static final String FIND_US_STATE_BY_ID = "" +
            "SELECT * FROM timur.us_states " +
            "WHERE state_id = ?";

    public static final String INSERT_US_STATE = "" +
            "INSERT INTO timur.us_states(state_id, state_name, state_abbr, state_region) " +
            "VALUES(?,?,?,?)";

    public static final String GET_US_STATES_COUNT = "" +
            "SELECT count(*) FROM timur.us_states";

    public static final String GET_US_STATES = "" +
            "SELECT * FROM timur.us_states";

    public static final String UPDATE_US_STATE_BY_ID = "" +
            "UPDATE timur.us_states SET state_name = ?, state_abbr = ?, state_region = ?" +
            "WHERE state_id = ?";

    public static final String DELETE_US_STATES_BY_ID = "" +
            "DELETE FROM timur.us_states WHERE state_id = ?";
}