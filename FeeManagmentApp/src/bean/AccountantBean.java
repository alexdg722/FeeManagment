package bean;

public class AccountantBean {

	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String address;
	private String contact;
	
	public AccountantBean() {
		
	}
	
	public AccountantBean(int id, String firstname, String lastname, String email,
			   String password, String contact,String address) 
		{
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
			this.password = password;
			this.contact = contact;
			this.address = address;
		}
	
	public AccountantBean(String firstname, String lastname, String email, String password,String address, String contact) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}
	
}
