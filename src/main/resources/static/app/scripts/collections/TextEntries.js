/*global Static, Backbone*/

Static.Collections = Static.Collections || {};

(function () {
    'use strict';

    Static.Collections.TextEntries = Backbone.Collection.extend({
         url: 'http://localhost:8080/textEntries'
    });

})();
