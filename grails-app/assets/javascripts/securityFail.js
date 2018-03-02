// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-1.6.1
//= require common
//= require_self

$( document ).ready(function() {
    $("a.hint").click(function() {
        $(this).next('div').slideDown();
        return false;
    });
});