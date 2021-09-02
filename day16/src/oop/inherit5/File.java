package oop.inherit5;

public class File {
	private String fileName;
	private long fileSize;// int는 약 21.48억까지 표현이 가능한데 파일크기로 치면 2GB

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileSize(long fileSize) {
		if (fileSize < 0) {
			return;
		}
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return this.fileName;
	}

	public long getFileSize() {
		return this.fileSize;
	}

	public void execute() {
		System.out.println("[" + this.fileName + "] 파일을 실행");
	}
}