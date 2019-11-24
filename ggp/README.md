# GGP

This is a Grammar base Genetic Programming made in Swift to evolve individuals of problem
The goal is to create a more generic framework as possible in a way that even if the 
problem change, the framework can be reused when changing the input grammar and the fitness function

### Running

To run the project is necessary to install Swift in your machine, for linux users you can follow the
steps in this link [Swift Linux Installation](https://itsfoss.com/use-swift-linux/), for Mac users is necessary to install XCode in order
to build the project.

After the installation check your swift version using the command:

```bash
swift --version
```

If you see that swift is installed the first thing to do is build the project using the command:

```bash
swift build
```

After that an executable will be created at path (.build/debug/ggp), you can execute the application
with the command:

```bash
./.build/debug/ggp
```

### Third libraries

The following third party libraries are used in this project:

[SwiftLog](https://github.com/apple/swift-log.git)