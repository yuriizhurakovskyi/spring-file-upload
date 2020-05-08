package ua.yurii.zhurakovskyi.springfileupload.dto;

public class StudentUploadResponse {
	private String firstName;
	private String lastName;
	private int age;
	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private long size;

	public StudentUploadResponse() {
	}

	public StudentUploadResponse(String firstName, String lastName, int age, String fileName, String fileDownloadUri,
			String fileType, long size) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
