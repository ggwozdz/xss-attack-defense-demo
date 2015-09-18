/*global Static, $*/


window.Static = {
    Models: {},
    Collections: {},
    Views: {},
    Routers: {},
    init: function () {
        'use strict';
        console.log('Hello from Backbone!');

        Handlebars.registerHelper('formattedText', function(text) {
          return new Handlebars.SafeString(text);
        });
    }
};

$(document).ready(function () {
    'use strict';
    Static.init();
    var router = new Static.Routers.AppRouter();
    Backbone.history.start();
});
