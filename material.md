---
layout: with-sidebar
title: "Lectures and Course Material – CSE12"
---

<ul>
{% for lecture in site.lectures %}
<li><a title="{{ lecture.index }}" href="{{ lecture.url }}">{{ lecture.name }}</a></li>
{% endfor %}
</ul>