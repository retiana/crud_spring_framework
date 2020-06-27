package commabank.test.crud.model;

import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "employee")
public class ModelEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;

	public ModelEmployee() {
	}

	public ModelEmployee(int id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

}
