# instrumentation

<a name="readme-top"></a>
[![MIT License][license-shield]][license-url]
[![Issues][issues-shield]][issues-url]

## About The Project

This is a Spring Boot project created to run in 2 profiles. Either default or RECORD else REPLAY. RECORD mode runs it as a regular Spring Boot Application whereas REPLAY mode generates mock results by stubbing.

### Prerequisites

* Docker Desktop running on local.
* Any database running on local.
* Create a new database/schema with name instrumentation in your DB.

> **_NOTE:_**  To access the host database from a docker container, we must use IP: 172.17.0.1. Also, while running the container we need to add --add-host host.docker.internal:host-gateway with run commands. I will attach a sample below.

### Installation

* Run the below docker command to create an image.
```
docker build -t hypertest .
```
* For RECORD mode, you can run the command:
```
docker run -p 8080:8080 -e "JAVA_OPTS=-Dspring.profiles.active=REPLAY" hypertest
```
* For REPLAY mode, you can update DB details in the below command and run.
```
docker run -d --add-host host.docker.internal:host-gateway -p 8080:8080 -e "JAVA_OPTS=-Dspring.profiles.active=RECORD -Dspring.datasource.url=jdbc:mysql://172.17.0.1:3306/instrumentation -Dspring.datasource.username=root -Dspring.datasource.password=****** -Dexternal.api=http://worldtimeapi.org/api/timezone/Asia/Kolkata" hypertest
```
> **_NOTE:_**  The values in REPLAY mode are hardcoded as specified in the problem statement document link on the top of README.



<!-- MARKDOWN LINKS & IMAGES -->
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/imran-dev100/instrumentation/blob/main/LICENSE
[issues-shield]: https://img.shields.io/badge/MDN_Web_Docs-black?style=for-the-badge&logo=mdnwebdocs&logoColor=white
[issues-url]: https://docs.google.com/document/d/1rD08Fkx1ydxrJgMxXrYyFenFplyAV79124U_HhWC8f4/edit#heading=h.idk60b83j2
