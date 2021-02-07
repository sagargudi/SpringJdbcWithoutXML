package com.sagar.Sjdbc.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sagar.Sjdbc.Dao.StudentDao;
import com.sagar.Sjdbc.Entity.Student;
@Component("studentDao")
public class StudentDaoImpel implements StudentDao {
@Autowired
	private JdbcTemplate template;

	// inserting the data
	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.template.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {

		this.template = template;
	}

// updating the data where id is ?
	public int change(Student student) {
		String query = "update student set name=?, city=? where id=?";
		int u = this.template.update(query, student.getName(), student.getCity(), student.getId());

		return u;
	}

	// deleting the data where id is hence taking only id

	public int remove(Student student) {
		String query = "delete from student where id=?";
		int d = this.template.update(query, student.getId());

		return d;
	}

	public Student getStudent(int studentId) {
		String query = "select *from student where id=?";
		
		//instead of creating a new class which implements RowMapper, will go for anonymous class.
		
		
		Student student = this.template.queryForObject(query, new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setCity(rs.getString(3));
				return s;
			}

		}, studentId);
		return student;
	}

	public List<Student> getAllStudent() {
		String query="select *from Student";
		//instead of creating a new class which implements RowMapper, will go for anonymous class.
		List<Student> student =this.template.query(query, new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setCity(rs.getString(3));
				return s;
			}
			
			
		});
	
		return student;
	}

}
