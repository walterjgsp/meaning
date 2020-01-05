# SK Processor

This is the module to process the individuals generate by the GGP using 
[Scikit-Learn](https://scikit-learn.org/) as the main processor.

## Virtual Env

I strongly suggest the usage of virtual enviromnent when running this process
on your machine for development porpuses.

You can follow the following tutorials:

- MacOS: https://swapps.com/blog/how-to-configure-virtualenvwrapper-with-python3-in-osx-mojave/
- Linux: https://virtualenvwrapper.readthedocs.io/en/latest/install.html

## Setup

To run on your local machine, maybe will be necessary to run the following command from the src folder:

```bash
pip install -e .
```

## Run tests

After all the setup is finished, you can run the tests using the command: 

```bash
pytest
```

## Run Worker

In order to run the worker use the command:

```bash
faust -A sk_worker worker -l info
```