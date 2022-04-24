package com.epam.dhontar.aqamp.entity;

public class Author extends Person{
    private int idBook;
    private String firstName;
    private String lastName;

    private Author(Builder builder) {
        this.setId(builder.id);
        this.idBook = builder.idBook;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    private Author() {
    }

    public Builder getBuilder(){
        return new Builder(this.getId(), this.idBook, this.firstName, this.lastName);
    }

    public static class Builder{

        private int id;
        private int idBook;
        private String firstName;
        private String lastName;

        public Builder(int id, int idBook, String firstName, String lastName) {
            this.id = id;
            this.idBook = idBook;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder(int id) {
            this.id = id;
        }

        public Builder withIdBook(int idBook) {
            this.idBook = idBook;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Author build() {
            return new Author(this);
        }
    }

    public int getIdBook() {
        return idBook;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
