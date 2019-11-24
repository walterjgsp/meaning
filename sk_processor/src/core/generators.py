#!/usr/bin/env python
# -*- coding: utf-8 -*-

from models.algorithm import Algorithm

def generate_model(algorithm : Algorithm):
    exec(algorithm.import_str)
    generated_model = eval(algorithm.get_model_str())
    return generated_model