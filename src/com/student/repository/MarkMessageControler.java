package com.student.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.student.bean.model.Mark;
import com.student.bean.model.Student;

public class MarkMessageControler {

	private Connection connection;
	private ResultSet resultSet;
	
	public MarkMessageControler() {
		connection = DatabaseFactory.open();
	}
	
	/**
	 * 根据学生的id和老师id和课程id查询学生成绩
	 * @param students
	 * @param suid
	 * @param tid
	 * @return
	 */
	public List<Mark> getStudentsScores(
			List<Student> students, String suid, String tid) {
		if(students != null && students.size() > 0) {
			try {
				Statement state = connection.createStatement();
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT no, score FROM mark WHERE " +
						"suid=" + suid + " AND tid=" + tid + " AND (");
				boolean judge = false;
				for(Student student : students) {
					if(judge) {
						sql.append(" OR no=" + student.getNo());
					}
					else {
						sql.append("no=" + student.getNo());
						judge = true;
					}
				}
				sql.append(");");
				resultSet = state.executeQuery(sql.toString());
				List<Mark> marks = null;
				if(resultSet.first()) {
					marks = new ArrayList<Mark>();
					do {
						Mark mark = new Mark();
						Student s = new Student();
						s.setNo(resultSet.getString("no"));
						mark.setStudent(s);
						mark.setScore(resultSet.getDouble("score"));
						marks.add(mark);
					} while(resultSet.next());
				}
				return marks;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 更新学生的成绩
	 * @param marks	key为学生的学号，value为学生的学号
	 * @param suid
	 * @param tid
	 * @return	成功返回true
	 */
	public boolean updateStudentsMark(
			Map<String, String> marks, String suid, String tid) {
		try {
			connection.setAutoCommit(false);
			Statement state = connection.createStatement();
			for(Map.Entry<String, String> entry : marks.entrySet()) {
				String sql = "UPDATE mark SET score=" + 
						entry.getValue() + " where suid=" + suid + 
						" and tid=" + tid + 
						" and no=" + entry.getKey() + ";";
				state.execute(sql);
			}
			connection.commit();
			connection.setAutoCommit(true);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
				connection.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean close() {
		return DatabaseFactory.close(connection);
	}
	
}
