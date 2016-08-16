#!/bin/bash

mvn clean package

rm -rf wildfly-10.1.0.CR1/standalone/deployments/*

cp target/infinispan-multiple-wars-issue-1.0.0-SNAPSHOT.war wildfly-10.1.0.CR1/standalone/deployments/infinispan-multiple-wars-issue-1.0.0-SNAPSHOT-1.war
cp target/infinispan-multiple-wars-issue-1.0.0-SNAPSHOT.war wildfly-10.1.0.CR1/standalone/deployments/infinispan-multiple-wars-issue-1.0.0-SNAPSHOT-2.war
cp target/infinispan-multiple-wars-issue-1.0.0-SNAPSHOT.war wildfly-10.1.0.CR1/standalone/deployments/infinispan-multiple-wars-issue-1.0.0-SNAPSHOT-3.war
cp target/infinispan-multiple-wars-issue-1.0.0-SNAPSHOT.war wildfly-10.1.0.CR1/standalone/deployments/infinispan-multiple-wars-issue-1.0.0-SNAPSHOT-4.war
cp target/infinispan-multiple-wars-issue-1.0.0-SNAPSHOT.war wildfly-10.1.0.CR1/standalone/deployments/infinispan-multiple-wars-issue-1.0.0-SNAPSHOT-5.war
cp target/infinispan-multiple-wars-issue-1.0.0-SNAPSHOT.war wildfly-10.1.0.CR1/standalone/deployments/infinispan-multiple-wars-issue-1.0.0-SNAPSHOT-6.war

