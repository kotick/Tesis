package functions;

import model.SOPData;
import model.SOProblem;
import ec.util.Parameter;
import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;

public class And extends GPNode {

	private static final long serialVersionUID = -8211906719366870683L;

	public String toString() { return "And"; }

	public void checkConstraints(
			final EvolutionState state, final int tree,
			final GPIndividual typicalIndividual, final Parameter individualBase) {
        
		super.checkConstraints(state, tree, typicalIndividual, individualBase);
        
        if (children.length != 2) {
            state.output.error("Incorrect number of children for node " +  toStringForError() + " at " + individualBase);
        }
    }

	@Override
	public void eval(
			final EvolutionState state, final int thread,
			final GPData input, final ADFStack stack,
			final GPIndividual individual, final Problem problem) {
		boolean x;
		SOPData sop = (SOPData) input;
		SOProblem sopp = (SOProblem) problem;
		children[0].eval(state, thread, sop, stack, individual, sopp);
		
		x = sop.getResult();
		
		if(!x) {
			sop.setResult(false);
			return;
		}

		children[1].eval(state, thread, sop, stack, individual, sopp);
		sop.setResult(sop.getResult() && x);
	}
}