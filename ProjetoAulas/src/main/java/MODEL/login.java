package MODEL;

public class login {
private String email;
private String senha;
private String cadastroEmail;
private String cadastroSenha;

public String getCadastroEmail() {
	return cadastroEmail;
}
public void setCadastroEmail(String cadastroEmail) {
	this.cadastroEmail = cadastroEmail;
}
public String getCadastroSenha() {
	return cadastroSenha;
}
public void setCadastroSenha(String cadastroSenha) {
	this.cadastroSenha = cadastroSenha;
}
public login() {
	super();
	
}
public login(String email, String senha, String cadastroEmail, String cadastroSenha) {
	super();
	this.email = email;
	this.senha = senha;
	this.cadastroEmail = cadastroEmail;
	this.cadastroSenha = cadastroSenha;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}

}
