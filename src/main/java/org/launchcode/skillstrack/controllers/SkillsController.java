package org.launchcode.skillstrack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class SkillsController {
    @GetMapping
    @ResponseBody
    public String skills() {
        String html = "<html>" + "<title>Skill Tracker</title>" + "<body>" +
                "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>Python</li>" +
                "<li>JavaScript</li>" +
                "</ol>" +
                "</body></html>";
        return html;
    }
    @GetMapping("/form")
    @ResponseBody
    public String formSkills() {
        String html = "<html>" + "<title>Skill Tracker</title>" + "<body>" +
                "<form method='post' action='/formResponse'>" +
                    "<label for='name'>Name:</label>" + "<br>" +
                        "<input type='text' name='name' id='name'>" + "<br>" +
                    "<label for='favorite'>My favorite language:</label>" + "<br>" +
                        "<select id='favorite' name='favorite'>" +
                            "<option value='Java'>Java</option>" +
                            "<option value='JavaScript'>JavaScript</option>" +
                            "<option value='Python'>Python</option>" +
                        "</select>" + "<br>" +
                    "<label for='favorite2'>My second favorite language:</label>" + "<br>" +
                        "<select id='favorite2' name='favorite2'>" +
                            "<option value='Java'>Java</option>" +
                            "<option value='JavaScript'>JavaScript</option>" +
                            "<option value='Python'>Python</option>" +
                        "</select>" + "<br>" +
                    "<label for='favorite3'>My third favorite language:</label>" + "<br>" +
                        "<select id='favorite3' name='favorite3'>" +
                            "<option value='Java'>Java</option>" +
                            "<option value='JavaScript'>JavaScript</option>" +
                            "<option value='Python'>Python</option>" +
                        "</select>" + "<br>" +
                "<input type='submit'>" +
                "</body></html>";
        return html;
    }
    @PostMapping("/formResponse")
    @ResponseBody
    public String formSkillsResponse(@RequestParam String name, @RequestParam String favorite, @RequestParam String favorite2, @RequestParam String favorite3) {
        ArrayList<String> favorites = new ArrayList<>();
        favorites.add(favorite);
        favorites.add(favorite2);
        favorites.add(favorite3);
        String html = "<html>" + "<title>Skill Tracker</title>" + "<body>" +
                "<h1>" + name + "</h1>" +
                "<table style='border:1px solid black'>" +
                "<tr>" +
                "<th style='border:1px solid black'>My favorite language</th>" +
                "<th style='border:1px solid black'>My second favorite language</th>" +
                "<th style='border:1px solid black'>My third favorite language</th>" +
                "</tr>" +
                "<tr>";
        for (String fav : favorites) {
            html += "<td style='border:1px solid black'>" + fav + "</td>";
        }
        html += "</tr></table></body></html>";
        return html;
    }
}
