/*global Static, Backbone*/

Static.Collections = Static.Collections || {};

(function () {
    'use strict';

    Static.Collections.Images = Backbone.Collection.extend({
        url: 'http://localhost:8080/images'
    });

})();
