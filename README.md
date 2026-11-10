# Overview

[![GitHub Action CI](https://github.com/vitruv-tools/NeoJoin-for-Vitruvius/actions/workflows/ci.yml/badge.svg)](https://github.com/vitruv-tools/NeoJoin-for-Vitruvius/actions/workflows/ci.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=vitruv-tools_NeoJoin-for-Vitruvius&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=vitruv-tools_NeoJoin-for-Vitruvius)
[![Issues](https://img.shields.io/github/issues/vitruv-tools/NeoJoin-for-Vitruvius.svg)](https://github.com/vitruv-tools/NeoJoin-for-Vitruvius/issues)
[![License](https://img.shields.io/github/license/vitruv-tools/NeoJoin-for-Vitruvius.svg)](https://raw.githubusercontent.com/vitruv-tools/NeoJoin-for-Vitruvius/main/LICENSE)

This repository contains an implementation to create Vitruvius view types using the NeoJoin language.
The implementation can be integrated into a Maven-based build to generate Java code defining view types for each NeoJoin file.
These generated view types can be used the same way as standard Vitruvius view types.
Additionally, the view types can be used as part of change propagation specifications.

When using XBase, the implementation currently cannot automatically invert these.
If inversion is needed, one has to extend the generated view types and provide the inversion.

The integration into the Maven build can be seen in the [Methodologist Template](https://github.com/vitruv-tools/Methodologist-Template/tree/main).

# Structure

The implementation is split into three parts.

The `generator` module contains the classes needed for integration into a build, based on xtext maven plugin, as well as the code generators.
Additionally, it contains an AggregateEcoreGenerator that can be used as a replacement in mwe2 workflow files.

The `views` module defines a set of composable operations that are used to define the view types.
Currently, this does not support aggregation (e.g. `group by`).

The `change` module defines the needed utilities to use views during change propagation.
The heart of this is the `ViewBasedChangePropagationSpecificationAdapter`, constructed using a factory, that wraps two views and a change propagation specification using those views.
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

The `NeoJoinVitruvBuildSetup` in the `generator` module is such a setup.
It overrides all three extension points described above.

# Build

Requirements: JDK 21+.

```sh
./mvnw verify
```

The build resolves the NeoJoin artifacts it depends on from the Maven Central snapshot repository, which the NeoJoin repository updates with every nightly build.
This repository does not publish artifacts yet; GitHub Actions only builds and tests it on Linux, macOS and Windows.
We use [SonarQube](https://sonarcloud.io/project/overview?id=vitruv-tools_NeoJoin-for-Vitruvius) to analyze our Maven projects.

### Code Style

The code style is checked with [Checkstyle](https://checkstyle.org/) (`checkstyle.xml`). The check is optional and part of the Maven profile `checkstyle`, which prints violations as warnings and does not fail the build:

```sh
# only the style check (fast)
./mvnw checkstyle:check@validate -P checkstyle
# or: as part of the whole build
./mvnw verify -P checkstyle
```

Add `-Dcheckstyle.severity=error` to print the violations as errors and fail the build at the first module with violations. The CI job `Checkstyle` checks all modules and fails while there are violations.
