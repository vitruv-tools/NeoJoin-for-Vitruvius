# Snapshots and Jar Metadata

The CI job `deploy-snapshot` deploys the snapshots with `./mvnw clean deploy -P snapshot` (nightly and for manual runs of the workflow on `main`). The repository and the signing of the artifacts come from the parent POM `tools.vitruv:parent`; the repository secrets `CENTRAL_USERNAME`, `CENTRAL_PASSWORD`, `OSSRH_GPG_SECRET_KEY` and `OSSRH_GPG_SECRET_KEY_PASSWORD` are needed.

Every jar contains the license of this project as `META-INF/LICENSE` and the manifest entry `Automatic-Module-Name` (the artifact ID). The POMs have a name and a description for the project and each module.

The jar of the `change` module is also an OSGi bundle: the EMF generator (`change/workflow/generate.mwe2`) writes `change/META-INF/MANIFEST.MF` and `change/plugin.properties` for the `view_id` model. Both files are tracked, because the generator keeps edited values: they contain the bundle name, the vendor and the bundle version `0.1.0.qualifier`, which is not derived from the Maven version. Edit it by hand when the version changes (the jar plugin cannot override it). The genmodel `view_id.genmodel` has the compliance level 21 (the Java version of the build).
