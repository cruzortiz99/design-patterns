package design.pattern.java.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class ContainerComposite implements UIComponent {
    private List<UIComponent> children;
    public ContainerComposite(UIComponent component) {
        this.children = new ArrayList<>();
        this.children.add(component);
    }
    @Override
    public String render() {
        return children.stream()
                .map(component -> component.render())
                .reduce("",
                        (acc, current) -> acc.concat(" ")
                                .concat(current));
    }
    public ContainerComposite add(UIComponent component) {
        this.children.add(component);
        return this;
    }
    public void remove(UIComponent component) {
        this.children.remove(component);
    }
}
