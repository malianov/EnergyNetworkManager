package net.igorok.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.igorok.logging.ClassNameUtil.getCurrentClassName;

public class Network extends PowerEntity {
    private static final Logger logger = LogManager.getLogger(getCurrentClassName());

    public Network(String id, NodeType type, String name, String description) {
        super(id, type, name, description);
        logger.debug("Network constructor just created a \"Network Node\": id = " + id + ", type = " + type + ", name = " + name + ", description = " + description);

    }

    @Override
    public String getParent() {
        logger.warn("Wrong parent request. It is not possible to have parent for Network.");
        return "";
    }

    @Override
    public void setParent(PowerEntity parent) {
        logger.warn("Wrong parent setting. It is not possible to have parent for Network");
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
            logger.trace("Such entity - " + child.getId() + " already in Set of childs - \"Substations\"");
            return false;
        }
        return children.add(child.getId());
    }

    @Override
    public String toString() {
        return "Network{" +
                "id='" + getId()  + '\'' +
                ", type=" + getType() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", params=" + params +
                ", children=" + children +
                ", parent=" + parent +
                '}';
    }
}
