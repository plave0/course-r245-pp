import constraint

p = constraint.Problem()

p.addVariable("x", range(1,11))
p.addVariable("y", range(1, 52, 2))
p.addVariable("z", [10*i for i in range(1,11)])
#p.addVariable("w", [i**3 for i in range(1,10)])
p.addVariable("w", range(1,101))

def c1(x, w):
    if x >= 2*w:
        return True

def c2(y, z):
    if 3 + y <= z:
        return True

def c3(x, y, z, w):
    if x - 11*w + y + 11*z <= 100:
        return True

p.addConstraint(c1, "xw")
p.addConstraint(c2, "yz")
p.addConstraint(c3, "xyzw")

for s in p.getSolutions():
    x = s['x']
    y = s['y']
    z = s['z']
    w = s['w']

    print("___")
    print(f"X = {x} Y = {y} Z = {z} W = {w}")
