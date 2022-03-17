import constraint

p = constraint.Problem()

p.addVariables("ed", range(250))

def c(e, d):
    if 100*e + 105*d <= 26000 and 150*e + 170*d <= 51200:
        return True

p.addConstraint(constraint.ExactSumConstraint(250))
p.addConstraint(c, "ed")

max_d = 0
max_s = {}
for s in p.getSolutionIter():
    d = 5*s['e'] + 6*s['d']
    if d > max_d:
        max_d = d
        max_s = s

print(max_s)
print(max_d)
