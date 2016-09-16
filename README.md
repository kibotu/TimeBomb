# TimeBomb [![](https://jitpack.io/v/kibotu/TimeBomb.svg)](https://jitpack.io/#kibotu/TimeBomb) [![Build Status](https://travis-ci.org/kibotu/TimeBomb.svg?branch=master)](https://travis-ci.org/kibotu/TimeBomb) [![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)  [![Gradle Version](https://img.shields.io/badge/gradle-3.0-green.svg)](https://docs.gradle.org/current/release-notes) [![Retrolambda](https://img.shields.io/badge/java-8-green.svg)](https://github.com/evant/gradle-retrolambda)

## Introduction

Blocks the user from keep using the App after a period of time based on build time. Mainly to have control preview versions handed out using e.g.: hockey or fabric.

## How to install

    compile 'com.github.kibotu:TimeBomb:-SNAPSHOT'

## How to build

    graldew clean build
    
### CI 
    
    gradlew clean assembleRelease test javadoc
    
#### Build Requirements

- JDK7, JDK8
- Android Build Tools 24.0.2
- Android SDK 24 

## How to use

1. Add to build date to defaultConfig

    
    buildConfigField "String", "BUILD_DATE", "\"" + new Date().getTime() + "\""

2. Invoke check at app start

    
    TimeBomb.bombAfterDays(this, BuildConfig.BUILD_DATE, 14);

(Optional) Adapt Message in string.xml 

    <string name="time_bomb_message">This Version is no longer Supported. Please update.</string>

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