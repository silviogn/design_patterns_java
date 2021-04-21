package section2;
// A. High-level modules should not depend on low-level modules.
// Both should depend on abstractions.

//B. Abstractions should not depend on details.
// Details  should depend on abstractions.

import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

enum Relationship {
    PARENT, CHILD, SIBLING
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}

// solution and implementation of the DIP
interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser {  // low-level model

    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
                .filter(x -> Objects.equals(x.getValue0().name, name)
                        && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }
}

class Research { // high level model
    public Research(RelationshipBrowser relationShipBrowser) {
        List<Person> children = relationShipBrowser.findAllChildrenOf("John");
        for (Person p : children) {
            System.out.println("John has a child called " + p.name);
        }
    }
}

public class E_Dependency_Inversion_Principle {



    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Math");

        Relationships r = new Relationships();
        r.addParentAndChild(parent, child1);
        r.addParentAndChild(parent, child2);
        new Research(r);
    }
}





