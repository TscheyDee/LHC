package LHC;

import INFRASTRUCTURE.EXPERIMENT.Experiment;

import java.util.LinkedList;

public interface IRODetector {
    LinkedList<Experiment> getExperimentList();
}
