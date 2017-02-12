package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mapper.UserMapper;
import com.pojo.User;

public class UnitTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("com/config/SqlMapConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	// @Test
	public void findUserByIdTest() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(8);
		System.out.println(user);
		sqlSession.close();
	}

	 @Test
	public void findUserListTest() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userlist = userMapper.findUserList(new User());
//		for (User m : userlist) {
//			System.out.println(m);
//		}
	}

//	 @Test
	public void findUserInList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Object[] ids = { 6, 7 };
		List<User> userlist = userMapper.findUserInList(ids);
		for(User user:userlist){
			System.out.println(user);
		}
	}

//	 @Test
	public void updateUserTest() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(7);
		user.setUsername("ID6的名字_修改");
		userMapper.updateUser(user);
		sqlSession.commit();
	}

//	@Test
	public void insertTest() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername(new Random().toString());
		user.setBirthday(new Date());
		user.setAddress("9 3/4车站");
		userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
	}
//	@Test
	public void getRandom(){
		System.out.println(new Random().nextInt());
	}
}
