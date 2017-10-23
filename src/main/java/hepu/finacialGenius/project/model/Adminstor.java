package hepu.finacialGenius.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adminstor")
public class Adminstor {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String adminstorName;
private String adminstorPassword;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getAdminstorName() {
	return adminstorName;
}
public void setAdminstorName(String adminstorName) {
	this.adminstorName = adminstorName;
}
public String getAdminstorPassword() {
	return adminstorPassword;
}
public void setAdminstorPassword(String adminstorPassword) {
	this.adminstorPassword = adminstorPassword;
}

}
