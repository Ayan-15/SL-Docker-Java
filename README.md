# SL-Docker-Java
Simple JAVA project built with gradle to create a docker image
It has 5 .java files - 
1. Batch.java (Abstract - with 2 children - Morning.java and Evening.java)
2. Morning.java - sends SMS when batch starts
3. Evening.java - sends SMS when batch starts
4. Participant.java - holds the participant's details in Arraylist
5. Run.java - main() is executed from here. Ask the participant details and stores it in the file - participants_detail.txt
## Dependencies details
Fat jar is created loaded with all dependencies in gradle '(java -jar build/libs/01_Project_SL_gradle-all.jar)'
Docker file is already present (Main docer file where fat jar is copied from host machine and another one where fat jar is built during docker image creation). 
Built with JAVA 11 - 'build.gradle.kts' can be referred. 
Root project name is - '01_Project_SL_gradle'
