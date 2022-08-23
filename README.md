
### What to test

- API of most important classes (public methods)
- focus on business logic
- do not test JavaFx controllers - it's hard to test, it's better to focus on other things

### Good unit test properties
- for the same input always gives same result
- independent - works without internet connection, on every machine
- test on thing at the time - thing can be method, function etc
- isolated - no test makes influence on the other tests
- readable - it's clear what test is testing/doing, serves as code specification
- automated - run during every build (`mvn clean install`) and if tests fails, then build fails

### Good practices

- check test coverage to not miss some important piece of code
- use mocks/stubs only where needed
- for testing databases / HTTP connections integration tests can be used
- if your code is hard to test, refactor it to make it more testable
- do not test if Java or library is working the right way (testing constructors etc.)