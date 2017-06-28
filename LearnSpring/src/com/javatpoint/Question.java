/**
 * 
 */
package com.javatpoint;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author asingha6
 *
 */
public class Question {
	private int id;
	private String name;
	private List<Answer> answer;
	private Map<String, String> comments;

	Question() {

	}

	Question(int id, String name, List<Answer> answer) {
		this.id = id;
		this.name = name;
		this.answer = answer;
	}

	Question(int id, String name, Map<String, String> comments) {
		this.id = id;
		this.name = name;
		this.comments = comments;
	}

	public void displayInfo() {
		System.out.println(id + " " + name);
		if (answer != null) {
			System.out.println("answers are:");
			Iterator<Answer> it = answer.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		}
		if (comments != null) {
			System.out.println("comments are:");
			Set<Entry<String, String>> s = comments.entrySet();
			Iterator<Entry<String, String>> it = s.iterator();
			while (it.hasNext()) {
				Entry<String, String> comment = it.next();
				System.out.println(comment.getKey() + " " + comment.getValue());
			}
		}
	}
}
