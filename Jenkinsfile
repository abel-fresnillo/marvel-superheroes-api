pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GitHub', url: 'https://github.com/abel-fresnillo/marvel-superheroes-api.git']]])
                sh label: 'Maven Build', script: 'mvn clean install'
            }
        }

        stage('Reporting') {
            steps {
                snykSecurity failOnIssues: false, organisation: 'isc.abel', snykInstallation: 'snyk', snykTokenId: 'Snyk'
            }
        }
    }
}