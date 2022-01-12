generateJig:
	./gradlew clean build
	java -jar jig-cli-kt.jar --directory.sources=src/main/kotlin --jig.pattern.domain=.+\\.domain\\..+
publishJig:
	rm -rf docs
	mkdir docs
	cp -r build/jig/* docs/


