package net.igorok;

import net.igorok.entities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.igorok.entities.NodeType.*;
import static net.igorok.logging.ClassNameUtil.getCurrentClassName;
import static net.igorok.utility.Utilites.*;


public class Main {
    private static final Logger logger = LogManager.getLogger(getCurrentClassName());

    public static void main(String[] args) {
        logger.debug("Start Main method, logging starts");

        PowerEntity nt_1 = new Network("nt_1", NETWORK, "Network nt_1", "wow");
        addToStorage(nt_1);

        PowerEntity nt_2 = new Network("nt_2", NETWORK, "Network nt_2", "wow2");
        addToStorage(nt_2);

        PowerEntity sbst_1 = new Substation("sbst_1", SUBSTATION,"Substation_1", "wow");
        addToStorage(sbst_1);

        PowerEntity sbst_2 = new Substation("sbst_2", SUBSTATION, "Substation_2", "wow");
        addToStorage(sbst_2);

        PowerEntity sbst_3 = new Substation("sbst_3", SUBSTATION, "Substation_3", "wow");
        addToStorage(sbst_3);

        PowerEntity sbst_4 = new Substation("sbst_4", SUBSTATION, "Substation_4", "wow");
        addToStorage(sbst_4);

        PowerEntity tf_1 = new Transformer("tf_1", TRANSFORMER,"Transformer_1", "wow");
        addToStorage(tf_1);

        PowerEntity tf_2 = new Transformer("tf_2", TRANSFORMER,"Transformer_2", "wow");
        addToStorage(tf_2);

        PowerEntity tf_3 = new Transformer("tf_3", TRANSFORMER,"Transformer_3", "wow");
        addToStorage(tf_3);

        PowerEntity tf_4 = new Transformer("tf_4", TRANSFORMER,"Transformer_4", "wow");
        addToStorage(tf_4);

        PowerEntity tf_5 = new Transformer("tf_5", TRANSFORMER,"Transformer_5", "wow");
        addToStorage(tf_5);

        PowerEntity tf_6 = new Transformer("tf_6", TRANSFORMER,"Transformer_6", "wow");
        addToStorage(tf_6);

        PowerEntity tf_7 = new Transformer("tf_7", TRANSFORMER,"Transformer_7", "wow");
        addToStorage(tf_7);

        PowerEntity tf_8 = new Transformer("tf_8", TRANSFORMER,"Transformer_8", "wow");
        addToStorage(tf_8);

        PowerEntity fdr_1 = new Feeder("fdr_1", FEEDER,"Feeder fdr-1", "wow");
        addToStorage(fdr_1);

        PowerEntity fdr_2 = new Feeder("fdr_2", FEEDER,"Feeder fdr-2", "wow");
        addToStorage(fdr_2);

        PowerEntity fdr_3 = new Feeder("fdr_3", FEEDER, "Feeder fdr-3", "wow");
        addToStorage(fdr_3);

        PowerEntity fdr_4 = new Feeder("fdr_4", FEEDER, "Feeder fdr-4", "wow");
        addToStorage(fdr_4);

        PowerEntity fdr_5 = new Feeder("fdr_5", FEEDER, "Feeder fdr-5", "wow");
        addToStorage(fdr_5);

        PowerEntity fdr_6 = new Feeder("fdr_6", FEEDER,"Feeder fdr-6", "wow");
        addToStorage(fdr_6);

        PowerEntity fdr_7 = new Feeder("fdr_7", FEEDER,"Feeder fdr-7", "wow");
        addToStorage(fdr_7);

        PowerEntity fdr_8 = new Feeder("fdr_8", FEEDER, "Feeder fdr-8", "wow");
        addToStorage(fdr_8);

        PowerEntity rsc_1 = new Resource("rsc_1", RESOURCE,"Resource rsc_1", "wow");
        addToStorage(rsc_1);

        PowerEntity rsc_2 = new Resource("rsc_2", RESOURCE,"Resource rsc_2", "wow");
        addToStorage(rsc_2);

        PowerEntity rsc_3 = new Resource("rsc_3", RESOURCE,"Resource rsc_3", "wow");
        addToStorage(rsc_3);

        PowerEntity rsc_4 = new Resource("rsc_4", RESOURCE,"Resource rsc_4", "wow");
        addToStorage(rsc_4);

        PowerEntity rsc_5 = new Resource("rsc_5", RESOURCE,"Resource rsc_5", "wow");
        addToStorage(rsc_5);

        PowerEntity rsc_6 = new Resource("rsc_6", RESOURCE,"Resource rsc_6", "wow");
        addToStorage(rsc_6);

        PowerEntity rsc_7 = new Resource("rsc_7", RESOURCE,"Resource rsc_7", "wow");
        addToStorage(rsc_7);

        PowerEntity rsc_8 = new Resource("rsc_8", RESOURCE,"Resource rsc_8", "wow");
        addToStorage(rsc_8);

        addMutualRelationship(nt_1, sbst_1);
        addMutualRelationship(sbst_1, tf_1);
        addMutualRelationship(tf_1, fdr_1);

        deleteEntryAndAdjacentRecords(nt_1);

        }
}
