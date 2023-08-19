package com.todo.model;

public class Anime {
	private int id;
	private String animeName;
	private boolean watched;
	private boolean watchLater;
	private boolean completed;

	public Anime(int id, String animeName, boolean watched, boolean watchLater, boolean completed) {
		this.id = id;
		this.animeName = animeName;
		this.watched = watched;
		this.watchLater = watchLater;
		this.completed = completed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnimeName() {
		return animeName;
	}

	public void setAnimeName(String animeName) {
		this.animeName = animeName;
	}

	public boolean isWatched() {
		return watched;
	}

	public void setWatched(boolean watched) {
		this.watched = watched;
	}

	public boolean isWatchLater() {
		return watchLater;
	}

	public void setWatchLater(boolean watchLater) {
		this.watchLater = watchLater;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
