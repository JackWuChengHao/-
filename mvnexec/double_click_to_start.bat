call mvn -f pom.xml dependency:copy-dependencies  -DoutputDirectory=D:\mavenresp\lib 
call mvn -f pom.xml dependency:sources 
call mvn dependency:resolve -Dclassifier=javadoc
@pause