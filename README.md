Problem Manager API
=====================================

This project is providing restful API to manage problems:
 
1. create a problem (title, content, testing data, etc.)
2. modify a problem
3. delete a problem
4. show a problem
5. get a list of problems

technology stack
================

1. Scala: 2.11.0
1. Play: 2.2.3
1. Database: h2

Kanban:
========

https://huboard.com/tw-scala-workshop/problem_manager_api

CI
======

http://jenkins.shuzu.org:8080/job/problem_manager_api/

Demo
=====

http://problem-manager-api.herokuapp.com/

Usage
=====

**Create new problem**

`POST /problem`

data:

    {
        "title": "problem title",
        "level": 1,
        "content" "content or description",
        "input": "intput data for testing",
        "output": "expected output data for testing",
        "author": "who contributes this problem"
    }

Response: 201 (created)

How to run test
================
play test

**TODO**
