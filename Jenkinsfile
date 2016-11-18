node {
    git url: 'https://github.com/varyvol/maven-basic'
    def mvnHome = tool 'M3'
    cbEnv = ["MAVEN_HOME=${mvnHome}"]
    withEnv(cbEnv) {
        sh 'mvn javadoc:javadoc -f pom.xml'
        step([$class: 'JavadocArchiver', javadocDir: 'target/site/apidocs', keepAll: false])

        try {
            sh 'mvn test -DmavenBasicNotFail'
        } catch (any) {
            currentBuild.result = 'FAILURE'
            throw any
        } finally {
            junit 'target/surefire-reports/TEST-com.cloudbees.manticore.BasicTest.xml'
            step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'dev@example.com', sendToIndividuals: true])
        }
    }
}