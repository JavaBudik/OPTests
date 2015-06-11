package dao;

import java.util.ArrayList;
import java.util.List;

import classes.User;

import other.SaxResults;
import other.SaxTest;
import other.SaxTestList;
import other.SaxUsers;

import pojo.Results;
import pojo.Test;
import pojo.TestList;

public class Facade implements AbstractFacadeDAO {

//	/** Constant for logging hibernate. */
//	private static final Log LOG = LogFactory.getLog(Facade.class);

	public Test getTest(String url) {
		SaxTest s = new SaxTest();
		return s.getTest(url);
	}

	public List<TestList> getTestList(String uri) {
		SaxTestList s = new SaxTestList();
		return s.getList(uri);
	}

	public List<Results> getUserResults(String login, String uri) {
		SaxResults s = new SaxResults();
		List<Results> res = new ArrayList<Results>();
		for (Results ss : s.getRes(uri)) {
			if (ss.getLogin().equals(login)) {
				res.add(ss);
			}
		}
		return res;
	}

	public List<User> getUserList(String uri) {
		SaxUsers s = new SaxUsers();
		return s.getUsers(uri);
	}

	public User getUser(String login, String uri) {
		for (User use: getUserList(uri)){
			if (use.getLogin().equals(login)){
				return use;
			}
		}
		return null;
	}

}
