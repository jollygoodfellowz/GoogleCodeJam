import itertools, math, random, sys

def isPrime(val):
    if val < 2:
        return False
    if val is 2:
        return True
    if val % 2 is 0:
        return False
    for x in range(3, int(math.sqrt(val) + 1), 2):
        if val % x is 0:
            return False
    return True

def checkBases(jamCoin):
    for i in range(2,11):
        jamVal = int(jamCoin,i)
        if isPrime(jamVal):
            return False
    return True

def createComboGen(N):
    gen = (itertools.product(range(2),repeat=N))
    for comb in gen:
        yield comb

def findDivisors(val, J):
    divisors = []
    for i in range(2,11):
        baseNum = int(val,i)
        for j in range(2,int(math.sqrt(baseNum)) +1):
            if baseNum % j is 0:
                divisors.append(j)
                if len(divisors) is J:
                    return divisors
	    	break
    return None

with open(sys.argv[1], 'r') as file, open('out', 'w') as out:
    data = file.read().split()

    T  = int(data.pop(0))
    N = int(data.pop(0))
    J = int(data.pop(0))
    gen = createComboGen(N)
    count = 0

    out.write("Case #1:\n")
    for combo in gen:
        newCombo = list(combo)
        strJamCombo = ''.join(map(str,newCombo))

        if newCombo[len(newCombo)-1] is 1 and newCombo[0] is 1 and checkBases(strJamCombo):
            divisors = findDivisors(strJamCombo, 9)

            if divisors is None:
                continue
            out.write(strJamCombo)
            for x in divisors:
                out.write(" " + str(x))
            out.write("\n")

            count = count + 1

            if count is J:
                sys.exit()
