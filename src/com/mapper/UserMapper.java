package com.mapper;

import java.util.List;
import java.util.Map;
import com.pojo.User;

public interface UserMapper {
	public User findUserById(int id) throws Exception;

	public List<User> findUserList(User user) throws Exception;

	public int findUserCount(User user) throws Exception;

	public List<User> findUserInList(Object[] ids) throws Exception;

	public void updateUser(User user) throws Exception;

	public void insertUser(User user) throws Exception;
}
