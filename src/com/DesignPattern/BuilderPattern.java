package com.DesignPattern;

interface  icheese{
    public iToppings addCheese(String s);
}
interface  iveggie{
    public Subway.SubwayBuilder addVeggie(String s);
}
interface  iToppings{
    public Subway.SubwayBuilder addToppings(String s);
}
interface  iSauce{
    public Subway.SubwayBuilder addSauce(String s);
}

class Subway {
    private String bread;
    private String sauce;
    private String veggie;
    private String cheese;
    private String toppings;

    private Subway(String bread, String sauce, String veggie, String cheese, String toppings) {
        this.bread = bread;
        this.sauce = sauce;
        this.veggie = veggie;
        this.cheese = cheese;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Subway{" +
                "bread='" + bread + '\'' +
                ", sauce='" + sauce + '\'' +
                ", veggie='" + veggie + '\'' +
                ", cheese='" + cheese + '\'' +
                ", toppings='" + toppings + '\'' +
                '}';
    }

    public static class SubwayBuilder implements  icheese,iSauce,iveggie,iToppings{
        private String bread;
        private String sauce;
        private String veggie;
        private String cheese;
        private String toppings;
        public SubwayBuilder(String bread) {
            this.bread = bread;
        }
        public SubwayBuilder addSauce(String sauce){
            this.sauce = sauce;
            return this;
        }

        public SubwayBuilder addVeggie(String veggie){
            this.veggie = veggie;
            return this;
        }
        public iToppings addCheese(String cheese){
            this.cheese = cheese;
            return this;
        }
        public SubwayBuilder addToppings(String toppings){
            this.toppings = toppings;
            return this;
        }
        public Subway build(){
            return new Subway(bread, sauce, veggie, cheese, toppings);
        }
    }
}

class SubWayTest{
    public static void main(String[] args) {
        Subway subway = new Subway.SubwayBuilder("Oregano")
                .addCheese("cheddar").addToppings("olives").build();

        System.out.println(subway);
    }
}
