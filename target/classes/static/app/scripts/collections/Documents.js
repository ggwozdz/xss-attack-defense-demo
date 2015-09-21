/*global Static, Backbone*/

Static.Collections = Static.Collections || {};

(function () {
    'use strict';

    Static.Collections.Documents = Backbone.Collection.extend({
        url: 'http://localhost:8080/documents'
    });

})();
