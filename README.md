# kotlin-js-canvas-exp1

This is an experiment with kotlins js-compile. See the result [here](https://gaerfield.github.io/kotlin-js-canvas-exp1/).

The build defines a multi-platform-setup, so the common-Code is reusable with other implementations (jvm, android, ...). It was only introduced to eventually reuse the project-configuration on different experiments and to tryout possibilities with kotlins standard-library.

If you want to startup the project locally after cloning, use the `jsRun`-task: `./gradlew jsRun`. Otherwise feel free to fork and edit the project within github (the project includes a build-workflow to automatically deploy the build-result to github-pages).
