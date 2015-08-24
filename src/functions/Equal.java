package functions;

import model.SOPData;
import model.SOProblem;
//import model.MISProblemEvo;
import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;
import ec.util.Parameter;
public class Equal extends GPNode {

	private static final long serialVersionUID = 751665529269339218L;

	public String toString() { return "Equal"; }

	public void checkConstraints(
			final EvolutionState state, final int tree,
			final GPIndividual typicalIndividual, final Parameter individualBase) {

		super.checkConstraints(state, tree, typicalIndividual, individualBase);

		if (children.length != 2) {
			state.output.error("Incorrect number of children for node " +  toStringForError() + " at " + individualBase);
		}
	}

	public void eval(
			final EvolutionState state, final int thread,
			final GPData input, final ADFStack stack,
			final GPIndividual individual, final Problem problem) {
		
		boolean x;
		SOPData sopd = (SOPData) input;
		SOProblem sopp = (SOProblem) problem;
		

		children[0].eval(state, thread, sopd, stack, individual, sopp);

		x = sopd.getResult();

		children[1].eval(state, thread, sopd, stack, individual, sopp);
		sopd.setResult(sopd.getResult() == x);
	}
}