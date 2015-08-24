package terminals;

import model.SOP;
import model.SOPData;
import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;
import ec.util.Parameter;

public class Swap extends GPNode {

	private static final long serialVersionUID = 1234567795794857335L;
	
	public String toString() { return "Swap"; }
	
	public void checkConstraints (
		final EvolutionState state, final int tree,
		final GPIndividual typicalIndividual, final Parameter individualBase) {      
		super.checkConstraints(state, tree, typicalIndividual, individualBase);
        if (children.length != 0) {
            state.output.error("Incorrect number of children for node " + toStringForError() + " at " + individualBase);
        }
    }
	
	@Override
	public void eval(final EvolutionState state, final int thread,
			final GPData input, final ADFStack stack,
			final GPIndividual individual, final Problem problem) {
		SOPData sop = (SOPData) input;		
		sop.setResult(SOP.swap(sop.getInstance()));
	}
}
