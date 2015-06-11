package pojo;

import java.util.ArrayList;
import java.util.List;

public class Questions {
	private String name;
	private String level;
	private int count;
	private List<Answers> answers = new ArrayList<Answers>();
	
	public String getName() {
		return name;
	}
	public List<Answers> getAnswers() {
		return answers;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
