package hr.tvz.raic.hardwareapp.repository;

import hr.tvz.raic.hardwareapp.enums.HardwareTypeConst;
import hr.tvz.raic.hardwareapp.model.Hardware;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.*;

@Primary
@Repository
public class JdbcRepository implements HardwareRepositoryInterface {
    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert insert;

    public JdbcRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.insert = new SimpleJdbcInsert(jdbc)
                .withTableName("hardware")
                .usingGeneratedKeyColumns("id");
    }

    private Hardware hardwareMapper(Map<String, Object> map) {
        return new Hardware(
                (Long) map.get("ID"),
                map.get("NAME").toString(),
                map.get("CODE").toString(),
                (Double) map.get("PRICE"),
                HardwareTypeConst.getTypeFromString(map.get("TYPE").toString()),
                (Integer) map.get("AMOUNT")
        );
    }

    @Override
    public List<Hardware> findAll() {
        List<Hardware> list = new ArrayList<>();

        List<Map<String, Object>> map = jdbc.queryForList("SELECT * FROM hardware");

        for (int i = 0; i < map.size(); i++) {
            list.add(hardwareMapper(map.get(i)));
        }
        return list;
    }

    @Override
    public Optional<List<Hardware>> findByCode(String code) {
        try {
            List<Hardware> list = new ArrayList<>();

            List<Map<String, Object>> map = jdbc.queryForList("SELECT * FROM hardware WHERE code ILIKE '" + code + "%'");

            for (int i = 0; i < map.size(); i++) {
                list.add(hardwareMapper(map.get(i)));
            }
            return Optional.ofNullable(list);
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    @Override
    public void create(Hardware object) {
        Map<String, Object> values = new HashMap<>();

        values.put("code", object.getCode());
        values.put("name", object.getName());
        values.put("price", object.getPrice());
        values.put("type", object.getType());
        values.put("amount", object.getAmountAvailable());

        insert.execute(values);
    }

    @Override
    public void update(String code, Double price) {

    }

    @Override
    public void delete(String code) {
        jdbc.update("DELETE FROM hardware WHERE code = ?", code);
    }
}