package funzy.rules.functions;

import static com.google.common.collect.Iterables.getOnlyElement;
import static com.google.common.collect.Lists.immutableList;

import java.util.List;

/**
 * Implementation of a fuzzy operator requiring exactly 1 parameter.
 * 
 * @author <a href="romain.rouvoy+funzy@gmail.com">Romain Rouvoy</a>
 * @version $Revision$
 */
public class FuzzyFunctionPipe implements
		FuzzyFunction {
	private FuzzyFunction[] delegates;

	public FuzzyFunctionPipe(FuzzyFunction... functions) {
		delegates = functions;
	}

	/* (non-Javadoc)
	 * @see funzy.operators.FuzzyOperator#evaluate(N[])
	 */
	public double evaluate(List<Double> values) {
	    List<Double> res = values;
		for (int i = delegates.length - 1; i >= 0; i--)
			res = immutableList(delegates[i].evaluate(res));
		return getOnlyElement(res);
	}
}
