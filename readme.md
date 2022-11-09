## Summary

LDAP Tool is a web based tool for interacting with LDAP registries.

Currently LDAP Tool supports performing specifying a host and port, a BaseDN, and applying filters.

LDAP Tool is a SpringBoot application that uses the unboundedid library for interacting with LDAP. The UI is built using ThymeLeaf templating engine.

## Building and running

1. cd into the parent directory and run mvn clean package
1. cd into the target directory and run:
`java -jar ldap-tool-0.0.1-SNAPSHOT.jar`
1. application will be available in your web browser at: localhost:8080/search

## Deploying

The .jar file generated in the above steps can be deployed to WebSphere Liberty or Open Liberty
by following the steps for deploying a Spring Boot jar file.

See this repo for steps to deploy to Open Liberty in a Docker container: [LDAP-Tool-OpenLiberty-Docker](https://github.com/pmcder/LDAP-Tool-OpenLiberty-Docker-Image)

## Using LDAP Tool

Steps to perform a search:
1. navigate to localhost:8080/search in your browser
2. fill out the form and click 
3. Your results or any errors will appear below



 
