package dao;

import java.util.List;

import classes.User;

import pojo.Results;
import pojo.Test;
import pojo.TestList;

public interface AbstractFacadeDAO {
	Test getTest(String url);
	List<TestList> getTestList(String uri);
	List<Results> getUserResults(String login, String uri);
	List<User> getUserList(String uri);
	User getUser(String login, String uri);
}
