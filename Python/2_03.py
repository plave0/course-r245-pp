import constraint

problem = constraint.Problem()

problem.addVariable('1 din', range(51))
problem.addVariable('2 din', range(26))
problem.addVariable('5 din', range(11))
problem.addVariable('10 din', range(6))
problem.addVariable('20 din', range(3))

def o(a, b, c, d, e):
    return a + b * 2 + c * 5 + d * 10 + e * 20 == 50

problem.addConstraint(o, ['1 din', '2 din', '5 din', '10 din', '20 din'])

for r in problem.getSolutions():
    print(r)
 
