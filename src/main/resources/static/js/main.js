$(function() {
"use strict";
    var username = localStorage.getItem("username");
    if (username) {
        $('.username-field').html(username);
    }

    $('#username-input').change(function () {
        localStorage.setItem("username", $(this).val());
    })
});