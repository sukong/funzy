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
package funzy.variables;

import static funzy.variables.Variables.newInputVariable;

import org.junit.Test;

import funzy.literals.SimpleDegree;
import funzy.variables.IllegalRangeException;

/**
 * Test cases for the literal variables.
 * 
 * @author <a href="romain.rouvoy+funzy@gmail.com">Romain Rouvoy</a>
 * @version $Revision$
 */
public class InputVariablesTest {
	@Test
	public void CheckNewEnumIntVariable() {
		newInputVariable(0,100,SimpleDegree.class);
	}
	
	@Test(expected=IllegalRangeException.class)
	public void CheckFailureNewEnumIntVariable() {
		newInputVariable(100,0,SimpleDegree.class);
	}

	@Test
	public void CheckNewDoubleVariable() {
		newInputVariable("length",0.0,100.0);
	}
	
	@Test(expected=IllegalRangeException.class)
	public void CheckFailureNewDoubleVariable() {
		newInputVariable("Incorrect range",100.0,0.0);
	}
	
	@Test
	public void CheckNewIntVariable() {
		newInputVariable("temperature",-10,10);
	}
}