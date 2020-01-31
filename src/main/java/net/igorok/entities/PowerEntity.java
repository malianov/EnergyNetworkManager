package net.igorok.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.igorok.logging.ClassNameUtil.getCurrentClassName;

public abstract class PowerEntity {
    private static final Logger logger = LogManager.getLogger(getCurrentClassName());

    protected String id;
    protected NodeType type;
    protected String name;
    protected String description;
    protected Map<String, String> params = new HashMap<>();
    protected List<String> children = new ArrayList<>();
    protected String parent;

    public abstract String getParent();

    public void setParent(PowerEntity parent) {
        logger.trace("set " + parent + "as Parent inside setParent()");
        this.parent = parent.getId();
    }
    public abstract void setParams(String parameterName, String parameterValue) ;
    public abstract boolean addChild(PowerEntity child);


    public List<String> getChildren() {
        logger.trace("Get the children");
        return children;
    }

    public void setChildren(String childId) {
        logger.trace("Set the children id " + childId);
        this.children.add(childId);
    }

    public Map<String, String> getParams() {
        logger.trace("Get the parameters");
        return params;
    }

    public String getDescription() {
        logger.trace("Get the description");
        return description;
    }
    public void setDescription(String description) {
        logger.trace("Set the description as " + description);
        this.description = description;
    }

    public NodeType getType() {
        logger.trace("Get the type");
        return type;
    }
    public void setType(NodeType type) {
        logger.trace("Set the name as " + type);
        this.type = type;
    }

    public String getId() {
        logger.trace("Get the id");
        return id;
    }
    public void setId(String id) {
        logger.trace("Set the id as " + id);
        this.id = id;
    }

    public String getName() {
        logger.trace("Get the name");
        return name;
    }
    public void setName(String name) {
        logger.trace("Set the name as " + name);
        this.name = name;
    }

    public PowerEntity(String id, NodeType type, String name, String description) {
        logger.debug("PowerEntity (abstract class) constructor request with: id = " + id + ", type = " + type + ", name = " + name + ", description = " + description);

        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
    }
}
