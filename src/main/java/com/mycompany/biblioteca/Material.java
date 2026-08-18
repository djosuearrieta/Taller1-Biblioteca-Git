package com.mycompany.biblioteca;

public class Material {
    protected String code;
    protected String title;
    protected String publicationYear;

    public Material(String code, String title, String publicationYear) {
        this.code = code;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPublicationYear() { return publicationYear; }
    public void setPublicationYear(String publicationYear) { this.publicationYear = publicationYear; }

    @Override
    public String toString() {
        return "code=" + code + ", title=" + title + ", year=" + publicationYear;
    }
}