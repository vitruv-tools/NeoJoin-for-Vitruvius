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
