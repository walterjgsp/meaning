class Algorithm:
    
    def __init__(self,import_str: str,alg_str: str,parameters_str: str):
        self.import_str = import_str
        self.alg_str = alg_str
        self.parameters_str = parameters_str

    def getModelStr(self):
        return "{0}()".format(self.alg_str)