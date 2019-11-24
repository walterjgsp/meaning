#!/usr/bin/env python
# -*- coding: utf-8 -*-

from models.algorithm import Algorithm

def generateModel(algorithm : Algorithm):
    exec(algorithm.import_str)
    generated_model = eval(algorithm.getModelStr())
    return generated_model