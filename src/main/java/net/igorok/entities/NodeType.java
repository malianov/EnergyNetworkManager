package net.igorok.entities;

public enum NodeType {
    //private static final Logger logger = LogManager.getLogger(getCurrentClassName());

    NETWORK(1),
    SUBSTATION(2),
    TRANSFORMER(3),
    FEEDER(4),
    RESOURCE(5);

    NodeType(int level) {
    }
}
