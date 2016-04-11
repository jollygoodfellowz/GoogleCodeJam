import itertools

def createGen(val):
    gen = (itertools.product(range(2),repeat=3))
    for comb in gen:
        yield comb

x = ['1','1','1','1']
val = int(''.join(x))

mygen = createGen(x)

for i in mygen:
    print ''.join(map(str, i))

