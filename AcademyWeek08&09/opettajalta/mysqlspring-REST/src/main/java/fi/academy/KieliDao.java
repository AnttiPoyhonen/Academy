package fi.academy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class KieliDao {
    private static Logger log = LoggerFactory.getLogger("KieliDao");
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Language> haeKaikki() {
        log.info("jdbcTemplate: " + jdbcTemplate);
        List<Language> kaikki = jdbcTemplate.query(
                "SELECT cl.countrycode as code, c.name as name, cl.language as language, cl.isofficial as isofficial, cl.percentage as percentage from countrylanguage cl join country c on cl.countrycode=c.code order by language",
                (RowMapper<Language>) new KieliMapper()

        );
        log.warn("getAll() palauttaa: "+ kaikki.size());
        return kaikki;
    }


    public List<Language> haeKaikki(String maa) {
        List<Language> kaikki = jdbcTemplate.query(
                "SELECT cl.countrycode as code, c.name as name, cl.language as language, cl.isofficial as isofficial, cl.percentage as percentage from countrylanguage cl join country c on cl.countrycode=c.code where name like ? order by language",
                new Object[] {maa},
                new KieliMapper()
        );
        log.warn("getAll() palauttaa: "+ kaikki.size());
        return kaikki;
    }
}

class KieliMapper implements RowMapper<Language>/*, ResultSetExtractor<Course>*/ {
    @Override
    public Language mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Language(
                rs.getString("code"),
                rs.getString("name"),
                rs.getString("language"),
                "t".equalsIgnoreCase(rs.getString("isofficial")),
                rs.getDouble("percentage")
        );
    }
}