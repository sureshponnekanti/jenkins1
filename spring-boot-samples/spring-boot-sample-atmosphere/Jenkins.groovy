node {
   stage('checkout') {
       git 'https://github.com/Murail/jenkins.git'
   }
   stage('test'){
       sh 'mvn test -f spring-boot-samples/spring-boot-sample-atmosphere/pom.xml'
   }
   stage('Test reports'){
       junit 'spring-boot-samples/spring-boot-sample-atmosphere/target/surefire-reports/*.xml'
       
   }
   stage('package'){
       
       sh 'mvn package'
       
   }
   stage('archieve artifacts'){
       archiveArtifacts 'target/*.*ar'
       sdjg
       
   }
}