// The MIT License - Copyright (c) 2007 Universitetet i Oslo

// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:

// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.

// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE. 
package funzy.rules.operators;

import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.asList;

import java.util.Collection;

import com.google.common.base.Function;
import com.google.common.base.Supplier;

import funzy.rules.functions.FuzzyFunction;

/**
 * Implementation of a fuzzy operator.
 * 
 * @author <a href="romain.rouvoy+funzy@gmail.com">Romain Rouvoy</a>
 * @version $Revision$
 */
public class FuzzyOperator  implements Supplier<Double>{
	private FuzzyFunction function;
	private Collection<Supplier<Double>> operators;
	private Function<Supplier<Double>, Double> values = new Function<Supplier<Double>, Double>() {
		public Double apply(Supplier<Double> operator) {
			return operator.get();
		}
	};
	
	private FuzzyOperator(FuzzyFunction f, Supplier<Double>[] ops) {
		function = f;
		operators = asList(ops);
	}

	public Double get() {
		return function.evaluate(newArrayList(transform(operators, values)));
	}
	
	
	public static final Supplier<Double> newOperator(FuzzyFunction function, Supplier<Double>... operators) {
		return new FuzzyOperator(function, operators);
	}
}
