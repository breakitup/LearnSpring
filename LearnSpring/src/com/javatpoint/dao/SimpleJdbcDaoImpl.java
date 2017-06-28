/**
 * 
 */
package com.javatpoint.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.javatpoint.model.Rectangle;

/**
 * @author asingha6
 *
 */
public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport {
	public List<Rectangle> getAllRectangle() {
		String sql = "select * from circle";
		return getSimpleJdbcTemplate().query(sql, new RectangleMapper());
	}

	private static final class RectangleMapper implements RowMapper<Rectangle> {

		@Override
		public Rectangle mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			Rectangle rec = new Rectangle();
			rec.setId(resultSet.getInt("ID"));
			rec.setName(resultSet.getString("Name"));
			return rec;
		}
	}
}
