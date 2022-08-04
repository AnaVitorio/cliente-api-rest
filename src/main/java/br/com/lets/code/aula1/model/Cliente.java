package br.com.lets.code.aula1.model;

public class Cliente {
    private String name;
    private int age;
    private String number;
    private String email;

    public Cliente(String name, int age, String number, String email) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.email = email;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
