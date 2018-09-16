package com.poyan.volly.stat.vollystat;

import com.poyan.volly.stat.vollystat.model.Game;
import com.poyan.volly.stat.vollystat.model.GameResult;
import com.poyan.volly.stat.vollystat.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

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

    public void sumbitResult(GameResult gameResult) {
        long gameId = createGame(gameResult.getGame());
    }

    private long createGame(Game game) {
        Map<String, Date> insertElements = new HashMap<>();
        insertElements.put("date", game.getDate());
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("game").usingGeneratedKeyColumns("id");
        return insert.executeAndReturnKey(insertElements).longValue();
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
