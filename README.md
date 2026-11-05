# Overview

This repository contains an implementation to create VITRUVIUS viewtypes using the NeoJoin language.
The implementation can be integrated into a Maven-based build to generate Java code defining viewtypes for each NeoJoin file.
These generated viewtypes can be used the same way as standard VITRUVIUS viewtypes.
Addtionally, the viewtypes can be used as part of change propagation specifications.

When using XBase, the implementation currently cannot autoamtically invert these.
If inversion is needed, one has to extend the generated viewtypes and provide the inversion.

The integration into the Maven build can be seen in the [Methodologist Template](https://github.com/vitruv-tools/Methodologist-Template/tree/main).

# Structure

The implementation is split into three parts.

The ```generator``` module contains the classes needed for integration into a build, based on xtext maven plugin, as well as the code generators.
Additionally, it contains an AggregateEcoreGenerator that can be used as a replacement in mwe2 workflow files.

The ```views``` module defines a set of composable operations that are used to define the viewtypes.
Currently, this does not support aggregation (e.g. ```group by```).

The ```change``` module defines the needed utilities to use views during change propagation.
The heart of this is the ```ViewBasedChangePropagationSpecificationAdapter```, constructed using a factory, that wraps two views and a change propagation specification using those views.
For example, one can define a reaction that reacts to changes in a view and modifies another view.

# Integration

To integrate NeoJoin into other projects, such as a custom transpiler, the `NeoJoinStandaloneSetup` serves as a starting point.
One can create a new setup which extends that setup and then use the `xtext-maven-plugin` to integrate the setup into the build process.
To customize the behavior, overriding of the injection module is used.
Overriding the `IGenerator` allows supplying a custom generator.
A custom implementation of `QueryModelExpressionTypeConfiguration` allows customizing the type of the Java model holding the query expressions.
By default, NeoJoin creates a Java function per XBase expression in a private `AllQueryExpressions` class.
A custom implementation of `SourceTypeRegistryInitialization` allows customizing the types used in the source type registry.
By default, NeoJoin infers the types of the source metamodel using the `SourceModelInferrer` class.
This means it creates a Java class model for each type in the source metamodel.

The ```NeoJoinVitruvBuildSetup``` in the ```generator``` module is such a setup.
It overrides all three extension points described above.
