package com.poyan.volly.stat.vollystat;

import com.poyan.volly.stat.vollystat.model.Game;
import com.poyan.volly.stat.vollystat.model.GameResult;
import com.poyan.volly.stat.vollystat.model.Player;
import com.poyan.volly.stat.vollystat.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MainRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MainRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Player> getAllPlayers() {
        String sql = "SELECT * FROM players";
        return jdbcTemplate.query(sql, new PlayerMapper());
    }

    @Transactional
    public void submitResult(GameResult gameResult) {
        long gameId = createGame(gameResult.getGame());
        gameResult.getTeam1().setId(createTeam(gameResult.getTeam1()));
        gameResult.getTeam2().setId(createTeam(gameResult.getTeam2()));
        updatePlyaerTeamGame(gameId, gameResult.getTeam1());
        updatePlyaerTeamGame(gameId, gameResult.getTeam2());
        submitGameResult(gameId, gameResult);
    }

    private void submitGameResult(long gameId, GameResult gameResult) {
        Map insertElements = new HashMap<>();
        insertElements.put("game_id", gameId);
        insertElements.put("team1_id", gameResult.getTeam1().getId());
        insertElements.put("team2_id", gameResult.getTeam2().getId());
        insertElements.put("team1_set_win", gameResult.getTeam1SetWin());
        insertElements.put("team2_set_win", gameResult.getTeam2SetWin());
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("game_result");
        insert.execute(insertElements);
    }

    private void updatePlyaerTeamGame(long gameId, Team team) {
        String sql = "INSERT INTO player_team_game (player_id, team_id, game_id) VALUES (?, ?, ?)";
        final List<Player> players = team.getPlayers();
        try {
            jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setInt(1, players.get(i).getId());
                    ps.setLong(2, team.getId());
                    ps.setLong(3, gameId);
                }
                @Override
                public int getBatchSize() {
                    return players.size();
                }
            });
        } catch (Exception e) {
            System.out.println("Problem creating team: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private int createGame(Game game) {
        Map<String, Date> insertElements = new HashMap<>();
        insertElements.put("date", game.getDate());
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("game").usingGeneratedKeyColumns("id");
        return insert.executeAndReturnKey(insertElements).intValue();
    }

    private int createTeam(Team team) {
        Map<String, String> insertElements = new HashMap<>();
        insertElements.put("team_name", team.getName());
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("team").usingGeneratedKeyColumns("id");
        return insert.executeAndReturnKey(insertElements).intValue();
    }

    private static class PlayerMapper implements RowMapper<Player> {
        @Override
        public Player mapRow(ResultSet resultSet, int i) throws SQLException {
            Player player = new Player();
            player.setId(resultSet.getInt("id"));
            player.setName(resultSet.getString("player_name"));
            return player;
        }
    }
}
