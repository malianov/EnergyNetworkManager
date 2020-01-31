package net.igorok.utility;

import net.igorok.entities.NodeType;
import net.igorok.entities.PowerEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;
import static net.igorok.database.Storage.powerSystemDataBase;
import static net.igorok.logging.ClassNameUtil.getCurrentClassName;

public class Utilites {
    private static final Logger logger = LogManager.getLogger(getCurrentClassName());

    public static void deleteEntryAndAdjacentRecords(PowerEntity entity) {
        logger.debug("Deleting the " + entity.getId() + " \"Power Node\" and adjacent links");
        Set<PowerEntity> entitiesToDelete = new HashSet<>();

        entitiesToDelete.add(entity);

        Set<PowerEntity> substationLevel = powerSystemDataBase.stream()
                .filter(x -> x.getType() == NodeType.SUBSTATION)
                .filter(x -> x.getParent() != null)
                .filter(x -> x.getParent().equals(entity.getId()))
                .collect(toSet());

        entitiesToDelete.addAll(substationLevel);

        Set<PowerEntity> transformerLevel = powerSystemDataBase.stream()
                .filter(x -> x.getType() == NodeType.TRANSFORMER)
                .filter(x -> substationLevel.contains(x.getParent()))
                .collect(toSet());


        entitiesToDelete.addAll(transformerLevel);

        Set<PowerEntity> feederLevel = powerSystemDataBase.stream()
                .filter(x -> x.getType() == NodeType.FEEDER)
                .filter(x -> transformerLevel.contains(x.getParent()))
                .collect(toSet());


        entitiesToDelete.addAll(feederLevel);

        Set<PowerEntity> resourceLevel = powerSystemDataBase.stream()
                .filter(x -> x.getType() == NodeType.RESOURCE)
                .filter(x -> feederLevel.contains(x.getParent()))
                .collect(toSet());

        entitiesToDelete.addAll(resourceLevel);

        deleteEntries(entitiesToDelete);
    }

    public static void deleteEntries(Set<PowerEntity> EntityList) {
        logger.debug("Deleting the set of \"Power Nodes\" " + EntityList.stream().map(x -> x.getId()).collect(Collectors.toList()) + " \"Power Node\" and adjacent links");
        Set<PowerEntity> entity = powerSystemDataBase.stream()
                .filter(x -> EntityList.stream()
                        .anyMatch(y -> y.equals(x))).collect(Collectors.toSet());

        if (powerSystemDataBase.removeAll(entity)) {
            System.out.println("deleted");
        }
    }

    public static PowerEntity findElement(String identificator) {
        logger.trace("Request to find the Node with " + identificator + " identificator.");
        return powerSystemDataBase.stream()
                .filter((x -> x.getName().equals(identificator) || x.getId().equals(identificator)))
                .findFirst().get();
    }

    public static boolean findNetwork(String networkName) {
        logger.trace("Request to find the Network with " + networkName + " identificator.");
        return powerSystemDataBase.stream()
                .filter(x -> x.getType() == NodeType.NETWORK)
                .anyMatch(x -> x.getName().contains(networkName));
    }

    public static boolean addToStorage(PowerEntity entity) {
        if (powerSystemDataBase.contains(entity.getId())) {
            System.out.println("Such ID exists");
            logger.warn("Cannot add to Network Elements database the " + entity.getId() + "because it ia already exists.");
            return false;
        }
        powerSystemDataBase.add(entity);
        logger.debug("The Network Element " + entity.getId() + " was successfully added to Network Elements database.");
        return true;
    }

    public static void showStorage() {
        System.out.println(powerSystemDataBase);
    }

    public static void addMutualRelationship(PowerEntity highLevelEntity, PowerEntity lowLevelEntity) {
        if (highLevelEntity.getType().compareTo(lowLevelEntity.getType()) == -1) {
            highLevelEntity.addChild(lowLevelEntity);
            lowLevelEntity.setParent(highLevelEntity);
            logger.debug("Adding the mutual relationship request between: " + lowLevelEntity + " and " + highLevelEntity + " was successful");
        } else {
            System.out.println("It is not possible to connect " + lowLevelEntity.getType() + " to " + highLevelEntity.getType());
            logger.warn("Wrong adding the mutual relationship request: " + lowLevelEntity + "cannot be connected to " + highLevelEntity);
        }
    }
}
