package com.DesignPattern;

import java.util.ArrayList;
import java.util.List;

interface DocumentComponent {
    void print();
}

class Paragraph implements DocumentComponent {

    int id;
    int indent = 6;

    Paragraph(int id) {
        this.id = id;
    }

    @Override
    public void print() {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println("Paragraph<" + id + ">");
    }
}

abstract class Composite implements DocumentComponent {
    List<DocumentComponent> componentList = new ArrayList<>();
    int indent = 0;
//    DocumentComponent parent;
    public void addComponent(DocumentComponent c) {
        componentList.add(c);
    }
}

class Book extends Composite {

    String name;
    Book(String n){
        name = n;
    }
    @Override
    public void print() {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println("Book<" + name + "> {");
        for (DocumentComponent c: componentList
        ) {
            c.print();
        }
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println("}");
    }
}

class Chapter extends Composite {

    String name;
    Chapter(String n){
        name = n;
        indent = 2;
    }
    @Override
    public void print() {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println("Chapter<" + name + "> {");
        for (DocumentComponent c: componentList
        ) {
            c.print();
        }
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println("}");
    }
}

class Section extends Composite {

    String name;
    Section(String n){
        name = n;
        indent = 4;
    }
    @Override
    public void print() {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println("Section<" + name + "> {");
        for (DocumentComponent c: componentList
        ) {
            c.print();
        }
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println("}");
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        Book se = new Book("Software Engineering");
        Chapter c1 = new Chapter("c1");
        Chapter c2 = new Chapter("c2");
        se.addComponent(c1);
        se.addComponent(c2);
        Section s11 = new Section("s1.1");
        Section s12 = new Section("s1.2");
        Section s21 = new Section("s2.1");
        Section s22 = new Section("s2.2");
        c1.addComponent(s11);c1.addComponent(s12);
        c2.addComponent(s21);c2.addComponent(s22);
        Paragraph p1 = new Paragraph(1);
        Paragraph p2 = new Paragraph(2);
        Paragraph p3 = new Paragraph(3);
        Paragraph p4 = new Paragraph(4);
        Paragraph p5 = new Paragraph(5);
        Paragraph p6 = new Paragraph(6);
        Paragraph p7 = new Paragraph(7);

        s11.addComponent(p1);
        s12.addComponent(p2);
        s12.addComponent(p3);
        s21.addComponent(p4);
        s21.addComponent(p5);
        s21.addComponent(p6);
        s22.addComponent(p7);

        se.print();
    }

}
