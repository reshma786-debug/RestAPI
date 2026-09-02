package projectPojoClass;

public class TestClassPojo {

	private String name;
	private String gender;
	private String email;
	private String status;
	
	public TestClassPojo(String name, String gender, String email, String status) {
		this.name= name;
		this.gender = gender;
		this.email = email;
		this.status = status;
	}
	
	// Getters
		public String getGender() {
			return gender;
		}

		public String getName() {
			return name;
		}
		
		public String getEmail() {
			return email;
		}

		public String getStatus() {
			return status;
		}

		// Setters
		public void setGender(String gender) {
			this.gender = gender;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		public void setActive(String status) {
			this.status = status;
		}

}
