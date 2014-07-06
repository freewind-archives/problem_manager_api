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

https://trello.com/b/qEiAwXei/problem-manager-api

CI
======

http://jenkins.shuzu.org:8080/job/problem-manager-api/

Demo
=====

http://shuzu.org:10001

Usage
=====

**Create new problem**

`POST /problem`

data:

    {
        "title": "problem title",
        "level": 1,
        "content" "content or descript",
        "input": "intput data for testing",
        "output": "expected output data for testing",
        "author": "who contributes this problem"
    }

Response: 201 (created)

**TODO**
