package br.com.lets.code.aula1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 5,max = 11, message = "Nome deve ter entre 5 e 11 caracteres")
    @NotNull(message = "Name não pode ser nulo")
    @NotEmpty(message = "Nome não pode estar vazio")
    private String name;

    @Min(18)
    @NotNull(message = "Idade não pode ser nulo")
    @NotEmpty(message = "Idade não pode estar vazio")
    private int age;

    @Pattern(regexp = "\\w\\w\\d{9}", message = "VAT Number inválido!")
    @NotNull(message = "VAT Number não pode ser nulo")
    @NotEmpty(message = "VAT Number não pode estar vazio")
    private String vatNumber;

    @Email(message="Email inválido")
    @NotNull(message = "Email não pode ser nulo")
    @NotEmpty(message = "Email não pode estar vazio")
    private String email;

    public Cliente(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
