pipeline {
  environment{
	registry = 'cherifa123/cherifa123'
	registryCredential= 'dockerHub'
	dockerImage = ''
 
 }
 agent any
 stages{
  stage('Checkout GIT'){
    steps{
      echo 'Pulling...';
      git branch: 'cherifaBranche',
      url : 'https://github.com/cherifa34/timesheet.git';
    }
  }
         

  stage("Test,Build"){
    steps{
      bat """mvn clean package"""
    }
     }


  stage("Sonar"){
    steps{
      bat """mvn sonar:sonar"""
    }
     }

          
  stage("Nexus"){
    steps{
      bat """mvn clean package -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.jar"""
    }
     }
         
  stage('Building our image') {
    steps {
       script {
          dockerImage= docker.build registry + ":$BUILD_NUMBER" 
       }
    }
  }

  stage('Deploy our image') {
    steps {
       script {
         docker.withRegistry( '', registryCredential) {
            dockerImage.push() 
         }
       } 
    }
  }

  stage('Cleaning up') {
    steps { 
      bat "docker rmi $registry:$BUILD_NUMBER" 
    }
  }
 }
}