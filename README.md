## Transliteration service

Application is made as part of the Tallinn University graduation thesis

* <b>Prerequisites to running application</b>\
Java 17\
Gradle 7.4.2\
Docker (for web profile)


* <b>Starting application locally</b>\
Execute command in project root directory\
```./gradlew bootRun```


* <b>Starting application in docker with web profile</b>\
Execute commands project root directory\
```./gradlew clean build```\
```docker build -t transliteration-app .```\
```docker run -d -p 8080:8080 transliteration-app:1.0```\


* Example for web profile\
Make HTTP(S) request to URL ```app-domain.com/api/v1/source=testname```
