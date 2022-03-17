import constraint

problem = constraint.Problem()

problem.addVariable('A', range(1, 10))
problem.addVariable('B', range(10))
problem.addVariable('C', range(10))

problem.addConstraint(constraint.AllDifferentConstraint())

#all solutions
min_d = 1000
min_r =  {}
for r in problem.getSolutions():
    a = r['A']
    b = r['B']
    c = r['C']
    d = (a * 100 + b * 10 + c) / (a + b + c)
    if d < min_d:
        min_d = d
        min_r = r

print(min_r)

