package com.DesignPattern;

class Graph {
    String[] nodes;
    String[] edges;
    Graph(String[] nodes, String[] edges ){
        this.nodes = nodes;
        this.edges = edges;
    }
}

abstract class UIComponent{

    abstract void paintComponent(Graph g);
    abstract void paintBorder(Graph g);
    abstract void paintChildren(Graph g);

    public void paint(Graph g){
        System.out.println("Painting a UI component ...");
        paintComponent(g);
        paintBorder(g);
        paintChildren(g);
        System.out.println("Done painting a UI component ...");
    }
}

class Button extends UIComponent{

    @Override
    void paintComponent(Graph g) {
        System.out.println("Button component");
    }

    @Override
    void paintBorder(Graph g) {
        System.out.println("Button border");
    }

    @Override
    void paintChildren(Graph g) {
        System.out.println("Button children");
    }

}

class Textbox extends UIComponent{

    @Override
    void paintComponent(Graph g) {
        System.out.println("Textbox component");
    }

    @Override
    void paintBorder(Graph g) {
        System.out.println("Textbox border");
    }

    @Override
    void paintChildren(Graph g) {
        System.out.println("Textbox children");
    }
}

public class TemplatePattern {

    public static void main(String[] args) {
        Graph g1 = new Graph(new String[]{"node1","node2"}, new String[]{"node1->node2"});
        Button btn = new Button();
        btn.paint(g1);

        Graph g2 = new Graph(new String[]{"node3","node4"}, new String[]{"node3->node4"});
        Textbox textbox = new Textbox();
        textbox.paint(g2);
    }
}
