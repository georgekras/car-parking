package by.htp.carparking.domain;

import java.io.Serializable;

public class Entity implements Serializable {

	private static final long serialVersionUID = 5402816097942908602L;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Entity() {
		super();
	}

	public Entity(int id) {
		super();
		this.id = id;
	}

}
