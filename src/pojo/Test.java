package pojo;

import java.util.ArrayList;
import java.util.List;

public class Test {
	private String name;
	private String link;
	private String numberOfQuestions;
	private List<Questions> question = new ArrayList<Questions>();
	
	public String getName() {
		return name;
	}
	public List<Questions> getQuestion() {
		return question;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setQuestion(List<Questions> question) {
		this.question = question;
	}
	public String getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
