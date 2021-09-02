package oop.inherit5;

public class Mp3 extends MediaFile {
	private int duration;

	public void setDuration(int duration) {
		if (duration < 0) {
			return;
		}
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}

}
