pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/juhii2004/testsphere-automation-framework.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Performance Test (JMeter)') {
            steps {
                bat '''
                if exist results.jtl del results.jtl
                if exist jmeter-report rmdir /s /q jmeter-report
                jmeter -n -t test-plan.jmx -l results.jtl -e -o jmeter-report
                '''
            }
        }
    }

    post {
        always {

            // ✅ Allure Report
            allure([
                        includeProperties: false,
                        results: [[path: 'target/allure-results']]
                    ])

            // ✅ JMeter Report
            publishHTML(target: [
                reportDir: 'jmeter-report',
                reportFiles: 'index.html',
                reportName: 'JMeter Performance Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])

            echo 'Pipeline executed'
        }

        success {
            echo 'Build Successful ✅'
        }

        failure {
            echo 'Build Failed ❌'
        }
    }
}