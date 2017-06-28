/**
 * 
 */
package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.javatpoint.model.Rectangle;

/**
 * @author asingha6
 *
 */
@Component
public class JdbcDaoImpl {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public Rectangle getRectangle(int recId){
		
		Connection conn=null;
		String driver="org.apache.derby.jdbc.ClientDriver";
		try{
		//Class.forName(driver).newInstance();
		//conn=DriverManager.getConnection("jdbc:derby://localhost:1527/db");
			conn=dataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("Select * from circle where id=?");
		ps.setInt(1, recId);
		Rectangle rec=null;
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			rec=new Rectangle(recId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return rec;
		}
		catch(Exception e){
			throw new RuntimeException();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getRectangleCount(){
		String sql="Select count(*) from circle";
		return jdbcTemplate.queryForInt(sql);
	}
	
	public String getRectangleName(int circleId){
		String sql="Select name from circle where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);
	}
	
	public Rectangle getRectangleForId(int circleId){
		String sql="select * from circle where id=?";
		return jdbcTemplate.queryForObject(sql,new Object[] {circleId}, new RectangleMapper());
	}
	
	public List<Rectangle> getAllRectangle(){
		String sql="select * from circle";
		return jdbcTemplate.query(sql,new RectangleMapper());
	}
 	
	public void insertRectangle(Rectangle rec){
		String sql="Insert into circle(id,name) values (?,?)";
		jdbcTemplate.update(sql, new Object[] {rec.getId(),rec.getName()});
	}
	
	public void insertRectangleUsingNamedSpaceJdbcTemplate(Rectangle rec){
		String sql="Insert into Circle(ID,name) Values (:id,:name)";
		namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource("id",rec.getId()).addValue("name",rec.getName()));
	}
	
	
	public void createRectangleTable(){
		String sql="create table Rectangle(Id Integer,Name varchar(50))";
		jdbcTemplate.execute(sql);
	}
	
	private static final class  RectangleMapper implements RowMapper<Rectangle>{

		@Override
		public Rectangle mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			Rectangle rec=new Rectangle();
			rec.setId(resultSet.getInt("ID"));
			rec.setName(resultSet.getString("Name"));
			return rec;
		}
		
	}
	
	public DataSource getDatasource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


}
