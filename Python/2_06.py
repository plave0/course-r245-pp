import constraint

p = constraint.Problem()

p.addVariables('tf', range(1,10))
p.addVariables('wour', range(10))

def c(t, w, o, f, u, r):
    if 2*(100*t + 10*w + o) == f*1000 + o*100 + u*10 + r:
        return True

p.addConstraint(constraint.AllDifferentConstraint())
p.addConstraint(c, "twofur")

for s in p.getSolutions():
    print("_____")
    print("  " + str(s['t']) + str(s['w']) + str(s['o']))
    print(" +" + str(s['t']) + str(s['w']) + str(s['o']))
    print("=" + str(s['f']) + str(s['o']) + str(s['u']) + str(s['r']))
