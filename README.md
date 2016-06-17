# Software Delivery mit Docker?

Demo-Projekt zum [Java User Group CH](http://www.jug.ch/) Vortrag _Software Delivery mit Docker?_ am 16.06.2016 in St. Gallen. 

__Slides:__ [presentation.pdf](presentation.pdf)
__Docker:__ [https://docs.docker.com/](https://docs.docker.com/)

__Docker Repositories:__  [https://hub.docker.com](https://hub.docker.com/r/aschaefer/)
__Docker Cloud:__ [https://cloud.docker.com](https://cloud.docker.com)
__AWS Console:__ [https://console.aws.amazon.com](https://console.aws.amazon.com/ec2/v2/home)

## Demo

__Ziel:__ Integrierter Entwicklungs- Build- und Delivery-Prozess mit Maven

- Run Spring Boot app in IDE: start `com.namics.samples.docker.HelloDockerApplication#main`
- Build jar `mvn clean package`
- Run jar `java -jar target/hellodocker.jar`
- Build docker image `mvn docker:package`
- Run docker image local `docker run -p 8080:8080 docker.io/aschaefer/hellodocker:${project.version}`
- Push docker image to registry `mvn docker:deploy` 
- Alternative with docker cli `docker push aschaefer/hellodocker:${project.version}`
- Build release 
	- Start release branch `mvn jgitflow:release-start -B`
		- creates release branch from develop
		- (optional) git push branch to origin
		- prepares pom.xml for release
	- Build release `mvn jgitflow:release-finish -B`
		- prepares pom.xml for release version
		- build jar
		- build docker images
		- push maven artifacts to repo (e.g. Nexus)
		- push docker images to docker registry
		- tag release
		- merge release to master
		- merge changes to develop
		- prepare pom.xml on develop for next development version (SNAPSHOT)
		- (option) git push branches and tags to origin
- Run final release docker image `docker run -p 8080:8080 aschaefer/hellodocker`
	- or deploy in target environments

