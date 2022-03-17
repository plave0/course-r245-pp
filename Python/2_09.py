import constraint

p = constraint.Problem()

p.addVariable("h", range(68))
p.addVariable("k", range(101))

def c(h, k):
    if (h*300 + k*120 <= 20000) and (h*10 + k*12 <= 1200):
        return True

p.addConstraint(c, "hk")

max_dobit = 0
max_s = 0
for s in p.getSolutionIter():
    dobit = 7*s['h'] + 9*s['k']
    if dobit > max_dobit:
        max_dobit = dobit
        max_s = s

print(max_s)
print(max_dobit)
