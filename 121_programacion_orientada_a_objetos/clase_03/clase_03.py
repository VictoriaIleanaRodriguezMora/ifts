# los n parametros los guarda dentro de una tupla
def clase03(p1, p2, *params):
    print("p1", p1)
    print("p2", p2)
    print("params", params) # params ('strdstg', 445, ['hola'])


clase03(1, 2, "strdstg", 445, ["hola"])