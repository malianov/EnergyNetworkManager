package net.igorok.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static net.igorok.logging.ClassNameUtil.getCurrentClassName;

public class Resource extends PowerEntity {
    private static final Logger logger = LogManager.getLogger(getCurrentClassName());

    public Resource(String id, NodeType type, String name, String description) {
        super(id, type, name, description);
        params.put("consumes","");
        params.put("units","");
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
    public List<String> getChildren() {
        logger.warn("Wrong getChildren request. The Resource cannot have childs");
        return null;
    }

    @Override
    public boolean addChild(PowerEntity child) {
        logger.warn("Wrong addChild request. The Resource cannot have childs");
        return false;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id='" + getId()  + '\'' +
                ", type=" + getType() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", params=" + params +
                ", children=" + "Not applicable" +
                ", parent=" + parent +
                '}';
    }
}