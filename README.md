[![CodeFactor](https://www.codefactor.io/repository/github/walterjgsp/meaning/badge/master)](https://www.codefactor.io/repository/github/walterjgsp/meaning/overview/master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f4791748f12b4b9abdbbcf5d47fa8598)](https://www.codacy.com/manual/walterjgsp/meaning?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=walterjgsp/meaning&amp;utm_campaign=Badge_Grade)

<div align="center">
    <h1 align="center">MEANING (<b>M</b>achine l<b>EA</b>r<b>N</b>ing p<b>I</b>peli<b>N</b>e <b>G</b>enerator)</h1>
    <h3>Automatic machine learning pipeline generator </h3>
</div>

The architecture followed by this project is presented in the next image:

<div align="center">
    <img  src="./images/architecture.png">
</div>

## GGP

The Grammar Genetic Programming module was made using Swift as base language

## SK Processor

This is the module to process each individual genrate by the GGP using the framework SKLearn. The module is made using Python
and [Faust](https://faust.readthedocs.io/en/latest/index.html) 