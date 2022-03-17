import constraint

problem = constraint.Problem()

problem.addVariables('abcdefghi', range(1,10))
problem.addConstraint(constraint.AllDifferentConstraint())

problem.addConstraint(constraint.ExactSumConstraint(15), ['a', 'b', 'c'])
problem.addConstraint(constraint.ExactSumConstraint(15), ['d', 'e', 'f'])
problem.addConstraint(constraint.ExactSumConstraint(15), ['g', 'h', 'i'])
problem.addConstraint(constraint.ExactSumConstraint(15), ['a', 'd', 'g'])
problem.addConstraint(constraint.ExactSumConstraint(15), ['b', 'e', 'h'])
problem.addConstraint(constraint.ExactSumConstraint(15), ['c', 'f', 'i'])
problem.addConstraint(constraint.ExactSumConstraint(15), ['a', 'e', 'i'])
problem.addConstraint(constraint.ExactSumConstraint(15), ['c', 'e', 'g'])

for r in problem.getSolutionIter(): 
   print("____")
   print(f"| {r['a']} {r['b']} {r['c']} |")
   print(f"| {r['d']} {r['e']} {r['f']} |")
   print(f"| {r['f']} {r['h']} {r['i']} |")
   print("____")
