#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }

    stages {
        stage("init") {
            steps {
                script {
                   gv = load "script.groovy"
                }
            }
        }
        stage("build Jar") {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage("build Image") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }
        stage("test") {
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
