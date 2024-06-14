package org.example.java.designpattern;

import java.util.Arrays;
import java.util.List;

public class BuilderPattern {

    private int id;

    private String name;

    private List<String> property;

    @Override
    public String toString() {
        return "BuilderPattern{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", property=" + property +
                '}';
    }

    private BuilderPattern(BuilderPatternBuilder builderPatternBuilder){
        this.id = builderPatternBuilder.id;
        this.name = builderPatternBuilder.name;
        this.property = builderPatternBuilder.property;
    }


    public static class BuilderPatternBuilder {

        private int id;

        private String name;

        private List<String> property;

        public BuilderPatternBuilder(int id){
            this.id = id;
        }

        public BuilderPatternBuilder name(String name){
            this.name =name;
            return this;
        }

        public BuilderPatternBuilder property(List<String> property){
            this.property = property;
            return this;
        }

        public BuilderPattern build(){
            return new BuilderPattern(this);
        }
    }

    public static void main(String[] args) {
        BuilderPattern b1 = new BuilderPatternBuilder(1)
                .name("Rocky")
                .property(Arrays.asList("p1","p2"))
                .build();
        System.out.println(b1);
    }
}
