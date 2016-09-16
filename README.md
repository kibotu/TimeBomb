# Computop SDK [![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)  [![Gradle Version](https://img.shields.io/badge/gradle-3.0-green.svg)](https://docs.gradle.org/current/release-notes) [![Retrolambda](https://img.shields.io/badge/java-8-green.svg)](https://github.com/evant/gradle-retrolambda)

## Introduction

Android SDK for [Computop](https://www.computop.com/).

## How to install

    compile 'net.kibotu:timebomb:<VERSION>'

## How to build

    graldew clean build
    
### CI 
    
    gradlew clean assembleRelease test javadoc
    
#### Build Requirements

- JDK7, JDK8
- Android Build Tools 24.0.2
- Android SDK 24 

## How to use

    TimeBomb.bomb

Adapt Message in string.xml 

    <string name="time_bomb_message">This Version is no longer Supported. Please update.</string>

// add public apis and requirements

## Contributors

[Jan Rabe](jan.rabe@kibotu.net)

###License
<pre>
Copyright 2016 Jan Rabe

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>