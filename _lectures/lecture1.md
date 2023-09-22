---
layout: with-sidebar
index: 1
name: Introduction
released-on: "2023-04-03"
videos:
    - title: "Welcome"
      url: https://drive.google.com/file/d/1OQW-Gji89qB8WPkicO2kgzQBzyUauC7F
---

## Problem Session 1 – Introduction

_{{ page.released-on }}_

Welcome to the page for the first problem session! Each problem session will
come with a page like this that summarizes the videos you should watch and
readings you should complete **beforehand**, along with any handouts for the day
and code examples, notes, and recordings from the problem solving session.

Session plan:
- 2-3 min: Introduce instructors/staff
- 2-3 min: Say hi to the people around you
- 35 min: syllabus
    - Problem Solving Sessions, videos
    - Lecture Participation
    - Stepik Exercises
    - Programming Assignments
    - Exams
    - Getting Help
    - Schedule
    - Lecture 1 and 2 pages
- 10 min: q/a

The university requires us to determine which students commence academic activity. Failure to certify academic activity, may result in students being billed for unearned financial aid.

To do this automatically, we are using a survey in Canvas that every student must fill out by the end of Friday of Week 2 to ensure that they are certified.
- [First Day Survey: Tell Me About Yourself #FinAid](https://canvas.ucsd.edu/courses/45403/quizzes/133769){:target="_blank"}

After the first lecture, there is one video to watch. You should also familiarize
yourself with the [syllabus](../syllabus.html).

Videos (to watch **after** lecture):

{% for video in page.videos %}
[{{ video.title }}]({{ video.url }}){:target="_blank"}

<iframe src="{{ video.url }}/preview" width="640" height="480" allow="autoplay"></iframe>
{% endfor %}

## Notes & Files from Pre-Lecture Videos

[Pre-Lecture 1](https://github.com/ucsd-cse12-sp23/ucsd-cse12-sp23.github.io/tree/main/_pre-lectures/lecture-01){:target="_blank"}

## Handout

<iframe src="https://drive.google.com/file/d/116uXHVwysfwaJmPqaF9tO1-UYURHIYEC/preview" width="640" height="480" allow="autoplay"></iframe>

## Notes & Files from Lecture 

[Lecture Notes](https://github.com/ucsd-cse12-sp23/ucsd-cse12-sp23.github.io/tree/main/_lectures/lecture-01){:target="_blank"}
