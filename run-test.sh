cd design-pattern-jvm && ./gradlew test && cd ..
cd design-pattern-python && ./run-test.sh && cd ..
cd design-pattern-ts && npm run test && cd ..
cd design-pattern-go/src && go test ./test/... -v && cd ../..