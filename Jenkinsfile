node {
    git url: 'https://github.com/varyvol/maven-basic'
    def mvnHome = tool 'M3'
    cbEnv = ["PATH+MVN=${mvnHome}/bin", "MAVEN_HOME=${mvnHome}"]
    withEnv(cbEnv) {
        try {
            sh 'mvn javadoc:javadoc -f pom.xml'
        } catch (e) {
            println("Executing javadoc on windows")
            bat 'mvn javadoc:javadoc -f pom.xml'
            println("Successfully executed javadoc on windows")
        } 
        step([$class: 'JavadocArchiver', javadocDir: 'target/site/apidocs', keepAll: false])

        try {
            try {
                sh 'mvn test -DmavenBasicNotFail'
            } catch (e) {
                println("Executing test on windows")
                bat 'mvn test -DmavenBasicNotFail'
                println("Executed test on windows")
            }
        } catch (any) {
            currentBuild.result = 'FAILURE'
            //throw any
        } finally {
            junit 'target/surefire-reports/TEST-com.cloudbees.manticore.BasicTest.xml'
            step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'dev@example.com', sendToIndividuals: true])
        }
    }
}
