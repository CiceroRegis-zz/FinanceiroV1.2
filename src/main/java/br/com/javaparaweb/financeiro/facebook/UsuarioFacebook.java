package br.com.javaparaweb.financeiro.facebook;

public class UsuarioFacebook {

	private Long id;
	private String firstName;
	private Integer timezone;
	private String email;
	private Boolean verified;
	private String middleName;
	private String gender;
	private String lastName;
	private String link;
	private String locale;
	private String name;
	private String updatedTime;

	public UsuarioFacebook(org.primefaces.json.JSONObject resp){

		id = resp.getLong("id");
		firstName = resp.getString("first_name");
		timezone = resp.getInt("timezone");
		email = resp.getString("email");
		verified = resp.getBoolean("verified");
		middleName = resp.getString("middle_name");
		gender = resp.getString("gender");
		lastName = resp.getString("last_name");
		link = resp.getString("link");
		locale = resp.getString("locale");
		name = resp.getString("name");
		updatedTime = resp.getString("updated_time");

	}

	@Override
	public String toString() {
		return "UsuarioFacebook [id=" + id + ", firstName=" + firstName
				+ ", timezone=" + timezone + ", email=" + email + ", verified="
				+ verified + ", middleName=" + middleName + ", gender="
				+ gender + ", lastName=" + lastName + ", link=" + link
				+ ", locale=" + locale + ", name=" + name + ", updatedTime="
				+ updatedTime + "]";
	}

}