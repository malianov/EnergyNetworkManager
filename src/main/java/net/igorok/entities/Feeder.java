package net.igorok.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.igorok.logging.ClassNameUtil.getCurrentClassName;

public class Feeder extends PowerEntity {
    private static final Logger logger = LogManager.getLogger(getCurrentClassName());

    public Feeder(String id, NodeType type, String name, String description) {
        super(id, type, name, description);
        logger.debug("Feeder constructor just created a \"Feeder Node\": id = " + id + ", type = " + type + ", name = " + name + ", description = " + description);
    }

    @Override
    public String getParent() {
        logger.trace("Get the parent");
        return this.parent;
    }

    @Override
    public void setParent(PowerEntity parent) {
        logger.trace("Set the parent as " + parent.getId());
        this.parent = parent.getId();
    }

    @Override
    public void setParams(String parameterName, String parameterValue) {
        logger.trace("Set the parameter " + parameterName + " as " + parameterValue);
        params.put(parameterName, parameterValue);
    }

    @Override
    public boolean addChild(PowerEntity child) {
        logger.trace("Trying add the child " + child.getId());

        if (getChildren().contains(child)) {
            logger.trace("Such entity - " + child.getId() + " already in Set of childs - \"Resources\"");
            return false;
        }
        return children.add(child.getId());
    }

    @Override
    public String toString() {
        return "Feeder{" +
                "id='" + getId() + '\'' +
                ", type=" + getType() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", params=" + params +
                ", children=" + getChildren() +
                ", parent=" + parent +
                '}';
    }
}

